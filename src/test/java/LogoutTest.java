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
 * Класс тестирования выхода из ЛК
 */
@RunWith(Parameterized.class)
public class LogoutTest {

    private final String URL = "https://stellarburgers.nomoreparties.site/";
    private final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/";
    private final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

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

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver(browser);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        driver.get(URL);
    }

    /**
     * Конструктор
     *
     * @param browser Браузер
     */
    public LogoutTest(String browser) {
        this.browser = browser;
    }

    @Test
    @Description("Баг. Тестирование выхода из аккаунта по кнопке «Выйти» в личном кабинете")
    public void testExitButton() {
        registrationPage.clickLoginAccountButton();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.submitLogin();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
        loginPage.clickPersonalCabinetButton();
        assertEquals(PROFILE_URL, driver.getCurrentUrl());
        // Клик по кнопке "Выход"
        loginPage.clickExit();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
