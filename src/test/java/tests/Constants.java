package tests;

import Model.User;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LogInPage;

public class Constants {

    public static String MAIN_URL = "https://trello.com/login";

    protected WebDriver driver;


    @BeforeMethod()
    public void setup() throws InterruptedException {
        driver = DriverSingleton.getDriver();
        driver.get(MAIN_URL);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.login(new User());

    }
    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
