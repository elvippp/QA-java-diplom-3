## Задание 3: веб-приложение

**Что нужно сделать**
1. Опиши элементы, которые будешь использовать в тестах, с помощью Page Object.
2. Протестируй функциональность в Google Chrome и Яндекс.Браузере. Про кроссбраузерные тесты рассказывали на вебинаре. Чтобы вспомнить основное, загляни в шпаргалку.
3. Подключи Allure-отчёт.

**Регистрация**

Проверь:

1. Успешную регистрацию.
2. Ошибку для некорректного пароля. Минимальный пароль — шесть символов.

**Вход** 

Проверь:

1. вход по кнопке «Войти в аккаунт» на главной,
2. вход через кнопку «Личный кабинет»,
3. вход через кнопку в форме регистрации,
4. вход через кнопку в форме восстановления пароля.

**Переход в личный кабинет**
1. Проверь переход по клику на «Личный кабинет».

**Переход из личного кабинета в конструктор**
1. Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.

**Выход из аккаунта**
1. Проверь выход по кнопке «Выйти» в личном кабинете.

**Раздел «Конструктор»**

Проверь, что работают переходы к разделам:

1. «Булки»,
2. «Соусы»,
3. «Начинки».

1. Тесты в test/java.
2. Для Page Object создан отдельный пакет.
3. Для каждой страницы создан отдельный класс с Page Object.
4. Тесты разделены по тематике или функциональности. Для тестов созданы отдельные классы.
5. В файле pom.xml нет ничего лишнего.
6. Все элементы страниц, которые ты используешь в тестах, описаны в Page Object.
7. Название класса Page Object отражает его содержимое.
8. Названия локаторов понятны.
9. Тесты запускаются и не падают.
10. Автотесты запускаются в обоих браузерах.
11. Для всех шагов автотестов должна быть использована аннотация @Step.
12. Названия тестов понятные и неизбыточные.
13. Тест — прежде всего проверка, а не набор действий. Каждый тест что-то проверяет.
14. Нужные тестовые данные создаются перед тестом и удаляются после того, как он выполнится.
15. Если для теста нужен тестовый юзер, он создаётся с помощью API.
16. Есть все тесты, которые описаны в задании.
17. Сделан Allure-отчёт. Отчёт добавлен в пул-реквест.
18. В проекте используется Java 11.
