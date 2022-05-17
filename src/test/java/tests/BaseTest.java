package tests;

import Model.User;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BoardPage;
import pages.LogInPage;
import pages.MainPage;

public class BaseTest {

    public static String MAIN_URL = "https://trello.com/login";

    protected WebDriver driver;
    LogInPage testLoginPage = new LogInPage();
    BoardPage testBoardPage = new BoardPage();
    MainPage testMainPage = new MainPage();



    @BeforeMethod()
    public void setup() throws InterruptedException {
        driver = DriverSingleton.getDriver();
        driver.get(MAIN_URL);
        LogInPage logInPage = new LogInPage();
        logInPage.login(new User());

    }
    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
