package b2k.reception.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.commons.io.FileUtils;

import b2k.human.person.entity.AddressEntity;
import b2k.human.person.entity.ContactEntity;
import b2k.human.person.entity.PersonEntity;
import b2k.human.person.layout.ControllerPerson;
import b2k.human.person.layout.ControllerRegistryPerson;
import b2k.lib.connector.EntityMethod;
import b2k.lib.connector.MongoConnector;
import b2k.lib.util.ProcessData;
import b2k.lib.util.ProcessFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ControllerReception extends LayoutReception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControllerPerson _clp;

	public ControllerReception() {
		super();
		initActions();
		initDatas();
	}

	private void initActions() {

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println(txtPatientID.getText());
				// PersonEntity entity = PersonEntity.findByID(txtPatientID
				// .getText());

				// System.out.println(entity);

				// DBObject exec = ProcessFactory.exec("q1", "private", "p1",
				// entity);

				if (true) {
					List<PersonEntity> find = EntityMethod.find(
							PersonEntity.class,
							new BasicDBObject(PersonEntity.PERSON_ID,
									txtPatientID.getText()), "person");

					for (PersonEntity s : find) {
						_clp.setPerson(s);
						break;

					}

				}
				if (true) {
					List<ContactEntity> find = EntityMethod.find(
							ContactEntity.class,
							new BasicDBObject(ContactEntity.FK_ID, txtPatientID
									.getText()), "contacts");

					for (ContactEntity s : find) {
						_clp.setContact(s);
						break;

					}

				}
				if (true) {
					List<AddressEntity> find = EntityMethod.find(
							AddressEntity.class,
							new BasicDBObject(AddressEntity.FK_ID, txtPatientID
									.getText()), "addresses");

					for (AddressEntity s : find) {
						_clp.setAddress(s);
						break;

					}

				}
			}
		});
	}

	public DBObject searchPerson(DBObject object) {

		// MongoConnector.regit("localhost", "db");
		//
		// DBCollection collection = MongoConnector.getDB()
		// .getCollection("person");
		// DBCursor find = collection.find();
		// while (find.hasNext()) {
		// DBObject next = find.next();
		// PersonEntity personEntity = new PersonEntity(next);
		//
		// return personEntity;
		// }

		// String personID = (String) object.get("personID");

		return null;

	}

	private void initDatas() {

		// loadingData();

		try {

			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:PersonData.b2k";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {

				Statement statement = conn.createStatement();
				statement.setQueryTimeout(30);
				ResultSet rs = statement.executeQuery("select * from PROCESS");
				while (rs.next()) {
					List<String> ls = new ArrayList<String>();
					// System.out.println("name = " +
					// rs.getString("f2"));

					ls.add(rs.getString(2));
					ls.add(rs.getString(3));
					ls.add(rs.getString(4));
					ls.add(rs.getString(5));
					ls.add(rs.getString(6));
					ls.add(rs.getString(7));
					ls.add(rs.getString(8));
					ls.add(rs.getString(9));
					ProcessData.addData(ls);

					System.out.println("------------------------ " + ls);
				}
				conn.close();
			}

			new ProcessFactory();

			MongoConnector.regit("localhost", "db");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// DBObject exec = ProcessFactory.exec("q1", "private", "p1", null);

		_clp = new ControllerPerson();
		addPersonInfoLayout(_clp);
		addPersonInfoLayout(new ControllerRegistryPerson());

	}

	private static void loadingData() {

		Connection connection = null;
		try {

			File file = FileUtils.getFile("PersonData.b2k");

			if (!file.exists()) {
				// Xử lý khi không thấy file
				file.createNewFile();
			}

			Class.forName("org.sqlite.JDBC");
			// create a database connection
			connection = DriverManager
					.getConnection("jdbc:sqlite:PersonData.b2k");
			Statement statement = connection.createStatement();

			statement.setQueryTimeout(30); // set timeout to 30 sec.

			// statement.executeUpdate("drop table if exists t1");
			// statement.executeUpdate("drop table if exists t2");
			// statement.executeUpdate("drop table if exists t3");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS  'PROCESS' ("
					+ " '_ID' INTEGER PRIMARY KEY AUTOINCREMENT  ,"
					+ " 'Queue' TEXT NOT NULL,"
					+ " 'Operation' TEXT NOT NULL ,"
					+ " 'Class' TEXT NOT NULL ," + ""
					+ " 'Method' TEXT NOT NULL ," + " 'Type' TEXT NOT NULL ,"
					+ " 'Version' TEXT NOT NULL,"
					+ " 'Description'  TEXT NOT NULL,"
					+ " 'Status'  TEXT NOT NULL )");
			//
			statement
					.executeUpdate("INSERT INTO PROCESS(Queue,Operation,Class,Method,Type,Version,Description,Status) SELECT 'q1','p1','b2k.reception.controller.ControllerReception','searchPerson','private','1.0.0.0','','U' WHERE NOT EXISTS (SELECT 1 FROM PROCESS WHERE Queue = 'q1' and Operation = 'p1')");

			// statement
			// .executeUpdate("INSERT INTO t1(f2,f3,f4,f5,f6,f7) SELECT 'q1','p2','b2k.person.process.PersonProcess','saveAddress','private','U' WHERE NOT EXISTS (SELECT 1 FROM t1 WHERE f2 = 'q1' and f3 = 'p2')");
			// statement
			// .executeUpdate("INSERT INTO t1(f2,f3,f4,f5,f6,f7) SELECT 'q1','p3','b2k.person.process.PersonProcess','loadPersonList','private','U' WHERE NOT EXISTS (SELECT 1 FROM t1 WHERE f2 = 'q1' and f3 = 'p3')");
			// statement
			// .executeUpdate("INSERT INTO t1(f2,f3,f4,f5,f6,f7) SELECT 'q1','p4','b2k.person.process.PersonProcess','doSavePersonInfo','private','U' WHERE NOT EXISTS (SELECT 1 FROM t1 WHERE f2 = 'q1' and f3 = 'p4')");
			//
			// statement
			// .executeUpdate("INSERT INTO t1(f2,f3,f4,f5,f6,f7) SELECT 'q1','p5','b2k.person.process.PersonProcess','doSelectedPerson','private','U' WHERE NOT EXISTS (SELECT 1 FROM t1 WHERE f2 = 'q1' and f3 = 'p5')");

			// Person: "T2" No;ID,First,Lass,BirthDay,Gender
			// statement
			// .executeUpdate("CREATE TABLE IF NOT EXISTS  'T2' ('f1' INTEGER PRIMARY KEY  AUTOINCREMENT, 'f2' TEXT NOT NULL, 'f3' TEXT NOT NULL , 'f4' TEXT NOT NULL , 'f5' LONG NOT NULL , 'f6' TEXT NOT NULL)");

			// Address: "T3" No,FKNo,FKID,Address,Province
			// statement
			// .executeUpdate("CREATE TABLE IF NOT EXISTS  'T3' ('f1' INTEGER PRIMARY KEY  AUTOINCREMENT , 'f2' INTEGER NOT NULL, 'f3' TEXT NOT NULL , 'f4' TEXT NOT NULL , 'f5' TEXT NOT NULL )");

			// int executeUpdate = statement
			// .executeUpdate("UPDATE 'T2' SET f2='P00003' WHERE f1=3");
			// System.out.println(executeUpdate);

		} catch (Exception e) {
			e.printStackTrace();
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e);
			}
		}

	}

	protected void doRemove() {

		pnPersonLay.remove(_clp);
		Dimension preferredSize = pnPersonLay.getPreferredSize();
		Dimension preferredSize2 = _clp.getPreferredSize();
		pnPersonLay.setPreferredSize(new Dimension(preferredSize.width,
				preferredSize.height - preferredSize2.height));
		pnPersonLay.setMinimumSize(pnPersonLay.getPreferredSize());

		pnPersonLay.updateUI();

		pnPatientInformation.updateUI();
	}

	public void addPersonInfoLayout(JPanel panel) {

		Dimension preferredSize = pnPersonLay.getPreferredSize();
		Dimension preferredSize2 = panel.getPreferredSize();
		pnPersonLay.setPreferredSize(new Dimension(preferredSize.width,
				preferredSize.height + preferredSize2.height));
		pnPersonLay.setMinimumSize(pnPersonLay.getPreferredSize());

		int componentCount = pnPersonLay.getComponentCount() + 1;

		pnPersonLay.add(panel, getgb(componentCount));

		if (componentCount > si) {
			si = si + 10;
			pnPersonLay.add(getLblEmp1(), getgbEnd());
		}

		pnPersonLay.updateUI();

		pnPatientInformation.updateUI();

	}
}
