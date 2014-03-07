package b2k.help;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

public class CommonMethod {

	public static GridBagConstraints getGridBagLayout(boolean isEnd, int ord){
		return getGridBagLayout(isEnd, ord, new Insets(0, 0, 0, 0));
	}
	
	public static GridBagConstraints getGridBagLayout(boolean isEnd, int ord,
			Insets insets) {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = isEnd ? 1.0 : 0.0;
		gridBagConstraints.insets = insets;
		gridBagConstraints.gridy = ord;
		return gridBagConstraints;
	}

	public static GridBagConstraints getGridBagLayout(boolean isEnd, int row, int col){
		return getGridBagLayout(isEnd, row, col, new Insets(0, 0, 0, 0));
	}
	
	public static GridBagConstraints getGridBagLayout(boolean isEnd, int row,
			int col, Insets insets) {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = isEnd ? 1.0 : 0.0;
		gridBagConstraints.weighty = isEnd ? 1.0 : 0.0;
		gridBagConstraints.insets = insets;
		gridBagConstraints.gridy = row;
		gridBagConstraints.gridx = col;
		return gridBagConstraints;
	}

	public static void setLocation(Component jComponent) {
		setLocation(jComponent, 0);
	}

	public static Point getLocationCenter(Component jComponent, int space) {
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		return new Point(graphicsEnvironment.getCenterPoint().x
				- jComponent.getWidth() / 2,
				graphicsEnvironment.getCenterPoint().y - jComponent.getHeight()
						/ 2 + space);
	}

	public static void setLocation(int space, Component jComponent) {
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		jComponent
				.setLocation(
						(graphicsEnvironment.getCenterPoint().x - jComponent
								.getWidth() / 2) + space,
						graphicsEnvironment.getCenterPoint().y
								- jComponent.getHeight() / 2);
	}

	public static void setLocation(Component jComponent, int space) {
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		jComponent.setLocation(graphicsEnvironment.getCenterPoint().x
				- jComponent.getWidth() / 2,
				graphicsEnvironment.getCenterPoint().y - jComponent.getHeight()
						/ 2 + space);
	}

	public static void exit(final Frame fr) {

		// TODO Auto-generated method stub
		Object[] options = { "Có", "Không" };
		int ret = JOptionPane.showOptionDialog(fr,
				"Quý vị muốn tắt chương trình?", "Thông báo",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, options[0]);

		if (ret == JOptionPane.YES_OPTION) {
			// if (action != null) {
			// action.run(true);
			// }
			// try {
			// unRegisterToExtern();
			// CurrentUser.getLoginContext().logout();
			// } catch (Exception e) {
			// YLogger.showException(e);
			// System.exit(0);
			// }

			System.exit(0);
		}
	}

	public static void showError(Exception e) {
		e.printStackTrace();
		StackTraceElement[] stackTrace = e.getStackTrace();
		int i = 0;
		for (StackTraceElement element : stackTrace) {

			System.out.println("===============" + (i++)
					+ "===================");
			System.out.println("ClassName " + element.getClassName());
			System.out.println("FileName " + element.getFileName());
			System.out.println("LineNumber " + element.getLineNumber());
			System.out.println("MethodName " + element.getMethodName());

		}
		MyMessageDialog.showErrorDialog("Đã phát sinh lỗi");

	}

	public static String convertFromDoubleNotSymbolNoDigits(double value) {
		String result = null;
		// Locale l = new Locale("vi");
		NumberFormat formmater = new DecimalFormat("##");
		// formmater.setParseIntegerOnly(true);
		// formmater.setMaximumFractionDigits(0);
		result = formmater.format(value);
		return result;
	}

	public static String getNum(String num, int digit) {
		if (digit > 15)
			digit = 15;
		String s = "00000000000000000000" + num;
		s = s.substring(s.length() - digit, s.length());

		return s;
	}

