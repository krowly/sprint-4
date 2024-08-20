package org.chaoswarlock.sprint4.page_object;

import org.openqa.selenium.By;

public class OrderPage {
    //Локаторы относящиеся к странице проверки заказа.
    //Локатор имени
    public static By nameInOrder = By.cssSelector(".Track_OrderInfo__2fpDL > .Track_Row__1sN1F:nth-child(1) > .Track_Value__15eEX");
    //Локатор фамилии
    public static By surNameInOrder = By.cssSelector(".Track_OrderInfo__2fpDL > .Track_Row__1sN1F:nth-child(2) > .Track_Value__15eEX");
    //Локатор адреса
    public static By addressInOrder = By.cssSelector(".Track_OrderInfo__2fpDL > .Track_Row__1sN1F:nth-child(3) > .Track_Value__15eEX");
    //Локатор станции метро - я получаю метро, но метро в заказе формируется не то, поэтому в функции сравнения оно удаляется.
    public static By metroInOrder = By.cssSelector(".Track_OrderInfo__2fpDL > .Track_Row__1sN1F:nth-child(4) > .Track_Value__15eEX");
    //Локатор телефона
    public static By phoneInOrder = By.cssSelector(".Track_OrderInfo__2fpDL > .Track_Row__1sN1F:nth-child(5) > .Track_Value__15eEX");
    //Локатор даты - не используется в тестах ибо мне лень.
    public static By dateInOrder = By.cssSelector(".Track_OrderInfo__2fpDL > .Track_Row__1sN1F:nth-child(6) > .Track_Value__15eEX");
    //Локатор продолжительности аренды
    public static By rentInOrder = By.cssSelector(".Track_OrderInfo__2fpDL > .Track_Row__1sN1F:nth-child(8) > .Track_Value__15eEX");
    //Локатор цвета
    public static By colorInOrder = By.cssSelector(".Track_OrderInfo__2fpDL > .Track_Row__1sN1F:nth-child(10) > .Track_Value__15eEX");
    //Локатор комментария
    public static By commentInOrder = By.cssSelector(".Track_OrderInfo__2fpDL > .Track_Row__1sN1F:nth-child(11) > .Track_Value__15eEX");
}
