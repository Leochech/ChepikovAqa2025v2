package page.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

public class RadioButton {
    private ElementsCollection elements;

    public RadioButton(String name , ElementsCollection elements) {
        this.elements = elements;
    }

    public RadioButton clickRadioButton(int index) {
        elements.get(index).click();
        return this;
    }

    public boolean checkColorRadioButton(int index) {
        elements.get(index).shouldHave(Condition.cssValue("color", "rgba(220, 53, 69, 1)"));
        return true;
    }
}
