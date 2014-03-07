/**	
 * 
 */
package b2k.generic.mysql.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import b2k.generic.objects.GroupQuery;
import b2k.generic.objects.QueryEntity;

/**
 * @author dinhkhai
 *
 */
public class CommonQuery {

	/**
	 * 
	 */
	// Hàm select
	//============================================================================================================================================
	//============================================================================================================================================
	
	private static Object[] getQueryWhere(String where, String operator, int i, Boolean isOperation, List<QueryEntity> queryEntities, List<Object> values){
		for(QueryEntity queryEntity : queryEntities){
			if(isOperation){
				where += " " + operator + " ";
			}else{
				isOperation = true;
			}
			if (queryEntity.isParameterInd()) {
				where += " "+queryEntity.getKey() +" "+ queryEntity.getCondition()+" ?";
				values.add(queryEntity.getValue());
			}else {
				where += " "+queryEntity.getKey() +" "+ queryEntity.getCondition()+" "+queryEntity.getValue();
			}
		}
		return new Object[]{where, isOperation, i};
	}
	
	private static Object[] getGroupQuery(String where, int i, Boolean isOperation, GroupQuery groupQuery, List<Object> values){
		
		List<QueryEntity> queryEntities = groupQuery.getQueryEntities();
		if(queryEntities != null ){
			Object[] ret = getQueryWhere(where, groupQuery.getOperator(), i, isOperation, queryEntities, values);
			where = (String) ret[0];
			isOperation = (Boolean) ret[1];
			i = (Integer) ret[2];
		}
		List<GroupQuery> groupQueries = groupQuery.getGroupQueries();
		if(groupQueries != null){
			for(GroupQuery _groupQuery : groupQueries){
				
				List<QueryEntity> _queryEntities = _groupQuery.getQueryEntities();
				List<GroupQuery> _groupQueries = _groupQuery.getGroupQueries();
				if((_groupQueries != null && !_groupQueries.isEmpty()) 
						|| (_queryEntities != null && !_queryEntities.isEmpty())){
					if(isOperation){
						where += " " +groupQuery.getOperator()+ " ";
					}
					
					where+="(";
					Object[] ret = getGroupQuery(where, i,  false, _groupQuery, values);
					where = (String) ret[0];
					isOperation = (Boolean) ret[1];
					i = (Integer) ret[2];
					where+=")";
				}
			}
		}
		
		return new Object[]{where, isOperation, i};
	}
	
	public static List<Object[]> getQuery(Connection connection, List<String> selects, List<String> clazz, GroupQuery groupQuery, String clauses){
		PreparedStatement statement = null;
		try {
			
			String select = "";
			if (selects.isEmpty() || selects == null) {
				select = "p";
			}else {
				for (String sel : selects) {
					select +=sel;
				}
			}
			
			String clazs = "";
			for (String clas : clazz) {
				clazs +=clas;
			}
			
			List<Object> values = null;
			int i=1;
			String where = "";
			if (groupQuery != null) {
				values = new ArrayList<Object>();
				where = " where ";
				
				Boolean isOperation = false;
				Object[] ret =  getGroupQuery(where, i, isOperation, groupQuery, values);
				where = (String) ret[0];
				isOperation = (Boolean) ret[1];
			}
			
			String clause = " ";
			if (clauses != null) {
				clause += clauses;
			}
			statement = connection.prepareStatement("select "+select+
					" from "+clazs+
					where+clause);
			//test
			String string = "select "+select+" from "+clazs+where+clause;
			System.out.println(string);
			if(values != null){
				i=1;
				for(Object value : values){
					statement.setObject(i++, value);
				}
			}
			try {
				ResultSet rs = statement.executeQuery();
				
				ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();
				int row = rs.getRow();
				System.out.println(row);
				List<Object[]> list = new ArrayList<Object[]>();
				while(rs.next()){
//					T t = class1.newInstance();
//					
//					SQLFunction.convertToT(t, rs);
					
					Object[] obj = new Object[row];
					int ix = 0;
					for (int j = 0; j < columnCount; j++) {
						obj[ix++] = rs.getObject(j+1);
					}
					
					list.add(obj);
				}
				return list;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
