package b2k.help;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

public class CustomizedDocument {

	/**
	 * Chuyển đổi thành kiểu chữ hoa
	 * 
	 * @return
	 */
	public static Document getUpperCaseModel() {
		return new UpperCaseDocument();
	}

	/**
	 * Chuyển đổi thành kiểu chữ hoa
	 * 
	 * @return
	 */
	public static Document getLowerCaseModel() {
		return new LowerCaseDocument();
	}

	/**
	 * Kiểm tra chuỗi vào là Number
	 * 
	 * @param owner
	 * @return
	 */
	public static Document getNumberModel(Component owner) {
		return new NumberDocument(owner);
	}

	public static Document getMedicalCardNumRule(Component owner, String title) {
		return new NumberModelMedicalCardNumRule(owner, title);
	}

	/**
	 * Kiểm tra chuỗi nhập vào, không chứa kí tự number
	 * 
	 * @param owner
	 * @return
	 */
	public static Document getNotNumberModel(Component owner) {
		return new NotNumberDocument(owner);
	}

	/**
	 * Kiểm tra Chuỗi số nhập vào
	 * 
	 * @param owner
	 * @param maxlength
	 * @param errMsg
	 * @return
	 */
	public static Document getNumberModelLimitLength(Component owner,
			int maxlength, String errMsg) {
		return new NumberModelLimitMaxLength(owner, maxlength, errMsg);
	}

	public static Document getNumberModelLimitLengthNot0Begin(Component owner,
			int maxlength, String errMsg) {
		return new NumberModelLimitMaxLengthNot0Begin(owner, maxlength, errMsg);
	}

	/**
	 * Kiểm tra một chuỗi nhập vào bao gồm các kí tự a-z, A-Z và 0-9
	 */
	public static Document getCharacterNumberModeLimitMaxLength(
			Component owner, int maxlength, String errMsg) {
		return new CharacterNumberModeLimitMaxLength(owner, maxlength, errMsg);
	}

	public static Document getNumberModelRangeCompare(Component owner,
			Component compareObject, boolean isSmaller, String title) {
		return new NumberModelRangeCompare(owner, compareObject, isSmaller,
				title);
	}

	/**
	 * Kiểm tra chuỗi nhập vào không được chứa khoảng trắng
	 * 
	 * @param owner
	 * @param maxlength
	 * @param errMsg
	 * @return
	 */
	public static Document getNotNumberAndSpaceModel(Component owner,
			int maxlength, String errMsg) {
		return new NotNumberAndSpaceDocument(owner, maxlength, errMsg);
	}

	/**
	 * Hạn chế độ dài chuỗi nhập vào
	 * 
	 * @param owner
	 * @param maxlength
	 * @param errMsg
	 * @return
	 */
	public static Document getLimitMaxlengthModel(Component owner,
			int maxlength, String errMsg) {
		return new LimitMaxLength(owner, maxlength, errMsg);
	}

	public static Document getUpperCaseLimitMaxlengthModel(Component owner,
			int maxlength, String errMsg) {
		return new UppercaseLimitMaxLength(owner, maxlength, errMsg);
	}

	// public static Document getIDNoFormat(Component owner, int
	// maxlength,String err) {
	// return new IDNoFormat(owner, maxlength, err);
	// }

	/**
	 * Kiểm tra chuỗi nhập vào là các kí tự trong format
	 */
	public static Document getCustomModel(Component owner, String format,
			String err) {
		return new CustomDocument(owner, format, err);
	}

	/**
	 * Kiểm tra chuỗi number nhập vào
	 * 
	 * @param owner
	 * @param maxLength
	 * @param title
	 * @return
	 */
	public static Document getNumberModelLimitMaxlength2(Component owner,
			int maxLength, String title) {
		return new NumberModelLimitMaxLength2(owner, maxLength, title);
	}

	/**
	 * Kiểm tra chuỗi nhập vào là 1-9 và / và có độ dài maxlength
	 * 
	 * @param owner
	 * @param maxLength
	 * @param title
	 * @return
	 */
	public static Document getNumberModelLimitMaxlength3(Component owner,
			int maxLength, String title) {
		return new NumberModelLimitMaxLength3(owner, maxLength, title);
	}

	/**
	 * Kiểm tra chuỗi số nhập vào nh�? hơn hoặc bằng số truy�?n vào
	 * 
	 * @param owner
	 * @param eNumber
	 * @param title
	 * @return
	 */
	public static Document getNumberModelRange(Component owner, int eNumber,
			String title) {
		return new NumberModelRange(owner, eNumber, title);
	}

//	/**
//	 * Kiểm tra chuỗi nhập vào là 1-9 và / và có độ dài maxlength
//	 * 
//	 * @param owner
//	 * @param maxLength
//	 * @param title
//	 * @return
//	 */
//	public static Document getDateModel(Component owner, char symbol,
//			String title) {
//		return new DateModel(owner, symbol, title);
//	}

	/**
	 * Kiểm tra mã hồ sơ nhập vào, không chứa khoảng trắng, độ dài maxLength
	 */
	public static Document getIdFormatDocument(Component owner, int maxLength,
			String title) {
		return new IDFormatDocument(owner, maxLength, title);
	}

	public static Document getFloatModelRange(Component owner,
			double eNumberMin, double eNumberMax, String title) {
		return new FloatModelRange(owner, eNumberMin, eNumberMax, title);
	}

