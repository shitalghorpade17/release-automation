package org.fa.automation.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Forgeahead-Shital on 9/14/2017.
 */
public class XmlFile {
    public  Map<String, String> readXmlFile(String filename) {
        Map<String, String> elementMap = new HashMap<String, String>();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("src/main/resources/elementRepo/" + filename + ".xml");
            NodeList nodeList = document.getElementsByTagName("UIElement");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    elementMap.put(element.getAttribute("name"), element.getAttribute("locatorType") + "Aurushi" + element.getAttribute("locatorValue"));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementMap;
    }
}
