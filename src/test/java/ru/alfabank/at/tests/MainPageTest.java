package ru.alfabank.at.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.alfabank.at.pages.CashLoanPage;
import ru.alfabank.at.pages.MainPage;
import ru.alfabank.at.pages.SearchResultsPage;

import java.util.List;

import static io.qameta.allure.Allure.step;

public class MainPageTest extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @Tag("mainpage")
    @Stories({@Story("Проверка главной страницы")})
    @Description("Главный блок")
    @DisplayName("На странице присутствует главный блок со слайдами")
    @Severity(SeverityLevel.NORMAL)
    void checkMainBlock() {
        step("Блок с главной каруселью присутствует", () -> {
            mainPage.mainBlock().mainBlockIsVisible();
        });
        step("Отображается 4 слайда", () -> {
            mainPage.mainBlock().checkCountMainBlockSlides(4);
        });
    }

    @Test
    @Tag("mainpage")
    @Stories({@Story("Проверка главной страницы")})
    @Description("Блок 'Поиск по сайту'")
    @DisplayName("Отображаются результаты поиска")
    @Severity(SeverityLevel.NORMAL)
    void checkSearchResults() {
        step("Блок 'Поиск по сайту' присутствует", () -> {
            mainPage.searchBlock().blockIsVisible();
        });
        step("Получить результаты поиска по слову 'кредит'", () -> {
            String searchWord = "кредит";
            mainPage.searchBlock().searchField().sendKeys(searchWord);
            SearchResultsPage resultsPage = mainPage.searchBlock().submit();
            resultsPage.isFirstResultContainsSearchWord(searchWord);
        });
    }

    @Test
    @Tag("mainpage")
    @Stories({@Story("Проверка главной страницы")})
    @Description("Блок 'Популярные продукты'")
    @DisplayName("Блок 'Популярные продукты' со списком продуктов отображается")
    @Severity(SeverityLevel.NORMAL)
    void checkVisiblePopularProducts() {
        step("Блок 'Популярные продукты' присутствует", () -> {
            mainPage.popularProductsBlock().checkPopularProductsBlockHeader();
        });
        step("Отображается список продуктов", () -> {
            int productPopularSize = 6;
            mainPage.popularProductsBlock().checkPopularProductsSize(productPopularSize);
        });
    }

    @Test
    @Tag("mainpage")
    @Stories({@Story("Проверка главной страницы")})
    @Description("Блок со специальным предложением")
    @DisplayName("Проверка блока со специальным предложением")
    @Severity(SeverityLevel.CRITICAL)
    void checkSpecialPromotion() {
        String header = "Кредит наличными \nпо сниженной ставке";
        List<String> descriptionList = List.of(
                "-\nОнлайн-решение за 2 минуты",
                "-\nСумма до 7,5 млн ₽",
                "-\nДоставка на бесплатной дебетовой карте"
        );
        step("Блок со специальным предложением присутствует", () -> {
            mainPage.specialPromotionBlock().blockIsVisible();
        });
        step("Заголовок блока присутствует", () -> {
            mainPage.specialPromotionBlock().checkBlockHeader(header);
        });
        step("Описание в блоке присутствует", () -> {
            mainPage.specialPromotionBlock().descriptionIsVisible(descriptionList);
        });
        step("При нажатии кнопки 'Получить кредит' открылась страница 'Кредит наличными'", () -> {
            CashLoanPage cashLoanPage = mainPage.specialPromotionBlock().clickReceiveCreditBtn();
            cashLoanPage.checkTitle();
            cashLoanPage.checkUrlPath();
        });
    }

    @CsvSource(value = {
            "49999; Минимальная сумма кредита 50 000 ₽. Увеличьте сумму кредита или оформите кредитную карту 100 дней без %.",
            "50000; 7,5 %",
            "299999; 7,5 %",
            "300000; 7 %",
            "1349999; 7 %",
            "1350000; 5,5 %",
            "7500000; 5,5 %",
            "7500001; Альфа-Банк не выдаёт кредиты наличными больше 7,5 млн ₽"
    }, delimiter = ';')
    @ParameterizedTest(name = "Проверка граничных значений процентной ставки {1} калькулятора в зависимости от суммы: {0}")
    @Tag("mainpage")
    @Stories({@Story("Проверка главной страницы")})
    @Description("Блок с кредитным калькулятором")
    @DisplayName("Проверка зависимости процентной ставки от суммы кредита наличными")
    @Severity(SeverityLevel.CRITICAL)
    void checkInterestRate(String amount, String expectedPercent) {
        step("Блок с калькулятором присутствует", () -> {
            mainPage.calculatorBlock().blockIsVisible();
        });
        step("Выбрана вкладка 'Рассчитать кредит наличными'", () -> {
            mainPage.calculatorBlock().selectTabCreditLoan("Расcчитать кредит наличными");
        });
        step("Выбран 'Срок кредита' 1 год", () -> {
            mainPage.calculatorBlock().selectCreditTerm("1 год");
        });
        step("При изменении суммы кредита процентная ставка равна ожидаемому значению", () -> {
            mainPage.calculatorBlock().checkPercentByAmount(amount, expectedPercent);
        });
    }
}
