package b2k.updatemodule;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransferServerThread extends Thread {
	private Socket socket = null;
	private String store;

	public TransferServerThread(Socket socket, String store) {
		super("B2KServerThread");
		this.socket = socket;
		this.store = store;
	}
	
	Pattern macpt = null;

	private String getMac(String ip) {

	    // Find OS and set command according to OS
	    String OS = System.getProperty("os.name").toLowerCase();

	    String[] cmd;
	    if (OS.contains("win")) {
	        // Windows
	        macpt = Pattern
	                .compile("[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+");
	        String[] a = { "arp", "-a", ip };
	        cmd = a;
	    } else {
	        // Mac OS X, Linux
	        macpt = Pattern
	                .compile("[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+");
	        String[] a = { "arp", ip };
	        cmd = a;
	    }

	    try {
	        // Run command
	        Process p = Runtime.getRuntime().exec(cmd);
	        p.waitFor();
	        // read output with BufferedReader
	        BufferedReader reader = new BufferedReader(new InputStreamReader(
	                p.getInputStream()));
	        String line = reader.readLine();

	        // Loop trough lines
	        while (line != null) {
	            Matcher m = macpt.matcher(line);

	            // when Matcher finds a Line then return it as result
	            if (m.find()) {
	                System.out.println("Found");
	                System.out.println("MAC: " + m.group(0));
	                return m.group(0);
	            }

	            line = reader.readLine();
	        }

	    } catch (IOException e1) {
	        e1.printStackTrace();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    // Return empty string if no MAC is found
	    return "";
	}
	
	private static String getHostName(String ip) throws UnknownHostException{
		InetAddress inetAddress =InetAddress.getByName(ip);//get the host Inet using ip
	    System.out.println ("Host Name: "+ inetAddress.getHostName());//display the host
	    return inetAddress.getHostName();
	}

	public void run() {
		// System.out.println("begin now");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String inputLine, outputLine;

			while (!socket.isClosed() && (inputLine = in.readLine()) != null) {
				// System.out.println("inputLine = "+inputLine);
				String[] params = inputLine.trim().split(" ");
				if (params.length > 0) {
					String method = params[0];

					if (method.equalsIgnoreCase("file_update")) {
						fileListUpdate(socket, params[1]);
					} else if (method.equalsIgnoreCase("check")) {
						String fileName = params[1];
						long longTime = Long.valueOf(params[2]);
						getLastestVersion(socket, longTime, fileName);
					}
				}
			}
			in.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getLastestVersion(Socket socket, long longTime,
			final String fileName) throws IOException {
		final File myFile = new File(store + "/" + fileName);

		final OutputStream os = socket.getOutputStream();
		if (myFile.lastModified() <= longTime) {
			os.flush();
			os.close();
			return;
		}

		transfer(fileName, myFile, os);
	}

	private void transfer(String fileName, File myFile, OutputStream os)
			throws IOException {
		String method = "TRANSFER" + KEY + fileName + KEY
				+ myFile.lastModified();
		byte[] bytes = method.getBytes();

		byte[] mybytearray = new byte[(int) myFile.length() + bytes.length + 2];
		System.arraycopy(String.valueOf(bytes.length).getBytes(), 0,
				mybytearray, 0, 2);
		System.arraycopy(bytes, 0, mybytearray, 2, bytes.length);

		FileInputStream fis = new FileInputStream(myFile);
		BufferedInputStream bis = new BufferedInputStream(fis);
		bis.read(mybytearray, bytes.length + 2, (int) myFile.length());
		// System.out.println("Sending...");

		os.write(mybytearray, 0, mybytearray.length);
		os.flush();
		os.close();
	}

	private final String KEY = "*";

	private String getFileUpdate(File file) throws IOException {
		String file_update = "";
		FileInputStream fstream = new FileInputStream(file);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			if(file_update.length() != 0){
				file_update+=KEY;
			}
			file_update+=strLine;
		}
		// Close the input stream
		in.close();
		return file_update;
	}

	private static final int BIT_MESSAGE = 4;
	
	private void fileListUpdate(Socket socket, String info)
			throws IOException {
		OutputStream os = socket.getOutputStream();

		//info: computerName + serial
		//Kiểm tra xem máy này có được phép lấy gói về ko.
//		if(!validate(info)){
//			String method = "ERROR" + KEY + "" + 001;
//			os.write(method.getBytes(), 0, method.getBytes().length);
//			os.flush();
//			os.close();
//			return;
//		}
		
		
		// Goi bean de lay ve danh sach file can update.
		String fileUpdate = getFileUpdate(new File(store+"/file_update"));
		
		// Tao du lieu gia de chay.
//		String fileUpdate = "ahelp.jar" + KEY + "yHospitalEE.jar" + KEY
//				+ "ahospInterface.jar" + KEY + "bException.jar" + KEY
//				+ "iLabLicense.jar" + KEY + "yHospInterface.jar";

		//Dữ liệu gói tin gởi
		String method = "FILE_UPDATE" + KEY + "" + fileUpdate;
//		System.out.println(method);
		
		//Mảng byte gói tin cần gửi
		byte[] bytes = method.getBytes();

		//Tạo mảng byte gửi đi
		byte[] mybytearray = new byte[(int) bytes.length + BIT_MESSAGE];
		
		/*	
		 * Gói tin gởi đi được chia làm 2 phần: kích thước gói tin và thông tin về gói tin gửi
		 *	4 byte đầu cho biết kích thước cả gói tin
		*/
		
//		System.out.println("----> " + String.valueOf(bytes.length).getBytes());
//		
//		System.out.println("bytes.length: " + bytes.length);
//		System.out.println(mybytearray.length);
//		System.out.println("hello");
		
		byte[] bytes_mess = String.valueOf(bytes.length).getBytes();

		//Đưa kích thước gói tin.
		System.arraycopy(bytes_mess, 0, mybytearray, 0, bytes_mess.length);

		//Đưa thông tin gói tin vào.
		System.arraycopy(bytes, 0, mybytearray, BIT_MESSAGE, bytes.length);

		os.write(mybytearray, 0, mybytearray.length);
		os.flush();
		os.close();

	}

	private boolean validate(String info) {
		// TODO Auto-generated method stub
		return false;
	}

}