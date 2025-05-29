package page.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Сalendarius {

    private final SelenideElement selector;
    private final SelenideElement selectMonth = $(".react-datepicker__month-select");
    private final SelenideElement selectYear = $(".react-datepicker__year-select");
    private final ElementsCollection selectDay = $$(".react-datepicker__day");

    public Сalendarius(String name, SelenideElement selector) {
        this.selector = selector;
    }

    public Сalendarius click() {
        selector.click();
        return this;
    }

    public Сalendarius selectMonth(String month) {
        selectMonth.selectOption(month);
        return this;
    }

    public Сalendarius selectYear(String yaer) {
        selectYear.selectOption(yaer);
        return this;
    }

    public Сalendarius selectDay(String day) {
        selectDay.findBy(Condition.text(day)).click();
        return this;
    }

}
