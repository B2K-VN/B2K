package b2k.help;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;

public class DefaultCheckListRenderer extends JPanel implements
		javax.swing.ListCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int height = 35;
	private JCheckBox lblNo;
	private MyLabel lblGhichu = null;

	/**
	 * This method initializes
	 * 
	 */

	public DefaultCheckListRenderer() {
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.gridx = 15;
		gridBagConstraints6.weightx = 1.0;
		gridBagConstraints6.fill = GridBagConstraints.BOTH;
		gridBagConstraints6.gridy = 0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridy = 0;
		this.setSize(new Dimension(1505, 35));
		this.setPreferredSize(this.getSize());
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(getLblNo(), gridBagConstraints);
		this.add(getLblemp(), gridBagConstraints6);
	}

	protected JCheckBox getLblNo() {
		if (lblNo == null) {
			lblNo = new JCheckBox();
			lblNo.setPreferredSize(new Dimension(31, 21));
			lblNo.setMinimumSize(new Dimension(31, 21));
			lblNo.setOpaque(false);
		}
		return lblNo;
	}

	/**
	 * This method initializes this
	 * 
	 */

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		if (list instanceof JCheckList) {
			JCheckList chkList = (JCheckList) list;
			lblNo.setSelected((chkList.getSelectedRows().lastIndexOf(index) != -1));
		}

		if (isSelected) {
			setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, list
					.getSelectionBackground().darker()));
			setBackground(list.getSelectionBackground());
		} else {
			setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, list
					.getBackground().darker()));
			setBackground(list.getBackground());
		}

		lblGhichu.setText(" " + (index + 1) + ".  " + value.toString());
		this.setSize(list.getSize().width - 20, height);
		this.setPreferredSize(this.getSize());
//		this.setToolTipText(value.toString());
		// setText("    " + (index + 1) + ".  " + value.toString());

		return this;

	}

	/**
	 * This method initializes lblemp
	 * 
	 * @return javax.swing.MyLabel
	 */
	private MyLabel getLblemp() {
		if (lblGhichu == null) {
			lblGhichu = new MyLabel();
			lblGhichu.setText("");
			lblGhichu.setPreferredSize(new Dimension(100, 21));
			lblGhichu.setMinimumSize(lblGhichu.getPreferredSize());
			lblGhichu.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,
					Color.BLACK));
		}
		return lblGhichu;
	}
}