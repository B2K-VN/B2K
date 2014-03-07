package b2k.help;

import java.text.Format;

import javax.swing.JFormattedTextField;

public class MyFormattedTextField extends JFormattedTextField {

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

	public MyFormattedTextField(float fontSize) {
		setFont(getFont().deriveFont(fontSize));
	}

	public MyFormattedTextField() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyFormattedTextField(AbstractFormatter formatter) {
		super(formatter);
		// TODO Auto-generated constructor stub
	}

	public MyFormattedTextField(AbstractFormatterFactory factory,
			Object currentValue) {
		super(factory, currentValue);
		// TODO Auto-generated constructor stub
	}

	public MyFormattedTextField(AbstractFormatterFactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}

	public MyFormattedTextField(Format format) {
		super(format);
		// TODO Auto-generated constructor stub
	}

	public MyFormattedTextField(Object value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	
	
}
