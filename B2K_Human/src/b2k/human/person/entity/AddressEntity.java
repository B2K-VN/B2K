package b2k.human.person.entity;

import b2k.lib.connector.Entity;
import b2k.lib.connector.EntityConverter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class AddressEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String FK_ID = "addressfkid";
	public static String FK_CODE = "addressfkcode";
	public static String ADDRESS = "address";
	public static String PROVINCE = "province";

	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressEntity(DBObject dbObject) {
		super(dbObject);
		// TODO Auto-generated constructor stub
	}

	public String getFK_ID() {
		return EntityConverter.getValue(String.class, get(FK_ID));
	}

	public void setFK_ID(String fK_ID) {
		put(FK_ID, fK_ID);
	}

	public String getFK_CODE() {
		return EntityConverter.getValue(String.class, get(FK_CODE));
	}

	public void setFK_CODE(String fK_CODE) {
		put(FK_CODE, fK_CODE);
	}

	public String getADDRESS() {
		return EntityConverter.getValue(String.class, get(ADDRESS));
	}

	public void setADDRESS(String aDDRESS) {
		put(ADDRESS, aDDRESS);
	}

	public ProvinceEntity getPROVINCE() {
		BasicDBObject value = EntityConverter.getValue(BasicDBObject.class,
				get(PROVINCE));
		if (value != null)
			return new ProvinceEntity(value);
		return null;
	}

	public void setPROVINCE(ProvinceEntity pROVINCE) {
		put(PROVINCE, pROVINCE);
	}

	public String getPROVINCE_CODE() {
		ProvinceEntity province2 = getPROVINCE();
		if (province2 == null)
			return "";

		return province2.getPROVINCE_CODE();
	}

	public String getPROVINCE_NAME() {
		ProvinceEntity province2 = getPROVINCE();
		if (province2 == null)
			return "";

		return province2.getPROVINCE_NAME();
	}

}
