package b2k.help;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@Deprecated
public class MonthTextField extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MyTextField txtMonth = null;
	private MyTextField txtYear = null;
	private ActionListener listener;
	private JLabel errText = null;
	private String errMsg = "Lỗi";
	private boolean isShow = false;
	private Popup popup = null;
	@SuppressWarnings("unused")
	private boolean isEnabledAll = true;
	private DocumentListener checkAgeDListener = null;

	/**
	 * This method initializes
	 * 
	 */
	public MonthTextField() {
		super();
		initialize();
	}

	public MonthTextField(float fontSize) {
		setFont(getFont().deriveFont(fontSize));
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints2.gridy = 0;
		gridBagConstraints2.weightx = 1.0;
		gridBagConstraints2.weighty = 1.0;
		gridBagConstraints2.anchor = GridBagConstraints.WEST;
		gridBagConstraints2.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints2.gridx = 2;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 0;
		gridBagConstraints1.weightx = 0.0;
		gridBagConstraints1.insets = new Insets(0, 0, 0, 5);
		gridBagConstraints1.gridx = 1;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 0.0;
		gridBagConstraints.insets = new Insets(0, 0, 0, 5);
		gridBagConstraints.gridx = 0;
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		this.setBounds(new Rectangle(0, 0, 232, 53));
		this.add(getTxtMonth(), gridBagConstraints1);
		this.add(getTxtYear(), gridBagConstraints2);
		getTxtMonth().setFont(getFont());
		getTxtYear().setFont(getFont());

		int stringWidth = getFontMetrics(getFont()).stringWidth("0");
		Dimension dimension = new Dimension(
				(stringWidth * 3 + (stringWidth / 2)), getSize().height);
		Dimension dimension1 = new Dimension((stringWidth * 7),
				getSize().height);
		getTxtMonth().setPreferredSize(dimension);
		getTxtMonth().setMinimumSize(dimension);
		getTxtYear().setPreferredSize(dimension1);
		getTxtYear().setMinimumSize(dimension1);
		// Chinh vi tri cua cac Text Field
		// this.addComponentListener(new ComponentAdapter() {
		// public void componentResized(ComponentEvent e) {
		// txtDate.setBounds(0, 0, 16, getSize().height);
		// txtMonth.setBounds(21, 0, 16, getSize().height);
		// txtYear.setBounds(44, 0, 32, getSize().height);
		// }
		// });

	}

	private void checkAge(int age) {
		Calendar caa = Calendar.getInstance();
		if (!isValidDate())
			return;
		caa.setTimeInMillis(caa.getTimeInMillis() - getTimeStamp().getTime()
				+ new Timestamp(100, 0, 1, 0, 0, 0, 0).getTime());
		if (caa.getTime().getYear() - 100 < age)
			showErrorTip();
		else
			hideErrorTip();
	}

	private DocumentListener getAgeListener(final int age) {

		checkAgeDListener = new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {
				checkAge(age);
			}

			public void insertUpdate(DocumentEvent e) {
				checkAge(age);
			}

			public void changedUpdate(DocumentEvent e) {
				checkAge(age);
			}
		};
		return checkAgeDListener;
	}

	public void setLimitAge(final int age, String mess) {
		setErrorTip(mess);
		if (checkAgeDListener != null) {

			txtMonth.getDocument().removeDocumentListener(checkAgeDListener);

			txtYear.getDocument().removeDocumentListener(checkAgeDListener);
		}

		if (age < 0) {
			return;
		}

		txtMonth.getDocument().addDocumentListener(getAgeListener(age));

		txtYear.getDocument().addDocumentListener(getAgeListener(age));
	}

	public void requestFocus() {
		txtMonth.requestFocus();
	}

	public void setDateWithoutNotify(String date) {
		if (date != null) {
			if (!date.equals(getFullDate())) {
				if (date.length() == 4) {
					txtMonth.setText("01");
					txtYear.setText(date);
				} else {
					if (date.length() == 10) {
						txtMonth.setText(date.substring(3, 5));
						txtYear.setText(date.substring(6));
					} else {
						if (date.length() == 0) {
							txtMonth.setText("");
							txtYear.setText("");
						}
					}
				}
			}
		} else {
			txtMonth.setText("");
			txtYear.setText("");
		}
	}

	public void setDate(String date) {
		if (date != null) {
			if (!date.equals(getFullDate())) {
				if (date.length() == 4) {
					txtMonth.setText("01");
					txtYear.setText(date);
				} else {
					if (date.length() == 10) {
						txtMonth.setText(date.substring(3, 5));
						txtYear.setText(date.substring(6));
					} else {
						if (date.length() == 0) {
							txtMonth.setText("");
							txtYear.setText("");
						}
					}
				}
				if (listener != null)
					listener.actionPerformed(new ActionEvent("", 0, ""));
			}
		} else {
			txtMonth.setText("");
			txtYear.setText("");
		}
	}

	/**
	 * Get the full date dd-mm-yyyy
	 * 
	 * @return
	 */
	public String getFullDate() {
		String strDate = "01-";
		if (txtMonth.getText().equals("01")) {
			strDate += "01-";
		} else if (!txtMonth.getText().trim().equalsIgnoreCase("")) {
			strDate += txtMonth.getText() + "-";
		}
		strDate += txtYear.getText();

		return strDate;
	}

	public void setTimestamp(Timestamp t) {
		if (t != null) {
			Date date = new Date(t.getTime());
			setDate(CommonMethod.convertDate(date));
		} else {
			txtMonth.setText("");
			txtYear.setText("");
		}
	}

	public Timestamp getTimeStamp() {
		// yyyy-mm-dd hh:mm:ss.fffffffff
		String year = txtYear.getText().equalsIgnoreCase("") ? null : txtYear
				.getText();
		@SuppressWarnings("unused")
		String month = txtMonth.getText().equalsIgnoreCase("") ? null
				: txtMonth.getText();
		@SuppressWarnings("unused")
		String date = "01";
		if (year == null)
			return null;
		Timestamp time = new Timestamp(getCalendar().getTimeInMillis());
		return time;
	}

	public Calendar getCalendar() {
		Calendar cal = Calendar.getInstance();
		int year = Integer.valueOf(txtYear.getText());
		int month = Integer.valueOf(txtMonth.getText()) - 1;
		int date = 1;
		cal.clear();
		cal.set(year, month, date);
		return cal;
	}

	public boolean isValidDate() {
		String strDate = "";
		strDate = "01" + "-" + txtMonth.getText() + "-" + txtYear.getText();

		SimpleDateFormat sformat = new SimpleDateFormat("dd-MM-yyyy");
		sformat.setLenient(false);
		try {
			sformat.parse(strDate);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public void setEnabledAll(boolean enabled) {
		isEnabledAll = enabled;
		txtMonth.setFocusable(enabled);
		txtMonth.setEnabled(enabled);
		txtYear.setFocusable(enabled);
		txtYear.setEnabled(enabled);
	}

	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		txtMonth.setFocusable(enabled);
		txtMonth.setEditable(enabled);
		txtYear.setFocusable(enabled);
		txtYear.setEditable(enabled);

	}

	/**
	 * This method initializes txtDate
	 * 
	 * @return javax.swing.JTextField
	 */

	// Vẽ thêm đường gạch dưới và hai dấu -

	public void paint(Graphics e) {
		super.paint(e);
		// Color tmpColor = e.getColor();
		// if (isEnabledAll)
		// e.setColor(Color.black);
		// else
		// e.setColor(new Color(200, 200, 200));
		//
		// for (int i = 0; i <= 72; i = i + 5)
		// e.drawLine(i, this.getSize().height - 1, i,
		// this.getSize().height - 1);
		//
		// e.drawLine(72 - 1, this.getSize().height - 1, 72,
		// this.getSize().height - 1);
		//
		// e.drawLine(17, this.getSize().height - 9, 20, this.getSize().height -
		// 9);
		// e.drawLine(37, this.getSize().height - 9, 40, this.getSize().height -
		// 9);
		// e.setColor(tmpColor);
	}

	public void setErrorTip(String s) {
		errMsg = "  " + s.trim() + "  ";
	}

	public void showErrorTip() {
		if (errText == null) {
			errText = new JLabel(errMsg);
			errText.setOpaque(true);
			errText.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			// errText.setBackground(MyTextField.GROUND_COLOR);
			// errText.setForeground(MyTextField.TEXT_COLOR);
			// errText.setFont(MyTextField.TIP_FONT);
		} else {
			errText.setText(errMsg);
		}
		if (!isShow) {
			if (this.isShowing()) {
				int loc = this.getLocationOnScreen().x + 10;
				errText.setPreferredSize(new Dimension(
						errText.getMaximumSize().width, 23));
				if (loc + errText.getSize().width > Toolkit.getDefaultToolkit()
						.getScreenSize().width)
					loc = Toolkit.getDefaultToolkit().getScreenSize().width
							- errText.getSize().width;
				PopupFactory factory = PopupFactory.getSharedInstance();
				popup = factory.getPopup(this, errText, loc,
						this.getLocationOnScreen().y + 20);
				popup.show();
				new Thread(new Runnable() {
					public void run() {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						popup.hide();
						isShow = false;
					}
				}).start();
				isShow = true;
			}
		}
	}

	public void hideErrorTip() {
		if (isShow) {
			popup.hide();
			isShow = false;
		}
	}

	/**
	 * This method initializes txtMonth
	 * 
	 * @return yoffice.publiccomponents.MyTextField
	 */
	private MyTextField getTxtMonth() {
		if (txtMonth == null) {
			txtMonth = new MyTextField();
			txtMonth.setHorizontalAlignment(JTextField.RIGHT);
			txtMonth.setDocument(new RangeNumber(1, 12));
			txtMonth.setBorder(null);
			txtMonth.setText("");

			txtMonth.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
						if (txtMonth.getText().length() == 2) {
							txtMonth.transferFocus();
						}

				}
			});
			txtMonth.addFocusListener(new FocusAdapter() {

				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					txtMonth.setSelectionStart(0);
					txtMonth.setSelectionEnd(txtMonth.getText().length());
				}

				public void focusLost(FocusEvent e) {
					if (txtMonth.getText().length() == 0) {
						txtMonth.setText("01" + txtMonth.getText());
					} else if (txtMonth.getText().length() == 1) {
						txtMonth.setText("0" + txtMonth.getText());
					}
					if (listener != null)
						if (!txtYear.isFocusOwner())
							listener.actionPerformed(new ActionEvent("", 0, ""));
				}
			});
		}
		return txtMonth;
	}

	public void addKeyListener(KeyListener keyListener) {
		txtYear.addKeyListener(keyListener);
		txtMonth.addKeyListener(keyListener);
	}

	public void addDateTextFieldListener(ActionListener dListener) {
		listener = dListener;
	}

	public void removeDateTextFieldListener() {
		listener = null;
	}

	/**
	 * This method initializes txtYear
	 * 
	 * @return yoffice.publiccomponents.MyTextField
	 */
	public MyTextField getTxtYear() {
		if (txtYear == null) {
			txtYear = new MyTextField();
			txtYear.setHorizontalAlignment(JTextField.LEADING);
			txtYear.setDocument(new YearModel(txtYear));
			txtYear.setBorder(null);
			txtYear.setText("");
			txtYear.addFocusListener(new FocusAdapter() {

				public void focusGained(FocusEvent e) {
					txtYear.setSelectionStart(0);
					txtYear.setSelectionEnd(txtYear.getText().length());
				}

				public void focusLost(FocusEvent arg0) {

					if (txtMonth.getText().length() == 0) {
						txtMonth.setText("01" + txtMonth.getText());
					}
					if (txtYear.getText().length() == 3) {
						txtYear.setText("1" + txtYear.getText());
					}
					if (txtYear.getText().length() == 2) {
						txtYear.setText("19" + txtYear.getText());
					}
					if (txtYear.getText().length() == 1) {
						txtYear.setText("200" + txtYear.getText());
					}
					if (listener != null)
						if (!txtMonth.isFocusOwner())
							listener.actionPerformed(new ActionEvent("", 0, ""));
				}
			});
		}
		return txtYear;
	}

	class RangeNumber extends PlainDocument {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int maxLength = 2;
		private int bNum = 0;
		private int eNum = 0;

		public RangeNumber(int bNum, int eNum) {
			this.bNum = bNum;
			this.eNum = eNum;
		}

		public void insertString(int offs, String str, AttributeSet a)
				throws BadLocationException {
			if ((str == null) || (str == ""))
				return;

			if ((this.getLength() + str.length()) > maxLength)
				return;

			char[] charseq = str.toCharArray();
			StringBuffer tmp = new StringBuffer();
			for (int i = 0; i < charseq.length; i++) {
				if (((charseq[i] >= '0') && (charseq[i] <= '9'))) {
					tmp.append(charseq[i]);
				}
			}
			String tmp2 = "";
			tmp2 = this.getText(0, this.getLength());

			if (offs > 0)
				tmp2 = tmp2 + tmp.toString();
			else
				tmp2 = tmp.toString() + tmp2;

			try {
				int num = Integer.parseInt(tmp2);

				if (num == 0 && tmp2.length() == 1) {
					super.insertString(offs, tmp.toString(), a);
				} else {
					if ((num >= bNum) && (num <= eNum)) {
						super.insertString(offs, tmp.toString(), a);
					}

				}

			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
	}

	class YearModel extends PlainDocument {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int maxLength = 4;

		public YearModel(Component owner) {
		}

		public void insertString(int offs, String str, AttributeSet a)
				throws BadLocationException {
			if ((str == null) || (str == "")) {
				return;
			}
			if ((this.getLength() + str.length()) > maxLength) {
				return;
			}
			char[] charseq = str.toCharArray();
			StringBuffer tmp = new StringBuffer();
			for (int i = 0; i < charseq.length; i++) {
				if (((charseq[i] >= '0') && (charseq[i] <= '9'))) {
					String tmp2 = getContent().getString(0, offs);
					tmp2 = tmp2 + String.valueOf(charseq[i]);
					tmp.append(charseq[i]);
				}
			}
			super.insertString(offs, tmp.toString(), a);
		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"