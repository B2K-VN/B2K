package b2k.lib.connector;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class EntityMethod {
	/**
	 * 
	 * @param <T>
	 * @param t
	 * @param document
	 * @param table
	 * @return
	 */
	public static <T extends Entity> List<T> find(Class<T> t,
			BasicDBObject document, String table) {

		List<T> l = new ArrayList<T>();

		DBCollection collection = MongoConnector.getDB().getCollection(table);
		DBCursor find = collection.find(document);

		while (find.hasNext()) {
			DBObject next = find.next();
			T newInstance;
			try {
				newInstance = t.newInstance();
				newInstance.set(next);
				l.add(newInstance);

			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return l;

	}

	/**
	 * 
	 * @param <T>
	 * @param t
	 * @param document
	 * @param table
	 * @param client
	 * @param db
	 * @return
	 */
	public static <T extends Entity> List<T> find(Class<T> t,
			BasicDBObject document, String table, String client, String db) {

		List<T> l = new ArrayList<T>();

		MongoConnector.regit(client, db);
		DBCollection collection = MongoConnector.getDB().getCollection(table);
		DBCursor find = collection.find(document);

		while (find.hasNext()) {
			DBObject next = find.next();
			T newInstance;
			try {
				newInstance = t.newInstance();
				newInstance.set(next);
				l.add(newInstance);

			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return l;

	}

	/**
	 * 
	 * @param id
	 * @param table
	 * @return
	 */
	public static int deleteByID(String id, String table) {

		DBCollection collection = MongoConnector.getDB().getCollection(table);

		BasicDBObject document = new BasicDBObject();
		document.put(Entity.KEY_ID, id);

		WriteResult remove = collection.remove(document);
		return remove.getN();

	}

	/**
	 * 
	 * @param id
	 * @param table
	 * @param client
	 * @param db
	 * @return
	 */
	public static int deleteByID(String id, String table, String client,
			String db) {
		MongoConnector.regit(client, db);

		DBCollection collection = MongoConnector.getDB().getCollection(table);

		BasicDBObject document = new BasicDBObject();
		document.put(Entity.KEY_ID, id);

		WriteResult remove = collection.remove(document);
		return remove.getN();

	}

	/**
	 * 
	 * @param <T>
	 * @param entity
	 * @param table
	 * @return
	 */
	public static <T extends Entity> T update(T entity, String table) {
		DBCollection collection = MongoConnector.getDB().getCollection(table);
		BasicDBObject document = new BasicDBObject();
		document.put(Entity.KEY_ID, entity.getKey_ID());
		collection.update(document, entity);
		return entity;

	}

	/**
	 * 
	 * @param <T>
	 * @param entity
	 * @param document
	 * @param table
	 * @return
	 */
	public static <T extends Entity> T update(T entity, BasicDBObject document,
			String table) {
		DBCollection collection = MongoConnector.getDB().getCollection(table);
		collection.update(document, entity);
		return entity;

	}

	/**
	 * 
	 * @param <T>
	 * @param entity
	 * @param table
	 * @param client
	 * @param db
	 * @return
	 */
	public static <T extends Entity> T update(T entity, String table,
			String client, String db) {
		MongoConnector.regit(client, db);
		DBCollection collection = MongoConnector.getDB().getCollection(table);
		BasicDBObject document = new BasicDBObject();
		document.put(Entity.KEY_ID, entity.getKey_ID());
		collection.update(document, entity);
		return entity;

	}

	/**
	 * 
	 * @param <T>
	 * @param entity
	 * @param document
	 * @param table
	 * @param client
	 * @param db
	 * @return
	 */
	public static <T extends Entity> T update(T entity, BasicDBObject document,
			String table, String client, String db) {
		MongoConnector.regit(client, db);
		DBCollection collection = MongoConnector.getDB().getCollection(table);
		collection.update(document, entity);
		return entity;

	}

	/**
	 * 
	 * @param <T>
	 * @param o
	 * @param table
	 * @param client
	 * @param db
	 * @return
	 */
	public static <T extends Entity> T save(T o, String table, String client,
			String db) {
		MongoConnector.regit(client, db);
		DBCollection collection = MongoConnector.getDB().getCollection(table);
		collection.save(o);

		return o;
	}

	/**
	 * 
	 * @param <T>
	 * @param o
	 * @param table
	 * @return
	 */
	public static <T extends Entity> T save(T o, String table) {
		DBCollection collection = MongoConnector.getDB().getCollection(table);
		collection.save(o);

		return o;
	}

	/**
	 * 
	 * @param document
	 * @param table
	 * @return
	 */
	public static int delete(BasicDBObject document, String table) {
		DBCollection collection = MongoConnector.getDB().getCollection(table);
		WriteResult remove = collection.remove(document);
		return remove.getN();
	}

	/**
	 * 
	 * @param document
	 * @param table
	 * @param client
	 * @param db
	 * @return
	 */
	public static int delete(BasicDBObject document, String table,
			String client, String db) {
		MongoConnector.regit(client, db);
		DBCollection collection = MongoConnector.getDB().getCollection(table);
		WriteResult remove = collection.remove(document);
		return remove.getN();
	}

}
