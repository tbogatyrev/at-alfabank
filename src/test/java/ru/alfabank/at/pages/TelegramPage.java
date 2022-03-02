package ru.alfabank.at.pages;

import com.codeborne.selenide.WebDriverRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.title;
import static org.assertj.core.api.Assertions.assertThat;

public class TelegramPage {

    private static final String TITLE = "Telegram: Contact @AlfaBank";
    private static final String URL = "https://t.me/AlfaBank";

    public void checkTitle() {
        assertThat(title()).isEqualTo(TITLE);
    }

    public void checkUrlPath() {
        assertThat(getCurrentUrl().toString()).isEqualTo(URL);
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
