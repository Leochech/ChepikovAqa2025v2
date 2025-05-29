package page;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.jetbrains.annotations.NotNull;
import page.components.DropDown;
import page.components.Сalendarius;
import page.elements.*;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class FrontEnd {

    private final Input nameInput = new Input("Поле ввода имени", $x("//*[@id='firstName']"));
    private final Input lastNameInput = new Input("Поле ввода Фамилии", $x("//*[@id='lastName']"));
    private final Input emailInput = new Input("Поле ввода eMail", $x("//*[@id='userEmail']"));
    private final Input userNumberInput = new Input("Поле ввода userNumber", $x("//*[@id='userNumber']"));
    private final Input subjectsInput = new Input("Поле ввода subjectsContainer", $x("//*[@id='subjectsInput']"));
    private final RadioButton radioButton = new RadioButton("Радио мужчина", $$x("//*[@class='custom-control-label']"));
    private final Checkbox hobbiesCheckbox = new Checkbox("Чекбокс хобби", $$x("//*[@class='custom-control-label']"));
    private final Сalendarius calendar = new Сalendarius("Календарь", $x("//*[@id='dateOfBirthInput']"));
    private final Input fileUploader = new Input("Загрузка файла", $(".form-control-file"));
    private final Input currentAddress = new Input("Поле ввода текущего адреса", $x("//*[@id='currentAddress']"));
    private final DropDown state = new DropDown("Дропдаун выбора штата", $("#city"));
    private final DropDown city = new DropDown("Дропдаун выбора города", $("#state"));
    private final Button submitButton = new Button("Кнопка submit", $(".btn.btn-primary"));
    private final Table resultTable = new Table("Результирующая таблица", $(".table-responsive"));


    @Step("Вводим значение в поле ввода Имени")
    public FrontEnd addValueInNameInput(String value) {
        nameInput.inputValue(value);
        return this;
    }

    @Step("Вводим значение в поле ввода Фамилии")
    public FrontEnd addValueInLastNameInput(String value) {
        lastNameInput.inputValue(value);
        return this;
    }

    @Step("Вводим значение в поле ввода eMail")
    public FrontEnd addValueInEmailInput(String value) {
        emailInput.inputValue(value);
        return this;
    }

    @Step("Вводим значение в поле ввода userNumber")
    public FrontEnd addValueInUserNumberInput(String value) {
        userNumberInput.inputValue(value);
        return this;
    }

    @Step("Выбираем радио 1 (мужчина)")
    public FrontEnd clickRadioButtonMale() {
        radioButton.clickRadioButton(0);
        return this;
    }

    @Step("Выбираем дату рождения")
    public FrontEnd chooseDateOfBirth(String month, String year, String day) {
        calendar.click().selectMonth(month).selectYear(year).selectDay(day);
        return this;
    }

    @Step("Вводим значение в поле ввода userNumber")
    public FrontEnd addValueInSubjectsContainer(String value) {
        subjectsInput.inputValueEnter(value);
        return this;
    }

    @Step("Выбираем чекбокс")
    public FrontEnd clickhobbiesCheckbox() {
        hobbiesCheckbox.clickCheckbox(3);
        return this;
    }

    @Step("Загружаем файл")
    public FrontEnd upLoadFile(File file) {
        fileUploader.uploadFile(file);
        return this;
    }

    @Step("Вводим значение в поле ввода currentAddress")
    public FrontEnd addValueInCurrentAddress(String value) {
        currentAddress.inputValue(value);
        return this;
    }

    @Step("Выбираем Штат")
    public FrontEnd chooseState(String value) {
        state.click().choose(value);
        return this;
    }

    @Step("Выбираем Город")
    public FrontEnd chooseCity(String value) {
        city.click().choose(value);
        return this;
    }

    @Step("Нажимаем на кнопку Submit")
    public FrontEnd clickSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверяем результирующую таблицу")
    public FrontEnd checkResultTable(SoftAssertions softAssertions, @NotNull Map<String, String> expectedValues) {
        expectedValues.forEach((label, expectedValue) -> {
            String actualValue = resultTable.getValueByLabel(label);
            softAssertions.assertThat(actualValue)
                    .as("Значение для '%s' не совпадает", label)
                    .isEqualTo(expectedValue);
        });
        return this;
    }

    @Step("Проверяем цвет обязательны полей")
    public FrontEnd checkInputColorField(@NotNull SoftAssertions softAssertions) {
        softAssertions
                .assertThat(nameInput.checkColorInputField())
                .as("Цвет поля Имени не красный!")
                .isTrue();
        softAssertions
                .assertThat(lastNameInput.checkColorInputField())
                .as("Цвет поля Фамилии не красный!")
                .isTrue();
        softAssertions
                .assertThat(userNumberInput.checkColorInputField())
                .as("Цвет поля Телефон не красный!")
                .isTrue();
        softAssertions
                .assertThat(radioButton.checkColorRadioButton(0))
                .as("Цвет радио Male не красный!")
                .isTrue();
        softAssertions
                .assertThat(radioButton.checkColorRadioButton(1))
                .as("Цвет радио FeMale не красный!")
                .isTrue();
        softAssertions
                .assertThat(radioButton.checkColorRadioButton(2))
                .as("Цвет радио Оно не красный!")
                .isTrue();
        return this;
    }
}