	public static Document getFloatModelRange(Component owner, double eNumber,
			String title) {
		return new FloatModelRange(owner, eNumber, title);
	}

	public static Document getFloatModel(Component owner, double eNumber,
			String title) {
		return new FloatModel(owner, eNumber, title);
	}

	public static Document getFloatModel1(Component owner, double eNumber,
			String title) {
		return new FloatModel1(owner, eNumber, title);
	}

	public static Document getFractionModel(Component owner, double eNumber,
			String title) {
		return new FractionDocument(owner, eNumber, title);
	}
}

/**
 * gia tri la so nam trong mot khoang nao do
 * 
 * @author Le Nguyen Khang
 * 
 */
class FloatModelRange extends MyPlainDocument {

	private static final long serialVersionUID = 1L;
	private static final Double MAX = Double.MAX_VALUE;
	private Double eNumberMin;
	private Double eNumberMax;
	private String userErr = "";
	private boolean addDot = false;

	public FloatModelRange(Component owner, String title) {
		this(owner, 0.0, MAX, title);
	}

	public FloatModelRange(Component owner, Double eNumber, String title) {
		this(owner, 0.0, eNumber, title);
	}

	public FloatModelRange(Component owner, Double eNumberMin,
			Double eNumberMax, String title) {
		this.owner = owner;
		this.eNumberMin = eNumberMin;
		this.eNumberMax = eNumberMax;
		userErr = title;

	}

	public void remove(int arg0, int arg1) throws BadLocationException {
		boolean isDot = false;
		if (this.getText(arg0, arg1).equalsIgnoreCase(".")) {
			arg0 -= 1;
			isDot = true;
		}
		super.remove(arg0, arg1);
		if (isDot)
			arg0 += 1;
		insertString(arg0, "", null);
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {

		if (str == null)
			return;

		boolean checkInput = true;

		boolean inputPoint = false;

		boolean inputPointNearDot = false;

		if (str.equalsIgnoreCase(",")) {
			if (this.getText(offs - 1, 1).equalsIgnoreCase(".")) {
				inputPointNearDot = true;
			}
		}

		char[] charseq = str.replace(".", "").toCharArray();

		for (int i = 0; i < charseq.length; i++) {
			if (((charseq[i] >= '0') && (charseq[i] <= '9') || (charseq[i] == ','))) {
				checkInput = true;
			} else {
				checkInput = false;
			}
		}

		if (str.equalsIgnoreCase("")) {
			checkInput = true;
		}

		if (this.getLength() != 0)
			if (this.getText(0, 1).charAt(0) == '0') {
				if (this.getLength() > 1)
					if (this.getText(1, 1).charAt(0) != '0')
						super.remove(0, 1);
				offs -= 1;
			}

		if (!checkInput) {
			errText.setText("  Chỉ có thể gõ số ở đây  ");
			showErr();
		} else {
			String text = this.getText(0, this.getLength());
			int checkPoint = text.split(",").length;
			if (checkPoint == 2)
				inputPoint = true;
			if (str.equalsIgnoreCase(","))
				checkPoint++;

			if (checkPoint <= 2) {
				// System.out.println("offs: " + offs);
				String fText = "";
				if (offs < 0)
					offs = 0;
				fText = text.substring(0, offs);

				String lText = text.substring(offs);
				String tmp = convert(offs, fText + str.trim() + lText);
				double d = CommonMethod.convertToDouble(tmp);
				if (d >= eNumberMin && d <= eNumberMax) {
					super.remove(0, text.length());
					super.insertString(0, tmp, a);
					setCaretPosition(offs, str, inputPoint, inputPointNearDot);
				} else {
					errText.setText(userErr);
					showErr();
				}
			} else {
				if (checkPoint > 2) {
					errText.setText("Dữ liệu nhập vào không hợp lệ!");
					showErr();
				}
			}
		}
	}

	private void setCaretPosition(int offs, String str, boolean inputPoint,
			boolean inputPointNearDot) {
		try {
			int newOffs = 0;
			JTextComponent textComponent = (JTextComponent) owner;
			if (inputPointNearDot) {
				newOffs = offs;
			} else if (inputPoint) {
				newOffs = offs + str.length();
			} else {
				newOffs = (addDot ? offs + 1 : offs) + str.length();
			}
			textComponent.setCaretPosition(newOffs);
		} catch (Exception e) {

		}
	}

	private String convert(int offs, String str) {
		String tmp = "";
		String fText = "";
		String lText = "";

		if (str.lastIndexOf(",") > -1) {
			fText = str.substring(0, str.lastIndexOf(","));
			lText = str.substring(str.lastIndexOf(","));
			lText = lText.replace(".", "");
		} else {
			fText = str;
		}
		fText = fText.replace(".", "");

		fText = addDot(fText);

		int fFind = fText.indexOf(".");
		if (offs < fText.length())
			addDot = fFind == 1 ? true : false;
		else
			addDot = false;

		tmp += fText + lText;

		return tmp;
	}

	private String addDot(String str) {
		String tmp = "";
		try {
			int length = str.length();
			if (length > 3) {
				for (int i = length; i > 0; i--) {
					if (i != 0 && (str.length() - i) % 3 == 0) {
						tmp = "." + tmp;
					}
					tmp = String.valueOf(str.charAt(i - 1)) + tmp;
				}
			} else {
				tmp = str;
			}
			if (tmp.charAt(tmp.length() - 1) == '.')
				tmp = tmp.substring(0, tmp.length() - 1);
		} catch (Exception e) {

		}
		return tmp;
	}

}

class NumberModelRangeCompare extends MyPlainDocument {

