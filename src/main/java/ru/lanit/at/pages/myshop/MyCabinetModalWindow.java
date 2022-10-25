package ru.lanit.at.pages.myshop;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "модальное окно ЛК")
public class MyCabinetModalWindow extends WebPage {

    @Name("заголовок 'Мой кабинет' в модальном окне ЛК")
    public SelenideElement HeaderMyCabinet = $x("//div[@class='md-header']/div/span[contains(text(),'Мой кабинет')]");

    @Name("ссылка 'Выход' в модальном окне ЛК")
    public SelenideElement ExitMyCabinet = $x("//a[contains(@href,'/my/exit') and @class='link']/span[text()='Выход']");

    @Name("ссылка 'Заказы' в модальном окне ЛК")
    public SelenideElement MyOrders = $x("//a[contains(@href,'/my/orders') and @class='link']/span[text()='Заказы']");

    @Name("ссылка 'Лист ожидания' в модальном окне ЛК")
    public SelenideElement MyWaitlist = $x("//a[contains(@href,'/my/waitlist') and @class='link']/span[text()='Лист ожидания']");

    //внимание: в xpath в слове "Скидки" английская C (так в коде страницы), иначе не находит
    @Name("ссылка 'Скидки' в модальном окне ЛК")
    public SelenideElement MyDiscounts = $x("//a[contains(@href,'/my/discounts') and @class='link']/span[text()='Cкидки']");

    @Name("ссылка 'Баланс' в модальном окне ЛК")
    public SelenideElement MyAccount = $x("//a[contains(@href,'/my/account') and @class='link']/span[text()='Баланс']");

    @Name("ссылка 'Настройки' в модальном окне ЛК")
    public SelenideElement MyOptions = $x("//a[contains(@href,'/my/options') and @class='link']/span[text()='Настройки']");

    @Name("ссылка 'Рассылки' в модальном окне ЛК")
    public SelenideElement MySubscriptions = $x("//a[contains(@href,'/my/subscriptions') and @class='link']/span[text()='Рассылки']");

    @Name("ссылка 'Партнерская программа' в модальном окне ЛК")
    public SelenideElement MyPartnership = $x("//a[contains(@href,'/my/ps') and @class='link']/span[text()='Партнёрская программа']");
}