package page;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import page.elements.Button;
import page.elements.Input;
import page.elements.Logo;

public class WikiPage {
    private final Input input = new Input("Поиск", "//*[@id=\"searchInput\"]");
    private final Input inputValue = new Input("Поле ввода", "/html/body/div[5]/div/div[1]/div/div[1]/form/input[1]");
    private final Button searchButton = new Button("Кнопка ввода", "/html/body/div[5]/div/div[2]/div/div[1]/div");
    private final Logo logo = new Logo("Лого Википедии", "/html/body/div[1]/div/header/div/div/a/span/img");

    @Step("Нажимаем на поиск")
    public WikiPage clickSearch() {
        input.click();
        return this;
    }

    @Step("Вводим значение в поле ввода")
    public WikiPage setValueInInput(String value) {
        inputValue.setValue(value);
        return this;
    }

    @Step("Нажимаем на кнопку поиска")
    public WikiPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    @Step("Проверяем видимость лого")
    public WikiPage checkLogoVisible(SoftAssertions softAssertions) {
        softAssertions.assertThat(logo.checkVisible()).isTrue();
        return this;
    }

    @Step("Проверяем, что значение атрибута '{attribute}' логотипа — '{value}'")
    public WikiPage checkLogoAttribute(SoftAssertions softAssertions, String attribute, String value) {
        String currentValue = logo.getCurrentValue(attribute);
        softAssertions.assertThat(currentValue).as("Атрибут '%s' логотипа", attribute).isEqualTo(value);
        return this;
    }
}
