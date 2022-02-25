package ru.alfabank.at.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {

    private final ElementsCollection searchResults =
            $(".b-serp-list").$$("yass-li");

    public SelenideElement getSearchResultByIndex(int index) {
        return searchResults.get(index);
    }

    public void isFirstResultContainsSearchWord(String searchWord) {
        getSearchResultByIndex(0).$("yass-span b").shouldBe(text(searchWord));
    }
}
