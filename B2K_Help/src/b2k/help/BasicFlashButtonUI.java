package b2k.help;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.text.View;

public class BasicFlashButtonUI extends BasicButtonUI {

	private static final BasicFlashButtonUI basicButton = new BasicFlashButtonUI();
	private MyMouseListener myMouseListener;
	protected ActionListener actionListener;
	protected Timer timer;
	protected int num1;
	protected int num2;
	protected MyFlashButton myFlashButton;
	protected BasicStroke stroke;
	private boolean isStartFocus = false;
	private static Rectangle rec1 = new Rectangle();
	private static Rectangle rec2 = new Rectangle();
	private static Rectangle rec3 = new Rectangle();

	public BasicFlashButtonUI() {
		num1 = 40;
		num2 = 0;
	}

	public static ComponentUI createUI(JComponent jcomponent) {
		return basicButton;
	}

	public void installUI(JComponent jcomponent) {
		super.installUI(jcomponent);
		myFlashButton = (MyFlashButton) jcomponent;
		myFlashButton.setBorderPainted(false);
		myMouseListener = new MyMouseListener(null);
		jcomponent.addMouseListener(myMouseListener);
		actionListener = new ActionListener() {

			public void actionPerformed(ActionEvent actionevent) {
				if (!getComponent()) {
					timer.stop();
					return;
				}
				if (++num2 > 60)
					num2 = 0;
				myFlashButton.repaint();
			}

		};
		timer = new Timer(num1, actionListener);
		stroke = new BasicStroke(1.0F, 1, 1, 1.0F, new float[] { 3F, 2.0F },
				0.0F);
		
	}

	private boolean getComponent() {
		for (Object obj = myFlashButton; obj != null; obj = ((Component) (obj))
				.getParent()) {
			if (!((Component) (obj)).isVisible())
				return false;
			if (obj instanceof Window)
				return ((Window) obj).isShowing();
		}
		return false;
	}

	public void uninstallUI(JComponent jcomponent) {
		jcomponent.removeMouseListener(myMouseListener);
		myFlashButton = null;
		myMouseListener = null;
		timer.stop();
		timer = null;
		actionListener = null;
		stroke = null;
		super.uninstallUI(jcomponent);
	}