	private static final long serialVersionUID = 1L;
	private int eNum;
	private String userErr = ""; // User's error message
	private String defErr = "Chỉ có thể gõ số ở đây"; // default message
	private boolean isSmaller = true;
	private MyTextField compareObject;

	public NumberModelRangeCompare(Component owner, Component compareObject,
			boolean isSmaller, String title) {
		this.owner = owner;
		this.compareObject = (MyTextField) compareObject;
		userErr = title;
		this.isSmaller = isSmaller;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null)
			return;
		if (str.equals("")) {
			super.insertString(offs, str, a);
			return;
		}
		eNum = (compareObject.getText().trim().equalsIgnoreCase("") ? 0
				: Integer.parseInt(compareObject.getText().trim()));

		char[] charseq = str.toCharArray();
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < charseq.length; i++) {
			if (((charseq[i] >= '0') && (charseq[i] <= '9'))) {
				tmp.append(charseq[i]);
			} else {
				errText.setText(defErr);
				showErr();
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
			if (isSmaller) {
				if (num <= eNum)
					super.insertString(offs, tmp.toString(), a);
				else {
					if (!userErr.equals("")) {
						errText.setText(userErr);
						showErr();
					}
				}
			} else {
				if (num >= eNum)
					super.insertString(offs, tmp.toString(), a);
				else {
					if (!userErr.equals("")) {
						errText.setText(userErr);
						showErr();
					}
				}
			}

		} catch (Exception e) {
		}
	}
}

class UppercaseLimitMaxLength extends MyPlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxLength;
	private String userErr = ""; // User's error message

	public UppercaseLimitMaxLength(Component owner, int maxlength, String title) {
		this.owner = owner;
		maxLength = maxlength;
		userErr = title;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if ((this.getLength() + str.length()) <= maxLength) {
			if (isShow) {
				popup.hide();
				isShow = false;
			}
			super.insertString(offs, str.toUpperCase(), a);
		} else {
			errText.setText(userErr);
			showErr();
		}
	}
}

class LimitMaxLength extends MyPlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxLength;
	private String userErr = ""; // User's error message

	public LimitMaxLength(Component owner, int maxlength, String title) {
		this.owner = owner;
		maxLength = maxlength;
		userErr = title;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if ((this.getLength() + str.length()) <= maxLength) {
			if (isShow) {
				popup.hide();
				isShow = false;
			}
			super.insertString(offs, str, a);
		} else {
			errText.setText(userErr);
			showErr();
		}
	}
}

class NumberModelMedicalCardNumRule extends MyPlainDocument {

	private static final long serialVersionUID = 1L;
	private String userErr = ""; // User's error message
	private String defErr = "Chỉ có thể gõ số ở đây"; // default message
	private String conErr = "Chỉ có thẻ gõ chữ ở đây";

	public NumberModelMedicalCardNumRule(Component owner, String title) {
		this.owner = owner;
		userErr = title;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if (offs < 9) {
			if (isShow) {
				popup.hide();
				isShow = false;
			}
			char[] charseq = str.toCharArray();

			StringBuffer tmp = new StringBuffer();
			for (int i = 0; i < charseq.length; i++) {
				boolean isChar = false;
				if ((offs + i) == 0 || (offs + i) == 4) {
					isChar = true;
				}

				if (isChar) {
					if (((charseq[i] >= 'a') && (charseq[i] <= 'z'))
							|| ((charseq[i] >= 'A') && (charseq[i] <= 'Z'))) {
						tmp.append(charseq[i]);
						if (isShow) {
							popup.hide();
							isShow = false;
						}
					} else {
						errText.setText(conErr);
						showErr();
					}
				} else {
					if ((charseq[i] >= 48) && (charseq[i] <= 57)) {
						tmp.append(charseq[i]);
						if (isShow) {
							popup.hide();
							isShow = false;
						}
					} else {
						errText.setText(defErr);
						showErr();
					}
				}
			}
			super.insertString(offs, tmp.toString(), a);
		} else {
			errText.setText(userErr);
			showErr();
		}
	}

}

/**
 * gia tri la so nam trong mot khoang nao do
 * 
 * @author Dinh Thi Luong
 * 
 */
class NumberModelRange extends MyPlainDocument {

	private static final long serialVersionUID = 1L;
	private int bNum = 0;
	private int eNum;
	private String userErr = ""; // User's error message
	private String defErr = "Chỉ có thể gõ số ở đây"; // default message

	public NumberModelRange(Component owner, int eNumber, String title) {
		this.owner = owner;
		eNum = eNumber;
		userErr = title;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null)
			return;
		if (str.equals("")) {
			super.insertString(offs, str, a);
			return;
		}

		char[] charseq = str.toCharArray();
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < charseq.length; i++) {
			if (((charseq[i] >= '0') && (charseq[i] <= '9'))) {
				tmp.append(charseq[i]);
			} else {
				errText.setText(defErr);
				showErr();
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
			if ((num >= bNum) && (num <= eNum))
				super.insertString(offs, tmp.toString(), a);
			else {
				if (!userErr.equals("")) {
					errText.setText(userErr);
					showErr();
				}
			}
		} catch (Exception e) {
		}
	}
}

