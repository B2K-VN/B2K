package b2k.help;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MyLabel extends JLabel {
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

	public MyLabel(float fontSize) {
		super();
		setFont(getFont().deriveFont(fontSize));
	}

	public MyLabel() {
		super();
	}

	public MyLabel(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public MyLabel(Icon image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	public MyLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public MyLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public MyLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public void setBold() {
		setFont(getFont().deriveFont(Font.BOLD));

	}

	public void setPlain() {
		setFont(getFont().deriveFont(Font.PLAIN));
	}

	public void setItalic() {
		setFont(getFont().deriveFont(Font.ITALIC));
	}

}
