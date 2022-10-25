package ru.lanit.at.steps.web;

import com.codeborne.selenide.*;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.lanit.at.actions.WebActions;
import ru.lanit.at.utils.DataGenerator;
import ru.lanit.at.utils.Sleep;
import ru.lanit.at.utils.selenide.DriverManager;
import ru.lanit.at.utils.web.pagecontext.Environment;
import ru.lanit.at.utils.web.pagecontext.PageManager;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static ru.lanit.at.utils.VariableUtil.replaceVars;


public class WebActionWebSteps extends AbstractWebSteps {

    private final Logger LOGGER = LoggerFactory.getLogger(WindowWebSteps.class);

    public WebActionWebSteps(PageManager pageManager) {
        super(pageManager);
    }



    /**
     * нажимает на элемент по тексту
     *
     * @param text текст элемента
     */
    @Когда("кликнуть на элемент по тексту {string}")
    public void clickElementWithText(String text) {
        $(Selectors.byText(text))
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент по тексту '{}'", text);
    }

    @Если("кликнуть на элемент {string}")
    public void clickOnElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
        LOGGER.info("клик на элемент '{}'", elementName);
    }

    @Если("установить чекбокс на элементе {string}")
    public void selectCheckboxOnElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.enabled, Duration.ofSeconds(60));
        WebActions.setCheckBox(element, true);
        LOGGER.info("чекбокс  установлен на элементе '{}'", elementName);
    }

    @Если("убрать чекбокс на элементе {string}")
    public void unselectCheckboxOnElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.enabled, Duration.ofSeconds(60));
        WebActions.setCheckBox(element, false);
        LOGGER.info("чекбокс снят на элементе '{}'", elementName);
    }


    /**
     * скролл до элемента
     *
     * @param elementName наименование элемента
     */
    @Когда("проскроллить страницу до элемента {string}")
    public void scrollToElement(String elementName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до элемента '{}'", elementName);
    }

    /**
     * скролл до текста
     *
     * @param text текст
     */
    @Когда("проскроллить страницу до текста {string}")
    public void scrollToText(String text) {
        SelenideElement element = $(Selectors.byText(text));
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до текста '{}'", text);
    }

    @И("подождать {int} сек")
    public void waitSeconds(int timeout) {
        Sleep.pauseSec(timeout);
    }

    /**
     * Ввод значения в элемент
     *
     * @param field - наименование элемента
     * @param value - значение
     */
    @Когда("ввести в поле {string} значение {string}")
    public void fillTheField(String field, String value) {
        value = replaceVars(value, getStorage());
        SelenideElement fieldElement = pageManager
                .getCurrentPage()
                .getElement(field);
        fieldElement
                //.shouldBe(Condition.visible) - можно просто так вместо строки ниже:
                .shouldBe(Condition.visible, Duration.ofSeconds(60))
                .setValue(value);
        LOGGER.info("в поле '{}' введено значение '{}'", field, value);
    }

    /**
     * Сохранить  значения из элемент
     *
     * @param field - наименование элемента
     * @param key   - значение
     */
    @Когда("сохранить значение из поля {string} под именем {string}")
    public void saveTextField(String field, String key) {
        SelenideElement fieldElement = pageManager
                .getCurrentPage()
                .getElement(field);
        String elementValue = fieldElement
                .shouldBe(Condition.visible, Duration.ofSeconds(60))
                .getValue();
        saveValueInStorage(key, elementValue);
        LOGGER.info("значение '{}' сохранено под именем '{}'", elementValue, key);
    }


    /**
     * Очистка поля
     *
     * @param elementName наименование элемента
     */
    @Если("очистить поле {string}")
    public void clearField(String elementName) {
        pageManager
                .getCurrentPage()
                .getElement(elementName)
                .shouldBe(Condition.visible)
                .clear();
    }


    /**
     * открывает главную страницу сайта my-shop.ru
     */
    @Если("открыть сайт my-shop.ru")
    public void openMyShopUrl() {
        DriverManager.startDriver();
        Selenide.open("https://my-shop.ru/");
    }

    /**
     * этот шаг для экономии времени включает в себя 7 шагов:
     * инициализировать страницу: шапка и подвал сайта, кликнуть на элемент "ссылка 'Вход'",
     * кликнуть на элемент "кнопка 'Войти по паролю'", ввести в поле "поле 'Почта'" значение "...",
     * ввести в поле "поле 'Пароль'" значение "...", кликнуть на элемент "кнопка 'Войти'"
     *
     * @param login почта
     * @param pass  пароль
     */
    @Если("авторизоваться с логином {string} и паролем {string}")
    public void logIn(String login, String pass) {
        WebPage page = Environment.getPage("шапка и подвал сайта");
        pageManager.setCurrentPage(page);
        LOGGER.info("инициализирована страница: шапка и подвал сайта");
        clickOnElement("ссылка 'Вход'");
        page = Environment.getPage("форма авторизации и регистрации");
        pageManager.setCurrentPage(page);
        LOGGER.info("инициализирована страница: форма авторизации и регистрации");
        clickOnElement("кнопка 'Войти по паролю'");
        fillTheField("поле 'Почта'", login);
        fillTheField("поле 'Пароль'", pass);
        clickOnElement("кнопка 'Войти'");
    }

    /**
     * Генерирует набор английских букв и цифр по маске
     * и добавляет "@mail.ru"
     * <br/> D - цифра
     * <br/> W - английская буква
     *
     * @return - рандомный email в 38 знаков
     */
    @Если("сгенерировать почту")
    public static String generateEmail() {
        DataGenerator dataGenerator = new DataGenerator();
        String generated = dataGenerator.generateValueByMask("EEDEDEDEDEDEDEDEDEDEDEDDEDEDEDE");
        String readyEmail = generated + "@test.ru";
//        LOGGER.info("Generated e-mail: " + readyEmail);
        return readyEmail;
    }

    /**
     * использует метод для генерации email
     * вводит в поле Почта (или другое указанное) сгенерированный email
     * @param element - название поля, куда ввести email
     */
    @И("ввести в поле {string} сгенерированный email")
    public void inputGeneratedEmail(String element) {
        String email = generateEmail();
        fillTheField(element, email);
        LOGGER.info("Generated e-mail: " + email);
    }

    @Если("на странице товара изменить количество этого товара в корзине на {string} шт")
    public void setAmountOfProductInCart(String amount) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement("поле 'Количество единиц товара'")
                .setValue(amount);
        LOGGER.info("Товар на этой странице добавлен в корзину в кол-ве '{}' штук", amount);
    }
}
