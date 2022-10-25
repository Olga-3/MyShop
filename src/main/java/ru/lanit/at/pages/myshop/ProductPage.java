package ru.lanit.at.pages.myshop;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "страница товара")
public class ProductPage extends WebPage {

    @Name("кнопка 'В корзину'")
    public SelenideElement authorizeButton = $x("//button[text()='В корзину']");

    @Name("кнопка 'Добавить в избранное'")
    public SelenideElement addToWishlist = $x("//button/img[@alt='Добавить в избранное']");

    @Name("кнопка 'Удалить из избранного'")
    public SelenideElement removeFromWishlist = $x("//button/img[@alt='Удалить из избранного']");

    @Name("поле 'Количество единиц товара'")
    public SelenideElement productsQuantity = $x("//div[@class='cart-quantity__num']");

    @Name("кнопка плюс")
    public SelenideElement buttonPlus = $x(" //button[@class='cart-quantity__btn']/*[@height='14']");

    @Name("кнопка минус")
    public SelenideElement buttonMinus = $x(" //button[@class='cart-quantity__btn']/*[@height='2']");

}