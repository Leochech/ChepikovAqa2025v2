package page.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InputNew {
    private final SelenideElement selector;

    public InputNew(String name, String selector) {
        this.selector = $x(selector);
    }

    public InputNew click() {
        selector.click();
        return this;
    }

    public InputNew setValue(String value) {
        selector.setValue(value);
        return this;
    }
}
