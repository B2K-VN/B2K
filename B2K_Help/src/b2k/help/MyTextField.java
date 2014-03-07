package b2k.help;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class MyTextField extends JTextField {

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

	public MyTextField(float fontSize) {
		setFont(getFont().deriveFont(fontSize));
	}

	public MyTextField() {
		// TODO Auto-generated constructor stub
	}

	public MyTextField(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public MyTextField(int columns) {
		super(columns);
		// TODO Auto-generated constructor stub
	}

	public MyTextField(String text, int columns) {
		super(text, columns);
		// TODO Auto-generated constructor stub
	}

	public MyTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		// TODO Auto-generated constructor stub
	}

}
