package org.chaoswarlock.sprint4.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.chaoswarlock.sprint4.page_object.CommonData.*;
import static org.chaoswarlock.sprint4.page_object.OrderFormation.*;

public class PageOrder {
    WebDriver driver;
    WebDriverWait wait;
    public FirstPage firstPage;
    public SecondPage secondPage;

    public void clickUpperOrderButton(){
        clickElement(buttonUpperOrder);}
    public void clickBottomOrderButton(){
        clickElement(buttonBottomOrder);}

    public PageOrder(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        firstPage = new FirstPage();
        secondPage = new SecondPage();
    }
    public void clickCookieButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(cookie_button)).click();
    }
    abstract class Page
    {
        By[] bys;
        public void fillData(String[] strings)
        {
            for (int i = 0; i < bys.length; i++) {
                sendKeysToElement(bys[i],strings[i]);
            }
        }
    }
    //Класс реализует первый опрос
    public class FirstPage extends Page
    {
        public FirstPage(){
            super.bys = new By[]{nameInput, surnameInput, addressInput, metroStationInput,phoneInput};
        }
        public void clickNext()
        {
            clickElement(buttonNext);
        }
    }
    //Класс реализует второй опрос и подтверждение заказа
    public class SecondPage extends Page{
        public SecondPage(){
            super.bys = new By[]{dateInput,rentalDurationInput,commentInput};
        }
        public void selectColor(String color){
            switch (color){
                case "чёрный жемчуг":
                    clickElement(blackCheckbox);
                    break;
                case "серая безысходность":
                    clickElement(greyCheckbox);
                    break;
            }
        }
        public void clickOrder(){clickElement(buttonOrder);}
        public void clickOrderConfirm(){clickElement(buttonYes);}
        public void checkOrder(){clickElement(buttonOrderInfoPage);}
    }
    private void sendKeysToElement(By element,String keys)
    {
        if (element == rentalDurationInput)
        {
            clickElement(element);
            clickElement(rentDays(keys));
            return;
        }
        if(element == metroStationInput) {
            sendKeys(element, keys);
            clickElement(metroInList(keys));
            return;
        }
        if(element == dateInput)
        {
            sendKeys(element, keys);
            driver.findElement(element).sendKeys(Keys.ENTER);
            return;
        }
        clickElement(element);
        sendKeys(element, keys);
    }
    private void clickElement(By element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    private void sendKeys(By element, String keys)
    {
        driver.findElement(element).sendKeys(keys);
    }
}