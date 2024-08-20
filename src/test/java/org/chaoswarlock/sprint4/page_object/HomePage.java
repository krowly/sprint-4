package org.chaoswarlock.sprint4.page_object;

import org.openqa.selenium.By;

//Локаторы относящиеся к первому тесту
public class HomePage {
    public static By text = By.tagName("p");
    //Локатор свернутого вопроса
    public static By getByAccordionHeading(int panelNumber) {
        String id1 = String.format("accordion__heading-%d", panelNumber);
        String xpath = String.format("//div[@id='%s']/parent::*/parent::*", id1);
        return By.xpath(xpath);
    }
    //Локатор ответа на вопрос
    public static By getByAccordionPanel(int panelNumber) {
        String id2 = String.format("accordion__panel-%d", panelNumber);
        return By.id(id2);
    }
}
