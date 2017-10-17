package fluxxdog.fo4.convertbodyslide;

import org.w3c.dom.Element;

class Preset {
    private final MappedSetSliders mappedSliders;

    Preset(Element element, int variance){
        mappedSliders=new MappedSetSliders(element.getElementsByTagName("SetSlider"),variance);
    }

    @Override
    public String toString() {
        return mappedSliders.toString();
    }
}
