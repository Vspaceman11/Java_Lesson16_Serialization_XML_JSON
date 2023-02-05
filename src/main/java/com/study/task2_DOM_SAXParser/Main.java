package com.study.task2_DOM_SAXParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.newDocument();

            Element rootElement = doc.createElement("country");
            doc.appendChild(rootElement);

            Element city = doc.createElement("city");
            city.setAttribute("size", "big");
            city.setTextContent("Odesa");
            rootElement.appendChild(city);

            Element street = doc.createElement("street");
            street.setTextContent("Prymorska");
            rootElement.appendChild(street);

            Element building = doc.createElement("building");
            building.setTextContent("13");
            rootElement.appendChild(building);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            DOMSource source = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(new File("C:\\Users\\user\\IdeaProjects\\Java_Lesson16_Serialization_XML_JSON\\src\\main\\java\\com\\study\\task2\\1.xml"));

            transformer.transform(source, streamResult);
        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
