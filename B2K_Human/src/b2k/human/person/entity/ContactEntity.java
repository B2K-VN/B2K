package b2k.human.person.entity;

import b2k.lib.connector.Entity;
import b2k.lib.connector.EntityConverter;

import com.mongodb.DBObject;

public class ContactEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String FK_ID = "contactfkid";
	public static String PHONE = "phone";
	public static String EMAIL = "email";

	public ContactEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactEntity(DBObject dbObject) {
		super(dbObject);
		// TODO Auto-generated constructor stub
	}

	public String getFK_ID() {

		return EntityConverter.getValue(String.class, get(FK_ID));
	}

	public void setFK_ID(String fK_ID) {
		put(FK_ID, fK_ID);
	}

	public String getPHONE() {
		return EntityConverter.getValue(String.class, get(PHONE));
	}

	public void setPHONE(String pHONE) {
		put(FK_ID, pHONE);
	}

	public String getEMAIL() {
		return EntityConverter.getValue(String.class, get(EMAIL));
	}

	public void setEMAIL(String eMAIL) {
		put(FK_ID, eMAIL);
	}

}
