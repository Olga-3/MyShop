# language: ru
@MyShop
@Test

Функция: Проверить рег-ию юр.лица

  Предыстория: предыдущих действий не требуется

  Сценарий: Сгенерировать почту, сгенерировать ИНН и зарегистрировать аккаунт юр лица лица
# генерация ИНН для юр лица: https://1c-user.info/1-generator-inn-onlajn
    # или нужен шаг для генерации валидного ИНН

    Если открыть url "https://my-shop.ru/"
    И инициализировать страницу "шапка и подвал сайта"

  # ниже ВРЕМЕННЫЙ ШАГ, шаг будет удален из сценариев после 31.10 или по окончании розыгрыша подарков,
    # элемент "крестик для закрытия окна о розыгрыше" также будет удален.
    И кликнуть на элемент "крестик для закрытия окна о розыгрыше"

#    И инициализировать страницу: шапка и подвал сайта
    Тогда текущий url соответствует "https://my-shop.ru/"

    Если кликнуть на элемент "ссылка 'Вход'"
    И инициализация страницы "форма авторизации и регистрации"
#    И инициализировать страницу: форма авторизации и регистрации
    Тогда на странице отображается элемент "заголовок 'Вход и регистрация'"
    И кликнуть на элемент "вкладка 'Регистрация'"


