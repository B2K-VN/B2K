package b2k.billing.layout;

import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;

public class LayoutRegistryPerson extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblImage = null;
	private JLabel lblID = null;
	private JLabel lblRegistrationDate = null;
	private JLabel lblTitle = null;
	private JLabel jLabel = null;  //  @jve:decl-index=0:visual-constraint="356,299"
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
	private void initialize() {
		this.setSize(400, 256);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(300,200));
		this.setMinimumSize(this.getPreferredSize());
		this.add(getLblImage(), null);
		this.add(getLblID(), null);
		this.add(getLblRegistrationDate(), null);
		this.add(getLblTitle(), null);
	}

	/**
	 * This method initializes lblImage	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel();
			lblImage.setText("              [Hình]");
			lblImage.setBounds(new Rectangle(10, 10, 121, 136));
			lblImage.setBorder(BorderFactory.createRaisedBevelBorder());
		}
		return lblImage;
	}

	/**
	 * This method initializes lblID	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getLblID() {
		if (lblID == null) {
			lblID = new JLabel();
			lblID.setText("Mã bệnh nhân:");
			lblID.setBounds(new Rectangle(45, 175, 121, 54));
			lblID.setBorder(BorderFactory.createRaisedBevelBorder());
		}
		return lblID;
	}

	/**
	 * This method initializes lblRegistrationDate	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getLblRegistrationDate() {
		if (lblRegistrationDate == null) {
			lblRegistrationDate = new JLabel();
			lblRegistrationDate.setText("Ngày đăng ký:");
			lblRegistrationDate.setBounds(new Rectangle(225, 185, 84, 33));
		}
		return lblRegistrationDate;
	}

	/**
	 * This method initializes lblTitle	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel();
			lblTitle.setText("Thông tin bệnh nhân");
			lblTitle.setBounds(new Rectangle(140, 10, 121, 31));
		}
		return lblTitle;
	}

	/**
	 * This method initializes jLabel	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLabel() {
		if (jLabel == null) {
			jLabel = new JLabel();
			jLabel.setText("lblT");
			jLabel.setSize(new Dimension(173, 52));
		}
		return jLabel;
	}

} 
