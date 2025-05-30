package page.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

public class Input {

    private SelenideElement selector;
    private ElementsCollection selectors;

    public Input(String name, SelenideElement selector) {
        this.selector = selector;
    }

    public Input(String name, ElementsCollection selectors) {
        this.selectors = selectors;
    }

    public Input inputValue(String value) {
        selector.setValue(value);
        return this;
    }

    public Input inputInBlock(int index, String value) {
        selectors.get(index).setValue(value);
        return this;
    }

    public Input inputValueEnter(String value) {
        selector.setValue(value).pressEnter();
        return this;
    }

    public Input uploadFile(File file) {
        selector.uploadFile(file);
        return this;
    }

    public boolean checkColorInputField() {
        selector.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        return true;
    }
}
