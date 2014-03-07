package b2k.help;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JToggleButton;

public class MyToggleButton extends JToggleButton {

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

	public MyToggleButton(float fontSize) {
		super();
		setFont(getFont().deriveFont(fontSize));
	}

	public MyToggleButton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyToggleButton(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public MyToggleButton(Icon icon, boolean selected) {
		super(icon, selected);
		// TODO Auto-generated constructor stub
	}

	public MyToggleButton(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public MyToggleButton(String text, boolean selected) {
		super(text, selected);
		// TODO Auto-generated constructor stub
	}

	public MyToggleButton(String text, Icon icon, boolean selected) {
		super(text, icon, selected);
		// TODO Auto-generated constructor stub
	}

	public MyToggleButton(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	public MyToggleButton(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

}