/**
 * so nguyen tu 1- 9 va dau /
 * 
 * @author Dinh Thi Luong
 * 
 */
class NumberModelLimitMaxLength3 extends MyPlainDocument {

	private static final long serialVersionUID = 1L;
	private int maxLength;
	private String userErr = ""; // User's error message
	private String defErr = "Chỉ có thể gõ số và dấu /, hoặc dạng x/y ở đây"; // default

	// message

	public NumberModelLimitMaxLength3(Component owner, int maxlength,
			String title) {
		this.owner = owner;
		maxLength = maxlength;
		userErr = title;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if (offs < maxLength) {
			if (isShow) {
				popup.hide();
				isShow = false;
			}
			char[] charseq = str.toCharArray();
			StringBuffer tmp = new StringBuffer();
			for (int i = 0; i < charseq.length; i++) {
				if (((charseq[i] >= '1') && (charseq[i] <= '9'))
						|| (charseq[i] == '/')) {
					tmp.append(charseq[i]);
					if (isShow) {
						popup.hide();
						isShow = false;
					}
				} else {
					errText.setText(defErr);
					showErr();
				}
			}
			super.insertString(offs, tmp.toString(), a);
		} else {
			errText.setText(userErr);
			showErr();
		}
	}
}

/**
 * so nguyen tu 1- 9
 * 
 * @author Dinh Thi Luong
 * 
 */
class NumberModelLimitMaxLength2 extends MyPlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxLength;
	private String userErr = ""; // User's error message
	private String defErr = "Chỉ có thể gõ số ở đây"; // default message

	public NumberModelLimitMaxLength2(Component owner, int maxlength,
			String title) {
		this.owner = owner;
		maxLength = maxlength;
		userErr = title;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if (offs < maxLength) {
			if (isShow) {
				popup.hide();
				isShow = false;
			}
			char[] charseq = str.toCharArray();
			StringBuffer tmp = new StringBuffer();
			for (int i = 0; i < charseq.length; i++) {
				if ((charseq[i] >= '1') && (charseq[i] <= '9')) {
					tmp.append(charseq[i]);
					if (isShow) {
						popup.hide();
						isShow = false;
					}
				} else {
					errText.setText(defErr);
					showErr();
				}
			}
			super.insertString(offs, tmp.toString(), a);
		} else {
			errText.setText(userErr);
			showErr();
		}
	}
}

class NumberModelLimitMaxLength extends MyPlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxLength;
	private String userErr = "";
	private String defErr = "Chỉ có thể gõ số ở đây";

	public NumberModelLimitMaxLength(Component owner, int maxlength,
			String title) {
		this.owner = owner;
		maxLength = maxlength;
		userErr = title;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if ((this.getLength() + str.length()) <= maxLength) {
			if (isShow) {
				popup.hide();
				isShow = false;
			}
			char[] charseq = str.toCharArray();
			StringBuffer tmp = new StringBuffer();
			for (int i = 0; i < charseq.length; i++) {
				if ((charseq[i] >= '0') && (charseq[i] <= '9')) {
					tmp.append(charseq[i]);
					if (isShow) {
						popup.hide();
						isShow = false;
					}
				} else {
					errText.setText(defErr);
					showErr();
				}
			}
			super.insertString(offs, tmp.toString(), a);
		} else {
			errText.setText(userErr);
			if (!userErr.trim().equalsIgnoreCase(""))
				showErr();
		}
	}
}

class NumberModelLimitMaxLengthNot0Begin extends MyPlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxLength;
	private String userErr = "";
	private String defErr = "Chỉ có thể gõ số ở đây";
	@SuppressWarnings("unused")
	private String defErr1 = "Không thể gõ số 0 vào lúc này";

	public NumberModelLimitMaxLengthNot0Begin(Component owner, int maxlength,
			String title) {
		this.owner = owner;
		maxLength = maxlength;
		userErr = title;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if (getLength() == 0 && str.charAt(0) == '0' /*
													 * && this.getLength() == 0
													 * // KHang bo
													 */) {
			System.out.println(str.charAt(0));
			// errText.setText(defErr1);
			// showErr();
		} else {
			if ((this.getLength() + str.length()) <= maxLength) {
				if (isShow) {
					if (popup != null) {
						popup.hide();
					}
					isShow = false;
				}
				char[] charseq = str.toCharArray();
				StringBuffer tmp = new StringBuffer();
				for (int i = 0; i < charseq.length; i++) {
					if ((charseq[i] >= '0') && (charseq[i] <= '9')) {
						tmp.append(charseq[i]);
						if (isShow) {
							popup.hide();
							isShow = false;
						}
					} else {
						errText.setText(defErr);
						showErr();
					}
				}
				super.insertString(offs, tmp.toString(), a);
			} else {
				errText.setText(userErr);
				showErr();
			}
		}
	}
}

/**
 * Kiểm tra một chuỗi nhập vào bao gồm các kí tự a-z, A-Z và 0-9
 * 
 * @author Never_Say_Die
 * 
 */

class CharacterNumberModeLimitMaxLength extends MyPlainDocument {

	private static final long serialVersionUID = 1L;

	private int maxLength;
	private String userErr = ""; // User's error message
	private String defErr = "Chỉ bao gồm các kí tự a-z, A-Z và 0-9"; // default

	// message

