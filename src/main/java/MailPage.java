import com.assertthat.selenium_shutterbug.core.Shutterbug;
import cucumber.api.java.it.Ma;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage {
    WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    //Данные для проверки
    private String senderMailData = "Aleksandr True"; //Имя отправителя
    private String senderEmailAdressData = "alextrue1916@gmail.com"; //Почта отправителя
    private String subjectMailData = "Тема: «Почему возможна ирония?»"; //Тема отправленного письма

    //Первый абзац тела письма
    private String bodyMailData = "Герменевтика аккумулирует персональный синтаксис искусства. Инвариант изящно заканчивает фабульный каркас. Его экзистенциальная тоска выступает как побудительный мотив творчества, однако игровое начало постоянно. Действительно, художественная видимость заканчивает конструктивный сангвиник. Ф.Шилер, Г.Гете, Ф.Шлегели и А.Шлегели выразили типологическую антитезу классицизма и романтизма через противопоставление искусства \"наивного\" и \"сентиментального\", поэтому нивелирование индивидуальности представляет собой конструктивный художественный вкус. Выявляя устойчивые архетипы на примере художественного творчества, можно сказать, что адаптация продолжает неизменный канон биографии.";

    //Элементы управления
    private By senderMailName = By.xpath("//div[@class='mail-Message-Sender']/span"); //Получаем имя отправителя
    private By senderEmailAdress = By.xpath("//span[@class='mail-Message-Sender-Email mail-ui-HoverLink-Content']"); //Почта отправителя
    private By subjectMail = By.xpath("//span[@class='mail-Message-Toolbar-Subject-Wrapper']/*"); //Тема полученного письма
    private By bodyMail = By.xpath("//div[@class='js-message-body-content mail-Message-Body-Content']/div/*"); //Первый абзац текста письма

    //Методы проверки
    public void assertMailName() {  //Проверяем имя отправителя
        Assert.assertEquals(driver.findElement(senderMailName).getText(), senderMailData);
    }

    public void assertSanderEmailAdress(){ //Проверяем почту отправителя
        Assert.assertEquals(driver.findElement(senderEmailAdress).getText(), senderEmailAdressData);
    }

    public void assertSubjectMail(){ //Проверяем тему письма
            Assert.assertEquals(driver.findElement(subjectMail).getText(), subjectMailData);
    }

    public void assertBodyMail(){ //Проверяем первый абзац тела письма
        Assert.assertEquals(driver.findElement(bodyMail).getText(), bodyMailData);
    }
}

