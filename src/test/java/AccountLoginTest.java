import PageObjects.LoginPage;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/**
 * Класс тестирования Личного кабинета
 */
@RunWith(Parameterized.class)
public class AccountLoginTest {

    /**
     * Веб-драйвер
     */
    private WebDriver driver;

    /**
     * Тип Браузера
     */
    private String browser;

    private LoginPage loginPage;
    private final String URL = "https://stellarburgers.nomoreparties.site/";
    private final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/";
    private final String LOGIN_URL2 = "https://stellarburgers.nomoreparties.site/account/profile";

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
        loginPage = new LoginPage(driver);
        driver.get(URL);
    }

    /**
     * Конструктор
     *
     * @param browser Браузер
     */
    public AccountLoginTest(String browser) {
        this.browser = browser;
    }

    @Test
    @Description("Баг. Тестирование перехода в личный кабинет по клику на «Личный кабинет»")
    public void testLoginViaButtonPersonalCabinetIntoPersonalCabinet() {
        loginPage.clickPersonalCabinetButton();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.submitLogin();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
        loginPage.clickPersonalCabinetButton();
        assertEquals(LOGIN_URL2, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
