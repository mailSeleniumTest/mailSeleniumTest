import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MainClassTest {

    private WebDriver driver;
    private MainPage mainPage;
    private ProfilePage profilePage;
    private InboxPage inboxPage;
    private MailPage mailPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://passport.yandex.ru/");
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        inboxPage = new InboxPage(driver);
        mailPage = new MailPage(driver);
    }

    @Test
    public void mailWorkTest() {
        mainPage.typeLoginClickSingIn(); //Вводим логин
        mainPage.typePasswdClickSingIn(); //Вводим пароль
        profilePage.openInbox(); //Открываем почту
        inboxPage.openMail(); //Открываем письмо
        mailPage.assertMailName(); //Проверяем имя отправителя
        mailPage.assertSubjectMail(); //Проверяем тему письма
        mailPage.assertSanderEmailAdress(); //Проверяем почту отправителя
        mailPage.assertBodyMail(); //Проверяем первый абзац тела письма
    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
