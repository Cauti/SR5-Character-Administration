
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


// Creats a XMLFile with DOM-Parser
// source: https://www.tutorialspoint.com/java_xml/java_dom_create_document.htm
// source: https://www.tutorialspoint.com/java_xml/java_dom_modify_document.htm
public class XMLFileModifier{
	
	private static int id = 0;
	
	public static boolean create(String[] values){
		try {
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.newDocument();
	         // root element
	         
	         Element rootElement = doc.createElement("characters");
	         doc.appendChild(rootElement);

	         //  supercars element
	         Element chara = doc.createElement("chara");
	         rootElement.appendChild(chara);

	         // setting attribute to element
	         Attr attr = doc.createAttribute("id");
	         attr.setValue(""+ ++id);
	         chara.setAttributeNode(attr);

	         // Werte eintragen
	         Element kon = doc.createElement("kon");
	         kon.appendChild(doc.createTextNode("" + values[0]));
	         chara.appendChild(kon);
	         Element ges = doc.createElement("ges");
	         ges.appendChild(doc.createTextNode("" +  values[1]));
	         chara.appendChild(ges);
	         Element rea = doc.createElement("rea");
	         rea.appendChild(doc.createTextNode("" +  values[2]));
	         chara.appendChild(rea);
	         Element sta = doc.createElement("sta");
	         sta.appendChild(doc.createTextNode("" +  values[3]));
	         chara.appendChild(sta);
	         Element wil = doc.createElement("wil");
	         wil.appendChild(doc.createTextNode("" +  values[4]));
	         chara.appendChild(wil);
	         Element log = doc.createElement("log");
	         log.appendChild(doc.createTextNode("" +  values[5]));
	         chara.appendChild(log);
	         Element intu = doc.createElement("int");
	         intu.appendChild(doc.createTextNode("" +  values[6]));
	         chara.appendChild(intu);
	         Element cha = doc.createElement("cha");
	         cha.appendChild(doc.createTextNode("" +  values[7]));
	         chara.appendChild(cha);
	         Element edg = doc.createElement("edg");
	         edg.appendChild(doc.createTextNode("" +  values[8]));
	         chara.appendChild(edg);
	         Element ess = doc.createElement("ess");
	         ess.appendChild(doc.createTextNode("" +  values[9]));
	         chara.appendChild(ess);
	         Element mag = doc.createElement("mag");
	         mag.appendChild(doc.createTextNode("" +  values[10]));
	         chara.appendChild(mag);
	         Element ini = doc.createElement("ini");
	         ini.appendChild(doc.createTextNode("" +  values[11]));
	         chara.appendChild(ini);
	         Element ina = doc.createElement("ina");
	         ina.appendChild(doc.createTextNode("" +  values[12]));
	         chara.appendChild(ina);
	         Element inks = doc.createElement("inks");
	         inks.appendChild(doc.createTextNode("" +  values[13]));
	         chara.appendChild(inks);
	         Element inhs = doc.createElement("inhs");
	         inhs.appendChild(doc.createTextNode("" +  values[14]));
	         chara.appendChild(inhs);
	         Element klim = doc.createElement("kzm");
	         klim.appendChild(doc.createTextNode("" +  values[15]));
	         chara.appendChild(klim);
	         Element glim = doc.createElement("gzm");
	         glim.appendChild(doc.createTextNode("" +  values[16]));
	         chara.appendChild(glim);
	         Element name = doc.createElement("name");
	         name.appendChild(doc.createTextNode("" +  values[17]));
	         chara.appendChild(name);
	         Element meta = doc.createElement("meta");
	         meta.appendChild(doc.createTextNode("" +  values[18]));
	         chara.appendChild(meta);

	         // write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File("src/test.xml"));
	         transformer.transform(source, result);
	         // Output to console for testing
	         StreamResult consoleResult = new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
	         return true;
	      } catch (Exception e) {
	         e.printStackTrace();
	         return false;
	      }	
	}
	