	public CharacterNumberModeLimitMaxLength(Component owner, int maxlength,
			String title) {
		this.owner = owner;
		maxLength = maxlength;
		userErr = title;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if ((this.getLength() + str.length()) <= maxLength) {
			if (isShow) {
				popup.hide();
				isShow = false;
			}
			char[] charseq = str.toCharArray();
			StringBuffer tmp = new StringBuffer();
			for (int i = 0; i < charseq.length; i++) {
				if (((charseq[i] >= '0') && (charseq[i] <= '9'))
						|| ((charseq[i] >= 'a') && (charseq[i] <= 'z'))
						|| ((charseq[i] >= 'A') && (charseq[i] <= 'Z'))) {
					tmp.append(charseq[i]);
					if (isShow) {
						popup.hide();
						isShow = false;
					}
				} else {
					errText.setText(defErr);
					showErr();
				}
			}
			super.insertString(offs, tmp.toString(), a);
		} else {
			errText.setText(userErr);
			showErr();
		}
	}
}

class UpperCaseDocument extends PlainDocument {

	private static final long serialVersionUID = 1L;

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {

		if (str == null) {
			return;
		}
		char[] upper = str.toCharArray();
		for (int i = 0; i < upper.length; i++) {
			upper[i] = Character.toUpperCase(upper[i]);
		}
		super.insertString(offs, new String(upper), a);
	}
}

class LowerCaseDocument extends PlainDocument {

	private static final long serialVersionUID = 1L;

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {

		if (str == null) {
			return;
		}
		char[] upper = str.toCharArray();
		for (int i = 0; i < upper.length; i++) {
			upper[i] = Character.toLowerCase(upper[i]);
		}
		super.insertString(offs, new String(upper), a);
	}
}

class NumberDocument extends MyPlainDocument {

	private static final long serialVersionUID = 1L;

	public NumberDocument(Component owner) {
		this.owner = owner;
		errText.setText("  Chỉ có thể gõ số ở đây  ");
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		char[] charseq = str.toCharArray();
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < charseq.length; i++) {
			if ((charseq[i] >= '0') && (charseq[i] <= '9')) {
				tmp.append(charseq[i]);
				if (isShow) {
					popup.hide();
					isShow = false;
				}
			} else {
				showErr();
			}
		}
		super.insertString(offs, tmp.toString(), a);
	}
}

class FractionDocument extends MyPlainDocument {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private double max = Double.MAX_VALUE;

	public FractionDocument(Component owner) {
		this.owner = owner;
		errText.setText("  Chỉ có thể gõ số ở đây  ");
	}

	public FractionDocument(Component owner, double max, String warning) {
		this.owner = owner;
		this.max = max;
		if (warning != null) {
			errText.setText(warning);
		} else {
			errText.setText("  Chỉ có thể gõ số ở đây  ");
		}
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if (offs == 0 && str.indexOf('/') == 0) {
			showErr();
		}

		char[] charseq = str.toCharArray();
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < charseq.length; i++) {
			char c = charseq[i];
			if ((c >= '0') && (c <= '9') || c == '/') {
				tmp.append(charseq[i]);
				if (isShow) {
					popup.hide();
					isShow = false;
				}
			} else {
				showErr();
			}
		}
		super.insertString(offs, tmp.toString(), a);
	}
}

class NotNumberDocument extends MyPlainDocument {

	private static final long serialVersionUID = 1L;

	public NotNumberDocument(Component owner) {
		this.owner = owner;
		errText.setText(" Không thể gõ số ở đây ");
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {

		if (str == null) {
			return;
		}
		char[] charseq = str.toCharArray();
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < charseq.length; i++) {
			if ((charseq[i] >= '0') && (charseq[i] <= '9')) {
				showErr();
			} else {
				tmp.append(charseq[i]);
				if (isShow) {
					popup.hide();
					isShow = false;
				}
			}
		}
		super.insertString(offs, tmp.toString(), a);
	}
}

class CustomDocument extends MyPlainDocument {

	private static final long serialVersionUID = 1L;

	private String format;

	public CustomDocument(Component owner, String format, String error) {
		this.owner = owner;
		this.format = format;
		errText.setText(error);
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {

		if (str == null) {
			return;
		}
		char[] charseq = str.toCharArray();
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < charseq.length; i++) {
			if (format.indexOf(charseq[i]) >= 0) {
				tmp.append(charseq[i]);
				if (isShow) {
					popup.hide();
					isShow = false;
				}
			} else {
				showErr();
			}
		}
		super.insertString(offs, tmp.toString(), a);
	}
}

class NotNumberAndSpaceDocument extends MyPlainDocument {

	private static final long serialVersionUID = 1L;
	private int maxLength;
	private String userErr = ""; // User's error message
	private String defErr = "Tên không được chứa khoảng trắng"; // default

	// message

	public NotNumberAndSpaceDocument(Component owner, int maxlength,
			String title) {
		this.owner = owner;
		maxLength = maxlength;
		userErr = title;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if ((this.getLength() + str.length()) <= maxLength) {
			if (isShow) {
				popup.hide();
				isShow = false;
			}
			char[] charseq = str.toCharArray();
			StringBuffer tmp = new StringBuffer();
			for (int i = 0; i < charseq.length; i++) {
				if (charseq[i] != ' ') {
					tmp.append(charseq[i]);
					if (isShow) {
						popup.hide();
						isShow = false;
					}
				} else {
					errText.setText(defErr);
					showErr();
				}
			}
			super.insertString(offs, tmp.toString(), a);
		} else {
			errText.setText(userErr);
			showErr();
		}
	}
}

