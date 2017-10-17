package fluxxdog.fo4.convertbodyslide;

import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.stream.Collectors;

class MappedPresets extends HashMap<String, Preset> {
    MappedPresets(NodeList nodeList, int variance){
        super(nodeList.getLength());
        ProcessSliders.toMappedElements(nodeList).forEach((n,e)->this.put(n, new Preset(e,variance)));
    }

    @Override
    public String toString() {
        return this.entrySet().stream().map(
                e-> e.getKey()+"="+e.getValue().toString()
        ).collect(Collectors.joining("\n\n"));
    }
}
