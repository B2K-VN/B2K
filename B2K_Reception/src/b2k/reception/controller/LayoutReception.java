package b2k.reception.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.text.DefaultFormatterFactory;

import b2k.help.MaskFactory;
import b2k.help.MyButton;
import b2k.help.MyFormattedTextField;
import b2k.help.MyLabel;

public class LayoutReception extends JPanel {

	public static final long serialVersionUID = 1L;
	public JSplitPane spl_1 = null;
	public JPanel pnPatientInformation = null;
	public JPanel pnPersonLay = null;
	public MyLabel lblEmp = null;
	protected JPanel pnSearch = null;
	protected MyLabel lblSearch = null;
	protected MyFormattedTextField txtPatientID = null;
	protected MyButton btnSearch = null;

	/**
	 * This is the default constructor
	 */
	public LayoutReception() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	public void initialize() {
		this.setSize(1024, 600);
		this.setLayout(new BorderLayout());
		this.add(getSpl_1(), BorderLayout.CENTER);
	}

	/**
	 * This method initializes spl_1
	 * 
	 * @return javax.swing.JSplitPane
	 */
	public JSplitPane getSpl_1() {
		if (spl_1 == null) {
			spl_1 = new JSplitPane();
			spl_1.setLeftComponent(getPnPatientInformation());
		}
		return spl_1;
	}

	public GridBagConstraints getgb(int index) {
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.gridy = index;

		return gridBagConstraints1;
	}

	public GridBagConstraints getgbEnd() {
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.weighty = 1.0;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.gridy = si;

		return gridBagConstraints1;
	}

	/**
	 * This method initializes pnPatientInformation
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getPnPatientInformation() {
		if (pnPatientInformation == null) {

			pnPatientInformation = new JPanel();
			pnPatientInformation.setLayout(new GridBagLayout());
			pnPatientInformation.setPreferredSize(new Dimension(400, 400));
			pnPatientInformation.setMinimumSize(pnPatientInformation
					.getPreferredSize());
			pnPatientInformation.add(getPnPersonLay(), getgb(1));
			pnPatientInformation.add(getLblEmp(), getgbEnd());
			pnPatientInformation.add(getPnSearch(), getgb(0));
		}
		return pnPatientInformation;
	}

	/**
	 * This method initializes pnPerson
	 * 
	 * @return javax.swing.JPanel
	 */
	public int si = 20;
	protected JLabel lblEmp1 = null; // @jve:decl-index=0:visual-constraint="599,620"

	public JPanel getPnPersonLay() {
		if (pnPersonLay == null) {
			pnPersonLay = new JPanel();
			pnPersonLay.setPreferredSize(new Dimension(10, 10));
			pnPersonLay.setBorder(BorderFactory.createLoweredBevelBorder());
			pnPersonLay.setLayout(new GridBagLayout());
			pnPersonLay.add(getLblEmp1(), getgbEnd());
		}
		return pnPersonLay;
	}

	/**
	 * This method initializes lblEmp
	 * 
	 * @return javax.swing.MyLabel
	 */
	public MyLabel getLblEmp() {
		if (lblEmp == null) {
			lblEmp = new MyLabel();
			lblEmp.setText("");
		}
		return lblEmp;
	}

	/**
	 * This method initializes pnSearch
	 * 
	 * @return javax.swing.MyButton
	 */
	protected JPanel getPnSearch() {
		if (pnSearch == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 2;
			gridBagConstraints5.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints5.insets = new Insets(2, 5, 2, 10);
			gridBagConstraints5.gridy = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(2, 5, 2, 0);
			gridBagConstraints4.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.insets = new Insets(2, 10, 2, 0);
			gridBagConstraints2.gridy = 0;
			pnSearch = new JPanel();
			pnSearch.setLayout(new GridBagLayout());
			pnSearch.setPreferredSize(new Dimension(35, 34));
			pnSearch.setMinimumSize(pnSearch.getPreferredSize());
			pnSearch.add(getLblSearch(), gridBagConstraints2);
			pnSearch.add(getTxtPatientID(), gridBagConstraints4);
			pnSearch.add(getBtnSearch(), gridBagConstraints5);
			pnSearch.setBorder(BorderFactory.createRaisedBevelBorder());
		}
		return pnSearch;
	}

	/**
	 * This method initializes lblSearch
	 * 
	 * @return javax.swing.MyLabel
	 */
	protected MyLabel getLblSearch() {
		if (lblSearch == null) {
			lblSearch = new MyLabel(14f);
			lblSearch.setText("Mã bệnh nhân:");
		}
		return lblSearch;
	}

	/**
	 * This method initializes txtPatientID
	 * 
	 * @return javax.swing.MyTextField
	 */
	protected MyFormattedTextField getTxtPatientID() {
		if (txtPatientID == null) {
			txtPatientID = new MyFormattedTextField(14f);
			txtPatientID.setFormatterFactory(new DefaultFormatterFactory(
					MaskFactory.getMark("AAAAAAA")));

		}
		return txtPatientID;
	}

	/**
	 * This method initializes btnSearch
	 * 
	 * @return javax.swing.MyButton
	 */
	protected MyButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new MyButton(14f);
			btnSearch.setText("Tìm");
		}
		return btnSearch;
	}

	/**
	 * This method initializes lblEmp1
	 * 
	 * @return javax.swing.JLabel
	 */
	public JLabel getLblEmp1() {
		if (lblEmp1 == null) {
			lblEmp1 = new JLabel();
			lblEmp1.setText("");
		}
		return lblEmp1;
	}

}
