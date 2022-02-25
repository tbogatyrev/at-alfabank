package ru.alfabank.at.pages.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class MainBlock {

    private final SelenideElement
            mainBlock = $("[data-test-id='Main-Carousel-Tabs-Desktop']");

    private final ElementsCollection
            mainBlockSlides = $$("[data-test-id='Main-Carousel-Tabs-Desktop'] [role='button']");

    public void mainBlockIsVisible() {
        mainBlock.shouldBe(visible);
    }

    public void checkCountMainBlockSlides(int count) {
        assertThat(mainBlockSlides.size()).isEqualTo(count);
    }
}
