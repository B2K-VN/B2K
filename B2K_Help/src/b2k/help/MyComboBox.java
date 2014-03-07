package b2k.help;

import java.awt.Font;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class MyComboBox extends JComboBox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object tag = null;

	public Object getTag() {
		return tag;
	}

	public void setTag(Object tag) {
		this.tag = tag;
	}

	public MyComboBox(float fontSize) {
		super();
		setFont(getFont().deriveFont(Font.PLAIN, fontSize));
		setOpaque(false);
	}

	public MyComboBox() {
		super();
	}

	public MyComboBox(ComboBoxModel aModel) {
		super(aModel);
		// TODO Auto-generated constructor stub
	}

	public MyComboBox(Object[] items) {
		super(items);
		// TODO Auto-generated constructor stub
	}

	public MyComboBox(Vector<?> items) {
		super(items);
	}

}
