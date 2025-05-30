package page.elements;

import com.codeborne.selenide.ElementsCollection;

public class Checkbox {
    private ElementsCollection elements;

    public Checkbox(String name , ElementsCollection elements) {
        this.elements = elements;
    }

    public Checkbox clickCheckbox(int index) {
        elements.get(index).click();
        return this;
    }
}
