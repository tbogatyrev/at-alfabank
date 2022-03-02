package ru.alfabank.at.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.alfabank.at.pages.MainPage;
import ru.alfabank.at.pages.SearchResultsPage;
import ru.alfabank.at.pages.TelegramPage;

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
        String header = "Важные новости\nв нашем Telegram";
        List<String> descriptionList = List.of(
                "Подпишитесь, чтобы быть в курсе"
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
            TelegramPage telegramPage = mainPage.specialPromotionBlock().clickButton();
            telegramPage.checkTitle();
            telegramPage.checkUrlPath();
        });
    }

    @Disabled
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
    @Description("Блок с калькулятором")
    @DisplayName("Проверка зависимости процентной ставки от суммы кредита наличными")
    @Severity(SeverityLevel.CRITICAL)
    void checkCreditInterestRate(String amount, String expectedPercent) {
        step("Блок с калькулятором присутствует", () -> {
            mainPage.calculatorBlock().blockIsVisible();
        });
        step("Выбрана вкладка 'Рассчитать кредит наличными'", () -> {
            mainPage.calculatorBlock().selectTabCreditLoan("Расcчитать кредит наличными");
        });
        step("Выбран 'Срок кредита' 1 год", () -> {
            mainPage.calculatorBlock().selectTerm("1 год");
        });
        step("При изменении суммы кредита процентная ставка равна ожидаемому значению", () -> {
            mainPage.calculatorBlock().checkPercentByAmount(amount, expectedPercent);
        });
    }

    @CsvSource(value = {
            "3 месяца; 20,34 %",
            "6 месяцев; 19,77 %",
            "9 месяцев; 15,77 %",
            "1 год; 10,47 %",
            "1,5 года; 10,74 %",
            "2 года; 11,02 %",
            "3 года; 11,61 %"
    }, delimiter = ';')
    @ParameterizedTest(name = "Проверка процентной ставки по депозиту {1} калькулятора в зависимости от срока: {0}")
    @Tag("mainpage")
    @Stories({@Story("Проверка главной страницы")})
    @Description("Блок с калькулятором")
    @DisplayName("Проверка зависимости процентной ставки по депозиту от срока")
    @Severity(SeverityLevel.CRITICAL)
    void checkDepositInterestRate(String term, String expectedPercent) {
        step("Блок с калькулятором присутствует", () -> {
            mainPage.calculatorBlock().blockIsVisible();
        });
        step("Выбрана вкладка 'Рассчитать выгоду по вкладу'", () -> {
            mainPage.calculatorBlock().selectTabCreditLoan("Рассчитать выгоду по вкладу");
        });
        step("Выбран срок вклада", () -> {
            mainPage.calculatorBlock().selectTerm(term);
        });
        step("При изменении срока вклада процентная ставка равна ожидаемому значению", () -> {
            String amount = "1000000";
            mainPage.calculatorBlock().checkDepositPercent(amount, expectedPercent);
        });
    }
}
