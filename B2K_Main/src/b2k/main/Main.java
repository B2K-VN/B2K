package b2k.main;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.pushingpixels.substance.api.skin.SubstanceRavenLookAndFeel;

import b2k.help.MainData;
import b2k.theme.MainController;

public class Main {
	
	
	public Main(String keycis) {
		System.out.println("bao --> " + keycis);
		/**
		 * @T Đăng ký phiên làm việc hoặc kiểm tra phiên làm việc
		 * @T
		 * 
		 */
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);

		try {
			UIManager.setLookAndFeel(new SubstanceRavenLookAndFeel());
			UIManager.put("TaskPane.useGradient", Boolean.TRUE);
			UIManager.put("TaskPane.backgroundGradientStart", new Color(80,80,80).darker());
			UIManager.put("TaskPane.backgroundGradientEnd", new Color(80,80,80).darker().darker());
			
			UIManager.put("TaskPaneGroup.titleForeground", new Color(80,80,80).darker().darker());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				System.out.println("Hello world xxxxxxxxxxxxxxxxxxx");
//				JFrame jFrame = new JFrame();
//
//				jFrame.setSize(300, 300);
//				jFrame.setVisible(true);

				MainData.setTITLE("B2K- Clinic Demo");

				MainController mainController = new MainController();
				mainController.initDatas();
				MainData.getController().initMenus();

				mainController.run();

//				JFrame jFrame = new JFrame();
//
//				jFrame.setSize(300, 300);
//				jFrame.setVisible(true);
				
			};

		});

	}

}
