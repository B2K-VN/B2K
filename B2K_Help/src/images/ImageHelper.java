/*
 * Copyright 2005 MH-Software-Entwicklung. All rights reserved.
 * Use is subject to license terms.
 */

package images;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Class to load images out of jar-files
 * 
 * @author Michael Hagen
 */
public class ImageHelper {

	

	public static ImageIcon loadImage(String name) {
		ImageIcon image = null;
		try {
			URL url = ImageHelper.class.getResource(name);
			if (url != null) {
				java.awt.Image img = Toolkit.getDefaultToolkit().createImage(
						url);
				if (img != null)
					image = new ImageIcon(img);
			}
		} catch (Throwable ex) {
			System.out.println("ERROR: loading image " + name + " failed");
		}
		return image;
	}

	public static ImageIcon getDisplayImage(ImageIcon image, int size) {
		return getDisplayImage(image, size, true);
	}

	public static ImageIcon getDisplayImage(ImageIcon image, int size, boolean b) {
		if (image != null) {

			if (b) {
				Image i = image.getImage();
				Image resizedImage = null;
				ImageIcon img;

				int iWidth = i.getWidth(null);
				int iHeight = i.getHeight(null);

				if (iWidth > iHeight) {
					resizedImage = i.getScaledInstance(size, (size * iHeight)
							/ iWidth, Image.SCALE_SMOOTH);
				} else {
					resizedImage = i.getScaledInstance((size * iWidth)
							/ iHeight, size, Image.SCALE_SMOOTH);
				}
				img = new ImageIcon(resizedImage);
				return img;
			} else {

				Image i = image.getImage();
				int h = image.getIconHeight();
				int w = image.getIconWidth();
				w = (size * w) / h;
				Image resizedImage = null;
				ImageIcon img;
				resizedImage = i.getScaledInstance(w, size, Image.SCALE_SMOOTH);
				img = new ImageIcon(resizedImage);
				return img;
			}
		} else
			return null;
	}
	public static Icon getDisplayImageH(String addRow, int size) {

		Icon displayImage = null;

		String is = addRow + "@" + "NONE" + "@" + size;

		displayImage = iconMap.get(is);

		if (displayImage == null) {
			displayImage = getDisplayImage(loadImage(addRow), size,false);
			iconMap.put(is, displayImage);
		}

		return displayImage;

	}
	public static Icon getDisplayImage(String addRow, int size) {

		Icon displayImage = null;

		String is = addRow + "@" + "NONE" + "@" + size;

		displayImage = iconMap.get(is);

		if (displayImage == null) {
			displayImage = getDisplayImage(loadImage(addRow), size);
			iconMap.put(is, displayImage);
		}

		return displayImage;

	}

	private static HashMap<String, Icon> iconMap = new HashMap<String, Icon>();

	

}
