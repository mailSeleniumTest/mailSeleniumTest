import cucumber.api.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
}

    //Данные для авторизации
    private String login = "mailselenium@yandex.ru"; //Логин
    private String passwd = "89995164666"; //Пароль

    //Элементы страницы
    private By mainPageTitle = By.xpath("//title[1]"); //Заголовок окна
    private By inpUserName = By.xpath("//input[@name='login']"); //Поле input для логина
    private By inpPasswd = By.xpath("//input[@name='passwd']"); //Поле input для пароля
    private By btnSingIn = By.xpath("//button[@type='submit']"); //Кнопка "Войти" после ввода логина и пароля


    //Методы
    public MainPage typeLoginClickSingIn() { //Ввод логина
        driver.findElement(inpUserName).sendKeys(login); //Вводим логин
        driver.findElement(btnSingIn).click(); //Нажимаем кнопку "Войти"
    return this;
    }

    public MainPage typePasswdClickSingIn(){ //Ввод пароля
        driver.findElement(inpPasswd).sendKeys(passwd); //Вводим пароль
        driver.findElement(btnSingIn).click(); //Нажимаем кнопку "Войти"
    return this;
}



}
