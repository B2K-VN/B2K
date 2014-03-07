package b2k.system.menu;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import b2k.help.ui.FooterCmp;

public class LayoutCompanyInfo extends JPanel {

	private static final long serialVersionUID = 1L;
	public CmpCompanyInfo cmpCompanyInfo = null;
	public FooterCmp cmpFooter = null;

	/**
	 * This is the default constructor
	 */
	public LayoutCompanyInfo() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setLayout(new BorderLayout());
		this.add(getCmpFooter(), BorderLayout.SOUTH);
		this.add(getCmpCompanyInfo(), BorderLayout.CENTER);
	}

	/**
	 * This method initializes cmpCompanyInfo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private CmpCompanyInfo getCmpCompanyInfo() {
		if (cmpCompanyInfo == null) {
			cmpCompanyInfo = new CmpCompanyInfo();
		}
		return cmpCompanyInfo;
	}

	/**
	 * This method initializes cmpFooter	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private FooterCmp getCmpFooter() {
		if (cmpFooter == null) {
			cmpFooter = new FooterCmp();
		}
		return cmpFooter;
	}

}
