package b2k.help;


public class MethodObject {
	private String methodName = "";
	@SuppressWarnings("rawtypes")
	private Class[] classes;
	
	@SuppressWarnings("rawtypes")
	public MethodObject(String methodName, Class... classes) {
		super();
		this.methodName = methodName;
		this.classes = classes;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	@SuppressWarnings("rawtypes")
	public Class[] getClasses() {
		return classes;
	}
	@SuppressWarnings("rawtypes")
	public void setClasses(Class[] classes) {
		this.classes = classes;
	}
}
