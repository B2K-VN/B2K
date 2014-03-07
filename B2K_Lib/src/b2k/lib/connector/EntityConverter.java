package b2k.lib.connector;

import java.text.NumberFormat;
import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;

public class EntityConverter {
	public static <T> T getValue(Class<T> c, Object o) {

		String name = c.getName();

		if (Long.class.getName().equals(name)) {

			if (o == null) {
				return c.cast(0l);
			}

			try {
				String value = (String) o.toString();
				NumberFormat formmater = NumberFormat.getInstance();
				formmater.setMaximumFractionDigits(3);
				Number parse = formmater.parse(value);
				return c.cast(parse.shortValue());
			} catch (ParseException e) {
				return c.cast(0);
			}
		} else if (Integer.class.getName().equals(name)) {
			if (o == null) {
				return c.cast(0);
			}

			try {
				String value = (String) o;
				NumberFormat formmater = NumberFormat.getInstance();
				formmater.setMaximumFractionDigits(3);
				Number parse = formmater.parse(value);
				return c.cast(parse.intValue());
			} catch (ParseException e) {
				return c.cast(0);
			}
		} else if (Double.class.getName().equals(name)) {
			if (o == null) {
				return c.cast(0f);
			}
			try {
				String value = (String) o;
				NumberFormat formmater = NumberFormat.getInstance();
				formmater.setMaximumFractionDigits(3);
				Number parse = formmater.parse(value);
				return c.cast(parse.doubleValue());
			} catch (ParseException e) {
				return c.cast(0f);
			}
		} else if (Float.class.getName().equals(name)) {
			if (o == null) {
				return c.cast(0f);
			}
			try {
				String value = (String) o;
				NumberFormat formmater = NumberFormat.getInstance();
				formmater.setMaximumFractionDigits(3);
				Number parse = formmater.parse(value);
				return c.cast(parse.floatValue());
			} catch (ParseException e) {
				return c.cast(0f);
			}
		} else if (Long.class.getName().equals(name)) {
			if (o == null) {
				return c.cast(0);
			}
			try {
				String value = (String) o;
				NumberFormat formmater = NumberFormat.getInstance();
				formmater.setMaximumFractionDigits(3);
				Number parse = formmater.parse(value);
				return c.cast(parse.longValue());
			} catch (ParseException e) {
				return c.cast(0);
			}
		}

		else if (String.class.getName().equals(name)) {
			if (o == null) {
				return c.cast("");
			}
			try {
				String value = o.toString();
				return c.cast(StringUtils.defaultString(value));
			} catch (Exception e) {
				return c.cast("");
			}
		} else {
			if (o == null)
				return null;
			try {
				System.out.println(o.getClass().getName());
				
				return c.cast(o);
			} catch (Exception e) {
				System.out.println("Cast NULL");
//				e.printStackTrace();
			}
		}

		return null;

	}
}
