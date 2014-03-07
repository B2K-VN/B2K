package b2k.theme;

import b2k.help.MainData;
import b2k.help.MainFrameController;

public class MainController {

	private MainFrameController controller = null;

	public MainFrameController getController() {
		if (controller == null) {
			controller = new MyMainFrameController();
		}
		return controller;
	}

	public void setController(MainFrameController controller) {
		this.controller = controller;
	}

	public MainController() {
		initUIs();
		initActions();
	}

	public void initDatas() {
		MainData.setController(getController());
	}

	private void initActions() {
		// TODO Auto-generated method stub

	}

	private void initUIs() {
		// TODO Auto-generated method stub

	}

	public void run() {


			getController().setVisible(true);
			System.out.println("getController().setVisible(true);");

	}

}
