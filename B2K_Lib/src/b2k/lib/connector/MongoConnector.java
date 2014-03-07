package b2k.lib.connector;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoConnector {

	static MongoClient mongoClient = null;
	static DB db = null;

	public static DB getDB() {
		return db;
	}

	public static void regit(String client, String name) {
		try {
			mongoClient = new MongoClient(client);
			db = mongoClient.getDB(name);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
