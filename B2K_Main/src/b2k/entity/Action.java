package b2k.entity;

import b2k.generic.objects.B2K;
import b2k.generic.objects.Entity;

public class Action extends Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@B2K(index=true)
	public String name = "";
	public String className = "";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
