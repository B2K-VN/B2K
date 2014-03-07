package b2k.help;

public class ReadMoney {

	public static String read(double money) {
		String result = "";

		if (money < 0) {
			result += "(Nợ) ";
			money *= -1;
		}

		if (money >= 0 && money < 1)
			return "KHÔNG ĐỒNG";

		ReadMoney readMoney = new ReadMoney();

		char[] charArray = readMoney.changeMoneyToCharArray(money);

		// Bắt đầu đọc
		for (int i = 0; i < charArray.length; i++) {
			int pos = charArray.length - i;
			String so = "";
			String donVi = "";

			// --- Đọc số
			switch (charArray[i]) {
			case '0':
				if (pos == 2 || pos == 5 || pos == 8 || pos == 11) {
					if (charArray[i + 1] != '0') {
						so = "lẻ";
						result += so + " ";
					}
				}
				if (pos == 3 || pos == 6 || pos == 9 || pos == 12) {
					if (charArray[i + 1] != '0' || charArray[i + 2] != '0') {
						so = "không";
						result += so + " ";
					}
				}
				break;
			case '1':
				if (pos == 1 || pos == 4 || pos == 7 || pos == 10) {
					try {
						if (charArray[i - 1] != '0' && charArray[i - 1] != '1') {
							so = "mốt";
							result += so + " ";
						} else {
							so = "một";
							result += so + " ";
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						so = "một";
						result += so + " ";
					}
				} else if (pos == 2 || pos == 5 || pos == 8 || pos == 11) {
					so = "mười";
					result += so + " ";
				} else {
					so = "một";
					result += so + " ";
				}
				break;
			case '2':
				so = "hai";
				result += so + " ";
				break;
			case '3':
				so = "ba";
				result += so + " ";
				break;
			case '4':
				so = "bốn";
				result += so + " ";
				break;
			case '5':
				if (pos == 1 || pos == 4 || pos == 7 || pos == 10) {
					try {
						if (charArray[i - 1] != '0') {
							so = "lăm";
							result += so + " ";
						} else {
							so = "năm";
							result += so + " ";
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						so = "năm";
						result += so + " ";
					}
				} else {
					so = "năm";
					result += so + " ";
				}
				break;
			case '6':
				so = "sáu";
				result += so + " ";
				break;
			case '7':
				so = "bảy";
				result += so + " ";
				break;
			case '8':
				so = "tám";
				result += so + " ";
				break;
			case '9':
				so = "chín";
				result += so + " ";
				break;
			} // End of switch - Đọc số

			// --- Đọc đơn vị
			switch (pos) {
			case 4:
				if (charArray[i] != '0') {
					donVi = "ngàn,";
					result += donVi + " ";
				} else {
					if (charArray[i - 1] != '0' || charArray[i - 2] != '0') {
						donVi = "ngàn,";
						result += donVi + " ";
					}
				}
				break;
			case 7:
				if (charArray[i] != '0') {
					donVi = "triệu,";
					result += donVi + " ";
				} else {
					if (charArray[i - 1] != '0' || charArray[i - 2] != '0') {
						donVi = "triệu,";
						result += donVi + " ";
					}
				}
				break;
			case 10:
				donVi = "tỷ,";
				result += donVi + " ";
				break;
			default:
				if (pos == 2 || pos == 5 || pos == 8 || pos == 11)
					if (charArray[i] != '1' && charArray[i] != '0') {
						donVi = "mươi";
						result += donVi + " ";
					}
				if (pos == 3 || pos == 6 || pos == 9 || pos == 12) {
					if (charArray[i] != '0') {
						donVi = "trăm";
						result += donVi + " ";
					} else {
						if (charArray[i + 1] != '0' || charArray[i + 2] != '0') {
							donVi = "trăm";
							result += donVi + " ";
						}
					}
				}
				break;
			} // End of switch - Đọc đơn vị
		} // End of for

		if (result.length() - 2 > 0
				&& result.charAt(result.length() - 2) == ',')
			return result.substring(0, result.length() - 2).toUpperCase()
					+ " ĐỒNG";
		else
			return result.toUpperCase() + " ĐỒNG";
	}

	// Chuyển đổi double --> char[]
	private char[] changeMoneyToCharArray(double money) {
		String str = String.valueOf(Math.round(money));
		// System.out.println("\t\t\t" +
		// NumberFormat.getInstance().format(money));
		return str.toCharArray();
	}

	public static void main(String[] args) {

		// Run "vol"
	}

}