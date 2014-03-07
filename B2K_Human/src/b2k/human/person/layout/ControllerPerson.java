package b2k.human.person.layout;

import java.sql.Timestamp;

import b2k.help.CommonMethod;
import b2k.human.person.entity.AddressEntity;
import b2k.human.person.entity.ContactEntity;
import b2k.human.person.entity.PersonEntity;

public class ControllerPerson extends LayoutPerson {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerPerson() {
	}

//	public static void main(String[] args) {
//
//		// ControllerPerson controllerPerson = new ControllerPerson();
//		// provinces contacts addresses person
//		MongoConnector.regit("localhost", "db");
//		// ProvinceEntity entity = new ProvinceEntity(new BasicDBObject(
//		// ProvinceEntity.PROVINCE_CODE, "HCM").append(
//		// ProvinceEntity.PROVINCE_NAME, "Hồ Chí Minh"));
//
//		PersonEntity entity = new PersonEntity(new BasicDBObject(
//				PersonEntity.PERSON_ID, "PS00006")
//				.append(PersonEntity.LAST_NAME, "Nguyen Le Dinh")
//				.append(PersonEntity.FIRST_NAME, "Bao")
//				.append(PersonEntity.GENDER, "NAM")
//				.append(PersonEntity.BIRTH_DAY,
//						new Date(System.currentTimeMillis()))
//				.append(PersonEntity.NATIONAL, "Việt Nam"));
//
//		EntityMethod.save(entity, "person");
//
//		// EntityMethod.delete(new BasicDBObject(), "person");
//		List<PersonEntity> find = EntityMethod.find(PersonEntity.class,
//				new BasicDBObject(), "person");
//
//		for (PersonEntity c : find) {
//			System.out.println(c);
//			Object object = c.get(PersonEntity.BIRTH_DAY);
//
//			System.out.println(object.getClass().getName());
//			System.out.println(c.get(PersonEntity.BIRTH_DAY));
//		}
//
//		//
//		// DBCollection collection = MongoConnector.getDB()
//		// .getCollection("person");
//		// DBCursor find = collection.find();
//		// while (find.hasNext()) {
//		// DBObject next = find.next();
//		// PersonEntity personEntity = new PersonEntity(next);
//		// controllerPerson.setPerson(personEntity);
//		// break;
//		// }
//		//
//		// JFrame jFrame = new JFrame();
//		//
//		// jFrame.setSize(800, 600);
//		// jFrame.setContentPane(controllerPerson);
//		// jFrame.setVisible(true);
//
//	}

	public void setPerson(PersonEntity entity) {
		if (entity == null)
			return;
		lblTitle.setText(entity.getLastName() + " " + entity.getFirstName());

		Timestamp timestamp = null;

		java.util.Date birthday = entity.getBirthday();

		if (birthday != null) {
			timestamp = new Timestamp(birthday.getTime());
		}
		txtBirthday.setText(CommonMethod.convertDate(timestamp));
		txtGender.setText(entity.getGender());
		lblID.setText(entity.getPersonID());
		txtNational.setText(entity.getNational());

	}

	public void setContact(ContactEntity contactEntity) {

		if (contactEntity == null)
			return;

		txtPhone.setText(contactEntity.getPHONE());
		txtEmail.setText(contactEntity.getEMAIL());

	}

	public void setAddress(AddressEntity entity) {
		if (entity == null)
			return;

		txtAddress.setText("<html>"+entity.getADDRESS() + " " + entity.getPROVINCE());
	}

}
