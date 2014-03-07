package b2k.help;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public abstract class MainFrameController extends MainFrameLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Body body = null;

	public MainFrameController() {
		super();
		initUIs();
		initActions();
	}

	public void initMenus() {
		// getRibbon().addTask(new KklRibbon());
		// getRibbon().addTask(new ReportRibbon());
		// getRibbon().addTask(new ManagerRibbon());
	}

	private void initUIs() {

		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		initMenus();
		this.getContentPane().add(getBody());
	}

	public Body getBody() {
		if (body == null) {
			body = new Body();
		}

		return body;
	}

	private void initActions() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
				} catch (Exception e1) {
					CommonMethod.exit(MainData.getController());
				}
				CommonMethod.exit(MainData.getController());
			}
		});

	}

	@Override
	public void setTitle(String title) {
		super.setTitle(MainData.getTITLE() + " | " + title);
	}
}
