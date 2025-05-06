package tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import page.WikiPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class WikiPageTest {

    WikiPage wikiPage = new WikiPage();
    SoftAssertions softAssertions = new SoftAssertions();

    @Test
    void testWiki() {
        open("https://ru.m.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        wikiPage
                .clickSearch()
                .setValueInInput("БФТ")
                .clickSearchButton()
                .checkLogoVisible(softAssertions)
                .checkLogoAttribute(softAssertions,"alt", "Википедия");
        softAssertions.assertAll();
    }
}
