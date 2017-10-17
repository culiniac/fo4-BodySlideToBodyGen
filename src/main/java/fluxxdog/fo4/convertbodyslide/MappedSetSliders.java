package fluxxdog.fo4.convertbodyslide;

import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.stream.Collectors;

class MappedSetSliders extends HashMap<String, SetSlider> {
    public MappedSetSliders(NodeList nodeList, int variance) {
        super(nodeList.getLength());
        ProcessSliders.toMappedElements(nodeList).forEach((n,e)->this.put(n, new SetSlider(e,variance)));
    }

    @Override
    public String toString() {
        return this.entrySet().stream().map(
                e-> e.getKey()+"@"+e.getValue().toString()
        ).collect(Collectors.joining(", "));
    }
}
