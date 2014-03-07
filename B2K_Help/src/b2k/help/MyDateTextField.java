package b2k.help;

@SuppressWarnings("deprecation")
public class MyDateTextField extends DateTextField {

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

	public MyDateTextField() {
		super();
	}
	public MyDateTextField(float fontSize) {
		super(fontSize);
		setFont(getFont().deriveFont(fontSize));
	}


}
