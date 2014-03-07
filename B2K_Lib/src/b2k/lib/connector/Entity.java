package b2k.lib.connector;

import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public abstract class Entity extends BasicDBObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4624121878192030637L;
	public static String KEY_ID = "_id";

	public Entity() {
		super();
	}

	public String getKey_ID() {
		return EntityConverter.getValue(String.class, get(KEY_ID));
	}

	public Entity(DBObject dbObject) {
		super();

		Iterator<String> iterator = dbObject.keySet().iterator();

		while (iterator.hasNext()) {
			String next = iterator.next();
			put(next, dbObject.get(next));
		}

	}
	
	public void set(DBObject dbObject){

		Iterator<String> iterator = dbObject.keySet().iterator();

		while (iterator.hasNext()) {
			String next = iterator.next();
			put(next, dbObject.get(next));
		}

	}

}
