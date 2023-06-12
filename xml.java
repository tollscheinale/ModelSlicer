/**
 *
 * @author atoll
 */


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.NodeList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class xml {
    public void create(String ModelName, String ModelType){
        try {
            // Erzeuge eine Instanz der DocumentBuilderFactory und des DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Erzeuge ein neues Document
            Document document = builder.newDocument();

            // Erzeuge die Wurzel-Elemente und füge sie dem Document hinzu
            Element ModelElement = document.createElement("Model");
            document.appendChild(ModelElement);

            // Füge weitere Elemente und Textknoten dem Document hinzu
            Element Modelname = document.createElement("Modelname");
            ModelElement.appendChild(Modelname);

            Element Modeltype = document.createElement("Modeltype");
            ModelElement.appendChild(Modeltype);

            Text name = document.createTextNode(ModelName);
            Modelname.appendChild(name);

            Text type = document.createTextNode(ModelType);
            Modeltype.appendChild(type);

            // Schreibe das Document in eine XML-Datei
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            String outputPath = "./data/Modeldata/" + ModelName + ".xml";
            File file = new File(outputPath);
            StreamResult result = new StreamResult(file);

            // Schreibe das Dokument in die Datei
            transformer.transform(source, result);

            System.out.println("XML-Datei erfolgreich erstellt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }
    
    public void open(){
        
    }

    public void read(String ModelName){
        try {
            // Erzeuge eine Instanz der DocumentBuilderFactory und des DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Lade die XML-Datei
            File xmlFile = new File(ModelName + ".xml");
            Document document = builder.parse(xmlFile);

            // Extrahiere die Informationen aus der XML-Datei
            Element rootElement = document.getDocumentElement();
            NodeList childNodes = rootElement.getElementsByTagName("child");
            if (childNodes.getLength() > 0) {
                Element childElement = (Element) childNodes.item(0);
                String textContent = childElement.getTextContent();
                System.out.println("Inhalt des Child-Elements: " + textContent);
            } else {
                System.out.println("Kein Child-Element vorhanden.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void reload(){
        
    }

    public void getData(String filament){
        try {
            // Erzeuge eine Instanz der DocumentBuilderFactory und des DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Lade die XML-Datei
            String inputPath = "./data/Allgemein/" + filament + ".xml";
            File xmlFile = new File(inputPath);
            Document document = builder.parse(xmlFile);

            // Extrahiere die Informationen aus der XML-Datei
            Element rootElement = document.getDocumentElement();
            NodeList childNodes = rootElement.getElementsByTagName("child");
            if (childNodes.getLength() > 0) {
                Element Nozzletemp = (Element) childNodes.item(0);
                Element Bedtemp = (Element) childNodes.item(1);
                Element NeedVan = (Element) childNodes.item(2);
                System.out.println("Nozzle temp.: " + Nozzletemp.getTextContent());
                System.out.println("Need van: " + Bedtemp.getTextContent());
                System.out.println("Need van: " + NeedVan.getTextContent());
            } else {
                System.out.println("Kein Child-Element vorhanden.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}