class IDFormatDocument extends MyPlainDocument {

	private static final long serialVersionUID = 1L;
	private int maxLength;
	private String userErr = ""; // User's error message
	private String defErr = "Quy cách mã số không được chứa khoảng trắng"; // default

	// message

	public IDFormatDocument(Component owner, int maxlength, String errMsg) {
		this.owner = owner;
		maxLength = maxlength;
		userErr = errMsg;
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		if (str == null) {
			return;
		}
		if ((this.getLength() + str.length()) <= maxLength) {
			if (isShow) {
				popup.hide();
				isShow = false;
			}
			char[] charseq = str.toCharArray();
			StringBuffer tmp = new StringBuffer();
			for (int i = 0; i < charseq.length; i++) {
				if (charseq[i] != ' ') {
					tmp.append(charseq[i]);
					if (isShow) {
						popup.hide();
						isShow = false;
					}
				} else {
					errText.setText(defErr);
					showErr();
				}
			}
			super.insertString(offs, tmp.toString(), a);
		} else {
			errText.setText(userErr);
			showErr();
		}
	}
}

//
///**
// * nhập theo định dạng: dd-mm-yyyy (ex: 30-11-2008)
// * 
// * @author khang.ln
// * 
// */
//class DateModel extends MyPlainDocument {
//
//	private static final long serialVersionUID = 1L;
//	private char symbol;
//	private String userErr = ""; // User's error message
//	private String defErr = "Chỉ có thể gõ \"dd-mm-yyyy\""; // default message
//
//	public DateModel(Component owner, char symbol, String title) {
//		this.owner = owner;
//		this.symbol = symbol;
//		userErr = title;
//	}
//
//	public void insertString(int offs, String str, AttributeSet a)
//			throws BadLocationException {
//		if (str == null) {
//			return;
//		}
//		if (offs < 10) {
//			if (isShow) {
//				popup.hide();
//				isShow = false;
//			}
//			char[] charseq = str.toCharArray();
//			StringBuffer tmp = new StringBuffer();
//			if (str.length() > 1) {
//				for (int i = 0; i < charseq.length; i++) {
//					if ((charseq[i] >= '0') && (charseq[i] <= '9')
//							|| charseq[i] == symbol) {
//						tmp.append(charseq[i]);
//						if (isShow) {
//							popup.hide();
//							isShow = false;
//						}
//					} else {
//						errText.setText(defErr);
//						showErr();
//					}
//				}
//			} else {
//				if ((offs == 2 || offs == 5) && str.length() == 1
//						&& str.charAt(0) == symbol) {
//					tmp.append(charseq[0]);
//					if (isShow) {
//						popup.hide();
//						isShow = false;
//					}
//				} else if ((offs != 2 && offs != 5) && (charseq[0] >= '0')
//						&& (charseq[0] <= '9')) {
//					tmp.append(charseq[0]);
//					if (isShow) {
//						popup.hide();
//						isShow = false;
//					}
//				} else {
//					errText.setText(defErr);
//					showErr();
//				}
//			}
//
//			super.insertString(offs, tmp.toString(), a);
//		} else {
//			errText.setText(userErr);
//			showErr();
//		}
//	}
//}

/**
 * gia tri la so nam trong mot khoang nao do
 * 
 * @author Le Nguyen Khang
 * 
 */
class FloatModel extends MyPlainDocument {

	private static final long serialVersionUID = 1L;
	private static final Double MAX = Double.MAX_VALUE;
	private Double eNumberMin;
	private Double eNumberMax;
	private String userErr = "";
	private boolean addDot = false;

	public FloatModel(Component owner, String title) {
		this(owner, 0.0, MAX, title);
	}

	public FloatModel(Component owner, Double eNumber, String title) {
		this(owner, 0.0, eNumber, title);
	}

	public FloatModel(Component owner, Double eNumberMin, Double eNumberMax,
			String title) {
		this.owner = owner;
		this.eNumberMin = eNumberMin;
		this.eNumberMax = eNumberMax;
		userErr = title;

	}

