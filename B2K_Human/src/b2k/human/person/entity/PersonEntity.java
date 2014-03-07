package b2k.human.person.entity;


import java.util.Date;

import b2k.help.AgeCalculation;
import b2k.lib.connector.Entity;
import b2k.lib.connector.EntityConverter;
import b2k.lib.connector.MongoConnector;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


public class PersonEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String PERSON_NO = "personNo";
	public static String PERSON_ID = "personID";
	public static String LAST_NAME = "lastName";
	public static String FIRST_NAME = "firstName";
	public static String GENDER = "gender";
	public static String BIRTH_DAY = "birthday";
	public static String NATIONAL = "national";

	public PersonEntity() {
		super();
	}

	public PersonEntity(DBObject dbObject) {
		super(dbObject);
	}

	public PersonEntity(int personNo, String personID, String lastName,
			String firstName, String gender, Date birthday) {
		super();
		setPersonNo(personNo);
		setPersonID(personID);
		setLastName(lastName);
		setFirstName(firstName);
		setGender(gender);
		setBirthday(birthday);
	}

	public int getPersonNo() {
		return EntityConverter.getValue(Integer.class, get(PERSON_NO));
	}

	public void setPersonNo(int personNo) {
		put(PERSON_NO, personNo);
	}

	public String getPersonID() {
		return EntityConverter.getValue(String.class, get(PERSON_ID));
	}

	public void setPersonID(String personID) {
		put(PERSON_ID, personID);
	}

	public String getLastName() {
		return EntityConverter.getValue(String.class, get(LAST_NAME));
	}

	public void setLastName(String lastName) {
		put(LAST_NAME, lastName);
	}

	public String getFirstName() {
		return EntityConverter.getValue(String.class, get(FIRST_NAME));
	}

	public void setFirstName(String firstName) {
		put(FIRST_NAME, firstName);
	}

	public String getGender() {
		return EntityConverter.getValue(String.class, get(GENDER));
	}

	public void setGender(String gender) {
		put(GENDER, gender);
	}

	public Date getBirthday() {
		return EntityConverter.getValue(Date.class, get(BIRTH_DAY));
	}

	public void setBirthday(Date birthday) {
		put(BIRTH_DAY, birthday);
	}

	public void setNational(String national) {
		put(NATIONAL, national);
	}

	public String getNational() {
		return EntityConverter.getValue(String.class, get(NATIONAL));
	}

	public int getAge() {
		return AgeCalculation.getAgeByBirthDay(getBirthday());
	}

	@Override
	public String toString() {
		return getFirstName();
	}

	// public static List<PersonEntity> find(BasicDBObject document) {
	// MongoConnector.regit("localhost", "db");
	//
	// DBCollection collection = MongoConnector.getDB()
	// .getCollection("person");
	// DBCursor find = collection.find(document);
	//
	// List<PersonEntity> list = new ArrayList<PersonEntity>();
	//
	// while (find.hasNext()) {
	// DBObject next = find.next();
	// PersonEntity personEntity = new PersonEntity(next);
	//
	// list.add(personEntity);
	//
	// }
	//
	// return list;
	//
	// }
	//
	// public static PersonEntity findByID(String id) {
	// MongoConnector.regit("localhost", "db");
	//
	// DBCollection collection = MongoConnector.getDB()
	// .getCollection("person");
	// BasicDBObject document = new BasicDBObject();
	// document.put("personID", id);
	//
	// System.out.println(document);
	//
	// DBCursor find = collection.find(document);
	//
	// while (find.hasNext()) {
	// DBObject next = find.next();
	// PersonEntity personEntity = new PersonEntity(next);
	//
	// return personEntity;
	// }
	//
	// return null;
	//
	// }
	//
	// public PersonEntity update() {
	// MongoConnector.regit("localhost", "db");
	//
	// DBCollection collection = MongoConnector.getDB()
	// .getCollection("person");
	// BasicDBObject document = new BasicDBObject();
	// document.put("_id", get("_id"));
	// collection.update(document, this);
	// return this;
	//
	// }
	//
	// public PersonEntity updateByID() {
	// MongoConnector.regit("localhost", "db");
	//
	// DBCollection collection = MongoConnector.getDB()
	// .getCollection("person");
	// BasicDBObject document = new BasicDBObject();
	// document.put("personID", getPersonID());
	// collection.update(document, this);
	// return this;
	//
	// }
	//
	// public static PersonEntity update(PersonEntity entity) {
	// MongoConnector.regit("localhost", "db");
	//
	// DBCollection collection = MongoConnector.getDB()
	// .getCollection("person");
	// BasicDBObject document = new BasicDBObject();
	// document.put("personID", entity.getPersonID());
	// collection.update(document, entity);
	// return entity;
	//
	// }
	//
	// public PersonEntity save() {
	// MongoConnector.regit("localhost", "db");
	//
	// DBCollection collection = MongoConnector.getDB()
	// .getCollection("person");
	//
	// collection.save(this);
	// return this;
	//
	// }
	//
	// public static PersonEntity save(PersonEntity o) {
	// MongoConnector.regit("localhost", "db");
	//
	// DBCollection collection = MongoConnector.getDB()
	// .getCollection("person");
	//
	// collection.save(o);
	//
	// return o;
	//
	// }
	//
	// public int delete() {
	// MongoConnector.regit("localhost", "db");
	//
	// DBCollection collection = MongoConnector.getDB()
	// .getCollection("person");
	//
	// WriteResult remove = collection.remove(this);
	//
	// return remove.getN();
	//
	// }
	//
	// public static int delete(BasicDBObject document) {
	// MongoConnector.regit("localhost", "db");
	// DBCollection collection = MongoConnector.getDB()
	// .getCollection("person");
	// WriteResult remove = collection.remove(document);
	// return remove.getN();
	//
	// }
	//
	// public int deleteByID() {
	// MongoConnector.regit("localhost", "db");
	// DBCollection collection = MongoConnector.getDB()
	// .getCollection("person");
	// BasicDBObject document = new BasicDBObject();
	// document.put("personID", getPersonID());
	//
	// WriteResult remove = collection.remove(document);
	//
	// return remove.getN();
	//
	// }

	public static void main(String[] args) {

		//
		MongoConnector.regit("localhost", "db");

		DBCollection collection = MongoConnector.getDB()
				.getCollection("person");
		//
		// // if (true) {
		// PersonEntity personEntity = new PersonEntity(0, "PS00002",
		// "Nguyễn Lê Đình", "Khai3", "Nam", new Date(
		// System.currentTimeMillis()));
		// if (true) {
		// personEntity.save();
		//
		// DBCursor find = collection.find();
		// while (find.hasNext()) {
		// DBObject next = find.next();
		// System.out.println(next);
		// // PersonEntity personEntity = new PersonEntity(next);
		// //
		// // System.out.println(personEntity.getPersonNo());
		// }
		// }
		System.out.println("----------------");
		if (true) {
			// personEntity.delete();

			DBCursor find = collection.find();
			while (find.hasNext()) {
				DBObject next = find.next();
				System.out.println(next);
				// PersonEntity personEntity = new PersonEntity(next);
				//
				// System.out.println(personEntity.getPersonNo());
			}
		}

		// int deleteByID = personEntity.deleteByID();
		// System.out.println(deleteByID);
		// //
		// // collection.save(personEntity);
		// // }
		// //
		// // if (true) {
		// PersonEntity personEntity = new PersonEntity(0, "PS00005",
		// "Lê Nguyên",
		// "Khìn", "Nam", new Date(System.currentTimeMillis()));
		// personEntity.save();
		// //
		// // collection.save(personEntity);
		// // }
		// //
		// // BasicDBObject document = new BasicDBObject();
		// // document.put("personID", "PS00002");
		// // // collection.remove(document);

	}

}
