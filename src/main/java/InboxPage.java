import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InboxPage {
    WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }
    //Элементы управления
    private By mailMessagesList = By.xpath("//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']/div"); //Список писем в ящике входящие


    public InboxPage openMail() { //Выбираем письмо по номеру строки
        List<WebElement> mailRows = driver.findElements(mailMessagesList);
        try {
            mailRows.get(0).click();
        } catch (Exception e) {
            System.out.println("Ошибка выбора письма из списка: " + e);
            // Добавить скриншот
        }
        return this;
    }
}

