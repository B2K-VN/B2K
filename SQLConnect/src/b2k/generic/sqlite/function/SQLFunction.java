package b2k.generic.sqlite.function;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import b2k.generic.objects.ABS;
import b2k.generic.objects.B2K;

public class SQLFunction {

	private static boolean isType(Class<?> type) {
		String[] types = { "Long", "Integer", "int", "char", "Double",
				"ImageIcon", "String", "short", "boolean", "timestamp", "date",
				"byte" };
		for (String str : types) {
			if (str.equalsIgnoreCase(type.getSimpleName()))
				return true;
		}
		return false;
	}

	public static <T> void convertToT(T data, ResultSet cursor)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SQLException, SecurityException,
			NoSuchMethodException {

		Field[] declaredFields = data.getClass().getFields();
		for (Field f : declaredFields) {
			String name = f.getName();
			Class<?> type = f.getType();
			if (!isType(type))
				continue;
			f.set(data, getValue(type, (cursor.getObject(name))));
		}
	}

	private static Object getValue(Class<?> type, Object object) {
		if ("boolean".equalsIgnoreCase(type.getSimpleName())) {
			return Boolean.parseBoolean(String.valueOf(object));
		} else if ("timestamp".equalsIgnoreCase(type.getSimpleName())) {
			if(object == null) return object;
			return new Timestamp(Long.parseLong(String.valueOf(object)));
		}

		return object;
	}

