package org.chaoswarlock.sprint4.tests;

import org.chaoswarlock.sprint4.pages.PageHome;
import org.junit.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.chaoswarlock.sprint4.test_data.TestFAQPanelsData.*;
import static org.chaoswarlock.sprint4.page_object.CommonData.*;

@RunWith(Parameterized.class)
public class TestFAQPanels {
    @Parameterized.Parameters
    public static Object[][] ReturnData() {
        Object[][] data = new Object[6][];
        for (int i = 0; i < 6; i++) {
            data[i] = new Object[]{i, panelTexts[i], true};
        }
        return data;
    }
    static WebDriver driver;

    int i;
    boolean b;
    String checkedString;

    public TestFAQPanels(int i, String checkedString, boolean b) {
        this.i = i;
        this.b = b;
        this.checkedString = checkedString;
    }

    @BeforeClass
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(cookie_button).click();
    }
    @Test
    public void test() {
        PageHome homePage = new PageHome(driver, i);
        homePage.clickPanel();
        boolean result = checkedString.equals(homePage.GetPanelText());
        Assert.assertEquals(b, result);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}