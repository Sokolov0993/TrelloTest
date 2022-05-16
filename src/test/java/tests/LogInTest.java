package tests;
import Model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;

public class LogInTest extends BaseTest {
    @Test
    public void LogInAbility() throws InterruptedException {
        LogInPage testLoginPage = new LogInPage();
        testLoginPage.login(new User());
        Assert.assertTrue(testLoginPage.getInputPassword().isDisplayed(), "User logging failed");
    }

}
