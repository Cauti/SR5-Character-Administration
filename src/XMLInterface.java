
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

import sr5.classes.Fertigkeit;
import sr5.classes.Klasse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


// Creats a XMLFile with DOM-Parser
// source: https://www.tutorialspoint.com/java_xml/java_dom_create_document.htm
// source: https://www.tutorialspoint.com/java_xml/java_dom_modify_document.htm
public class XMLInterface{
	
	//private static int id = 0;
	
	public static boolean saveToXML(ArrayList<Chara> charas){
		int id = 0;

		Collections.sort(charas, new Comparator<Chara>() {
			public int compare(Chara c1, Chara c2) {
		    	return c1.getName().compareTo(c2.getName());
		    }
		});
		
		try {
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document dom = dBuilder.newDocument();
	         // root element
	         
	         Element rootElement = dom.createElement("characters");
	         dom.appendChild(rootElement);
	    	
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
		         
		         Element klasse = dom.createElement("klasse");
		         klasse.appendChild(dom.createTextNode("" + tmpChara.getKlasse().getValue()));
		         chara.appendChild(klasse);
		         
		         Element fertigkeiten = dom.createElement("fert");
		         String f = tmpChara.getFertigkeitenForXML();
		         fertigkeiten.appendChild(dom.createTextNode(f.equals("") ? " " : f));
		         chara.appendChild(fertigkeiten);
	        
	        }
	         // write the content into xml file
	         String path = IAmTheFrame.getPath();
			 //File file;
			 if (path != null) {
				 path = path.substring(0, path.lastIndexOf("\\")+1) + "CharaDB " + InitiativePanel.getTimeforPath() + ".xml";
				 System.out.println(path);
			 } else {
				 path = "C:\\Desktop\\dummy.xml";
			 }
			 
			 try {
		            Transformer tr = TransformerFactory.newInstance().newTransformer();
		            tr.setOutputProperty(OutputKeys.INDENT, "yes"); // Umbruch
		            tr.setOutputProperty(OutputKeys.METHOD, "xml");
		            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		            //tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
		            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); //Einrücken 

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
			 
	    	return true;
	}	
	
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
	            String fert = eElement.getElementsByTagName("fert").item(0).getTextContent();
	            
	            Map<Fertigkeit, Integer> fertigkeiten = new HashMap<Fertigkeit, Integer>();
	            
	            // Int speichern, aber als Enum in Chara parsen!
	            int klasse = 0;
	            try {
	            	klasse = Integer.parseInt(eElement.getElementsByTagName("klasse").item(0).getTextContent());
	            } catch (java.lang.NullPointerException e) {
	            	e.printStackTrace();
	            }
	          
	            
				if (Klasse.getKlassByID(klasse).equals(Klasse.TECHNOMANCER)) {
					System.out.println(name + " ist ein Techno!");
					charas[temp] = new Techno(kon,ges,rea,sta,wil,log,intu,cha,edg,ess,mag,ini,ina,inks,inhs,kzm,gzm,panz,name,meta,Klasse.getKlassByID(klasse));
				} else {
					charas[temp] = new Chara(kon, ges, rea, sta, wil, log, intu, cha, edg, ess, mag, ini, ina, inks, inhs, kzm, gzm, panz, name, meta, Klasse.getKlassByID(klasse));
				}
			  }
	        }
	        return charas;
	      } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	      }
	  }
}