package images;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import org.pushingpixels.flamingo.api.common.icon.ImageWrapperResizableIcon;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;

public class IconCollection {

	@SuppressWarnings("unused")
	public static ResizableIcon getIcon(String iconName) {

		ImageIcon imageIcon = new ImageIcon(iconName);


		if (imageIcon == null)
			return null;

		return ImageWrapperResizableIcon.getIcon(imageIcon.getImage(),
				new Dimension(48, 48));

	}

}
