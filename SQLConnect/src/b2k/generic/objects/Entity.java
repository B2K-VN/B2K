package b2k.generic.objects;

import java.io.Serializable;
import java.sql.Timestamp;


public abstract class Entity implements Serializable, ABS {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public long id = 0;
	public int status = 0;
	public Timestamp created = null;
	public Timestamp modified = null;
	public boolean deleted = false;
	public String createBy = null;
	public String modifiedBy = null;

	public Entity() {
		super();
	}

	public Entity( long id, int status, Timestamp created,
			Timestamp modified, boolean deleted, String createBy,
			String modifiedBy) {
		super();
		this.id = id;
		this.status = status;
		this.created = created;
		this.modified = modified;
		this.deleted = deleted;
		this.createBy = createBy;
		this.modifiedBy = modifiedBy;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