	public void remove(int arg0, int arg1) throws BadLocationException {
		boolean isDot = false;
		int position = ((JTextComponent) owner).getCaretPosition();
		if (arg0 > 3 && this.getText(arg0, arg1).equalsIgnoreCase(",")) {
			if (position != arg0)
				arg0 -= 1;
			else
				arg1 += 1;

			isDot = true;
		}

		super.remove(arg0, arg1);

		if (this.getLength() > 3) {
			String txt = this.getText(0, 3);

			if (txt.lastIndexOf(',') != -1) {
				arg0 -= 1;
			}
		}
		if (isDot)
			arg0 += 1;

		insertString(arg0, "", null);
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {

		if (str == null)
			return;

		boolean checkInput = true;

		boolean inputPoint = false;

		boolean inputPointNearDot = false;

		if (str.equalsIgnoreCase(".")) {
			if (this.getText(offs - 1, 1).equalsIgnoreCase(",")) {
				inputPointNearDot = true;
			}
		}

		char[] charseq = str.replace(".", "").toCharArray();

		for (int i = 0; i < charseq.length; i++) {
			if (((charseq[i] >= '0') && (charseq[i] <= '9') || (charseq[i] == ','))) {
				checkInput = true;
			} else {
				checkInput = false;
			}
		}

		if (str.equalsIgnoreCase("")) {
			checkInput = true;
		}

		// if (this.getLength() != 0)
		// if (this.getText(0, 1).charAt(0) == '0') {
		// if (this.getLength() > 1)
		// if (this.getText(1, 1).charAt(0) != '0')
		// super.remove(0, 1);
		// offs -= 1;
		// }

		if (!checkInput) {
			errText.setText("  Chỉ có thể gõ số ở đây  ");
			showErr();
		} else {
			String text = this.getText(0, this.getLength());
			int checkPoint = text.split(".").length;
			if (checkPoint == 2)
				inputPoint = true;
			if (str.equalsIgnoreCase(","))
				checkPoint++;

			if (checkPoint <= 2) {
				String fText = "";
				if (offs < 0)
					offs = 0;
				fText = text.substring(0, offs);

				String lText = text.substring(offs);
				String tmp = convert(offs, fText + str.trim() + lText);
				double d = CommonMethod.convertToDouble(tmp);
				if (d >= eNumberMin && d <= eNumberMax) {
					super.remove(0, text.length());
					super.insertString(0, tmp, a);
					setCaretPosition(offs, str, inputPoint, inputPointNearDot);
				} else {
					errText.setText(userErr);
					showErr();
				}
			} else {
				if (checkPoint > 2) {
					errText.setText("Dữ liệu nhập vào không hợp lệ!");
					showErr();
				}
			}
		}
	}

	private void setCaretPosition(int offs, String str, boolean inputPoint,
			boolean inputPointNearDot) {
		try {
			int newOffs = 0;
			JTextComponent textComponent = (JTextComponent) owner;
			if (inputPointNearDot) {
				newOffs = offs;
			} else if (inputPoint) {
				newOffs = offs + str.length();
			} else {
				newOffs = (addDot ? offs + 1 : offs) + str.length();
			}
			textComponent.setCaretPosition(newOffs);
		} catch (Exception e) {

		}
	}

	private String convert(int offs, String str) {
		String tmp = "";
		String fText = "";
		String lText = "";

		if (str.lastIndexOf(".") > -1) {
			fText = str.substring(0, str.lastIndexOf("."));
			lText = str.substring(str.lastIndexOf("."));
			lText = lText.replace(",", "");
		} else {
			fText = str;
		}
		fText = fText.replace(",", "");

		fText = addDot(fText);

		int fFind = fText.indexOf(",");
		if (offs < fText.length())
			addDot = fFind == 1 ? true : false;
		else
			addDot = false;

		tmp += fText + lText;

		return tmp;
	}

	private String addDot(String str) {
		String tmp = "";
		try {
			int length = str.length();
			if (length > 3) {
				for (int i = length; i > 0; i--) {
					if (i != 0 && (str.length() - i) % 3 == 0) {
						tmp = "," + tmp;
					}
					tmp = String.valueOf(str.charAt(i - 1)) + tmp;
				}
			} else {
				tmp = str;
			}
			if (tmp.charAt(tmp.length() - 1) == ',')
				tmp = tmp.substring(0, tmp.length() - 1);
		} catch (Exception e) {

		}
		return tmp;
	}

}

/**
 * gia tri la so nam trong mot khoang nao do
 * 
 * @author Le Dinh Bao
 * 
 */
class FloatModel1 extends MyPlainDocument {

	private static final long serialVersionUID = 1L;
	private static final Double MAX = Double.MAX_VALUE;
	private Double eNumberMin;
	private Double eNumberMax;
	private String userErr = "";
	private boolean addDot = false;

	public FloatModel1(Component owner, String title) {
		this(owner, 0.0, MAX, title);
	}

	public FloatModel1(Component owner, Double eNumber, String title) {
		this(owner, 0.0, eNumber, title);
	}

	public FloatModel1(Component owner, Double eNumberMin, Double eNumberMax,
			String title) {
		this.owner = owner;
		this.eNumberMin = eNumberMin;
		this.eNumberMax = eNumberMax;
		userErr = title;

	}