	public void paint(Graphics g, JComponent jcomponent) {
		AbstractButton abstractbutton = (AbstractButton) jcomponent;
		ButtonModel buttonmodel = abstractbutton.getModel();
		java.awt.FontMetrics fontmetrics = g.getFontMetrics();
		Insets insets = jcomponent.getInsets();
		rec1.x = insets.left;
		rec1.y = insets.top;
		rec1.width = abstractbutton.getWidth() - (insets.right + rec1.x);
		rec1.height = abstractbutton.getHeight() - (insets.bottom + rec1.y);
		rec2.x = rec2.y = rec2.width = rec2.height = 0;
		rec3.x = rec3.y = rec3.width = rec3.height = 0;
		java.awt.Font font = jcomponent.getFont();
		g.setFont(font);
		String s = SwingUtilities.layoutCompoundLabel(jcomponent, fontmetrics,
				abstractbutton.getText(), abstractbutton.getIcon(),
				abstractbutton.getVerticalAlignment(), abstractbutton
						.getHorizontalAlignment(), abstractbutton
						.getVerticalTextPosition(), abstractbutton
						.getHorizontalTextPosition(), rec1, rec3, rec2,
				abstractbutton.getText() != null ? abstractbutton
						.getIconTextGap() : 0);
		clearTextShiftOffset();
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int i = myFlashButton.getNum1();
		int j = myFlashButton.getNum2();
		int k = myFlashButton.getNUm3();
		int l = myFlashButton.getNUm4();
		java.awt.geom.RoundRectangle2D.Double double1 = new java.awt.geom.RoundRectangle2D.Double();
		java.awt.geom.RoundRectangle2D.Double double2 = new java.awt.geom.RoundRectangle2D.Double();
		if (!buttonmodel.isArmed() || !buttonmodel.isPressed()) {
			double1 = new java.awt.geom.RoundRectangle2D.Double(1.0D, 1.0D,
					abstractbutton.getWidth() - 3 - l, abstractbutton
							.getHeight()
							- 3 - l, i, j);
			double2 = new java.awt.geom.RoundRectangle2D.Double(1 + k, 1 + k,
					abstractbutton.getWidth() - 3 - l - k * 2, abstractbutton
							.getHeight()
							- 3 - l - k * 2, i, j);
		} else {
			double1 = new java.awt.geom.RoundRectangle2D.Double(1 + l, 1 + l,
					abstractbutton.getWidth() - 3 - l, abstractbutton
							.getHeight()
							- 3 - l, i, j);
			double2 = new java.awt.geom.RoundRectangle2D.Double(1 + l + k, 1
					+ l + k, abstractbutton.getWidth() - 3 - l - k * 2,
					abstractbutton.getHeight() - 3 - l - k * 2, i, j);
		}
		Area area = new Area(double1);
		Area area1 = new Area(area);
		area1.subtract(new Area(double2));
		AffineTransform affinetransform = new AffineTransform();
		if (!buttonmodel.isArmed() || !buttonmodel.isPressed())
			affinetransform.translate(1.0D, 1.0D);
		else
			affinetransform.translate(-1D, -1D);
		Area area2 = new Area(area);
		Area area3 = new Area(area);
		Area area4 = new Area(area2);
		for (int i1 = 0; i1 < l; i1++) {
			area4.transform(affinetransform);
			area2.add(area4);
			area3.transform(affinetransform);
		}

		area2.subtract(area);
		area3.transform(affinetransform);
		area3.subtract(area);
		if (!buttonmodel.isArmed() || !buttonmodel.isPressed())
			affinetransform.translate(-2D, -2D);
		else
			affinetransform.translate(2D, 2D);
		Area area5 = new Area(area);
		area5.transform(affinetransform);
		if (abstractbutton.hasFocus())
			graphics2d.setColor(myFlashButton.getColor1());
		else
			graphics2d.setColor(myFlashButton.getColor5());
		graphics2d.draw(area3);
		graphics2d.setColor(myFlashButton.getColor2());
		graphics2d.draw(area5);
		graphics2d.setColor(myFlashButton.setColor4());
		graphics2d.draw(area2);
		graphics2d.fill(area2);
		graphics2d.setColor(myFlashButton.getColor3());
		graphics2d.fill(area1);
		if (buttonmodel.isArmed() && buttonmodel.isPressed()) {
			graphics2d.setPaint(new GradientPaint(1 + k, 1 + k, myFlashButton
					.getColor7(), 1 + k, abstractbutton.getHeight() - 3 - l - k
					* 2, myFlashButton.getColor6(), true));
			graphics2d.fill(double2);
			graphics2d.setPaint(Color.white);
			rec2.x++;
			rec2.y++;
		} else if (timer.isRunning()) {
			graphics2d.setPaint(new GradientPaint(1 + k, 1 + k, myFlashButton
					.getColor6(), 1 + k, abstractbutton.getHeight() - 3 - l - k
					* 2, myFlashButton.getColor7(), true));
			graphics2d.fill(double2);
			graphics2d.setPaint(Color.white);
		} else {
			graphics2d.setPaint(new GradientPaint(1 + k, 1 + k, myFlashButton
					.getColor8(), 1 + k, abstractbutton.getHeight() - 3 - l - k
					* 2, myFlashButton.getColor9(), true));
			graphics2d.fill(double2);
			graphics2d.setPaint(Color.white);
		}
		if (timer.isRunning()) {
			g.setColor(Color.black);
			int j1 = abstractbutton.getWidth() / 2;
			int k1 = abstractbutton.getHeight() / 2;
			int l1 = (int) (Math
					.cos(((double) num2 * 3.1415926535897931D) / 30D - 1.5707963267948966D)
					* (double) abstractbutton.getWidth() + (double) j1);
			int i2 = (int) (Math
					.sin(((double) num2 * 3.1415926535897931D) / 30D - 1.5707963267948966D)
					* (double) abstractbutton.getWidth() + (double) k1);
			graphics2d.setPaint(new GradientPaint(j1, k1, myFlashButton
					.getColor10(), l1, i2, myFlashButton.getColor11(), true));
			graphics2d.fill(area1);
			graphics2d.setPaint(Color.black);
		}
		if (abstractbutton.getIcon() != null) {
			if (buttonmodel.isArmed() && buttonmodel.isPressed()) {
				rec3.x++;
				rec3.y++;
			}
			paintIcon(g, jcomponent, rec3);
		}
		if (s != null && !s.equals("")) {
			View view = (View) jcomponent.getClientProperty("html");
			if (view != null)
				view.paint(g, rec2);
			else
				paintText(g, abstractbutton, rec2, s);
		}
		if (abstractbutton.isFocusPainted() && abstractbutton.hasFocus())
			draw(graphics2d, abstractbutton, rec1, rec2, rec3);
	}

