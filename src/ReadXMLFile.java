import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

// Reads a XML-File with DOM-Parser
// source: https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
public class ReadXMLFile {

  /*
  public static void main(String argv[]) {

    try {
      File fXmlFile = new File("src/charatest.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(fXmlFile);

      //optional, but recommended
      //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
      doc.getDocumentElement().normalize();

      System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

      NodeList nList = doc.getElementsByTagName("chara");

      System.out.println("----------------------------");

      for (int temp = 0; temp < nList.getLength(); temp++) {

        Node nNode = nList.item(temp);

        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

          Element eElement = (Element) nNode;

          System.out.println("Chara id : " + eElement.getAttribute("id"));
          System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
          System.out.println("KON : " + eElement.getElementsByTagName("kon").item(0).getTextContent());
          System.out.println("GES : " + eElement.getElementsByTagName("ges").item(0).getTextContent());
          System.out.println("REA : " + eElement.getElementsByTagName("rea").item(0).getTextContent());
          System.out.println("STA : " + eElement.getElementsByTagName("sta").item(0).getTextContent());
          System.out.println("WIL : " + eElement.getElementsByTagName("wil").item(0).getTextContent());
          System.out.println("LOG : " + eElement.getElementsByTagName("log").item(0).getTextContent());
          System.out.println("INT : " + eElement.getElementsByTagName("int").item(0).getTextContent());
          System.out.println("CHA : " + eElement.getElementsByTagName("cha").item(0).getTextContent());
          System.out.println("EDG : " + eElement.getElementsByTagName("edg").item(0).getTextContent());
          System.out.println("ESS : " + eElement.getElementsByTagName("ess").item(0).getTextContent());
          System.out.println("MAG : " + eElement.getElementsByTagName("mag").item(0).getTextContent());
          System.out.println("INI : " + eElement.getElementsByTagName("ini").item(0).getTextContent());
          System.out.println("INKS : " + eElement.getElementsByTagName("inks").item(0).getTextContent());
          System.out.println("INHS : " + eElement.getElementsByTagName("inhs").item(0).getTextContent());

        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  } */
	
	private static int id = 0;
  
  // Liest die XML-Daten aus der Datei mit dem �bergebenen Pfad path.
  public static Chara[] read(String path){
    try {
        File fXmlFile = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        //optional, but recommended
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("chara");

        //System.out.println("----------------------------");
        Chara[] charas = new Chara[nList.getLength()];

        for (int temp = 0; temp < nList.getLength(); temp++) {

          Node nNode = nList.item(temp);

          //System.out.println("\nCurrent Element :" + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode;

            
            System.out.println("Chara id : " + eElement.getAttribute("id"));
            int kon = Integer.parseInt(eElement.getElementsByTagName("kon").item(0).getTextContent());
            int ges = Integer.parseInt(eElement.getElementsByTagName("ges").item(0).getTextContent());
            int rea = Integer.parseInt(eElement.getElementsByTagName("rea").item(0).getTextContent());
            int sta = Integer.parseInt(eElement.getElementsByTagName("sta").item(0).getTextContent());
            int wil = Integer.parseInt(eElement.getElementsByTagName("wil").item(0).getTextContent());
            int log = Integer.parseInt(eElement.getElementsByTagName("log").item(0).getTextContent());
            int intu = Integer.parseInt(eElement.getElementsByTagName("int").item(0).getTextContent());
            int cha = Integer.parseInt(eElement.getElementsByTagName("cha").item(0).getTextContent());
            int edg = Integer.parseInt(eElement.getElementsByTagName("edg").item(0).getTextContent());
            double ess = Double.parseDouble(eElement.getElementsByTagName("ess").item(0).getTextContent());
            int mag = Integer.parseInt(eElement.getElementsByTagName("mag").item(0).getTextContent());
            String ini = eElement.getElementsByTagName("ini").item(0).getTextContent();
            String ina = eElement.getElementsByTagName("ina").item(0).getTextContent();
            String inks = eElement.getElementsByTagName("inks").item(0).getTextContent();
            String inhs = eElement.getElementsByTagName("inhs").item(0).getTextContent();
            int kzm = Integer.parseInt(eElement.getElementsByTagName("kzm").item(0).getTextContent());
            int gzm = Integer.parseInt(eElement.getElementsByTagName("gzm").item(0).getTextContent());
            int panz = Integer.parseInt(eElement.getElementsByTagName("panz").item(0).getTextContent());
            String name = eElement.getElementsByTagName("name").item(0).getTextContent();
            String meta = eElement.getElementsByTagName("meta").item(0).getTextContent();
          
            charas[temp] = new Chara(kon, ges, rea, sta, wil, log, intu, cha, edg, ess, mag, ini, ina, inks, inhs, kzm, gzm, panz, name, meta);
          }
        }
        return charas;
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
  }
  
