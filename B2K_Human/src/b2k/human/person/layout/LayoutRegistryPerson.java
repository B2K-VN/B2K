package b2k.human.person.layout;

import images.ImageHelper;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import b2k.help.MyCheckBox;
import b2k.help.MyComboBox;
import b2k.help.MyDateTextField;
import b2k.help.MyLabel;
import b2k.help.MyTextArea;
import b2k.help.MyTextField;

public class LayoutRegistryPerson extends JPanel {

	protected static final long serialVersionUID = 1L;
	protected MyLabel lblImage = null;
	protected MyLabel lblID = null;
	protected MyLabel lblRegistrationDate = null;
	protected MyTextField lblTitle = null;
	protected MyLabel lblGender = null;
	protected MyLabel lblAddress = null;
	protected MyLabel lblNational = null;

	/**
	 * This is the default constructor
	 */
	public LayoutRegistryPerson() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	protected void initialize() {
		this.setSize(400, 219);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(300, 219));
		this.setMinimumSize(this.getPreferredSize());
		this.add(getLblImage(), null);
		this.add(getLblID(), null);
		this.add(getLblRegistrationDate(), null);
		this.add(getLblTitle(), null);
		this.add(getLblGender(), null);
		this.add(getLblAddress(), null);
		this.add(getLblNational(), null);
		this.add(getTxtBirthday(), null);
		this.add(getLblPhone(), null);
		this.add(getLblEmail(), null);
		this.add(getChMale(), null);
		this.add(getChFemale(), null);
		this.add(getCmbNational(), null);
		this.add(getTxtPhone(), null);
		this.add(getTxtEmail(), null);
		this.add(getTxtAddress(), null);
		this.add(getLblAge(), null);
		this.add(getTxtAge(), null);
	}

	/**
	 * This method initializes lblImage
	 * 
	 * @return javax.swing.MyLabel
	 */
	ImageIcon imageIcon = ImageHelper.getDisplayImage(new ImageIcon(getClass()
			.getResource("/b2k/human/person/layout/picture_demo.jpg")), 121);
	ImageIcon imageIcon1 = ImageHelper.getDisplayImage(new ImageIcon(getClass()
			.getResource("/b2k/human/person/layout/id_demo.jpg")), 101, true);
	protected MyDateTextField txtBirthday = null;
	protected MyLabel lblPhone = null;
	protected MyLabel lblEmail = null;
	protected MyCheckBox chMale = null;
	protected MyCheckBox chFemale = null;
	protected MyComboBox cmbNational = null;
	protected MyTextField txtPhone = null;
	protected MyTextField txtEmail = null;
	protected MyTextArea txtAddress = null;
	protected MyLabel lblAge = null;
	protected MyTextField txtAge = null;

	protected MyLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new MyLabel();
			lblImage.setBounds(new Rectangle(10, 10, 101, 121));
			lblImage.setIcon(imageIcon);
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBorder(BorderFactory.createRaisedBevelBorder());
		}
		return lblImage;
	}

	/**
	 * This method initializes lblID
	 * 
	 * @return javax.swing.MyLabel
	 */
	protected MyLabel getLblID() {
		if (lblID == null) {
			lblID = new MyLabel(14f);
			lblID.setBounds(new Rectangle(10, 132, 101, 30));
			// lblID.setBorder(BorderFactory.createRaisedBevelBorder());
			lblID.setText("PAT000001");
			lblID.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblID;
	}

	/**
	 * This method initializes lblRegistrationDate
	 * 
	 * @return javax.swing.MyLabel
	 */
	protected MyLabel getLblRegistrationDate() {
		if (lblRegistrationDate == null) {
			lblRegistrationDate = new MyLabel(14f);
			lblRegistrationDate.setText("Ngày sinh:");
			lblRegistrationDate.setBounds(new Rectangle(120, 45, 76, 25));

		}
		return lblRegistrationDate;
	}

	/**
	 * This method initializes lblTitle
	 * 
	 * @return javax.swing.MyLabel
	 */
	protected MyTextField getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new MyTextField(16f);
			lblTitle.setText("TRẦN THỊ YẾN VY");
			lblTitle.setBounds(new Rectangle(120, 10, 271, 30));
		}
		return lblTitle;
	}

	/**
	 * This method initializes lblGender
	 * 
	 * @return b2k.help.MyLabel
	 */
	protected MyLabel getLblGender() {
		if (lblGender == null) {
			lblGender = new MyLabel(14f);
			lblGender.setText("Giới tính:");
			lblGender.setBounds(new Rectangle(120, 70, 64, 25));
		}
		return lblGender;
	}

	/**
	 * This method initializes lblAddress
	 * 
	 * @return b2k.help.MyLabel
	 */
	protected MyLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new MyLabel(14f);
			lblAddress.setText("Địa chỉ:");
			lblAddress.setBounds(new Rectangle(5, 170, 51, 25));
		}
		return lblAddress;
	}

	/**
	 * This method initializes lblNational
	 * 
	 * @return b2k.help.MyLabel
	 */
	protected MyLabel getLblNational() {
		if (lblNational == null) {
			lblNational = new MyLabel(14f);
			lblNational.setText("Quốc tịch:");
			lblNational.setBounds(new Rectangle(120, 95, 71, 25));
		}
		return lblNational;
	}

	/**
	 * This method initializes txtBirthday
	 * 
	 * @return b2k.help.MyLabel
	 */
	protected MyDateTextField getTxtBirthday() {
		if (txtBirthday == null) {
			txtBirthday = new MyDateTextField(14f);
			// txtBirthday.setText("11-04-1987");
			txtBirthday.setBounds(new Rectangle(205, 46, 110, 23));
			// txtBirthday.setPlain();
		}
		return txtBirthday;
	}

	/**
	 * This method initializes lblPhone
	 * 
	 * @return b2k.help.MyLabel
	 */
	protected MyLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new MyLabel(14f);
			lblPhone.setText("Điện thoại:");
			lblPhone.setBounds(new Rectangle(120, 120, 75, 25));

		}
		return lblPhone;
	}

	/**
	 * This method initializes lblEmail
	 * 
	 * @return b2k.help.MyLabel
	 */
	protected MyLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new MyLabel(14f);
			lblEmail.setText("Email:");
			lblEmail.setBounds(new Rectangle(120, 145, 41, 25));
		}
		return lblEmail;
	}

	/**
	 * This method initializes chMale
	 * 
	 * @return javax.swing.MyCheckBox
	 */
	protected MyCheckBox getChMale() {
		if (chMale == null) {
			chMale = new MyCheckBox(14f);
			chMale.setText("Nam");
			chMale.setBounds(new Rectangle(205, 71, 66, 23));
		}
		return chMale;
	}

	/**
	 * This method initializes chFemale
	 * 
	 * @return javax.swing.MyCheckBox
	 */
	protected MyCheckBox getChFemale() {
		if (chFemale == null) {
			chFemale = new MyCheckBox(14f);
			chFemale.setText("Nữ");
			chFemale.setBounds(new Rectangle(275, 71, 56, 23));
		}
		return chFemale;
	}

	/**
	 * This method initializes cmbNational
	 * 
	 * @return javax.swing.MyComboBox
	 */
	protected MyComboBox getCmbNational() {
		if (cmbNational == null) {
			cmbNational = new MyComboBox(14f);
			cmbNational.setEditable(true);
			cmbNational.setBounds(new Rectangle(205, 96, 186, 23));
		}
		return cmbNational;
	}

	/**
	 * This method initializes txtPhone
	 * 
	 * @return javax.swing.MyTextField
	 */
	protected MyTextField getTxtPhone() {
		if (txtPhone == null) {
			txtPhone = new MyTextField(14f);
			txtPhone.setBounds(new Rectangle(205, 121, 186, 23));

		}
		return txtPhone;
	}

	/**
	 * This method initializes txtEmail
	 * 
	 * @return javax.swing.MyTextField
	 */
	protected MyTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new MyTextField(14f);
			txtEmail.setBounds(new Rectangle(205, 146, 186, 23));
		}
		return txtEmail;
	}

	/**
	 * This method initializes txtAddress
	 * 
	 * @return javax.swing.MyTextArea
	 */
	protected MyTextArea getTxtAddress() {
		if (txtAddress == null) {
			txtAddress = new MyTextArea(14f);
			txtAddress.setBounds(new Rectangle(61, 174, 330, 40));
			txtAddress.setLineWrap(true);
			txtAddress
					.setText("ZZZZZZZZZZMMMMMMMMMMMMMMMMMMMMMMZZZZZZZZZZZZZZZZZZZZMMMMMMMMMMMMZMMMMMMZMZMZMZZZZZZZZZZZMMMMMMMMMMMM");
		}
		return txtAddress;
	}

	/**
	 * This method initializes lblAge
	 * 
	 * @return b2k.help.MyLabel
	 */
	protected MyLabel getLblAge() {
		if (lblAge == null) {
			lblAge = new MyLabel(14f);
			lblAge.setText("Tuổi:");
			lblAge.setBounds(new Rectangle(320, 45, 35, 25));
		}
		return lblAge;
	}

	/**
	 * This method initializes txtAge
	 * 
	 * @return b2k.help.MyLabel
	 */
	protected MyTextField getTxtAge() {
		if (txtAge == null) {
			txtAge = new MyTextField(14f);
			txtAge.setText("100");
			txtAge.setBounds(new Rectangle(355, 45, 36, 25));
			txtAge.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return txtAge;
	}
}
