package page;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import page.elements.ButtonNew;
import page.elements.InputNew;
import page.elements.LogoNew;

public class WikiPage {
    private final InputNew inputNew = new InputNew("Поиск", "//*[@id=\"searchInput\"]");
    private final InputNew inputNewValue = new InputNew("Поле ввода", "/html/body/div[5]/div/div[1]/div/div[1]/form/input[1]");
    private final ButtonNew searchButtonNew = new ButtonNew("Кнопка ввода", "/html/body/div[5]/div/div[2]/div/div[1]/div");
    private final LogoNew logoNew = new LogoNew("Лого Википедии", "/html/body/div[1]/div/header/div/div/a/span/img");

    @Step("Нажимаем на поиск")
    public WikiPage clickSearch() {
        inputNew.click();
        return this;
    }

    @Step("Вводим значение в поле ввода")
    public WikiPage setValueInInput(String value) {
        inputNewValue.setValue(value);
        return this;
    }

    @Step("Нажимаем на кнопку поиска")
    public WikiPage clickSearchButton() {
        searchButtonNew.click();
        return this;
    }

    @Step("Проверяем видимость лого")
    public WikiPage checkLogoVisible(SoftAssertions softAssertions) {
        softAssertions.assertThat(logoNew.checkVisible()).isTrue();
        return this;
    }

    @Step("Проверяем, что значение атрибута '{attribute}' логотипа — '{value}'")
    public WikiPage checkLogoAttribute(SoftAssertions softAssertions, String attribute, String value) {
        String currentValue = logoNew.getCurrentValue(attribute);
        softAssertions.assertThat(currentValue).as("Атрибут '%s' логотипа", attribute).isEqualTo(value);
        return this;
    }
}
