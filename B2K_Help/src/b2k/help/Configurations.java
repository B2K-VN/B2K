package b2k.help;



import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Configurations {
	private Document doc;
	private NodeList mainBody;
	private Node     mainNode;
	
	public Configurations() {
		String path = MainData.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		if (path.endsWith(".jar")) 
			path = path.substring(0, path.lastIndexOf("/")) + "/";
		path += "config.xml";
		
		try {
	        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder;
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(new File(path));
			mainBody = doc.getElementsByTagName("config");
			if (mainBody.getLength() > 0){
				mainNode = mainBody.item(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getServerName(){
		return getStringNode("server");
	}
	
	public String getPort(){
		return getStringNode("port");
	}
	
	public String getServerPac(){
		return getStringNode("serverpac");
	}
	public String getPortPac(){
		return getStringNode("portpac");
	}
	
	public String getServerPacName(){
		return getStringNode("serverPacName");
	}
	
	public String getLocalPortPac(){
		return getStringNode("localPortPac");
	}
	
	private String getStringNode(String nodeName){
	    try {
            Element content = (Element)mainNode;
            NodeList contentList = content.getElementsByTagName(nodeName);
            Element firstContent = (Element)contentList.item(0);
            if (firstContent != null){
	            NodeList textFNList = firstContent.getChildNodes();
	            Node textNode = textFNList.item(0);
	            return textNode.getNodeValue();
            }
        }catch (Throwable t) {
        	t.printStackTrace ();
        }
		return "";
    }

}
