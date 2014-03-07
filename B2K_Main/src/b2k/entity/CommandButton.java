package b2k.entity;

import b2k.generic.objects.Entity;

public class CommandButton extends Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 352442871981020510L;
	
	public String name = "";
	public String hotKey = "";
	public String image = "";
	public long ribbonId = 0;
	public String priority = "TOP";
	public String action = "";
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public long getRibbonId() {
		return ribbonId;
	}
	public void setRibbonId(long ribbonId) {
		this.ribbonId = ribbonId;
	}
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
