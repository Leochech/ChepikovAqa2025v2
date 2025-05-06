package page.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Input {
    private final SelenideElement selector;

    public Input(String name, String selector) {
        this.selector = $x(selector);
    }

    public Input click() {
        selector.click();
        return this;
    }

    public Input setValue(String value) {
        selector.setValue(value);
        return this;
    }
}
