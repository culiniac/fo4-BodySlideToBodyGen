package fluxxdog.fo4.convertbodyslide;

import org.w3c.dom.Element;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

class SetSlider {
    private final String value;
    private final NumberFormat numberFormat = new DecimalFormat("0.00");
    private static final BigDecimal oneHundred = BigDecimal.valueOf(100);

    public SetSlider(Element element, int variance) {
        BigDecimal sliderValue = new BigDecimal(element.getAttribute("value"));
        if (variance == 0) {
            this.value = getRawSliderValue(sliderValue);
        } else {
            this.value = getVariedSliderValue(sliderValue, variance);
        }
    }

    private String getVariedSliderValue(BigDecimal sliderValue, int variance) {
        int slideUp = 100 + variance;
        int slideDown = 100 - variance;
        BigDecimal valueUp = sliderValue.multiply(BigDecimal.valueOf(slideUp)).divide(oneHundred.pow(2)).min(BigDecimal.ONE);
        BigDecimal valueDown = sliderValue.multiply(BigDecimal.valueOf(slideDown)).divide(oneHundred.pow(2));
        return numberFormat.format(valueDown) + ":" + numberFormat.format(valueUp);
    }

    private String getRawSliderValue(BigDecimal value) {
        BigDecimal sliderValue = value.divide(oneHundred);
        return numberFormat.format(sliderValue);
    }

    @Override
    public String toString() {
        return value;
    }
}
