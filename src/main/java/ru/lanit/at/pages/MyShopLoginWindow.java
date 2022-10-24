package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "форма авторизации и регистрации")
public class MyShopLoginWindow extends WebPage {

//    Элементы вкладки авторизации:

    @Name("вкладка 'Вход'")
    public SelenideElement authorizeButton = $x("//div[text()='Вход']");

    @Name("вкладка 'Регистрация'")
    public SelenideElement registerButton = $x("//div[text()='Регистрация']");

//чет как-то не находит что активную (active) что неактивную одинаково (а в консоли находит, но не различает)

    @Name("активная вкладка 'Вход'")
    public SelenideElement authorizeButtonActive = $x("//div[contains(@class, 'app-auth__tab active') and text() = 'Вход']");

    @Name("неактивная вкладка 'Вход'")
    public SelenideElement authorizeButtonInactive = $x("//div[contains(@class, 'app-auth__tab') and text() = 'Вход']");

    @Name("активная вкладка 'Регистрация'")
    public SelenideElement registerButtonActive = $x("//div[contains(@class, 'app-auth__tab active') and text() = 'Регистрация']");

    @Name("неактивная вкладка 'Регистрация'")
    public SelenideElement registerButtonInactive = $x("//div[contains(@class, 'app-auth__tab') and text() = 'Регистрация']");

    @Name("заголовок 'Вход и регистрация'")
    public SelenideElement HeaderMyCabinet = $x("//div[@class='popup-modal__window__header']/*[contains(text(),'Вход и регистрация')]");

    //    @Name("обязательное поле 'Телефон'")
    // это поле в форме авторизации
    @Name("Телефон")
    public SelenideElement fieldPhone = $x("//label[text()='Телефон']/ancestor::div[@class='field']/div/input[@id='inputText']");
//    public SelenideElement fieldPhone = $x("//div[@class='field']/div/label[contains(@class, 'required') and text() = 'Телефон']");
//проверка, что активно и макс.кол-во символов://input[(@type='tel') and (@autocomplete='on') and (@maxlength='18')]");
//проверка, что поле и текст Телефон://div[@class='field']/div/label[contains(text(),'Телефон')]
//проверка, что поле, текст Телефон и обязат.://div[@class='field']/div/label[contains(@class, 'required') and text() = 'Телефон']

    @Name("кнопка 'Войти по паролю'")
    public SelenideElement loginWithPass = $x("//span[text()='Войти по паролю']");

    @Name("поле 'Почта'")
    public SelenideElement fieldEmail = $x("//input[@id='email']");
//+проверка ярлыка: //input[@id='email']//following-sibling::*[text()='Почта']
//+проверка обязательности: //input[@id='email']//following-sibling::*[contains(@class,'required_CV9+Y label_mZPLM') and text()='Почта']

    @Name("поле 'Пароль'")
    public SelenideElement fieldPass = $x("//input[@id='pass']");
//+проверка ярлыка: //input[@id='pass']//following-sibling::*[text()='Пароль']
//+проверка обязательности: //input[@id='pass']//following-sibling::*[contains(@class,'required_Mdpun label_lxKDO') and text()='Пароль']

    @Name("кнопка 'Войти'")
    public SelenideElement loginButton = $x("//button/span[text()='Войти']");

    @Name("пустой чекбокс 'Показать пароль'")
    public SelenideElement checkboxShowPassDisabled = $x("//div[@class='checkbox']//following-sibling::div/*[text()='Показать пароль']");

    @Name("выбранный чекбокс 'Показать пароль'")
    public SelenideElement checkboxShowPassEnabled = $x("//div[@class='checkbox checked']//following-sibling::div/*[text()='Показать пароль']");

    @Name("кнопка 'Восстановить пароль'")
    public SelenideElement resetPass = $x("//button/span[text()='Восстановить пароль']");

    @Name("чекбокс согласия на обработку данных")
    public SelenideElement checkboxPersonalData = $x("//div[contains(@class, 'personal_data')]/label[@class='checkbox']");

    @Name("ссылка на политику конфиденциальности")
    public SelenideElement checkboxPersonal = $x("//a[contains(@href,'/help/109.html') and text()='Политикой конфиденциальности']");

    @Name("ошибка 'Логин или пароль введены неправильно'")
    public SelenideElement errorMessage = $x("//div[@class='error_fpQnP']/span[text()='Логин или пароль введены неправильно']");

//    Элементы вкладки регистрации:
    @Name("поле 'Почта' для регистрации")
    public SelenideElement emailField = $x("//label[text()='Почта']/ancestor::div[@class='field']/div/input[@id='client_3']");

    @Name("поле 'Имя' для регистрации")
    public SelenideElement nameField = $x("//label[text()='Имя']/ancestor::div[@class='field']/div/input[@id='client_6']");

    @Name("поле 'Фамилия' для регистрации")
    public SelenideElement surnameField = $x("//label[text()='Фамилия']/ancestor::div[@class='field']/div/input[@id='client_5']");

    @Name("кнопка 'Подтвердить телефон и войти'")
    public SelenideElement verifyPhoneNumberButton = $x("//button/span[text()='Подтвердить телефон и войти']");

    @Name("поле 'Код подтверждения'")
    public SelenideElement fieldForCode = $x("//label[text()='Код подтверждения']/ancestor::div[@class='field']/div/input[@id='sms']");

//    @Name("кнопка 'Войти'")
//    public SelenideElement buttonVerifyPhone = $x("//button/span[text()='Войти']");

}