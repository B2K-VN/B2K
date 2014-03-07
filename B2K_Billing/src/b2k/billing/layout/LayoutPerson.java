package b2k.billing.layout;

import images.ImageHelper;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import b2k.help.MyLabel;

public class LayoutPerson extends JPanel {

	private static final long serialVersionUID = 1L;
	private MyLabel lblImage = null;
	private MyLabel lblID = null;
	private MyLabel lblRegistrationDate = null;
	private MyLabel lblTitle = null;
	private MyLabel txtGender = null;
	private MyLabel lblGender = null;
	private MyLabel lblAddress = null;
	private MyLabel lblNational = null;

	/**
	 * This is the default constructor
	 */
	public LayoutPerson() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
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
		this.add(getTxtGender(), null);
		this.add(getTxtNational(), null);
		this.add(getTxtAddress(), null);
		this.add(getLblPhone(), null);
		this.add(getLblEmail(), null);
		this.add(getTxtPhone(), null);
		this.add(getTxtEmail(), null);
	}

	/**
	 * This method initializes lblImage
	 * 
	 * @return javax.swing.MyLabel
	 */
	ImageIcon imageIcon = ImageHelper.getDisplayImage(new ImageIcon(getClass()
			.getResource("/b2k/reception/layout/picture_demo.jpg")), 121);
	ImageIcon imageIcon1 = ImageHelper.getDisplayImage(new ImageIcon(getClass()
			.getResource("/b2k/reception/layout/id_demo.jpg")), 101, true);
	private MyLabel txtBirthday = null;
	private MyLabel txtNational = null;
	private MyLabel txtAddress = null;
	private MyLabel lblPhone = null;
	private MyLabel lblEmail = null;
	private MyLabel txtPhone = null;
	private MyLabel txtEmail = null;

	private MyLabel getLblImage() {
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
	private MyLabel getLblID() {
		if (lblID == null) {
			lblID = new MyLabel(14f);
			lblID.setBounds(new Rectangle(290, 10, 101, 61));
			// lblID.setBorder(BorderFactory.createRaisedBevelBorder());
			lblID.setIcon(imageIcon1);
			lblID.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblID;
	}

	/**
	 * This method initializes lblRegistrationDate
	 * 
	 * @return javax.swing.MyLabel
	 */
	private MyLabel getLblRegistrationDate() {
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
	private MyLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new MyLabel(16f);
			lblTitle.setText("TRẦN THỊ YẾN VY");
			lblTitle.setBounds(new Rectangle(120, 10, 251, 30));
			lblTitle.setBold();
		}
		return lblTitle;
	}

	/**
	 * This method initializes txtGender
	 * 
	 * @return b2k.help.MyLabel
	 */
	private MyLabel getTxtGender() {
		if (txtGender == null) {
			txtGender = new MyLabel(14f);
			txtGender.setText("NAM");
			txtGender.setBounds(new Rectangle(205, 70, 138, 25));
			txtGender.setPlain();
		}
		return txtGender;
	}

	/**
	 * This method initializes lblGender
	 * 
	 * @return b2k.help.MyLabel
	 */
	private MyLabel getLblGender() {
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
	private MyLabel getLblAddress() {
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
	private MyLabel getLblNational() {
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
	private MyLabel getTxtBirthday() {
		if (txtBirthday == null) {
			txtBirthday = new MyLabel(14f);
			txtBirthday.setText("11-04-1987");
			txtBirthday.setBounds(new Rectangle(205, 45, 176, 25));
			txtBirthday.setPlain();
		}
		return txtBirthday;
	}

	/**
	 * This method initializes txtNational
	 * 
	 * @return b2k.help.MyLabel
	 */
	private MyLabel getTxtNational() {
		if (txtNational == null) {
			txtNational = new MyLabel(14f);
			txtNational.setText("Việt Nam");
			txtNational.setBounds(new Rectangle(205, 95, 167, 25));
			txtNational.setPlain();
		}
		return txtNational;
	}

	/**
	 * This method initializes txtAddress
	 * 
	 * @return b2k.help.MyLabel
	 */
	private MyLabel getTxtAddress() {
		if (txtAddress == null) {
			txtAddress = new MyLabel(14f);
			txtAddress
					.setText("<html>382 Nguyễn Tri Phương Phường 7, Mỹ Tho, Tiền Giang");
			txtAddress.setBounds(new Rectangle(60, 170, 326, 46));
		}
		return txtAddress;
	}

	/**
	 * This method initializes lblPhone
	 * 
	 * @return b2k.help.MyLabel
	 */
	private MyLabel getLblPhone() {
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
	private MyLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new MyLabel(14f);
			lblEmail.setText("Email:");
			lblEmail.setBounds(new Rectangle(120, 145, 41, 25));
		}
		return lblEmail;
	}

	/**
	 * This method initializes txtPhone
	 * 
	 * @return b2k.help.MyLabel
	 */
	private MyLabel getTxtPhone() {
		if (txtPhone == null) {
			txtPhone = new MyLabel(14f);
			txtPhone.setText("0906781862");
			txtPhone.setBounds(new Rectangle(205, 120, 186, 25));
			txtPhone.setPlain();
		}
		return txtPhone;
	}

	/**
	 * This method initializes txtEmail
	 * 
	 * @return b2k.help.MyLabel
	 */
	private MyLabel getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new MyLabel(14f);
			txtEmail.setText("tranthiyenvy@gmail.com");
			txtEmail.setBounds(new Rectangle(205, 145, 191, 25));
		}
		return txtEmail;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
