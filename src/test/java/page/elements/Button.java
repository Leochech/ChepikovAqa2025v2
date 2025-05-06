package page.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Button {

    private final SelenideElement selector;

    public Button(String name, String selector) {
        this.selector = $x(selector);
    }

    public Button click() {
        selector.click();
        return this;
    }
}
