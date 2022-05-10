package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Constants {

    public static String MAIN_URL = "https://trello.com/login";

    protected WebDriver driver;


    @BeforeMethod()
    public void setup(){
        driver = DriverSingleton.getDriver();
    }
    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
