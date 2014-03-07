package b2k.help;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class Body extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gridBagConstraints; // @jve:decl-index=0:
	private JPanel jPanel;

	/**
	 * This is the default constructor
	 */
	public Body() {
		super();
		initialize();
	}

	public GridBagConstraints getGridBagConstraints() {
		if (gridBagConstraints == null) {
			gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
		}
		return gridBagConstraints;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setLayout(new GridBagLayout());
		this.add(getEmp(), getGridBagConstraints());
		this.setOpaque(false);
	}

	public void addBody(Container container) {
		this.removeAll();
		// this.add
		if (container == null)
			container = getEmp();
		this.add(container, getGridBagConstraints());
		updateUI();
		repaint();
		validate();
	}

	private JPanel getEmp() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setOpaque(false);
		}
		return jPanel;
	}
}
