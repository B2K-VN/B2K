package b2k.human.person.entity;

import b2k.lib.connector.Entity;
import b2k.lib.connector.EntityConverter;

import com.mongodb.DBObject;

public class ProvinceEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String PROVINCE_CODE = "provincecode";
	public static String PROVINCE_NAME = "provincename";

	public ProvinceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProvinceEntity(DBObject dbObject) {
		super(dbObject);
		// TODO Auto-generated constructor stub
	}

	public String getPROVINCE_CODE() {
		return EntityConverter.getValue(String.class, get(PROVINCE_CODE));
	}

	public void setPROVINCE_CODE(String pROVINCE_CODE) {
		put(PROVINCE_CODE, pROVINCE_CODE);
	}

	public String getPROVINCE_NAME() {
		return EntityConverter.getValue(String.class, get(PROVINCE_NAME));
	}

	public void setPROVINCE_NAME(String pROVINCE_NAME) {
		put(PROVINCE_NAME, pROVINCE_NAME);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getPROVINCE_NAME();
	}
}
