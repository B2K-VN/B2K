package b2k.updatemodule;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	
	private static BundleContext context;


	 public static void main (String[] args) {
	 }
	 
	
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		String dir = System.getenv("JBOSS_HOME");
		TransferServerSocket instance = TransferServerSocket.getInstance();
		instance.start(8642, dir + "\\lib_client" );
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		TransferServerSocket instance = TransferServerSocket.getInstance();
		instance.stop(8642);
	}

}
