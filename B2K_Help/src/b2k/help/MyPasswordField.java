package b2k.help;

import javax.swing.JPasswordField;
import javax.swing.text.Document;

public class MyPasswordField extends JPasswordField {
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

	public MyPasswordField(float fontSize) {
		super();
		setFont(getFont().deriveFont(fontSize));
	}

	public MyPasswordField() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyPasswordField(Document doc, String txt, int columns) {
		super(doc, txt, columns);
		// TODO Auto-generated constructor stub
	}

	public MyPasswordField(int columns) {
		super(columns);
		// TODO Auto-generated constructor stub
	}

	public MyPasswordField(String text, int columns) {
		super(text, columns);
		// TODO Auto-generated constructor stub
	}

	public MyPasswordField(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

}
