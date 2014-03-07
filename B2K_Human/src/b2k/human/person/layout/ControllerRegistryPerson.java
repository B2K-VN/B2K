package b2k.human.person.layout;

import java.sql.Timestamp;

import b2k.help.AgeCalculation;
import b2k.human.person.entity.AddressEntity;
import b2k.human.person.entity.ContactEntity;
import b2k.human.person.entity.PersonEntity;

public class ControllerRegistryPerson extends LayoutRegistryPerson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerRegistryPerson() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public void setPerson(PersonEntity entity) {
		if (entity == null)
			return;
		lblTitle.setText(entity.getLastName() + " " + entity.getFirstName());

		Timestamp timestamp = null;

		java.util.Date birthday = entity.getBirthday();
		int ageByBirthDay = 0;
		if (birthday != null) {
			timestamp = new Timestamp(birthday.getTime());

			ageByBirthDay = AgeCalculation.getAgeByBirthDay(birthday);

		}

		txtBirthday.setTimestamp(timestamp);
		txtAge.setText("" + ageByBirthDay);

		if ("NAM".equals(entity.getGender())) {
			chMale.setSelected(true);
		} else {
			chFemale.setSelected(true);
		}

		lblID.setText(entity.getPersonID());

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

		txtAddress.setText("<html>" + entity.getADDRESS() + " "
				+ entity.getPROVINCE());
	}
}
