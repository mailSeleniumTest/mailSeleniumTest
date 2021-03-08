import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    WebDriver driver;
    WebDriverWait wait;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Элементы управления
    //private By title = driver.getTitle(); //Заголовок окна
    private By txtLinkModal = By.xpath("//span[contains(text(),'mailSelenium')]"); //Текстовая ссылка с логином
    private By mdlMenu = By.xpath("//div[contains(@class,'light-popup')]"); //Открытое модальное окно
    private By mdlMenu2 = By.xpath("//ul[contains(@class,'menu')][1]"); //вуигп
    private By txtLinkMailBox = By.xpath("//li[@class='menu__list-item']/*/span[text()='Почта']"); //Ссылка на почту в модальном окне

    public ProfilePage openInbox(){
    wait = new WebDriverWait(driver, 5); //Настройка явного ожидания для модального окна
    driver.findElement(txtLinkModal).click();
    try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mdlMenu2));
    } catch (Exception e) {
        System.out.println("Ошибка поиска модального окна: " + e.fillInStackTrace());
    }
    driver.findElement(txtLinkMailBox).click();
        return this;
    }
}

