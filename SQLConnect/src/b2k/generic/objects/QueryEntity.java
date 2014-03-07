/**
 * 
 */
package b2k.generic.objects;

/**
 * @author khai.nld
 *
 */
public class QueryEntity {
	public QueryEntity() {
	}
	private String key = null;
	
	private String condition = "=";

	private Object value = null;
	
	private boolean parameterInd = false;

	/**
	 * @param key
	 * @param condition
	 * @param value
	 * @param classCode
	 */
	public QueryEntity(String key, String condition, Object value,
			boolean parameterInd) {
		super();
		this.key = key;
		this.condition = condition;
		this.value = value;
		this.parameterInd = parameterInd;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public boolean isParameterInd() {
		return parameterInd;
	}

	public void setParameterInd(boolean parameterInd) {
		this.parameterInd = parameterInd;
	}
}
