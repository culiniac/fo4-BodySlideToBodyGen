package fluxxdog.fo4.convertbodyslide;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ProcessSliders {
    static MappedPresets convertToBodyGenTemplates(Arguments arguments) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(arguments.getFile());
        Element documentElement = document.getDocumentElement();

        return new MappedPresets(documentElement.getElementsByTagName("Preset"), arguments.getVariance());
    }

    static Map<String, Element> toMappedElements(NodeList nodelist) {
        List<Element> converted = convertNodeListToJavaList(nodelist);
        return converted.stream().collect(Collectors.toMap(ProcessSliders::elementName, e -> e));
    }

    private static List<Element> convertNodeListToJavaList(NodeList nodelist) {
        List<Element> newList = new ArrayList<>();
        for (int node = 0; node < nodelist.getLength(); node++) {
            newList.add((Element) nodelist.item(node));
        }
        return newList;
    }

    private static String elementName(Element e) {
        return e.getAttribute("name");
    }
}
