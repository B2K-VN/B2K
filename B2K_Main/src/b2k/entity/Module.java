package b2k.entity;

import b2k.generic.objects.Entity;

public class Module extends Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 352442871981020510L;
	public String name = "";
	public String hotKey = "";
	public String image = "";
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHotKey() {
		return hotKey;
	}
	public void setHotKey(String hotKey) {
		this.hotKey = hotKey;
	}
	
}
