package b2k.help;

import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class MyCheckBox extends JCheckBox {

	public MyCheckBox(float fontSize) {
		super();
		setFont(getFont().deriveFont(Font.PLAIN, fontSize));
		setOpaque(false);
	}

	public MyCheckBox() {
		super();
		setOpaque(false);
	}

	public MyCheckBox(Icon icon) {
		super(icon);
		setOpaque(false);
		// TODO Auto-generated constructor stub
	}

	public MyCheckBox(String text) {
		super(text);
		setOpaque(false);
		// TODO Auto-generated constructor stub
	}

	public MyCheckBox(Action a) {
		super(a);
		setOpaque(false);
		// TODO Auto-generated constructor stub
	}

	public MyCheckBox(Icon icon, boolean selected) {
		super(icon, selected);
		setOpaque(false);
		// TODO Auto-generated constructor stub
	}

	public MyCheckBox(String text, boolean selected) {
		super(text, selected);
		setOpaque(false);
		// TODO Auto-generated constructor stub
	}

	public MyCheckBox(String text, Icon icon) {
		super(text, icon);
		setOpaque(false);
		// TODO Auto-generated constructor stub
	}

	public MyCheckBox(String text, Icon icon, boolean selected) {
		super(text, icon, selected);
		setOpaque(false);
		// TODO Auto-generated constructor stub
	}

}
