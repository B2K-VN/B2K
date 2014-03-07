package b2k.lib.util;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SystemConfig {
	private static SystemConfig configSystem;
	public Document doc;

	public static String getPath(String file_name) {
		String path = SystemConfig.class.getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		if (path.endsWith(".jar"))
			path = path.substring(0, path.lastIndexOf("/")) + "/";
		path += file_name;
		return path;
	}

	public SystemConfig() {
		String path = SystemConfig.class.getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		if (path.endsWith(".jar"))
			path = path.substring(0, path.lastIndexOf("/")) + "/";
		path += "config.xml";
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getString(String type, String tag) {
		if (configSystem == null) {
			configSystem = new SystemConfig();
		}
		Node node = null;
		NodeList nodeList = configSystem.doc.getElementsByTagName(type);
		if (nodeList.getLength() > 0) {
			node = nodeList.item(0);
		}
		if (node == null)
			return "";

		try {
			Element content = (Element) node;
			NodeList contentList = content.getElementsByTagName(tag);
			Element firstContent = (Element) contentList.item(0);
			if (firstContent != null) {
				NodeList textFNList = firstContent.getChildNodes();
				Node textNode = textFNList.item(0);
				return textNode.getNodeValue();
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return "";
	}

	public static String getAttribute(String type, String tag, String attr) {
		if (configSystem == null) {
			configSystem = new SystemConfig();
		}
		Node node = null;
		NodeList nodeList = configSystem.doc.getElementsByTagName(type);
		if (nodeList.getLength() > 0) {
			node = nodeList.item(0);
		}

		if (node == null)
			return "";

		try {
			Element content = (Element) node;
			NodeList contentList = content.getElementsByTagName(tag);
			Element firstContent = (Element) contentList.item(0);
			if (firstContent != null) {
				String attribute = firstContent.getAttribute(attr);
				return attribute == null ? "" : attribute;
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return "";
	}

	public static String getAttribute(String type, String attr) {
		if (configSystem == null) {
			configSystem = new SystemConfig();
		}
		Node node = null;
		NodeList nodeList = configSystem.doc.getElementsByTagName(type);
		if (nodeList.getLength() > 0) {
			node = nodeList.item(0);
		}

		if (node == null)
			return "";

		Element content = (Element) node;
		String attribute = content.getAttribute(attr);
		return attribute == null ? "" : attribute; 
	}


	
	public static void main(String[] args) {
		System.out.println(getString("THONGTIN", "MST"));
	}

}
