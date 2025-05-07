package page.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LogoNew {

    private final SelenideElement selector;

    public LogoNew(String name, String selector) {
        this.selector = $x(selector);
    }

    public boolean checkVisible() {
        return selector.is(Condition.visible);
    }

    public String getCurrentValue(String attribute) {
        return selector.getAttribute(attribute);
    }
}
