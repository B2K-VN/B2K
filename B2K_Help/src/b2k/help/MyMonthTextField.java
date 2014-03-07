package b2k.help;

@SuppressWarnings("deprecation")
public class MyMonthTextField extends MonthTextField {

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

	public MyMonthTextField() {
		super();
	}
	public MyMonthTextField(float fontSize) {
		super(fontSize);
		setFont(getFont().deriveFont(fontSize));
	}


}
