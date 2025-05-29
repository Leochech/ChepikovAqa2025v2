package page.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

public class Table {
    private String name;
    private SelenideElement selector;

    public Table(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    public String getValueByLabel(String label) {
        List<SelenideElement> rows = selector.$$(By.xpath(".//tbody/tr"));
        for (SelenideElement row : rows) {
            String currentLabel = row.$x("./td[1]").getText();
            if (currentLabel.equals(label)) {
                return row.$x("./td[2]").getText();
            }
        }
        return null;
    }
}
