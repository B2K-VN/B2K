package b2k.system.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import b2k.help.MyLabel;

class LayoutMenu extends JPanel {

	public static final long serialVersionUID = 1L;
	public JSplitPane spl_1 = null;
	/**
	 * This is the default constructor
	 */
	public LayoutMenu() {
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
	 * This method initializes pnPerson
	 * 
	 * @return javax.swing.JPanel
	 */
	public int si = 20;

}