	public static boolean append(ArrayList<Chara> charas){
//		Document dom;
//	    Element e = null;
//		try {
//			String path = IAmTheFrame.getPath();
//			File inputFile;
//			if (path != null) {
//				inputFile = new File(IAmTheFrame.getPath());
//			} else {
//				inputFile = new File("C:\\Desktop\\dummy.xml");
//			}
//		    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//		    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//		    dom = docBuilder.parse(inputFile);
//		      
//	    	//optional, but recommended
//	    	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
//	    	dom.getDocumentElement().normalize();
//
//	    	System.out.println("Root element :" + dom.getDocumentElement().getNodeName());
//
//	    	NodeList nList = dom.getElementsByTagName("chara");
//	    	
//
//	    	System.out.println("----------------------------");
//	    	
//	    	for (int temp = 0; temp < nList.getLength(); temp++) {
//
//	    		Node nNode = nList.item(temp);
//	    		
//
//	    		System.out.println("\nCurrent Element :" + nNode.getNodeName());
//
//	    		Element rootEle = (Element) nNode;
//	            System.out.println("id : " + rootEle.getAttribute("id"));
//	            id = Integer.parseInt(rootEle.getAttribute("id"));
//	    	}		
		
		try {
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document dom = dBuilder.newDocument();
	         // root element
	         
	         Element rootElement = dom.createElement("characters");
	         dom.appendChild(rootElement);

	         
	    	
//	    	Node characters = dom.getFirstChild();
//	    	Node charasa = dom.getElementsByTagName("chara").item(nList.getLength()-1);
	    	//Element rootElement = doc.createElement("chara");
	    	//Element chara = (Element) nList.item(nList.getLength()-1);
	    	//characters.appendChild(chara);
	    	
	    	for (int i = 0; i < charas.size(); ++i){
	    	//  supercars element
		         Element chara = dom.createElement("chara");
		         rootElement.appendChild(chara);

		         // setting attribute to element
		         Attr attr = dom.createAttribute("id");
		         attr.setValue(""+ ++id);
		         chara.setAttributeNode(attr);
		         
	        	Chara tmpChara = charas.get(i);
	        	System.out.println(tmpChara.toString());
        	
	        	 // Werte eintragen
		         Element kon = dom.createElement("kon");
		         kon.appendChild(dom.createTextNode("" + tmpChara.getKON()));
		         chara.appendChild(kon);
		         Element ges = dom.createElement("ges");
		         
		         ges.appendChild(dom.createTextNode("" +  tmpChara.getGES()));
		         chara.appendChild(ges);
		         Element rea = dom.createElement("rea");
		         
		         rea.appendChild(dom.createTextNode("" + tmpChara.getREA()));
		         chara.appendChild(rea);
		         Element sta = dom.createElement("sta");
		         
		         sta.appendChild(dom.createTextNode("" + tmpChara.getSTA()));
		         chara.appendChild(sta);
		         Element wil = dom.createElement("wil");
		         
		         wil.appendChild(dom.createTextNode("" + tmpChara.getWIL()));
		         chara.appendChild(wil);
		         Element log = dom.createElement("log");
		         
		         log.appendChild(dom.createTextNode("" + tmpChara.getLOG()));
		         chara.appendChild(log);
		         Element intu = dom.createElement("int");
		         
		         intu.appendChild(dom.createTextNode("" + tmpChara.getINT()));
		         chara.appendChild(intu);
		         Element cha = dom.createElement("cha");
		         
		         cha.appendChild(dom.createTextNode("" + tmpChara.getCHA()));
		         chara.appendChild(cha);
		         Element edg = dom.createElement("edg");
		         
		         edg.appendChild(dom.createTextNode("" + tmpChara.getEDG()));
		         chara.appendChild(edg);
		         Element ess = dom.createElement("ess");
		         
		         ess.appendChild(dom.createTextNode("" + tmpChara.getESS()));
		         chara.appendChild(ess);
		         Element mag = dom.createElement("mag");
		         
		         mag.appendChild(dom.createTextNode("" + tmpChara.getMAG()));
		         chara.appendChild(mag);
		         Element ini = dom.createElement("ini");
		         
		         ini.appendChild(dom.createTextNode(tmpChara.getINI().equals("") ? " " : tmpChara.getINI()));
		         chara.appendChild(ini);
		         Element ina = dom.createElement("ina");
		         
		         ina.appendChild(dom.createTextNode(tmpChara.getINA().equals("") ? " " : tmpChara.getINA()));
		         chara.appendChild(ina);
		         Element inks = dom.createElement("inks");
		         
		         inks.appendChild(dom.createTextNode(tmpChara.getINKS().equals("") ? " " : tmpChara.getINKS()));
		         chara.appendChild(inks);
		         Element inhs = dom.createElement("inhs");
		         
		         inhs.appendChild(dom.createTextNode(tmpChara.getINHS().equals("") ? " " : tmpChara.getINHS()));
		         chara.appendChild(inhs);
		         Element klim = dom.createElement("kzm");
		         
		         klim.appendChild(dom.createTextNode("" + tmpChara.getKZM()));
		         chara.appendChild(klim);
		         		         
		         Element glim = dom.createElement("gzm");
		         glim.appendChild(dom.createTextNode("" + tmpChara.getGZM()));
		         chara.appendChild(glim);
		         
		         Element panz = dom.createElement("panz");
		         panz.appendChild(dom.createTextNode("" + tmpChara.getPANZ()));
		         chara.appendChild(panz);
		         
		         Element name = dom.createElement("name");
		         name.appendChild(dom.createTextNode(tmpChara.getName().equals("") ? " " : tmpChara.getName()));
		         chara.appendChild(name);
		         
		         Element meta = dom.createElement("meta");
		         meta.appendChild(dom.createTextNode(tmpChara.getMeta().equals("") ? " " : tmpChara.getMeta()));
		         chara.appendChild(meta);
	        
	        }
	         // write the content into xml file
//	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
//	         Transformer transformer = transformerFactory.newTransformer();
//	         DOMSource source = new DOMSource(dom);
	         String path = IAmTheFrame.getPath();
			 //File file;
			 if (path != null) {
					//file = new File(IAmTheFrame.getPath() + InitiativePanel.getTimeforPath() + ".xml");
				 path = path.substring(0, path.lastIndexOf("\\")+1) + "CharaDB " + InitiativePanel.getTimeforPath() + ".xml";
				 System.out.println(path);
			 } else {
					//file = new File("C:\\Desktop\\dummy.xml");
				 path = "C:\\Desktop\\dummy.xml";
			 }
			 
			 try {
		            Transformer tr = TransformerFactory.newInstance().newTransformer();
		            tr.setOutputProperty(OutputKeys.INDENT, "yes");
		            tr.setOutputProperty(OutputKeys.METHOD, "xml");
		            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		            //tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
		            //tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		            // send DOM to file
		            tr.transform(new DOMSource(dom), 
		                                 new StreamResult(new FileOutputStream(path)));
		        } catch (TransformerException te) {
		            System.out.println(te.getMessage());
		        } catch (IOException ioe) {
		            System.out.println(ioe.getMessage());
		        }
		    } catch (ParserConfigurationException pce) {
		        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
		    }
			 
//	         StreamResult result = new StreamResult(file);
//	         transformer.transform(source, result);
//	         // Output to console for testing
//	         StreamResult consoleResult = new StreamResult(System.out);
//	         transformer.transform(source, consoleResult);
	    	
	    	return true;
//		} catch (Exception ex) {
//	         ex.printStackTrace();
//	         return false;
//	    }
				
	}
	
	
	/*
	public static boolean modify(String[] values){
		try {
		      File inputFile = new File("src/test.xml"); 	    	
		      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		      Document doc = docBuilder.parse(inputFile);
		      Node charas = doc.getFirstChild();
		      Node charvalues = doc.getElementsByTagName("chara").item(0);
		      // update supercar attribute
		      NamedNodeMap attr = charvalues.getAttributes();
		      Node nodeAttr = attr.getNamedItem("kon");
		      nodeAttr.setTextContent("42");

		      // loop the supercar child node
		      NodeList list = supercar.getChildNodes();
		      for (int temp = 0; temp < list.getLength(); temp++) {
		         Node node = list.item(temp);
		         if (node.getNodeType() == Node.ELEMENT_NODE) {
		            Element eElement = (Element) node;
		            if ("carname".equals(eElement.getNodeName())){
		               if("Ferrari 101".equals(eElement.getTextContent())){
		                  eElement.setTextContent("Lamborigini 001");
		               }
		            if("Ferrari 202".equals(eElement.getTextContent()))
		               eElement.setTextContent("Lamborigini 002");
		            }
		         }
		      }
		      NodeList childNodes = cars.getChildNodes();
		      for(int count = 0; count < childNodes.getLength(); count++){
		         Node node = childNodes.item(count);
		         if("luxurycars".equals(node.getNodeName()))
		            cars.removeChild(node);
		         }
		         // write the content on console
		         TransformerFactory transformerFactory = 
		         TransformerFactory.newInstance();
		         Transformer transformer = transformerFactory.newTransformer();
		         DOMSource source = new DOMSource(doc);
		         System.out.println("-----------Modified File-----------");
		         StreamResult consoleResult = new StreamResult(System.out);
		         transformer.transform(source, consoleResult);
		      } catch (Exception e) {
		         e.printStackTrace();
		      } 
		   }
		
	} */
}
