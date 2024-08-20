package org.chaoswarlock.sprint4.page_object;

import org.openqa.selenium.By;

//Локаторы относящиеся ко второму тесту. Возможно следовало бы сделать еще один уровень структуры.
public class OrderFormation {
    //Кнопка заказать сверху
    public static By buttonUpperOrder = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    //Кнопка заказать снизу
    public static By buttonBottomOrder = By.cssSelector(".Home_RoadMap__2tal_ .Button_Button__ra12g");

    //Локаторы относящиеся к первой панели

    //Локатор по имени
    public static By nameInput = By.xpath("(//input[@placeholder='* Имя'])[1]");
    //Локатор по фамилии
    public static By surnameInput = By.xpath("//input[@placeholder='* Фамилия']");
    //Локатор по адресу
    public static By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор по станции метро
    public static By metroStationInput = By.xpath("//input[@placeholder='* Станция метро']");
    //Локатор по телефону
    public static By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //"лемент в выпадающем списке метро
    public static By metroInList(String metro) {
        String xpath = String.format(".//div[@class='select-search__select']//div[@class='Order_Text__2broi'][contains(text(), '%s')]", metro);
        return By.xpath(xpath);
    }
    //Кнопка "Далее"
    public static By buttonNext = By.xpath("//button[contains(text(), 'Далее')]");
    //Локаторы относящиеся ко второй панели

    //Локатор даты
    public static By dateInput = By.xpath("//input[@placeholder= '* Когда привезти самокат']");
    //Локатор продолжительности аренды
    public static By rentalDurationInput = By.cssSelector(".Dropdown-root");
    //Локатор серого цвета
    public static By greyCheckbox = By.xpath("//label[@for='grey']");
    //Локатор чёрного цвета
    public static By blackCheckbox = By.xpath("//label[@for='black']");
    //Локатор комментария
    public static By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    public static By buttonOrder = By.cssSelector(".Order_Buttons__1xGrp > .Button_Middle__1CSJM:nth-child(2)");
    //Всплывающее окно подтверждения
    //Кнопка Да
    public static By buttonYes = By.cssSelector(".Order_Modal__YZ-d3 > .Order_Buttons__1xGrp > .Button_Middle__1CSJM:nth-child(2)");
    //Кнопка просмотра заказа
    public static By buttonOrderInfoPage = By.cssSelector(".Order_NextButton__1_rCA >.Button_Middle__1CSJM");

    //Локатор количество дня
    public static By rentDays(String days) {
        String xpath = String.format("//*[contains(text(), '%s')]", days);
        return By.xpath(xpath);
    }
}
