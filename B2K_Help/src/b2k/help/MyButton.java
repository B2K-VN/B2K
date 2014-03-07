package b2k.help;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class MyButton extends JButton {

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

	public MyButton(float fontSize) {
		super();
		setFont(getFont().deriveFont(fontSize));
	}

	public MyButton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyButton(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public MyButton(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public MyButton(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	public MyButton(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

}
