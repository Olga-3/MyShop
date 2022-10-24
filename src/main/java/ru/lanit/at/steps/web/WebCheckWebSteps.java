package ru.lanit.at.steps.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.lanit.at.actions.WebChecks;
import ru.lanit.at.utils.web.pagecontext.PageManager;

import java.util.List;

public class WebCheckWebSteps extends AbstractWebSteps {

    public WebCheckWebSteps(PageManager pageManager) {
        super(pageManager);
    }


    /**
     * проверка присутствия текста на странице
     *
     * @param text текст
     */
    @Когда("проверить что элемент {string} содержит текст:")
    public void textAppearOnThePage(String elementName, List<String> text) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementContainsText(element, text);
        LOGGER.info("элемент '{}' содержит текст '{}'", elementName, text);
    }


    /**
     * проверка присутствия текста на странице
     *
     * @param text текст
     */
    @Когда("на странице присутствует текст {string}")
    public void textAppearOnThePage(String text) {
        WebChecks.textVisibleOnPage(text, null);
        LOGGER.info("на странице '{}' имеется текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * проверка отсутствия текста на странице
     *
     * @param text текст
     */
    @Когда("на странице отсутствует текст {string}")
    public void textVisibleOnPage(String text) {
        WebChecks.textAbsentOnPage(text, null);
        LOGGER.info("на странице '{}' отсутствует текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * ожидание появления текста на странице в течении некоторого времени
     *
     * @param text           текст
     * @param timeoutSeconds количество секунд
     */
    @Когда("подождать появления текста {string} в течение {int} секунд")
    public void waitUntilTextAppearOnPage(String text, int timeoutSeconds) {
        WebChecks.textVisibleOnPage(text, timeoutSeconds);
        LOGGER.info("на странице '{}' имеется текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * ожидание исчезновения текста на странице в течении некоторого времени
     *
     * @param text           текст
     * @param timeoutSeconds количество секунд
     */
    @Когда("подождать исчезновения текста {string} в течение {int} секунд")
    public void waitUntilTextAbsentOnPage(String text, int timeoutSeconds) {
        WebChecks.textAbsentOnPage(text, timeoutSeconds);
        LOGGER.info("на странице '{}' отсутствует текст '{}'", pageManager.getCurrentPage().name(), text);
    }

    /**
     * ожидание элемента на странице в течение некоторого времени
     *
     * @param elementName    наименование элемента
     * @param timeoutSeconds количество секунд
     */
    @Когда("подождать появления элемента {string} в течение {int} секунд")
    public void waitUntilElementIsVisibleOnPage(String elementName, int timeoutSeconds) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementVisibleOnPage(element, timeoutSeconds);
        LOGGER.info("на странице '{}' имеется элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    /**
     * проверка что на странице отображен элемент
     *
     * @param elementName наименование элемента
     */
    @Когда("на странице отображается элемент {string}")
    public void elementAppearOnThePage(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementVisibleOnPage(element, null);
        LOGGER.info("на странице '{}' имеется элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    /**
     * проверка что на странице отсуствует элемент
     *
     * @param elementName наименование элемента
     */
    @Когда("на странице отсутствует элемент {string}")
    public void elementAbsentOnPage(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        WebChecks.elementAbsentOnPage(element, null);
        LOGGER.info("на странице '{}' отсутствует элемент '{}'", pageManager.getCurrentPage().name(), elementName);
    }

    /**
     * проверка текущего url
     * <br/>можно начать написание url с переменной %{apiUrl}% или %{webUrl}%
     *
     * @param url часть или полный url (также может содержать переменные)
     */
    @Тогда("текущий url соответствует {string}")
    public void currentUrlEqualsExpected(String url) {
        WebChecks.urlEquals(url);
    }

    /**
     * проверка текущего url
     * <br/>можно начать написание url с переменной %{apiUrl}% или %{webUrl}%
     *
     * @param url часть url (также может содержать переменные)
     */
    @Тогда("проверить что текущий url содержит текст {string}")
    public void currentUrlContainsExpected(String url) {
        WebChecks.urlContains(url);
    }

    /**
     * проверить, что поле пустое
     *
     * @param fieldName название поля (элемента)
     */
    @Тогда("поле {string} не заполнено")
    public void checkIfEmpty(String fieldName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(fieldName)
                .shouldHave(Condition.empty);
        LOGGER.info("поле '{}' не заполнено", fieldName);
    }

    /**
     * проверить, что в поле содержится текст
     *
     * @param fieldName название поля (элемента)
     * @param input     текст в поле
     */
    @Тогда("в поле {string} введено {string}")
    public void checkIfNotEmpty(String fieldName, String input) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(fieldName)
                .shouldHave(Condition.exactValue(input));
        LOGGER.info("в поле '{}' введено '{}'", fieldName, input);
    }

    /**
     * проверить, что в тексте xpath счетчика корзины (в шапке страницы) определенное кол-во товаров
     * (т.е. на иконке корзины эта цифра).
     * Но не ноль! для этого есть отдельный шаг
     * @param amount кол-во товаров
     */
    @И("в корзине в шапке страницы {string} товаров")
    public void productsInCart(String amount) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement("корзина в шапке страницы с товарами")
                .shouldHave(Condition.exactText(amount));
        LOGGER.info("в корзине в шапке страницы '{}' товаров", amount);
    }

    @Тогда("в корзине в шапке страницы нет товаров")
    public void noProductsInCart() {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement("корзина в шапке страницы с товарами");
        WebChecks.elementAbsentOnPage(element, null);
        LOGGER.info("в корзине в шапке страницы нет товаров");
    }

    /**
     * проверить, что в тексте xpath счетчика корзины (в шапке страницы) какое-то (неважно) кол-во товаров
     * (т.е. на иконке корзины есть какая-то цифра).
     */
    @И("в корзине в шапке страницы есть товары")
    public void SomeProductsInCart() {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement("корзина в шапке страницы с товарами");
        WebChecks.elementVisibleOnPage(element, null);
        LOGGER.info("в корзине в шапке страницы есть некоторое количество товаров");
    }

    /**
     * проверить, что в тексте xpath счетчика избранного (в шапке страницы) определенное кол-во товаров
     * (т.е. на иконке избранного эта цифра).
     * Но не ноль! для этого есть отдельный шаг
     * @param amount кол-во товаров
     */
    @И("в избранном в шапке страницы {string} товаров")
    public void productsInWishlist(String amount) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement("избранное в шапке страницы с товарами")
                .shouldHave(Condition.exactText(amount));
        LOGGER.info("в избранном в шапке страницы '{}' товаров", amount);
    }

    @Тогда("в избранном в шапке страницы нет товаров")
    public void noProductsInWishlist() {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement("избранное в шапке страницы с товарами");
        WebChecks.elementAbsentOnPage(element, null);
        LOGGER.info("в избранном в шапке страницы нет товаров");
    }

    /**
     * проверить, что в тексте xpath счетчика избранного (в шапке страницы) какое-то (неважно) кол-во товаров
     * (т.е. на иконке избранного есть какая-то цифра).
     */
    @И("в избранном в шапке страницы есть товары")
    public void someProductsInWishlist() {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement("избранное в шапке страницы с товарами");
        WebChecks.elementVisibleOnPage(element, null);
        LOGGER.info("в избранном в шапке страницы есть некоторое количество товаров");
    }

    /**
     * спец. метод для проверки кол-ва данного товара в корзине,
     * когда мы находимся на странице этого товара.
     * это цифра между кнопками + и -
     * @param amount - кол-во товара
     */
    @Тогда("на странице товара количество этого товара в корзине: {string} шт")
    public void amountOfProductInCart(String amount) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement("поле 'Количество единиц товара'")
                .shouldHave(Condition.exactText(amount));
        LOGGER.info("Товар на этой странице находится в корзине в кол-ве '{}' штук", amount);
    }
}
