package b2k.updatemodule;

import java.io.IOException;


public interface TransferServerInterface {
	
	public String ERROR = "ERROR";
	public String FILE_UPDATE = "FILE_UPDATE";
	public String CHECK_VERSION = "CHECK_VERSION";
	public String CHECK_LICENSE = "CHECK_LICENSE";
	
	public void start(int port, String store) throws IOException;
	public void stop(int port)  throws IOException;
}
