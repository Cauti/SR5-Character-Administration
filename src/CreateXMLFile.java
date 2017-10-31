
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;


// Creats a XMLFile with DOM-Parser
// source: https://www.tutorialspoint.com/java_xml/java_dom_create_document.htm
// source: https://www.tutorialspoint.com/java_xml/java_dom_modify_document.htm
public class CreateXMLFile{
	
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
	         Element klim = doc.createElement("klim");
	         klim.appendChild(doc.createTextNode("" +  values[15]));
	         chara.appendChild(klim);
	         Element glim = doc.createElement("glim");
	         glim.appendChild(doc.createTextNode("" +  values[16]));
	         chara.appendChild(glim);
	         Element slim = doc.createElement("slim");
	         slim.appendChild(doc.createTextNode("" +  values[17]));
	         chara.appendChild(slim);
	         Element name = doc.createElement("name");
	         name.appendChild(doc.createTextNode("" +  values[18]));
	         chara.appendChild(name);
	         Element meta = doc.createElement("meta");
	         meta.appendChild(doc.createTextNode("" +  values[19]));
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
	
   public static void main(String argv[]) {

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
         attr.setValue("1");
         chara.setAttributeNode(attr);

         // Werte eintragen
         Element kon = doc.createElement("kon");
         kon.appendChild(doc.createTextNode("42"));
         chara.appendChild(kon);
         Element ges = doc.createElement("ges");
         ges.appendChild(doc.createTextNode("8"));
         chara.appendChild(ges);
         
         /*
          //Attr attrType = doc.createAttribute("kon");
         //attrType.setValue("42");
         //newvalue.setAttributeNode(attrType);
         Element carname1 = doc.createElement("carname");
         Attr attrType1 = doc.createAttribute("type");
         attrType1.setValue("sports");
         carname1.setAttributeNode(attrType1);
         carname1.appendChild(doc.createTextNode("Ferrari 202"));
         supercar.appendChild(carname1);
         */

         // write the content into xml file
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File("src/test.xml"));
         transformer.transform(source, result);
         // Output to console for testing
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
