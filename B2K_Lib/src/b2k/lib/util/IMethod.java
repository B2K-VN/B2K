package b2k.lib.util;

import java.lang.reflect.Method;

public class IMethod {
	private Object clazz;
	public Object getClazz() {
		return clazz;
	}

	public void setClazz(Object clazz) {
		this.clazz = clazz;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	private Method method;

	public IMethod(Object clazz, Method method) {
		super();
		this.clazz = clazz;
		this.method = method;
	}

}
