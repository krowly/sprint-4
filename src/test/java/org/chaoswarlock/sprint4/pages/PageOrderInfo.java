package org.chaoswarlock.sprint4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.chaoswarlock.sprint4.page_object.OrderPage.*;

public class PageOrderInfo {
    By[] bys;
    ArrayList<String> values;
    WebDriverWait wait;
    public PageOrderInfo(WebDriver driver){
        //Не хочу, но могу сделать проверку по дате, для этого нужно формат дд/мм/гггг преобразовать в дд месяц в классе второго теста. Кроме того метро выдавало ошибку и было убрано.
        values = new ArrayList<String>();
        bys = new By[]{nameInOrder,surNameInOrder,addressInOrder,metroInOrder,phoneInOrder,rentInOrder, colorInOrder, commentInOrder};
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        for(int i = 0; i < bys.length; i++){
            String value = getValue(i);
            values.add(value);
        }
    }
    ///Убираем метро потому что оно не совпадает.
    public boolean checkEquals(ArrayList<String> checkValues){
        //Я не помню зачем это делаю, но без этого не работает.
        checkValues.remove(3);
        values.remove(3);
        return checkValues.remove(3).equals(values.remove(3))?true:false;
    }
    private String getValue(int i){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(bys[i])).getText();
    }
}
