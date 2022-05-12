package tests;
import Model.User;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Model;
import pages.LogInPage;
import pages.MainPage;

import java.time.Duration;

public class LogInTest extends Constants {
    @Test
    public void LogInAbility() throws InterruptedException {
        LogInPage testLoginPage = new LogInPage(driver);

        testLoginPage.login(new User());
        Assert.assertTrue(testLoginPage.getInputPassword().isEnabled(), "User logged successfully");
    }

}
