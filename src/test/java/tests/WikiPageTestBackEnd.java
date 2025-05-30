package tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import page.WikiPage;
import service.Box;
import service.BoxesFilter;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class WikiPageTestBackEnd {

    WikiPage wikiPage = new WikiPage();
    SoftAssertions softAssertions = new SoftAssertions();

    @Test
    @DisplayName("Проверки на Википедии")
    void testWiki() {
        open("https://ru.m.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        wikiPage
                .clickSearch()
                .setValueInInput("БФТ")
                .clickSearchButton()
                .checkLogoVisible(softAssertions)
                .checkLogoAttribute(softAssertions, "alt", "Википедия");
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Исключения обработка")
    void exceptionsProcessing() {
        Assertions.assertThrows(AssertionFailedError.class, () -> {
            System.out.println((Object) null);
            Assertions.assertTrue(false);
        });
    }

    @Test
    void boxFilterTask() {

        BoxesFilter boxesFilter = new BoxesFilter();

        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(20, 30, 20));
        boxes.add(new Box(25, 20, 15));
        boxes.add(new Box(30, 30, 30));
        boxes.add(new Box(35, 10, 50));
        boxes.add(new Box(40, 25, 20));

        System.out.println("Коробки до фильтрации:");
        boxes.forEach(System.out::println);

        List<Box> boxesFiltered = boxesFilter.boxesFilterByWidth(boxes, 30);
        System.out.println("\nКоробки после фильтрации:");
        boxesFiltered.forEach(System.out::println);
    }
}
