package b2k.human.person.entity;

import java.util.ArrayList;
import java.util.List;

import b2k.lib.connector.Entity;
import b2k.lib.connector.MongoConnector;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class HumanFactory {
	
	public static List<PersonEntity> find(BasicDBObject document) {
		DBCollection collection = MongoConnector.getDB()
				.getCollection("person");
		DBCursor find = collection.find(document);

		List<PersonEntity> list = new ArrayList<PersonEntity>();

		while (find.hasNext()) {
			DBObject next = find.next();
			PersonEntity personEntity = new PersonEntity(next);

			list.add(personEntity);

		}

		return list;

	}

	public static PersonEntity findByID(String id) {

		DBCollection collection = MongoConnector.getDB()
				.getCollection("person");
		BasicDBObject document = new BasicDBObject();
		document.put(PersonEntity.PERSON_ID, id);

		DBCursor find = collection.find(document);

		while (find.hasNext()) {
			DBObject next = find.next();
			PersonEntity personEntity = new PersonEntity(next);

			return personEntity;
		}

		return null;

	}


	public static PersonEntity update(PersonEntity entity) {

		DBCollection collection = MongoConnector.getDB()
				.getCollection("person");
		BasicDBObject document = new BasicDBObject();
		document.put(PersonEntity.PERSON_ID, entity.getPersonID());
		collection.update(document, entity);
		return entity;

	}

	

	public static PersonEntity save(PersonEntity o) {

		DBCollection collection = MongoConnector.getDB()
				.getCollection("person");
		collection.save(o);

		return o;

	}

	
	public static int delete(BasicDBObject document) {
		DBCollection collection = MongoConnector.getDB()
				.getCollection("person");
		WriteResult remove = collection.remove(document);
		return remove.getN();

	}



	public int deleteByID(String id) {
		DBCollection collection = MongoConnector.getDB()
				.getCollection("person");
		BasicDBObject document = new BasicDBObject();
		document.put(PersonEntity.PERSON_ID, id);
		WriteResult remove = collection.remove(document);

		return remove.getN();

	}
}