  public static void saveToXML(ArrayList<Chara> charas) {
	    Document dom;
	    Element e = null;

	    // instance of a DocumentBuilderFactory
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    
	    try {
	        // use factory to get an instance of document builder
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        // create instance of DOM
	        dom = db.newDocument();

	        for (int i = 0; i < charas.size(); ++i){
	        	Chara tmpChara = charas.get(i);
	        	System.out.println(tmpChara.toString());
	        	// create the root element
	        	Element rootEle = dom.createElement("chara");

	        	//	        e = dom.createElement("id");
	        	//	        e.appendChild(dom.createTextNode("" + ++id));
	        	//	        rootEle.appendChild(e);

	        	//  supercars element
	        	//Element chara = dom.createElement("chara");
	        	//rootEle.appendChild(chara);

	        	// setting attribute to element
	        	Attr attr = dom.createAttribute("id");
	        	attr.setValue(""+ ++id);
	        	rootEle.setAttributeNode(attr);

	        	// create data elements and place them under root
	        	e = dom.createElement("kon");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getKON()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("ges");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getGES()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("rea");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getREA()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("sta");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getSTA()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("wil");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getWIL()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("log");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getLOG()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("int");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getINT()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("cha");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getCHA()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("edg");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getEDG()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("ess");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getESS()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("mag");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getMAG()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("ini");
	        	e.appendChild(dom.createTextNode(tmpChara.getINI()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("ina");
	        	e.appendChild(dom.createTextNode(tmpChara.getINA()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("inks");
	        	e.appendChild(dom.createTextNode(tmpChara.getINKS()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("inhs");
	        	e.appendChild(dom.createTextNode(tmpChara.getINHS()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("kzm");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getKZM()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("gzm");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getGZM()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("panz");
	        	e.appendChild(dom.createTextNode("" + tmpChara.getPANZ()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("name");
	        	e.appendChild(dom.createTextNode(tmpChara.getName()));
	        	rootEle.appendChild(e);

	        	e = dom.createElement("meta");
	        	e.appendChild(dom.createTextNode(tmpChara.getMeta()));
	        	rootEle.appendChild(e);

	        	dom.appendChild(rootEle);
	        
	        }

	        try {
	            Transformer tr = TransformerFactory.newInstance().newTransformer();
	            tr.setOutputProperty(OutputKeys.INDENT, "yes");
	            tr.setOutputProperty(OutputKeys.METHOD, "xml");
	            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
	            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	            // send DOM to file
	            tr.transform(new DOMSource(dom), 
	                                 new StreamResult(new FileOutputStream(IAmTheFrame.getPath() + "Test")));
	        } catch (TransformerException te) {
	            System.out.println(te.getMessage());
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    } catch (ParserConfigurationException pce) {
	        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
	    }
	}
	
//	public static Chara[] read(String path){
//		
//		
//        Document dom;
//        // Make an  instance of the DocumentBuilderFactory
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        try {
//            // use the factory to take an instance of the document builder
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            // parse using the builder to get the DOM mapping of the    
//            // XML file
//            dom = db.parse(path);
//
//            Element doc = dom.getDocumentElement();
//            
//            //int kon = Integer.parseInt(eElement.getElementsByTagName("kon").item(0).getTextContent());
//            int kon = Integer.parseInt(getTextValue("", doc, "kon"));
//            if (role1 != null) {
//                if (!role1.isEmpty())
//                    rolev.add(role1);
//            }
//            role2 = getTextValue(role2, doc, "role2");
//            if (role2 != null) {
//                if (!role2.isEmpty())
//                    rolev.add(role2);
//            }
//            role3 = getTextValue(role3, doc, "role3");
//            if (role3 != null) {
//                if (!role3.isEmpty())
//                    rolev.add(role3);
//            }
//            role4 = getTextValue(role4, doc, "role4");
//            if ( role4 != null) {
//                if (!role4.isEmpty())
//                    rolev.add(role4);
//            }
//            return true;
//
//        } catch (ParserConfigurationException pce) {
//            System.out.println(pce.getMessage());
//        } catch (SAXException se) {
//            System.out.println(se.getMessage());
//        } catch (IOException ioe) {
//            System.err.println(ioe.getMessage());
//        }
//
//        return false;
//	}	
//	
//	private static String getTextValue(String def, Element doc, String tag) {
//	    String value = def;
//	    NodeList nl;
//	    nl = doc.getElementsByTagName(tag);
//	    if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
//	        value = nl.item(0).getFirstChild().getNodeValue();
//	    }
//	    return value;
//	}
	
}