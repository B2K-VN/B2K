/**
 * 
 */
package b2k.generic.objects;

import java.util.List;

/**
 * @author khai.nld
 *
 */
public class GroupQuery {

	private String operator = null;
	
	private List<QueryEntity> queryEntities = null;
	
	private List<GroupQuery> groupQueries = null;

	public GroupQuery(String operator, List<QueryEntity> queryEntities,
			List<GroupQuery> groupQueries) {
		super();
		this.operator = operator;
		this.queryEntities = queryEntities;
		this.groupQueries = groupQueries;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<QueryEntity> getQueryEntities() {
		return queryEntities;
	}

	public void setQueryEntities(List<QueryEntity> queryEntities) {
		this.queryEntities = queryEntities;
	}

	public List<GroupQuery> getGroupQueries() {
		return groupQueries;
	}

	public void setGroupQueries(List<GroupQuery> groupQueries) {
		this.groupQueries = groupQueries;
	}
	
	
}
