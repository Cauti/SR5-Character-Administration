import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

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
  
  // Liest die XML-Daten aus der Datei mit dem übergebenen Pfad path.
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
            String name = eElement.getElementsByTagName("name").item(0).getTextContent();
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
}