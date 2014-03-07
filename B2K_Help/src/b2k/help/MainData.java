package b2k.help;

public class MainData {
	private static String TITLE = "";
private static String accountName = "";
	public static String getAccountName() {
	return accountName;
}

public static void setAccountName(String accountName) {
	MainData.accountName = accountName;
}

	public static String getTITLE() {
		return TITLE;
	}

	public static void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	private static MainFrameController controller = null;

	public static MainFrameController getController() {
		return controller;
	}

	public static void setController(MainFrameController controller) {
		MainData.controller = controller;
	}
}
