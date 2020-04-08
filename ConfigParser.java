
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;

public class ConfigParser {

  

   public static Map<String,String> CollectPluggins(String filename) {
	 Map<String, String> m = new HashMap<String, String>();

	  try {	
        	File inputFile = new File(filename);
		DocumentBuilderFactory dbFactory 
            	= DocumentBuilderFactory.newInstance();
         	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         	Document doc = dBuilder.parse(inputFile);
         	doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("plugin");
         
         	for (int temp = 0; temp < nList.getLength(); temp++) {
            		Node nNode = nList.item(temp);
            
            		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               			Element eElement = (Element) nNode;
				String oper = eElement.getAttribute("operation");
				String handler = eElement.getAttribute("handler");
				m.put(oper,handler);
                        }
         	}

		return m;
		
		
	  }
         catch (Exception e) {
          return null;
      	 }
	

   }

   public static void main(String [] args ) {

      if ( args.length == 0 )
      {

	System.out.println("Invalid command line arguments");
	return;

      }

      Map<String,String> res = ConfigParser.CollectPluggins(args[0]);

      for (Map.Entry pair: res.entrySet()) {
         System.out.println(pair.getKey() + " = " + pair.getValue());
      }


   }

   
}