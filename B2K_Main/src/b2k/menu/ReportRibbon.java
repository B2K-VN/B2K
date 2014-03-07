package b2k.menu;

import images.IconCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.ribbon.AbstractRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority;
import org.pushingpixels.flamingo.api.ribbon.RibbonTask;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;

import b2k.action.Actions;

public class ReportRibbon extends RibbonTask {

	public ReportRibbon(String title, String hotkey) {

		super(title, getRibbonBands());
		setKeyTip(hotkey);
	}

	private static AbstractRibbonBand<?>[] getRibbonBands() {

		List<JRibbonBand> ribbonBands = new ArrayList<JRibbonBand>();

		JRibbonBand jRibbonBand = getJRibbonBand("Tiếp nhận");

		getJCommandButton(jRibbonBand, "Nhận bệnh", "images/customer.png",
				"getActionReception");

		ribbonBands.add(jRibbonBand);

		return ribbonBands
				.toArray(new AbstractRibbonBand<?>[ribbonBands.size()]);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JRibbonBand getJRibbonBand(String... arg) {
		JRibbonBand band = new JRibbonBand(arg[0], null);

		band.setResizePolicies((List) Arrays
				.asList(new CoreRibbonResizePolicies.Mirror(band
						.getControlPanel())));
		return band;
	}

	private static JCommandButton getJCommandButton(JRibbonBand band,
			String... arg) {
		JCommandButton btn1 = new JCommandButton(arg[0],
				IconCollection.getIcon(arg[1]));
		try {
			btn1.addActionListener(Actions.callAction(arg[2]));
		} catch (Exception e) {
			e.printStackTrace();
		}
		band.addCommandButton(btn1, RibbonElementPriority.TOP);
		return btn1;
	}

}
