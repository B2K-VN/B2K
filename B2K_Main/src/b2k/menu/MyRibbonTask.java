package b2k.menu;

import org.pushingpixels.flamingo.api.ribbon.AbstractRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.RibbonTask;

public class MyRibbonTask extends RibbonTask{
	
	public MyRibbonTask(String title, String hotkey,  AbstractRibbonBand<?>[] ribbonBands) {
		super(title, ribbonBands);
		setKeyTip(hotkey);
	}

}
