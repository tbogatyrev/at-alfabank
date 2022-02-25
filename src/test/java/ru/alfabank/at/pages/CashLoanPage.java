package ru.alfabank.at.pages;

import com.codeborne.selenide.WebDriverRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.*;

public class CashLoanPage {

    private static final String TITLE = "Кредиты наличными от 5,5% - оформить онлайн заявку на потребительский кредит и взять деньги физическим лицам - «Альфа-Банк»";
    private static final String PATH = "/get-money/credit/credit-cash/";

    public void checkTitle() {
        assertThat(title()).isEqualTo(TITLE);
    }

    public void checkUrlPath() {
        assertThat(getCurrentUrl().getPath()).isEqualTo(PATH);
    }

    private URL getCurrentUrl() {
        URL url = null;
        try {
            url = new URL(WebDriverRunner.getWebDriver().getCurrentUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
