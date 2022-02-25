package ru.alfabank.at.pages.blocks;

import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;

import java.util.Optional;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.*;
import static org.openqa.selenium.Keys.*;

public class CalculatorBlock {

    private static final String
            DESCRIPTION_LESS_AMOUNT = "Минимальная сумма кредита 50 000 ₽. Увеличьте сумму кредита или оформите кредитную карту 100 дней без %.",
            DESCRIPTION_MORE_AMOUNT = "Альфа-Банк не выдаёт кредиты наличными больше 7,5 млн ₽";

    private final SelenideElement
            calculatorBlock = $("[data-test-id=tabs-with-calculators]"),
            creditAmount = $("[data-test-id=tabs-with-calculators] #creditAmount"),
            interestRate = $("[data-test-id=tabs-with-calculators] .a2SelW"),
            descriptionWithMoreThenAllowedAmount = $$("[data-widget-name=Text]").first(),
            descriptionWithLessThenAllowedAmount = $("[data-test-id=tabs-with-calculators] [data-test-id=crossSaleText]");


    private final ElementsCollection
            creditTerm = $$("[data-test-id=tabs-with-calculators] [data-test-id=grid] button"),
            creditLoanTabs = $$("[data-test-id=tabs-with-calculators] [data-test-id=grid] [role=tab] span");


    public void blockIsVisible() {
        calculatorBlock.scrollTo().shouldBe(visible);
    }

    public void selectTabCreditLoan(String tab) {
        SelenideElement calcTab = creditLoanTabs.stream()
                .filter(el -> el.getText().replaceAll("\n", " ").equals(tab))
                .findFirst().orElseThrow(NotFoundException::new);
        calcTab.click();
        calcTab.isSelected();
    }

    public void selectCreditTerm(String term) {
        SelenideElement termBtn = creditTerm.find(text(term));
        termBtn.click();
        termBtn.isSelected();
    }

    public void checkPercentByAmount(String amount, String expectedResult) {
        creditAmount.scrollTo().click();
        creditAmount.sendKeys(CONTROL + "A" + DELETE);
        creditAmount.sendKeys(amount);
        sleep(1000);

        switch (expectedResult) {
            case DESCRIPTION_LESS_AMOUNT:
                assertThat(descriptionWithLessThenAllowedAmount.getText()).isEqualTo(expectedResult);
                break;
            case DESCRIPTION_MORE_AMOUNT:
                assertThat(descriptionWithMoreThenAllowedAmount.getText()).isEqualTo(expectedResult);
                break;
            default:
                assertThat(interestRate.getText()).isEqualTo(expectedResult);
        }
    }
}
