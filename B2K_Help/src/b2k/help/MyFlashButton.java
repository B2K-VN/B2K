package b2k.help;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

@SuppressWarnings("serial")
public class MyFlashButton extends JButton {

	@SuppressWarnings("unused")
	private static final ComponentUI BasicFlashButtonUI = null;

	public MyFlashButton(float size) {
		num1 = 10;
		num2 = 10;
		num3 = 2;
		num4 = 1;
		c2 = Color.white;
		c3 = new Color(224, 223, 227);
		c4 = Color.gray;
		c5 = Color.black;
		c6 = Color.white;
		c7 = new Color(255, 200, 80);
		c8 = Color.white;
		c9 = Color.lightGray;
		c10 = Color.white;
		c11 = Color.gray;
		c1 = Color.blue;

		setFont(getFont().deriveFont(size));
		mthint();
	}

	public MyFlashButton() {
		num1 = 10;
		num2 = 10;
		num3 = 2;
		num4 = 1;
		c2 = Color.white;
		c3 = new Color(224, 223, 227);
		c4 = Color.gray;
		c5 = Color.black;
		c6 = Color.white;
		c7 = new Color(255, 200, 80);
		c8 = Color.white;
		c9 = Color.lightGray;
		c10 = Color.white;
		c11 = Color.gray;
		c1 = Color.blue;
		mthint();
	}

	public MyFlashButton(Icon icon) {
		super(icon);
		num1 = 10;
		num2 = 10;
		num3 = 2;
		num4 = 1;
		c2 = Color.white;
		c3 = new Color(224, 223, 227);
		c4 = Color.gray;
		c5 = Color.black;
		c6 = Color.white;
		c7 = new Color(255, 200, 80);
		c8 = Color.white;
		c9 = Color.lightGray;
		c10 = Color.white;
		c11 = Color.gray;
		c1 = Color.blue;
		mthint();
	}

	public MyFlashButton(String s) {
		super(s);
		num1 = 10;
		num2 = 10;
		num3 = 2;
		num4 = 1;
		c2 = Color.white;
		c3 = new Color(224, 223, 227);
		c4 = Color.gray;
		c5 = Color.black;
		c6 = Color.white;
		c7 = new Color(255, 200, 80);
		c8 = Color.white;
		c9 = Color.lightGray;
		c10 = Color.white;
		c11 = Color.gray;
		c1 = Color.blue;
		mthint();
	}

	public MyFlashButton(String s, Icon icon) {
		super(s, icon);
		num1 = 10;
		num2 = 10;
		num3 = 2;
		num4 = 1;
		c2 = Color.white;
		c3 = new Color(224, 223, 227);
		c4 = Color.gray;
		c5 = Color.black;
		c6 = Color.white;
		c7 = new Color(255, 200, 80);
		c8 = Color.white;
		c9 = Color.lightGray;
		c10 = Color.white;
		c11 = Color.gray;
		c1 = Color.blue;
		mthint();
	}

	public String getUIClassID() {
		return "ELButtonUI";
	}

	public void updateUI() {
		setUI(mthchar());
	}

	private void mthint() {
		setFocusPainted(false);
		setOpaque(false);
	}

	protected ComponentUI mthchar() {
		ComponentUI componentui = (ComponentUI) UIManager.get("ELButtonUI");
		if (componentui == null) {
			// String s = "BasicELButtonUI";
			try {
				componentui = new BasicFlashButtonUI();
				// (ComponentUI)Class.forName(s).newInstance();
			} catch (Exception exception) {
				System.out.println(exception);
			}
		}
		return componentui;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int i) {
		num1 = i;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int i) {
		num2 = i;
	}

	public int getNUm4() {
		return num4;
	}

	public void setNum4(int i) {
		num4 = i;
	}

	public Color getColor3() {
		return c3;
	}

	public void setColor3(Color color) {
		c3 = color;
	}

	public Color getColor2() {
		return c2;
	}

	public void setColor2(Color color) {
		c2 = color;
	}

	public Color setColor4() {
		return c4;
	}

	public void setColor4(Color color) {
		c4 = color;
	}

	public Color getColor5() {
		return c5;
	}

	public void setColor5(Color color) {
		c5 = color;
	}

	public int getNUm3() {
		return num3;
	}

	public void setNum3(int i) {
		num3 = i;
	}

	public Color getColor8() {
		return c8;
	}

	public void setColor8(Color color) {
		c8 = color;
	}

	public Color getColor9() {
		return c9;
	}

	public void setColor9(Color color) {
		c9 = color;
	}

	public Color getColor6() {
		return c6;
	}

	public void setColor6(Color color) {
		c6 = color;
	}

	public Color getColor7() {
		return c7;
	}

	public void setColor7(Color color) {
		c7 = color;
	}

	public Color getColor10() {
		return c10;
	}

	public void setColor10(Color color) {
		c10 = color;
	}

	public Color getColor11() {
		return c11;
	}

	public void setColor11(Color color) {
		c11 = color;
	}

	public Color getColor1() {
		return c1;
	}

	public void setColor1(Color color) {
		c1 = color;
	}

	private int num1;
	private int num2;
	private int num3;
	private int num4;
	protected Color c2;
	protected Color c3;
	protected Color c4;
	protected Color c5;
	protected Color c6;
	protected Color c7;
	protected Color c8;
	protected Color c9;
	protected Color c10;
	protected Color c11;
	protected Color c1;

	// private static final String fldint = "ELButtonUI";

	/**
	 * Khang 8.9.2011: Gợi ý người dùng nhấn vào
	 */
	public void startFocus(boolean isStartFocus) {
		ComponentUI mthchar = getUI();
		if (mthchar instanceof BasicFlashButtonUI) {
			if (isStartFocus) {
				((BasicFlashButtonUI) mthchar).startFocus();
			} else {
				((BasicFlashButtonUI) mthchar).stopFocus();
			}
		}
	}

}
