package b2k.help;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyMessageDialog {
	private static final long serialVersionUID = 1L;
	private static MyMessageDialogUI diaglogUI;
	private static MyMessageDialog myMessageDialog = new MyMessageDialog();

	public MyMessageDialog() {
	}

	public static int showMessage(JFrame frame, String message) {
		diaglogUI = myMessageDialog.new MyMessageDialogUI(frame, message,
				"Thông báo", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		diaglogUI.setVisible(true);
		int ret = diaglogUI.getValue();
		diaglogUI.dispose();
		return ret;
	}

	/**
	 * Hiển thị message dialog
	 * 
	 * @param message
	 *            : Nộ dung message
	 * @param title
	 *            : Tiêu đ�? message
	 * @param optionType
	 *            : tùy ch�?n button
	 * @param messageType
	 *            : kiểu message
	 * @return
	 */
	public static int showMessageDialog(String message, String title,
			int optionType, int messageType) {
		diaglogUI = myMessageDialog.new MyMessageDialogUI(
				MainData.getController(), message, title, optionType,
				messageType);
		diaglogUI.setVisible(true);
		int ret = diaglogUI.getValue();
		diaglogUI.dispose();
		return ret;
	}

	/**
	 * Hiển thị message dialog
	 * 
	 * @param message
	 *            : Nội dung message
	 * @param title
	 *            Tiêu đ�? message
	 * @param optionType
	 *            tùy ch�?n button
	 * @param messageType
	 *            kiểu message
	 * @param buttonText
	 *            Tên button
	 * @return
	 */
	public static int showMessageDialog(String message, String title,
			int optionType, int messageType, String[] buttonText) {
		diaglogUI = myMessageDialog.new MyMessageDialogUI(
				MainData.getController(), message, title, optionType,
				messageType, buttonText);
		// diaglogUI.setButtonText(buttonText);
		diaglogUI.setVisible(true);
		int ret = diaglogUI.getValue();
		diaglogUI.dispose();
		return ret;
	}

	/**
	 * Hiễn thị message diaglog
	 * 
	 * @param message
	 *            Nộ dung message
	 * @param title
	 *            Tiêu đ�?
	 * @return
	 */
	public static int showMessageDialog(String message, String title) {
		diaglogUI = myMessageDialog.new MyMessageDialogUI(
				MainData.getController(), message, title,
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		diaglogUI.setVisible(true);
		int ret = diaglogUI.getValue();
		diaglogUI.dispose();
		return ret;
	}

	public static int showMessageWarningDialog(String message, String title) {
		diaglogUI = myMessageDialog.new MyMessageDialogUI(
				MainData.getController(), message, title,
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
		diaglogUI.setVisible(true);
		int ret = diaglogUI.getValue();
		diaglogUI.dispose();
		return ret;
	}

	public static int showMessageWarningDialog(String message) {
		diaglogUI = myMessageDialog.new MyMessageDialogUI(
				MainData.getController(), message, "Chú ý",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
		diaglogUI.setVisible(true);
		int ret = diaglogUI.getValue();
		diaglogUI.dispose();
		return ret;
	}

	/**
	 * Hiễn thị message dialog
	 * 
	 * @param message
	 *            Nội dung message
	 * @return
	 */
	public static int showMessageDialog(String message) {
		diaglogUI = myMessageDialog.new MyMessageDialogUI(
				MainData.getController(), message, "Thông báo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		diaglogUI.setVisible(true);
		int ret = diaglogUI.getValue();
		diaglogUI.dispose();
		return ret;
	}

	/**
	 * Hiễn thị lỗi
	 * 
	 * @param message
	 *            Nội dung message
	 * @return
	 */
	public static int showErrorDialog(String message) {
		diaglogUI = myMessageDialog.new MyMessageDialogUI(
				MainData.getController(), message, "Lỗi",
				JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		diaglogUI.setVisible(true);
		int ret = diaglogUI.getValue();
		diaglogUI.dispose();
		return ret;
	}

	private class MyMessageDialogUI extends JDialog {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private JPanel mainPane = null;
		private JButton btnYes = null;
		private JButton btnNo = null;
		private JButton btnCancel = null;
		private MyLabel lblMessage = null;
		private int buttonWidth = 85; // �?ộ rộng của các nút
		private int buttonSpace = 10; // Khoảng cách giữa các nút
		private int buttonLocationY = 60;
		private int buttonMessageSpace = 10; // Khoảng cách giữa các button với
		// message

		private Dimension minimumSize = new Dimension(277, 37);
		private Dimension maximumSize = new Dimension(500, 60); // @jve:decl-index=0:

		// private Font defaultFont = FontCollection.getFontPlainDefault(); //
		// new
		// Font("Arial",
		// Font.PLAIN,
		// 13);

		private int returnValue = -1;
		private JButton btnOk = null;

		public MyMessageDialogUI(JFrame parentComponent, String message,
				String title, int optionType, int messageType) {
			super(parentComponent);
			initialize();
			initDialog(message, title, optionType, messageType);
		}

		public MyMessageDialogUI(JFrame parentComponent, String message,
				String title, int optionType, int messageType,
				String[] buttonname) {
			super(parentComponent);
			initialize();
			setButtonText(buttonname);
			initDialog(message, title, optionType, messageType);
		}

		/**
		 * Thiết lập tên cho button
		 * 
		 * @param title
		 */
		public void setButtonText(String[] title) {
			int max = buttonWidth;
			if (title.length > 0) {
				// btnYes.setText(title[0]);

				max = setButtonLenth(btnYes, title[0], max);
				btnOk.setText(title[0]);
			}
			if (title.length > 1) {
				// btnNo.setText(title[1]);
				max = setButtonLenth(btnNo, title[1], max);
			}
			if (title.length > 2) {
				// btnCancel.setText(title[2]);
				max = setButtonLenth(btnCancel, title[2], max);
			}
			buttonWidth = max;
			Dimension dimension = new Dimension(buttonWidth, 25);
			btnOk.setSize(dimension);
			btnYes.setSize(dimension);
			btnNo.setSize(dimension);
			btnCancel.setSize(dimension);

		}

		private int setButtonLenth(JButton btn, String string, int max) {
			btn.setText(string);
			Graphics graphics = MainData.getController().getGraphics();
			Graphics g = graphics.create();
			g.setFont(btn.getFont());
			int i = g.getFontMetrics().stringWidth(string) + 35;
			if (i > max)
				max = i;
			g.dispose();
			return max;

		}

		private void initDialog(String message, String title, int optionType,
				int messageType) {
			// Set Title
			this.setTitle(title);
			// Set MessgageTest
			if (message != null)
				lblMessage.setText("<html><center>"
						+ message.replaceAll("\n", "<br>") + "<center></html>");

			// Kích thước tối thiểu khi chỉ có 2 nút Yes và No
			if (optionType == JOptionPane.YES_NO_OPTION)
				minimumSize = new Dimension(200, 37);

			// Kích thước tối thiểu khi chi có một nút OK
			if (optionType == JOptionPane.DEFAULT_OPTION)
				minimumSize = new Dimension(130, 37);

			if (lblMessage.getPreferredSize().height < minimumSize.height) {
				lblMessage.setPreferredSize(new Dimension(lblMessage
						.getPreferredSize().width, minimumSize.height));
			}

			if (lblMessage.getPreferredSize().width < minimumSize.width) {
				lblMessage.setPreferredSize(new Dimension(minimumSize.width,
						lblMessage.getPreferredSize().height));
			}

			if (lblMessage.getPreferredSize().width > maximumSize.width) {
				int tmp = lblMessage.getPreferredSize().width
						/ maximumSize.width;
				if ((tmp * maximumSize.width) < lblMessage.getPreferredSize().width)
					tmp++;
				if (lblMessage.getText().indexOf("<br>") >= 0)
					lblMessage.setPreferredSize(new Dimension(
							maximumSize.width,
							lblMessage.getPreferredSize().height + tmp * 17));
				else
					lblMessage.setPreferredSize(new Dimension(
							maximumSize.width, tmp * 17));
			}
			lblMessage.setSize(lblMessage.getPreferredSize());

			// Set vi tri cac button
			buttonLocationY = lblMessage.getLocation().y
					+ lblMessage.getSize().height + buttonMessageSpace;

			// Set size cua dialog
			this.setSize(lblMessage.getLocation().x
					+ lblMessage.getSize().width + 20, buttonLocationY + 65);

			// Set MessageType
			setMessageType(messageType);

			// set OptionType
			setOptionType(optionType);

			// canh Form nằm giữa màn hình
			GraphicsEnvironment env = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			setLocation(
					(env.getMaximumWindowBounds().width - this.getSize().width) / 2,
					(env.getMaximumWindowBounds().height - this.getSize().height) / 2);
		}

		private void setMessageType(int messageType) {
			// switch (messageType) {
			// case JOptionPane.INFORMATION_MESSAGE:
			// this.getRootPane().setWindowDecorationStyle(
			// JRootPane.INFORMATION_DIALOG);
			// break;
			// case JOptionPane.WARNING_MESSAGE:
			// this.getRootPane().setWindowDecorationStyle(
			// JRootPane.WARNING_DIALOG);
			// break;
			// case JOptionPane.ERROR_MESSAGE:
			// this.getRootPane().setWindowDecorationStyle(
			// JRootPane.ERROR_DIALOG);
			// break;
			// case JOptionPane.QUESTION_MESSAGE:
			// this.getRootPane().setWindowDecorationStyle(
			// JRootPane.QUESTION_DIALOG);
			// break;
			// case JOptionPane.PLAIN_MESSAGE:
			// this.getRootPane().setWindowDecorationStyle(
			// JRootPane.PLAIN_DIALOG);
			// lblMessage.setBounds(new Rectangle(18, 12, 331, 61));
			// break;
			// }
		}

		// Hiên thị các nút và set vị trí cho các nút luôn
		private void setOptionType(int optionType) {
			buttonWidth = (int) btnYes.getSize().getWidth();
			switch (optionType) {
			case JOptionPane.DEFAULT_OPTION:
				btnOk.setVisible(true);
				this.getRootPane().setDefaultButton(btnOk);
				btnOk.setLocation(
						(this.getSize().width - buttonWidth - 10) / 2,
						buttonLocationY);
				break;
			case JOptionPane.YES_NO_OPTION:
				btnYes.setVisible(true);
				btnNo.setVisible(true);
				btnYes.setLocation(
						(this.getSize().width - 2 * buttonWidth - 10 - buttonSpace) / 2,
						buttonLocationY);
				btnNo.setLocation(btnYes.getLocation().x + buttonWidth
						+ buttonSpace, buttonLocationY);
				this.getRootPane().setDefaultButton(btnYes);
				break;
			case JOptionPane.YES_NO_CANCEL_OPTION:
				btnYes.setVisible(true);
				btnNo.setVisible(true);
				btnCancel.setVisible(true);
				btnYes.setLocation(
						(this.getSize().width - 3 * buttonWidth - 10 - 2 * buttonSpace) / 2,
						buttonLocationY);
				btnNo.setLocation(btnYes.getLocation().x + buttonWidth
						+ buttonSpace, buttonLocationY);
				btnCancel.setLocation(btnNo.getLocation().x + buttonWidth
						+ buttonSpace, buttonLocationY);
				this.getRootPane().setDefaultButton(btnYes);
				break;
			}
		}

		private void doClose() {
			this.setVisible(false);
		}

		public int getValue() {
			return returnValue;
		}

		/**
		 * This method initializes this
		 * 
		 */
		private void initialize() {
			this.setSize(new Dimension(309, 126));
			this.setContentPane(getMainDataPane());
			this.setResizable(false);
			this.setModal(true);
			this.addWindowListener(new java.awt.event.WindowAdapter() {

				public void windowClosing(java.awt.event.WindowEvent e) {
					returnValue = JOptionPane.CLOSED_OPTION;
					doClose();
				}
			});
		}

		/**
		 * This method initializes mainPane
		 * 
		 * @return javax.swing.JPanel
		 */
		private JPanel getMainDataPane() {
			if (mainPane == null) {
				lblMessage = new MyLabel();
				lblMessage.setBounds(new Rectangle(12, 12, 277, 37));
				lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
				lblMessage.setHorizontalTextPosition(SwingConstants.CENTER);
				// lblMessage.setFont(defaultFont);
				// lblMessage.setBorder(BorderFactory.createLineBorder(Color.red));
				lblMessage.setText("");
				mainPane = new JPanel();// new
				// JPanel();
				mainPane.setLayout(null);
				mainPane.add(getBtnYes(), null);
				mainPane.add(getBtnNo(), null);
				mainPane.add(getBtnCancel(), null);
				mainPane.add(lblMessage, null);
				mainPane.add(getBtnOk(), null);
			}
			return mainPane;
		}

		/**
		 * This method initializes btnYes
		 * 
		 * @return javax.swing.JButton
		 */
		private JButton getBtnYes() {
			if (btnYes == null) {
				btnYes = new JButton();
				btnYes.setBounds(new Rectangle(6, 60, 85, 25));
				btnYes.setText("Có");
				btnYes.setVisible(false);
				// btnYes.setFont(defaultFont);
				btnYes.addFocusListener(new FocusListener() {
					public void focusGained(FocusEvent arg0) {
						diaglogUI.getRootPane().setDefaultButton(btnYes);
					}

					public void focusLost(FocusEvent e) {
					}
				});
				btnYes.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						returnValue = JOptionPane.YES_OPTION;
						doClose();
					}
				});
			}
			return btnYes;
		}

		/**
		 * This method initializes btnNo
		 * 
		 * @return javax.swing.JButton
		 */
		private JButton getBtnNo() {
			if (btnNo == null) {
				btnNo = new JButton();
				btnNo.setBounds(new Rectangle(96, 60, 85, 25));
				btnNo.setText("Không");
				btnNo.setVisible(false);
				// btnNo.setFont(defaultFont);
				btnNo.addFocusListener(new FocusListener() {
					public void focusGained(FocusEvent arg0) {
						diaglogUI.getRootPane().setDefaultButton(btnNo);
					}

					public void focusLost(FocusEvent e) {
					}
				});
				btnNo.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						returnValue = JOptionPane.NO_OPTION;
						doClose();
					}
				});
			}
			return btnNo;
		}

		/**
		 * This method initializes btnCancel
		 * 
		 * @return javax.swing.JButton
		 */
		private JButton getBtnCancel() {
			if (btnCancel == null) {
				btnCancel = new JButton();
				btnCancel.setBounds(new Rectangle(186, 60, 85, 25));
				btnCancel.setText("Bỏ qua");
				btnCancel.setVisible(false);
				// btnCancel.setFont(defaultFont);
				btnCancel.addFocusListener(new FocusListener() {
					public void focusGained(FocusEvent arg0) {
						diaglogUI.getRootPane().setDefaultButton(btnCancel);
					}

					public void focusLost(FocusEvent e) {
					}
				});
				btnCancel
						.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(
									java.awt.event.ActionEvent e) {
								returnValue = JOptionPane.CANCEL_OPTION;
								doClose();
							}
						});
			}
			return btnCancel;
		}

		/**
		 * This method initializes btnOk
		 * 
		 * @return javax.swing.JButton
		 */
		private JButton getBtnOk() {
			if (btnOk == null) {
				btnOk = new JButton();
				btnOk.setBounds(new Rectangle(276, 60, 85, 25));
				btnOk.setText("Đóng lại");
				btnOk.setVisible(false);
				// btnOk.setFont(defaultFont);
				btnOk.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						returnValue = JOptionPane.OK_OPTION;
						doClose();
					}
				});
			}
			return btnOk;
		}
	}
}
