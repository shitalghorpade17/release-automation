package org.fa.automation.pages;

import org.fa.automation.utils.XmlFile;

import java.util.Map;

/**
 * Created by Forgeahead-Shital on 9/14/2017.
 */
public class BasePage {
    String xmlFileName=this.getClass().getSimpleName();
     Map<String,String> elementMap = new XmlFile().readXmlFile(xmlFileName);
}