	protected void draw(Graphics2D graphics2d, AbstractButton abstractbutton,
			Rectangle rectangle, Rectangle rectangle1, Rectangle rectangle2) {
		Rectangle rectangle3 = new Rectangle();
		String s = abstractbutton.getText();
		boolean flag = abstractbutton.getIcon() != null;
		if (s != null && !s.equals("")) {
			if (!flag) {
				rectangle3.setBounds(rectangle1);
				if (rectangle3.x > 0) {
					rectangle3.x--;
					rectangle3.width += 2;
				}
			} else {
				rectangle3.setBounds(rectangle2.union(rectangle1));
			}
		} else if (flag)
			rectangle3.setBounds(rectangle2);
		graphics2d.setStroke(stroke);
		graphics2d.setColor(myFlashButton.setColor4());
		graphics2d.drawRect(rectangle3.x - 1, rectangle3.y - 1,
				rectangle3.width + 1, rectangle3.height + 1);
	}

	private class MyMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent mouseevent) {
		}

		public void mouseEntered(MouseEvent mouseevent) {
			MyEffectManager.setComponent(myFlashButton);
			timer.stop();
			if (myFlashButton.isEnabled())
				timer.start();
		}

		public void mouseExited(MouseEvent mouseevent) {
			if(!isStartFocus){
				timer.stop();
				myFlashButton.repaint();
			}
		}

		public void mousePressed(MouseEvent mouseevent) {
			if (!getComponent()) {
				timer.stop();
				return;
			} else {
				myFlashButton.repaint();
				return;
			}
		}

		public void mouseReleased(MouseEvent mouseevent) {
			isStartFocus = false;
			if (!getComponent()) {
				timer.stop();
				return;
			} else {
				myFlashButton.repaint();
				return;
			}
		}

		private MyMouseListener() {
			super();
		}

		MyMouseListener(MyMouseListener a1) {
			this();
		}
	}

	/**
	 * Khang: 8/9/2011. 
	 * Dùng để gợi ý cho người dùng ấn vào.
	 */
	public void startFocus(){
		this.isStartFocus = true;
		MyEffectManager.setComponent(myFlashButton);
		if(timer != null){
			timer.stop();
			if (myFlashButton.isEnabled())
				timer.start();
		}
	}

	public void stopFocus() {
		this.isStartFocus = false;
		MyEffectManager.setComponent(myFlashButton);
		if(timer != null){
			if (!getComponent()) {
				timer.stop();
				return;
			} else {
				myFlashButton.repaint();
				return;
			}
		}
		
	}
	
}
