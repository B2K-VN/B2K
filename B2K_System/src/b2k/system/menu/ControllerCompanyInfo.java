package b2k.system.menu;

import javax.swing.JButton;

public class ControllerCompanyInfo extends LayoutCompanyInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1137842902524113444L;
	private JButton btnSave;
	
	public ControllerCompanyInfo() {
		super();
		initUI();
	}

	private void initUI() {
		cmpFooter.addRight(getBtnSave());
	}

	private JButton getBtnSave() {
		if(btnSave == null){
			btnSave = new JButton();
			btnSave.setText("Lưu lại");
		}
		return btnSave;
	}
}
