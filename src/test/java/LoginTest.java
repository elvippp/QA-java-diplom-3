import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/**
 * Класс тестирования Логина
 */
@RunWith(Parameterized.class)
public class LoginTest {

    /**
     * Веб-драйвер
     */
    private WebDriver driver;

    /**
     * Тип Браузера
     */
    private String browser;

    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private final String URL = "https://stellarburgers.nomoreparties.site/";
    private final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }

    /**
     * Конструктор
     *
     * @param browser Браузер
     */
    public LoginTest(String browser) {
        this.browser = browser;
    }

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver(browser);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        driver.get(URL);
    }

    @Test
    @Description("Тестирование входа по кнопке 'Войти в аккаунт' на главной странице")
    public void testLoginViaLoginAccountButton() {
        registrationPage.clickLoginAccountButton();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.submitLogin();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Тестирование входа через кнопку 'Личный кабинет'")
    public void testLoginViaPersonalCabinetButton() {
        loginPage.clickPersonalCabinetButton();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.submitLogin();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Тестирование входа через кнопку в форме регистрации")
    public void testLoginViaRegisterFormButton() {
        registrationPage.clickLoginAccountButton();
        registrationPage.scrollToRegisterButton();
        registrationPage.clickRegisterButton();
        loginPage.clickRegisterLoginButton();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.submitLogin();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Тестирование входа через кнопку в форме восстановления пароля")
    public void testLoginViaForgotPasswordButton() {
        registrationPage.clickLoginAccountButton();
        registrationPage.scrollToRegisterButton();
        loginPage.clickRestorePasswordButton();
        loginPage.clickLoginButtonInRestorePasswordPage();
        loginPage.waitForEmailInput();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.submitLogin();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
