package b2k.build;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.SplashScreen;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;

public class Update{

	public static String path;
	public static final String PLAF_BERNSTEIN = "com.btc.plaf.bernstein.BernsteinLookAndFeel";

	private static Socket echoSocket;
	private static int locationX = 60;
	private static int locationY = 280;

	Pattern macpt = null;
	
	
	public static void main(String[] args) throws IOException {
		String ip = "192.168.1.103";
//		String ip = "localhost";
		// String ip = "dtad.no-ip.org";
		int port = 8642;

		if (args != null) {
			int length = args.length;
			if (length > 1) {
				ip = args[0];
				port = Integer.valueOf(args[1]);
				if (length > 3) {
					locationX = Integer.valueOf(args[2]);
					locationY = Integer.valueOf(args[3]);
				}
			}
		}

		System.out.println("ip: " + ip);
		System.out.println("port: " + port);

		path = Update.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath();
		if (path.endsWith(".jar"))
			path = path.substring(0, path.lastIndexOf("/")) + "/";

		new Update().connection(ip, port);

	}

	private void connection(final String ip, final int port) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {

					final SplashScreen splash = SplashScreen.getSplashScreen();

					// splash.setImageURL(new
					// URL("file:/F:/Share/Khang_PC2011/Workspaces/MainProject/images/IMG_2563.JPG"));

					if (splash == null) {
						System.out
								.println("SplashScreen.getSplashScreen() returned null");
						return;
					}

					Graphics2D g = splash.createGraphics();

					if (g == null) {
						System.out.println("g is null");
						return;
					}

					List<String> fileNames = getFileListUpdate(ip, port,
							InetAddress.getLocalHost().getHostAddress());

					// String[] fileNames = { "ahelp.jar", "yHospitalEE.jar",
					// "ahospInterface.jar", "bException.jar",
					// "iLabLicense.jar", "yHospInterface.jar" };

					int size = fileNames.size();
//					System.out.println("size: " + size);
					for (int i = 0; i < size; i++) {
						String fileName = fileNames.get(i);
//						System.out.println("fileName: " + fileName);
						renderSplashFrame(g, fileName, splash.getBounds());
						splash.update();
						if (!checkVersion(fileName, ip, port)) {
							break;
						}
					}

					//

					splash.close();

				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
		});

	}

	private final static String KEY = "[*]";
	private static RandomAccessFile fileRandomAccessFile;

	protected static List<String> getFileListUpdate(String ip, int port,
			String company) throws IOException {
		List<String> fileNames = new ArrayList<String>();
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			echoSocket = new Socket(ip, port);
			if (!echoSocket.isConnected())
				return fileNames;

			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host:" + ip + ".");
			return fileNames;
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: "
					+ ip + ".");
			return fileNames;
		}

		out.println("file_update " + company);

		byte[] buf = new byte[4];
		InputStream is = echoSocket.getInputStream();
		is.read(buf, 0, buf.length);

//		System.out.println("buf: " + new String(buf));
		try {
			Integer valueOf = Integer.valueOf(new String(buf).trim());
			buf = new byte[valueOf];

			is.read(buf, 0, buf.length);
			String readLine = new String(buf);
//			System.out.println("readline: " + readLine);
			//
			String[] params = readLine.split(KEY);
//			System.out.println("params: " + params.length);
			if (params.length > 0) {
				String method = params[0];
//				System.out.println("method: " + method);
				if (method.equalsIgnoreCase("FILE_UPDATE")) {
					for (int i = 1; i < params.length; i++) {
						fileNames.add(params[i]);
					}
				}
			}

		} catch (NumberFormatException e) {
		}
		out.close();
		in.close();
		echoSocket.close();
		return fileNames;
	}

	static void renderSplashFrame(Graphics2D g, String file, Rectangle rectangle) {
		g.setComposite(AlphaComposite.Clear);
		g.fillRect(0, 0, rectangle.width, rectangle.height);
		g.setPaintMode();
		g.setColor(Color.red);
		g.setFont(new Font("tahoma", Font.BOLD | Font.ITALIC, 20));
		String text = "Loading: " + file;
		g.drawString(text, locationX, locationY);
	}

	public static boolean checkVersion(String fileName, String ip, int port)
			throws IOException {
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		System.out.println("____________________________________");
		try {
			echoSocket = new Socket(ip, port);
			System.out.println("echoSocket: "  + echoSocket);
			if (!echoSocket.isConnected())
				return false;

			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host:" + ip + ".");
			return false;
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: "
					+ ip + ".");
			return false;
		}
		
		 long longTime = 0;
		 File file = new File("./lib/" + fileName);
		 if (file.isFile()) {
//			 	longTime = file.lastModified();
				fileRandomAccessFile = new RandomAccessFile(file.getPath(),
						"rw");
				FileChannel fileChannel = fileRandomAccessFile.getChannel();
				FileLock fileLock = fileChannel.tryLock();
				if (fileLock != null) {
					System.out.println("File is locked");

					try {
						fileChannel.truncate(0);
					} catch (Exception e) {// Catch exception if any
						System.err.println("Error: " + e.getMessage());
					}
				}
				fileRandomAccessFile.close();
				file.setWritable(true);
			}

		  System.out.println(fileName + " " + longTime);

		long time = 0;
		out.println("check " + fileName + " " + longTime);
		InputStream is = echoSocket.getInputStream();
		System.out.println("is: " + is.available());
		byte[] buf = new byte[2];
		is.read(buf, 0, buf.length);
		String string = new String(buf);
		if(string.trim().length() > 0){

			try {
				buf = new byte[Integer.parseInt(string)];
				System.out.println("buf: " + buf);
				is.read(buf, 0, buf.length);
				String readLine = new String(buf);
				System.out.println("readline: " + readLine);
				String[] params = readLine.split(KEY);
				if (params.length > 0) {
					String method = params[0];
					if (method.equalsIgnoreCase("TRANSFER")) {
						fileName = params[1];
						time = Long.valueOf(params[2].trim());
					} else if (method.equalsIgnoreCase("COMPLETE")) {
						fileName = null;
						time = 0;
					}
				}
	
				// Sẽ viết tiếp phần kiểm tra file có được ghi hay ko sau.
				FileOutputStream fos = new FileOutputStream("./lib/" + fileName);
	
				stream(is, fos);
	//			System.out.println(new Timestamp(file.lastModified()));
				file.setLastModified(time);
	//			System.out.println(new Timestamp(file.lastModified()) + " - time: "
	//					+ new Timestamp(time));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		out.close();
		in.close();
		echoSocket.close();
		return true;
	}

	public static void stream(InputStream in, OutputStream out)
			throws IOException {
		byte[] buf = new byte[1024];
		int bytesRead = 0;

		try {
			while (-1 != (bytesRead = in.read(buf, 0, buf.length))) {
				out.write(buf, 0, bytesRead);
			}
//			System.out.println("complete");
		} catch (IOException e) {
			throw (e);
		} finally {
			try {
				in.close();
				out.flush();
				out.close();
			} catch (Exception e) {
			}
		}
	}
}
