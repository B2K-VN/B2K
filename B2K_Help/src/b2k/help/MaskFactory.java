package b2k.help;

import javax.swing.text.MaskFormatter;

public class MaskFactory {

	public static MaskFormatter getMark(String format) {

		if (format == null)
			return new MaskFormatter();

		try {

			MaskFormatter maskFormatter = new MaskFormatter(format);

			maskFormatter.setPlaceholderCharacter('_');

			return maskFormatter;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return new MaskFormatter();

	}

}
