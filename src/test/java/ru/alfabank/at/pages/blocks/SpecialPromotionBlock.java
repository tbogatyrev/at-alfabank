package ru.alfabank.at.pages.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.alfabank.at.pages.CashLoanPage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class SpecialPromotionBlock {

    private final SelenideElement
            specialPromotionBlock = $("#benefits-block-mortgage h2"),
            header = $("#benefits-block-mortgage h2"),
            receiveCreditBtn = $("#benefits-block-mortgage button[data-test-id=button]");

    private final ElementsCollection
            descriptionList = $$("#benefits-block-mortgage .b2hUpQ");

    public void blockIsVisible() {
        specialPromotionBlock.scrollTo().shouldBe(visible);
    }

    public void checkBlockHeader(String expectedHeader) {
        header.shouldHave(text(expectedHeader));
    }

    public void descriptionIsVisible(List<String> expectedDescriptionList) {
        descriptionList.shouldHave(exactTexts(expectedDescriptionList));
    }

    public CashLoanPage clickReceiveCreditBtn() {
        receiveCreditBtn.click();
        return new CashLoanPage();
    }
}

