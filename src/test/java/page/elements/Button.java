package page.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class Button {

    private final SelenideElement selector;

    public Button(String name, String selector) {
        this.selector = $x(selector);
    }

    public Button(String name, SelenideElement selector) {
        this.selector = selector;
    }

    public Button click() {
        selector.shouldBe(Condition.enabled, Duration.ofSeconds(10000))
                .click();
        return this;
    }
}
