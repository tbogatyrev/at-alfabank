package ru.alfabank.at.pages;

import ru.alfabank.at.pages.blocks.*;

public class MainPage {

    private final MainBlock mainBlock = new MainBlock();
    private final SearchBlock searchBlock = new SearchBlock();
    private final PopularProductsBlock popularProductsBlock = new PopularProductsBlock();
    private final SpecialPromotionBlock specialPromotionBlock = new SpecialPromotionBlock();
    private final CalculatorBlock calculatorBlock = new CalculatorBlock();

    public MainBlock mainBlock() {
        return mainBlock;
    }

    public SearchBlock searchBlock() {
        return searchBlock;
    }

    public PopularProductsBlock popularProductsBlock() {
        return popularProductsBlock;
    }

    public SpecialPromotionBlock specialPromotionBlock() {
        return specialPromotionBlock;
    }

    public CalculatorBlock calculatorBlock() {
        return calculatorBlock;
    }
}
