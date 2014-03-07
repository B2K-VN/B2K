package b2k.datatest;

import java.util.HashMap;

public class CurrentData {
	private static HashMap<Object, Object> hashMap = new HashMap<Object, Object>();

	public static Object get(Object o) {
		return hashMap.get(o);
	}

	public static void set(Object k, Object o) {
		if (k == null)
			return;
		if (o == null)
			return;
		hashMap.put(k, o);
	}

}
