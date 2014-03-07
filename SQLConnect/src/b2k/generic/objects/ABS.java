package b2k.generic.objects;

import java.sql.Timestamp;

public interface ABS {

	public long getId();

	public void setId(long id);

	public int getStatus();

	public void setStatus(int status);

	public Timestamp getCreated();

	public void setCreated(Timestamp time);

	public Timestamp getModified();

	public void setModified(Timestamp time);

	public boolean isDeleted();

	public void setDeleted(boolean deleted);

	public String getCreateBy();

	public void setCreateBy(String str);

	public String getModifiedBy();

	public void setModifiedBy(String str);
}
