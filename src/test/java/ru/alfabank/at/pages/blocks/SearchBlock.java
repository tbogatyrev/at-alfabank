package ru.alfabank.at.pages.blocks;

import com.codeborne.selenide.SelenideElement;
import ru.alfabank.at.pages.SearchResultsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SearchBlock {

    private final SelenideElement
            searchBlock = $x("//p[text()='Поиск по сайту']//ancestor::div[@data-test-id='layout']"),
            searchField = $x("//p[text()='Поиск по сайту']//ancestor::div[@data-test-id='layout']//input[@type='search']"),
            searchSubmit = $x("//p[text()='Поиск по сайту']//ancestor::div[@data-test-id='layout']//button[@type='submit']");

    public SelenideElement searchField() {
        return searchField;
    }

    public SearchResultsPage submit() {
        searchSubmit.click();
        return new SearchResultsPage();
    }

    public void blockIsVisible() {
        searchBlock.shouldBe(visible);
    }
}
