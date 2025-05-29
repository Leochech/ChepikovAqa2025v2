package page.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class DropDown {
    private final SelenideElement selector;
    private final ElementsCollection choose = $$(".css-1n7v3ny-option");

    public DropDown(String name, SelenideElement selector) {
        this.selector = selector;
    }

    public DropDown click() {
        selector.click();
        return this;
    }

    public DropDown choose(String values) {
        choose.findBy(Condition.text(values)).click();
        return this;
    }
}
