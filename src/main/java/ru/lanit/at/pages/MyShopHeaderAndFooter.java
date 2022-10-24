package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "шапка и подвал сайта")
public class MyShopHeaderAndFooter extends WebPage {

    @Name("ссылка 'Вход'")
    public SelenideElement authorizeButton = $x("//span[text()='Вход']");

    @Name("ссылка 'Мой кабинет'")
    public SelenideElement linkMyCabinet = $x("//a/span[contains(text(),'Мой кабинет')]");

    @Name("ссылка 'Избранное'")
    public SelenideElement linkFavorite = $x("//a/span[contains(text(),'Избранное')]");

    @Name("избранное в шапке страницы с товарами")
    public SelenideElement wishlistInHeaderNotEmpty = $x("//a[@href='/my/cart?to=save']/div[@class='badge']");

    @Name("ссылка 'Корзина'")
    public SelenideElement linkCart = $x("//a/span[contains(text(),'Корзина')]");

    @Name("корзина в шапке страницы с товарами")
    public SelenideElement cartInHeaderNotEmpty = $x("//a[@href='/my/cart']/div[@class='badge']");

    @Name("Учебники для школы")
    public SelenideElement linkExerciseBooksForSchool = $x("//a[contains(text(),'Учебники для школы')]");

}