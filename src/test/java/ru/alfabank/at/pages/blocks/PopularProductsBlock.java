package ru.alfabank.at.pages.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.*;

public class PopularProductsBlock {

    private final static String BLOCK_TITLE = "Популярные продукты";

    private final SelenideElement
            popularProductsBlockHeader = $("#popular-products-block");

    private final ElementsCollection
            popularProductsList = $$("#popular-products-block~[data-test-id='layout'] [data-test-id='grid'] .k2rkie");

    public void checkPopularProductsBlockHeader() {
        popularProductsBlockHeader.scrollTo().shouldHave(text(BLOCK_TITLE));
    }

    public void checkPopularProductsSize(int popularProductsSize) {
        assertThat(popularProductsList.size()).isEqualTo(popularProductsSize);
    }
}
