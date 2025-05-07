package page.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ButtonNew {

    private final SelenideElement selector;

    public ButtonNew(String name, String selector) {
        this.selector = $x(selector);
    }

    public ButtonNew click() {
        selector.click();
        return this;
    }
}
