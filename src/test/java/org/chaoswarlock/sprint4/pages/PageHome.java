package org.chaoswarlock.sprint4.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.chaoswarlock.sprint4.page_object.HomePage.*;

import java.time.Duration;

public class PageHome {
    private WebDriver driver;
    WebDriverWait wait;
    int panelNumber;

    public PageHome(WebDriver driver, int panelNumber) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        this.panelNumber = panelNumber;
    }
    public void clickPanel()
    {
        WebElement we= driver.findElement(getByAccordionHeading(panelNumber));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', inline: 'nearest'});",we);
        wait.until(ExpectedConditions.elementToBeClickable(getByAccordionHeading(panelNumber))).click();
    }
    //Проверяет раскрылась панель и скролит до раскрытой панели.
    public Boolean isPanelOpened()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByAccordionPanel(panelNumber)));
        return driver.findElement(getByAccordionPanel(panelNumber)).isDisplayed();
    }
    public String GetPanelText()
    {
        if (isPanelOpened())
        {
            return driver.findElement(getByAccordionPanel(panelNumber)).findElement(text).getText();
        }
        return "";
    }
}
