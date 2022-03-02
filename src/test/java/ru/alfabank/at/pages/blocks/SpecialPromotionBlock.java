package ru.alfabank.at.pages.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.alfabank.at.pages.TelegramPage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SpecialPromotionBlock {

    private final SelenideElement
            specialPromotionBlock = $("#benefits-block-mortgage h2"),
            header = $("#benefits-block-mortgage h2"),
            button = $("#benefits-block-mortgage button[data-test-id=button]");

    private final ElementsCollection
            descriptionList = $$("#benefits-block-mortgage p[data-test-id=text]");

    public void blockIsVisible() {
        specialPromotionBlock.scrollTo().shouldBe(visible);
    }

    public void checkBlockHeader(String expectedHeader) {
        header.shouldHave(text(expectedHeader));
    }

    public void descriptionIsVisible(List<String> expectedDescriptionList) {
        descriptionList.shouldHave(exactTexts(expectedDescriptionList));
    }

    public TelegramPage clickButton() {
        button.click();
        return new TelegramPage();
    }
}

