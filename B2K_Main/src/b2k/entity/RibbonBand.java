package b2k.entity;

import b2k.generic.objects.Entity;

public class RibbonBand extends Entity {
	public String name = "";
	public String hotKey = "";
	public long moduleId = 0;
	public String image = "";
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getModuleId() {
		return moduleId;
	}
	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
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
