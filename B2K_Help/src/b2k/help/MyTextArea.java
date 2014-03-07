package b2k.help;

import javax.swing.JTextArea;
import javax.swing.text.Document;

public class MyTextArea extends JTextArea {

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

	public MyTextArea(float fontSize) {
		setFont(getFont().deriveFont(fontSize));
	}

	public MyTextArea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyTextArea(Document doc, String text, int rows, int columns) {
		super(doc, text, rows, columns);
		// TODO Auto-generated constructor stub
	}

	public MyTextArea(Document doc) {
		super(doc);
		// TODO Auto-generated constructor stub
	}

	public MyTextArea(int rows, int columns) {
		super(rows, columns);
		// TODO Auto-generated constructor stub
	}

	public MyTextArea(String text, int rows, int columns) {
		super(text, rows, columns);
		// TODO Auto-generated constructor stub
	}

	public MyTextArea(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}



}
