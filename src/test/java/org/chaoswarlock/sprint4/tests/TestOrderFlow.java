package org.chaoswarlock.sprint4.tests;

import org.chaoswarlock.sprint4.pages.PageOrder;
import org.chaoswarlock.sprint4.pages.PageOrderInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import static org.chaoswarlock.sprint4.test_data.TestOrderFlowData.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestOrderFlow {
    @Parameterized.Parameters
    public static Object[][] ReturnData() {
        Object[][] data = new Object[inputData2.length][];
        for (int i = 0; i < inputData2.length; i++) {
            //Каждый второй тест мы отправляем черный самокат, каждый третий - вызываем тест через кнопку сверху.
            String colorSelector = i % 2 == 0 ? "чёрный жемчуг" : "серая безысходность";
            boolean upperOrBottom = i % 3 == 0 ? true : false;
            data[i] = new Object[]{inputData2[i],  colorSelector, upperOrBottom, true};
        }
        return data;
    }
    WebDriver driver;
    //IsExpected == true - тест позитивный, false - негативный.
    String[] inputTextData1;
    String[] inputTextData2;
    String color;
    boolean upperOrBottom;
    boolean isExpected;
    public TestOrderFlow(String[][] inputTextData, String color, boolean upperOrBottom, boolean isExpected) {
        inputTextData1 = inputTextData[0];
        inputTextData2 = inputTextData[1];
        this.color = color;
        this.upperOrBottom = upperOrBottom;
        this.isExpected = isExpected;
    }
    @Before
    public void setup() {

        String defaultDriver = "Firefox";

        switch (defaultDriver) {
            case "Firefox":
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
                break;
            case "Chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
        public void test() {
        driver.get("https://qa-scooter.praktikum-services.ru");

        PageOrder pageOrder = new PageOrder(driver);
        pageOrder.clickCookieButton();
        if (upperOrBottom) {
            pageOrder.clickUpperOrderButton();
        } else {
            pageOrder.clickBottomOrderButton();
        }
        pageOrder.firstPage.fillData(inputTextData1);
        pageOrder.firstPage.clickNext();
        pageOrder.secondPage.fillData(inputTextData2);
        pageOrder.secondPage.selectColor(color);
        pageOrder.secondPage.clickOrder();
        pageOrder.secondPage.clickOrderConfirm();
        pageOrder.secondPage.checkOrder();
        PageOrderInfo pageOrderInfo = new PageOrderInfo(driver);

        ///Сборка данных для сравнения. Мы не берем дату

        ArrayList<String> expectedData = new ArrayList<>();
        expectedData.addAll(Arrays.asList(inputTextData1));
        expectedData.add(inputTextData2[1]);
        expectedData.add(color);
        expectedData.add(inputTextData2[2]);

        ///Метод pageOrderInfo.checkEquals() сравнивает полученные данные с ожидаемыми данными за исключением даты и станции метро - потому что метро забагавано.
        assertEquals(isExpected, pageOrderInfo.checkEquals(expectedData));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