	public static <T extends ABS> T save(Connection db, T data)
			throws SQLException, SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		return save(db, data, true);
	}

	public static <T extends ABS> T save(Connection db, T data,
			boolean isTransaction) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, SQLException {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			Field[] declaredFields = data.getClass().getFields();
			for (Field field : declaredFields) {
				if (field.getName().equalsIgnoreCase("id"))
					continue;
				Class<?> type = field.getType();
				if (type.getSimpleName().equalsIgnoreCase("List")) {
					// save list
				} else {
					if (isType(type)) {
						map.put(field.getName(), field.get(data));
					}
				}
			}
			db.setAutoCommit(!isTransaction);
			String tableName = data.getClass().getSimpleName();
			long id = data.getId();
			if (id == 0) {
				id = insertByFieldNames(db, tableName, map);
				data.setId(id);
			} else {
				updateByFieldNames(db, tableName, map, id);
				}
			
		} catch (SQLException e1) {
			if(e1.getErrorCode() == 1){
				createTable(db, data.getClass());
				save(db, data, isTransaction);
			}else{
				e1.printStackTrace();
			}
		}finally {
			if (isTransaction)
				db.commit();
		}

		return data;
	}

	private static void updateByFieldNames(Connection connection,
			String tableName, Map<String, Object> map, long id)
			throws SQLException {
		Set<String> keySet = map.keySet();
		String fieldName = "";
		List<Object> list = new ArrayList<Object>();

		for (String key : keySet) {

			fieldName += key + " = ?, ";
			list.add(map.get(key));
		}

		fieldName = fieldName.substring(0, fieldName.lastIndexOf(","));

		String query = "UPDATE " + tableName + " SET " + fieldName
				+ " where id = ?";

//		System.out.println(query);
//		System.out.println(list);
		
		PreparedStatement preparedStatement = connection
				.prepareStatement(query);

		int ix = 1;
		for (Object object : list) {
			preparedStatement.setObject(ix++, object);
		}
		preparedStatement.setObject(ix, id);

		preparedStatement.executeUpdate();
	}

	private static long insertByFieldNames(Connection connection,
			String tableName, Map<String, Object> map) throws SQLException {
		Set<String> keySet = map.keySet();
		String fieldName = "";
		String fieldValue = "";
		List<Object> list = new ArrayList<Object>();

		for (String key : keySet) {
			fieldName += key + ", ";
			fieldValue += "?, ";
			list.add(map.get(key));
		}

		fieldName = fieldName.substring(0, fieldName.lastIndexOf(","));
		fieldValue = fieldValue.substring(0, fieldValue.lastIndexOf(","));

		String query = "insert into " + tableName + " (" + fieldName
				+ ") values (" + fieldValue + ")";

		PreparedStatement preparedStatement = connection
				.prepareStatement(query);

		int ix = 1;
		for (Object object : list) {
			preparedStatement.setObject(ix++, object);
		}
		return preparedStatement.executeUpdate();
	}

	public static <T> void createTable(Connection db, Class<T> obj) {

		HashMap<String, List<String>> hashIndex = new HashMap<String, List<String>>();

		String createTableQuery = "CREATE TABLE IF NOT EXISTS "
				+ obj.getSimpleName() + " (";

		for (Field f : obj.getFields()) {

			f.setAccessible(true);
			updateIndexName(f, hashIndex);

			String name = f.getName();
			String _type = f.getType().getSimpleName();
			String type = null;
			if (_type.equalsIgnoreCase("string")) {
				type = FieldType.VARCHAR + getLength(f);
			} else if (_type.equalsIgnoreCase("short")) {
				type = FieldType.SHORT;
			} else if (_type.equalsIgnoreCase("integer")
					|| _type.equalsIgnoreCase("int")) {
				type = FieldType.INT;
			} else if (_type.equalsIgnoreCase("long")) {
				type = FieldType.LONG;
			} else if (_type.equalsIgnoreCase("boolean")) {
				type = FieldType.BOOLEAN;
			} else if (_type.equalsIgnoreCase("double")) {
				type = FieldType.DOUBLE;
			} else if (_type.equalsIgnoreCase("timestamp")) {
				type = FieldType.DATETIME;
			} else if (_type.equalsIgnoreCase("date")) {
				type = FieldType.DATE;
			} else if (_type.equalsIgnoreCase("imageicon")) {
				type = FieldType.BLOB;
			}

			if (type == null)
				continue;

			if (name.equalsIgnoreCase("id")) {
				createTableQuery += name + " " + type + " "
						+ PrimaryKey.PRIMARY_KEY_AUTO + " , ";
			} else {
				createTableQuery += name + " " + type + ", ";
			}
		}
		System.out.println(createTableQuery);
		createTableQuery = createTableQuery.substring(0,
				createTableQuery.lastIndexOf(","));

		createTableQuery += ")";

		try {
			PreparedStatement statement = db.prepareStatement(createTableQuery);
			statement.executeUpdate();
			Set<String> keySet = hashIndex.keySet();
			Iterator<String> iterator = keySet.iterator();
			while (iterator.hasNext()) {
				String next = iterator.next();
				createIndex(db, obj, next, hashIndex.get(next));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}

	private static String getLength(java.lang.reflect.Field f) {
		B2K annotation = f.getAnnotation(B2K.class);
		if (annotation != null)
			return "(" + annotation.length() + ")";
		return "";
	}

	protected static <T> void createIndex(Connection db, Class<T> obj,
			String indexName, List<String> fields) throws SQLException {
		String tableName = obj.getSimpleName();
		String indexQuery = "CREATE INDEX _" + indexName + " ON " + tableName
				+ "(";
		for (String field : fields) {
			indexQuery += field + ",";
		}
		indexQuery = indexQuery.substring(0, indexQuery.lastIndexOf(","));
		indexQuery += ")";
		PreparedStatement statement = db.prepareStatement(indexQuery);
		statement.executeUpdate();
	}

	private static void updateIndexName(java.lang.reflect.Field f,
			HashMap<String, List<String>> map) {
		B2K annotation = f.getAnnotation(B2K.class);
		if (annotation != null) {
			String groupIndexs = annotation.groupIndexs();
			String[] split = groupIndexs.split(",");
			for (String indexName : split) {
				indexName = indexName.trim();
				List<String> list = map.get(indexName);
				if (list == null) {
					list = new ArrayList<String>();
					map.put(indexName, list);
				}
				list.add(f.getName());
			}
		}
	}

	public static <T> List<T> selectAll(Connection connection, Class<T> class1)
			throws SQLException, IllegalArgumentException, SecurityException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, InstantiationException {

		String query = "";
		query += "SELECT * from " + class1.getSimpleName();

		PreparedStatement statement = connection.prepareStatement(query);

		ResultSet resultSet = statement.executeQuery();

		List<T> list = new ArrayList<T>();
		while (resultSet.next()) {
			T t = class1.newInstance();

			convertToT(t, resultSet);

			list.add(t);
		}
		return list;
	}

	public static <T> T selectByid(Connection connection, Class<T> class1,
			long id) throws SQLException, IllegalArgumentException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			InstantiationException {

		String query = "";
		query += "SELECT * from " + class1.getSimpleName() + " where id = "
				+ id;

		PreparedStatement statement = connection.prepareStatement(query);

		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			T t = class1.newInstance();

			convertToT(t, resultSet);

			return t;
		}
		return null;
	}
	
	public static <T> List<T> selectByWhere(Connection connection,
			Class<T> class1, String where) throws SQLException,
			IllegalArgumentException, SecurityException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, InstantiationException {

		String query = "";
		query += "SELECT * from " + class1.getSimpleName() + " where " + where;

		PreparedStatement statement = connection.prepareStatement(query);

		ResultSet resultSet = statement.executeQuery();

		List<T> list = new ArrayList<T>();
		while (resultSet.next()) {
			T t = class1.newInstance();

			convertToT(t, resultSet);

			list.add(t);
		}
		return list;
	}
}