	public static void limitTextIsNumber(final MyTextField com,
			final Integer lenth, final Integer max, final Boolean next) {
		com.addKeyListener(new KeyAdapter() {
			boolean bo = true;

			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() != 8 && arg0.getKeyCode() != 127) {
					docheck(com.getText(), arg0);
				}
				// if (com.getText().length() >= lenth)
				// arg0.consume();

			}

			private void docheck(String string, KeyEvent ke) {
				System.out.println(ke.getKeyCode());
				if (ke.getKeyCode() < '0' || ke.getKeyCode() > '9') {
					if (ke.getKeyCode() < 96 || ke.getKeyCode() > 105) {
						switch (ke.getKeyCode()) {
						case KeyEvent.VK_RIGHT:
						case KeyEvent.VK_RIGHT_PARENTHESIS:
						case KeyEvent.VK_LEFT:
						case KeyEvent.VK_LEFT_PARENTHESIS:
						case KeyEvent.VK_HOME:
						case KeyEvent.VK_END:
							break;

						default:
							ke.consume();
							bo = false;
							return;
						}
						bo = true;
						return;
					}
				}
				if (max == null && lenth == null) {
					bo = true;
					return;
				}

				try {

					StringBuffer b = new StringBuffer();
					b.append(string);
					b.insert(com.getSelectionStart(), ke.getKeyChar());

					int parseInt = Integer.parseInt(b.toString());
					if (max != null && parseInt > max) {
						ke.consume();
						bo = false;
						return;
					}
					if (lenth != null) {
						if (b.toString().length() > lenth) {
							ke.consume();
							bo = false;
							return;
						} else if (b.toString().length() == lenth) {

							if (next != null) {
								if (next) {
									com.transferFocus();
								} else {
									com.transferFocusBackward();
								}
							}
						}

					}
					bo = true;
				} catch (Exception e) {
					ke.consume();
					bo = false;
				}
			}

			public void keyReleased(KeyEvent arg0) {
				if (!bo)
					arg0.consume();
			}

			public void keyTyped(KeyEvent arg0) {
				if (!bo)
					arg0.consume();
			}
		});

	}

	public static double convertToDouble(String value) {

		value = value.trim();
		int pos = value.indexOf(" ");
		if (pos > 0)
			value = value.substring(0, pos);
		Locale l = new Locale("EN");
		NumberFormat formmater = NumberFormat.getInstance(l);
		formmater.setMaximumFractionDigits(3);
		Number parse;
		try {
			parse = formmater.parse(value);
			return parse.doubleValue();
		} catch (ParseException e) {
			return 0;
		}
	}

	public static String getDateString(Timestamp time) {
		String s = new SimpleDateFormat("MM/dd/yyyy").format(time);
		return s;
	}

	public static String convertPrice(double unitPrice) {
		NumberFormat instance = new DecimalFormat("#,##0");

		return instance.format(unitPrice);
	}

	public static double convertStringtoPrice(String unitPrice) {
		NumberFormat instance = new DecimalFormat("#,##0");
		Number parse;
		double d = 0;
		try {
			parse = instance.parse(unitPrice);
			d = parse.doubleValue();
		} catch (ParseException e) {
			// showError(e);
		}

		return d;
	}

	public static Date convertDate(String date) {

		try {
			return new Date(new SimpleDateFormat("dd-MM-yyyy").parse(date)
					.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Chuyen doi ngay: " + date + " bi loi");
		}
		return null;

		//
		// // if(date.length()<4)
		// // return null;
		//
		//
		// Date tmpResult = null;
		// String tmpDate = date.trim();
		// // if (tmpDate.equals("")) return null;
		// if (tmpDate.length() < 4)
		// return tmpResult;
		// if (!withDayOfWeek) {
		// if (tmpDate.length() == 4)
		// tmpDate = "01-01-" + tmpDate;
		// } else {
		// tmpDate = tmpDate
		// .substring(tmpDate.length() - 10, tmpDate.length());
		//
		// }
		//
		//
		//
		// tmpDate = tmpDate.substring(6, 10) + "-" + tmpDate.substring(3, 5)
		// + "-" + tmpDate.substring(0, 2);
		// tmpResult = Date.valueOf(tmpDate);
		// return tmpResult;
	}

	public static String convertDate(Timestamp time) {
		if (time == null)
			return "";
		return new SimpleDateFormat("dd-MM-yyyy").format(time);
	}
	
	public static String convertDate(java.util.Date time) {
		if (time == null)
			return "";
		return new SimpleDateFormat("HH:mm 'ngày' dd-MM-yyyy").format(time);
	}

	public static String convertDate(Date time) {
		if (time == null)
			return "";

		return new SimpleDateFormat("dd-MM-yyyy").format(time);

	}

	public static String convertDateWithTime(Timestamp time) {
		if (time == null)
			return "";
		return new SimpleDateFormat("HH:mm 'ngày' dd-MM-yyyy").format(time);
	}

	
	
	public static void main(String[] args) {

		Timestamp timestamp = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());

		System.out.println(convertDateWithTime(timestamp));

	}

	public static <T> T getSelectedValue(Object ob, Class<T> clazz,
			MyListModel model, String method) {
		if (ob == null)
			return null;
		int size = model.getSize();
		for (int i = 0; i < size; i++) {
			Object o = model.getElementAt(i);
			if (clazz.isInstance(o)) {
				T cast = clazz.cast(o);
				Object callMethod = callMethod(cast, new MethodObject(method));
				if (ob.equals(callMethod)) {
					return cast;
				}

			}
		}

		return null;
	}

	public static <T> T getSelectedValue(Object ob, List<T> model, String method) {
		if (ob == null)
			return null;
		int size = model.size();
		for (int i = 0; i < size; i++) {
			T cast = model.get(i);
			Object callMethod = callMethod(cast, new MethodObject(method));
			if (ob.equals(callMethod)) {
				return cast;
			}

		}

		return null;
	}

	public static <T> T getSelectedValue(Object ob, Class<T> clazz,
			JComboBox comboBox, String method) {
		if (ob == null)
			return null;
		ComboBoxModel model = comboBox.getModel();
		int size = model.getSize();
		for (int i = 0; i < size; i++) {
			Object o = model.getElementAt(i);
			if (clazz.isInstance(o)) {
				T cast = clazz.cast(o);
				Object callMethod = callMethod(cast, new MethodObject(method));
				if (ob.equals(callMethod)) {
					return cast;
				}

			}
		}

		return null;
	}

	public static <T> T getSelectedValue(Object ob, Class<T> clazz, JList lst,
			String method) {
		if (ob == null)
			return null;
		ListModel model = lst.getModel();
		int size = model.getSize();
		for (int i = 0; i < size; i++) {
			Object o = model.getElementAt(i);
			if (clazz.isInstance(o)) {
				T cast = clazz.cast(o);
				Object callMethod = callMethod(cast, new MethodObject(method));
				if (ob.equals(callMethod)) {
					return cast;
				}

			}
		}

		return null;
	}

	public static <T> int getSelectedIndex(Object ob, Class<T> clazz,
			JComboBox comboBox, String method) {
		if (ob == null)
			return -1;
		ComboBoxModel model = comboBox.getModel();
		int size = model.getSize();
		for (int i = 0; i < size; i++) {
			Object o = model.getElementAt(i);
			if (clazz.isInstance(o)) {
				T cast = clazz.cast(o);
				Object callMethod = callMethod(cast, new MethodObject(method));
				if (ob.equals(callMethod)) {
					return i;
				}

			}
		}

		return -1;
	}

	public static <T> int getSelectedIndex(Object ob, Class<T> clazz,
			JList list, String method) {
		if (ob == null)
			return -1;
		ListModel model = list.getModel();
		int size = model.getSize();
		for (int i = 0; i < size; i++) {
			Object o = model.getElementAt(i);
			if (clazz.isInstance(o)) {
				T cast = clazz.cast(o);
				Object callMethod = callMethod(cast, new MethodObject(method));
				if (ob.equals(callMethod)) {
					return i;
				}

			}
		}

		return -1;
	}

	public static <T> T getItem(Class<T> clazz, JComboBox comboBox) {
		return getValue(clazz, comboBox.getSelectedItem());
	}

	public static <T> T getItem(Class<T> clazz, JList list) {
		return getValue(clazz, list.getSelectedValue());
	}

	public static <T> T getValue(Class<T> clazz, Object object) {
		if (clazz.isInstance(object)) {
			return clazz.cast(object);
		}
		return null;
	}

	public static Object callMethod(Object obj, MethodObject methodObject,
			Object... parametters) {
		Method method = null;
		String methodName = methodObject.getMethodName();
		Class<?>[] classes = methodObject.getClasses();
		try {
			if (classes.length == 0)
				method = obj.getClass().getMethod(methodName);
			else
				method = obj.getClass().getMethod(methodName, classes);

		} catch (Exception e) {
		}

		if (method != null) {
			try {
				// System.out.println("parametters: " + parametters);
				return method.invoke(obj, parametters);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Short convertToShort(Object obj) {
		// try {
		// return Short.valueOf(String.valueOf(value));
		// } catch (Exception e) {
		// return 0;
		// }

		String value = obj.toString().trim();
		int pos = value.indexOf(" ");
		if (pos > 0)
			value = value.substring(0, pos);
		Locale l = new Locale("EN");
		NumberFormat formmater = NumberFormat.getInstance(l);
		formmater.setMaximumFractionDigits(3);
		Number parse;
		try {
			parse = formmater.parse(value);
			return parse.shortValue();
		} catch (ParseException e) {
			return 0;
		}
	}

	public static Long convertToLong(Object value) {
		try {
			return Long.valueOf(String.valueOf(value));
		} catch (Exception e) {
			return (long) 0;
		}

	}

	public static Integer convertToInteger(Object obj) {
		String value = obj.toString().trim();
		int pos = value.indexOf(" ");
		if (pos > 0)
			value = value.substring(0, pos);
		Locale l = new Locale("EN");
		NumberFormat formmater = NumberFormat.getInstance(l);
		formmater.setMaximumFractionDigits(3);
		Number parse;
		try {
			parse = formmater.parse(value);
			return parse.intValue();
		} catch (ParseException e) {
			return 0;
		}

	}

	public static Timestamp getBeginMonth(Timestamp begin) {
		if (begin == null)
			return null;
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(begin.getTime());
		instance.set(Calendar.DATE, 1);
		instance.set(Calendar.HOUR, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);

		return new Timestamp(instance.getTimeInMillis());
	}

	public static Timestamp getEndMonth(Timestamp begin) {
		Timestamp month = getBeginMonth(begin);
		if (month == null)
			return null;
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(month.getTime());
		instance.add(Calendar.MONTH, 1);
		instance.add(Calendar.MILLISECOND, -1);
		month.setTime(instance.getTimeInMillis());
		return month;
	}

}
