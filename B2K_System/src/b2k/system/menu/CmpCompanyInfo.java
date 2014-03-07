package b2k.system.menu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import b2k.help.FontCollection;
import b2k.help.MyLabel;

public class CmpCompanyInfo extends JPanel {

	private static final long serialVersionUID = 1L;
	private MyLabel lblTitle = null;
	private MyLabel lblTax = null;
	private MyLabel lblPhone = null;
	private JButton btnImage = null;
	private JTextField txtTax = null;
	private JTextField txtPhone = null;
	private MyLabel lblName = null;
	private JTextField txtName = null;
	private MyLabel lblFax = null;
	private JTextField txtFax = null;
	private MyLabel lblAddress = null;
	private JScrollPane scrAddress = null;
	private JTextArea txtAddress = null;

	/**
	 * This is the default constructor
	 */
	public CmpCompanyInfo() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
		gridBagConstraints13.fill = GridBagConstraints.BOTH;
		gridBagConstraints13.gridy = 5;
		gridBagConstraints13.weightx = 1.0;
		gridBagConstraints13.weighty = 1.0;
		gridBagConstraints13.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints13.gridx = 2;
		GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
		gridBagConstraints12.gridx = 1;
		gridBagConstraints12.anchor = GridBagConstraints.NORTHEAST;
		gridBagConstraints12.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints12.gridy = 5;
		lblAddress = new MyLabel();
		lblAddress.setText("Mã số thuế:");
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.fill = GridBagConstraints.BOTH;
		gridBagConstraints11.gridy = 4;
		gridBagConstraints11.weightx = 1.0;
		gridBagConstraints11.insets = new Insets(5, 5, 0, 5);
		gridBagConstraints11.gridx = 2;
		GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
		gridBagConstraints10.gridx = 1;
		gridBagConstraints10.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints10.anchor = GridBagConstraints.EAST;
		gridBagConstraints10.gridy = 4;
		lblFax = new MyLabel();
		lblFax.setText("Mã số thuế:");
		GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
		gridBagConstraints9.fill = GridBagConstraints.BOTH;
		gridBagConstraints9.gridy = 1;
		gridBagConstraints9.weightx = 1.0;
		gridBagConstraints9.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints9.gridx = 2;
		GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
		gridBagConstraints8.gridx = 1;
		gridBagConstraints8.anchor = GridBagConstraints.EAST;
		gridBagConstraints8.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints8.gridy = 1;
		lblName = new MyLabel();
		lblName.setText("Tên công ty:");
		GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
		gridBagConstraints7.fill = GridBagConstraints.BOTH;
		gridBagConstraints7.gridy = 3;
		gridBagConstraints7.weightx = 1.0;
		gridBagConstraints7.insets = new Insets(5, 5, 0, 5);
		gridBagConstraints7.gridx = 2;
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.fill = GridBagConstraints.BOTH;
		gridBagConstraints6.gridy = 2;
		gridBagConstraints6.weightx = 1.0;
		gridBagConstraints6.anchor = GridBagConstraints.WEST;
		gridBagConstraints6.insets = new Insets(5, 5, 0, 5);
		gridBagConstraints6.gridx = 2;
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 0;
		gridBagConstraints5.gridheight = 3;
		gridBagConstraints5.fill = GridBagConstraints.BOTH;
		gridBagConstraints5.insets = new Insets(20, 20, 20, 20);
		gridBagConstraints5.gridy = 0;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 1;
		gridBagConstraints4.anchor = GridBagConstraints.EAST;
		gridBagConstraints4.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints4.gridy = 3;
		lblPhone = new MyLabel();
		lblPhone.setText("Điện thoại:");
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.gridx = 1;
		gridBagConstraints3.anchor = GridBagConstraints.EAST;
		gridBagConstraints3.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints3.gridy = 2;
		lblTax = new MyLabel();
		lblTax.setText("Mã số thuế:");
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(20, 0, 20, 20);
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.gridy = 0;
		lblTitle = new MyLabel();
		lblTitle.setText("THÔNG TIN CÔNG TY");
		lblTitle.setFont(FontCollection.FONT_TITLE);
		this.setSize(824, 488);
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.white);
		this.add(lblTitle, gridBagConstraints);
		this.add(lblTax, gridBagConstraints3);
		this.add(lblPhone, gridBagConstraints4);
		this.add(getBtnImage(), gridBagConstraints5);
		this.add(getTxtTax(), gridBagConstraints6);
		this.add(getTxtPhone(), gridBagConstraints7);
		this.add(lblName, gridBagConstraints8);
		this.add(getTxtName(), gridBagConstraints9);
		this.add(lblFax, gridBagConstraints10);
		this.add(getTxtFax(), gridBagConstraints11);
		this.add(lblAddress, gridBagConstraints12);
		this.add(getScrAddress(), gridBagConstraints13);
	}

	/**
	 * This method initializes btnImage	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnImage() {
		if (btnImage == null) {
			btnImage = new JButton();
		}
		return btnImage;
	}

	/**
	 * This method initializes txtTax	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTax() {
		if (txtTax == null) {
			txtTax = new JTextField();
		}
		return txtTax;
	}

	/**
	 * This method initializes txtPhone	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtPhone() {
		if (txtPhone == null) {
			txtPhone = new JTextField();
		}
		return txtPhone;
	}

	/**
	 * This method initializes txtName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
		}
		return txtName;
	}

	/**
	 * This method initializes txtFax	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtFax() {
		if (txtFax == null) {
			txtFax = new JTextField();
		}
		return txtFax;
	}

	/**
	 * This method initializes scrAddress	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrAddress() {
		if (scrAddress == null) {
			scrAddress = new JScrollPane();
			scrAddress.setViewportView(getTxtAddress());
		}
		return scrAddress;
	}

	/**
	 * This method initializes txtAddress	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTxtAddress() {
		if (txtAddress == null) {
			txtAddress = new JTextArea();
		}
		return txtAddress;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
