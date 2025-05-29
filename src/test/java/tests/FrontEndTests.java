package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.FrontEnd;
import settings.BaseTest;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static data.FlData.*;

public class FrontEndTests extends BaseTest {

    FrontEnd frontEnd = new FrontEnd();

    @Test
    @DisplayName("Заполнение таблицы")
    void addValueInForm() {
        open("https://demoqa.com/automation-practice-form");
        var file = new File("src/test/resources/attachment/Решение (1).pdf");
        frontEnd
                .addValueInNameInput(NAME)
                .addValueInLastNameInput(LASTNAME)
                .addValueInEmailInput(EMAIL)
                .clickRadioButtonMale()
                .addValueInUserNumberInput(PHONE)
                .chooseDateOfBirth(NOVEMBER, BIRTHYEAR, BIRTHDAY)
                .addValueInSubjectsContainer(ENGLISH)
                .clickhobbiesCheckbox()
                .upLoadFile(file)
                .addValueInCurrentAddress(CURRENTADDRESS)
                .chooseCity(CITY)
                .chooseState(STATE)
                .clickSubmitButton()
                .checkResultTable(softAssertions, Map.of(
                                "Student Name", NAME + " " + LASTNAME,
                                "Student Email", EMAIL,
                                "Gender", "Male",
                                "Mobile", PHONE,
                                "Date of Birth", BIRTHDAY + " " + NOVEMBER + "," + BIRTHYEAR,
                                "Subjects", ENGLISH,
                                "Hobbies", "Sports",
                                "Picture", "Решение (1).pdf",
                                "Address", CURRENTADDRESS,
                                "State and City", CITY + " " + STATE
                        )
                );
        softAssertions.assertAll();
        sleep(5000);
    }

    @Test
    @DisplayName("Обязательность полей")
    void checkMustHaveField() {
        open("https://demoqa.com/automation-practice-form");
        frontEnd
                .clickSubmitButton()
                .checkInputColorField(softAssertions);
        softAssertions.assertAll();
    }
}