	public void remove(int arg0, int arg1) throws BadLocationException {

		boolean isDot = false;

		int position = ((JTextComponent) owner).getCaretPosition();

		if (arg0 > 3 && this.getText(arg0, arg1).equalsIgnoreCase(".")) {
			if (position != arg0)
				arg0 -= 1;
			else
				arg1 += 1;

			isDot = true;
		}

		super.remove(arg0, arg1);

		if (this.getLength() > 3) {
			String txt = this.getText(0, 3);

			if (txt.lastIndexOf('.') != -1) {
				arg0 -= 1;
			}
		}
		if (isDot)
			arg0 += 1;

		insertString(arg0, "", null);
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		int coffs = offs;
		if (str == null)
			return;
		boolean checkInput = true;

		boolean inputPoint = false;

		boolean inputPointNearDot = false;

		if (str.equalsIgnoreCase(",")) {
			if (this.getText(offs - 1, 1).equalsIgnoreCase(".")) {
				inputPointNearDot = true;
			}
		}

		char[] charseq = str.replace(".", "").toCharArray();

		for (int i = 0; i < charseq.length; i++) {
			if (((charseq[i] >= '0') && (charseq[i] <= '9') || (charseq[i] == ','))) {
				checkInput = true;
			} else {
				checkInput = false;
			}
		}

		if (str.equalsIgnoreCase("")) {
			checkInput = true;
		}
		if (this.getLength() != 0)
			if (this.getText(0, 1).charAt(0) == '0') {
				if (this.getLength() > 1) {
					System.out.println("-" + this.getText(1, 1).charAt(0));
					if (this.getText(1, 1).charAt(0) != '0'
							&& this.getText(1, 1).charAt(0) != ',')
						super.remove(0, 1);
				}
				offs -= 1;

			}

		if (!checkInput) {
			errText.setText("  Chỉ có thể gõ số ở đây  ");
			showErr();
		} else {
			String text = this.getText(0, this.getLength());

			int checkPoint = text.split(",").length;
			if (checkPoint == 2)
				inputPoint = true;
			if (str.equalsIgnoreCase(","))
				checkPoint++;
			System.out.println("ck2 >> " + text);
			System.out.println("ck3 >> " + str);
			System.out.println("off   " + coffs);
			if (coffs >= 0) {

				String f1 = text.substring(0, coffs);
				String f2 = text.substring(coffs);
				System.out.println("CK --1--- " + f1);
				System.out.println("CK --2--- " + f2);
				String f3 = f1 + str + f2;
				System.out.println("CK --3--- " + f3);
				System.out.println("ck4 >> ");
			}
			if (checkPoint <= 2) {
				String fText = "";
				if (offs < 0)
					offs = 0;

				fText = text.substring(0, offs);

				String lText = text.substring(offs);

				String tmp = convert(offs, fText + str.trim() + lText);
				if (tmp.equals(",") || tmp.equals("."))
					tmp = "0";
				System.out.println("H2 >>" + tmp);
				double d = CommonMethod.convertToDouble(tmp);
				System.out.println("H3 >>" + d);
				if (d >= eNumberMin && d <= eNumberMax) {
					super.remove(0, text.length());
					super.insertString(0, tmp, a);
					setCaretPosition(offs, str, inputPoint, inputPointNearDot);
				} else {
					errText.setText(userErr);
					showErr();
				}
			} else {
				if (checkPoint > 2) {
					errText.setText("Dữ liệu nhập vào không hợp lệ!");
					showErr();
				}
			}
		}
	}

	private void setCaretPosition(int offs, String str, boolean inputPoint,
			boolean inputPointNearDot) {
		try {
			int newOffs = 0;
			JTextComponent textComponent = (JTextComponent) owner;
			if (inputPointNearDot) {
				newOffs = offs;
			} else if (inputPoint) {
				newOffs = offs + str.length();
			} else {
				newOffs = (addDot ? offs + 1 : offs) + str.length();
			}
			textComponent.setCaretPosition(newOffs);
		} catch (Exception e) {

		}
	}

	private String convert(int offs, String str) {
		String tmp = "";
		String fText = "";
		String lText = "";

		if (str.lastIndexOf(",") > -1) {
			fText = str.substring(0, str.lastIndexOf(","));
			lText = str.substring(str.lastIndexOf(","));
			lText = lText.replace(".", "");
		} else {
			fText = str;
		}
		fText = fText.replace(".", "");

		fText = addDot(fText);

		int fFind = fText.indexOf(".");
		if (offs < fText.length())
			addDot = fFind == 1 ? true : false;
		else
			addDot = false;

		tmp += fText + lText;

		return tmp;
	}

	private String addDot(String str) {
		String tmp = "";
		try {
			int length = str.length();
			if (length > 3) {
				for (int i = length; i > 0; i--) {
					if (i != 0 && (str.length() - i) % 3 == 0) {
						tmp = "." + tmp;
					}
					tmp = String.valueOf(str.charAt(i - 1)) + tmp;
				}
			} else {
				tmp = str;
			}
			if (tmp.charAt(tmp.length() - 1) == '.')
				tmp = tmp.substring(0, tmp.length() - 1);
		} catch (Exception e) {

		}
		return tmp;
	}

}

/**
 * Khi viết các Document nên extends lớp này để rút g�?n code và hiển thị tip đẹp
 * hơn ^^
 * 
 * @author Phuc Hung
 * 
 */
class MyPlainDocument extends PlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected MyLabel errText = new MyLabel() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void setText(String text) {
			text = "  " + text.trim() + "  ";
			super.setText(text);
		}
	};
	protected Popup popup = null;
	protected boolean isShow = false;
	protected Component owner = null;

	public MyPlainDocument() {
		errText.setOpaque(true);
	}

	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		super.insertString(offs, str, a);
	}

	protected void showErr() {
		if (!isShow) {
			if (owner.isShowing()) {
				int loc = owner.getLocationOnScreen().x + 10;
				errText.setPreferredSize(new Dimension(
						errText.getMaximumSize().width, 23));
				if (loc + errText.getSize().width > Toolkit.getDefaultToolkit()
						.getScreenSize().width)
					loc = Toolkit.getDefaultToolkit().getScreenSize().width
							- errText.getSize().width;
				PopupFactory factory = PopupFactory.getSharedInstance();
				popup = factory.getPopup(owner, errText, loc,
						owner.getLocationOnScreen().y + 20);
				if (popup == null)
					return;
				popup.show();
				isShow = true;
				new Thread(new Runnable() {
					public void run() {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (popup != null)
							popup.hide();
						isShow = false;
					}
				}).start();
			}
		}
	}
}
