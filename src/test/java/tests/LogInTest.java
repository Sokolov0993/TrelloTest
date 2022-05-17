package tests;
import Model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;

public class LogInTest extends BaseTest {
    @Test
    public void LogInTest() throws InterruptedException {
        testLoginPage.login(new User());
        Assert.assertTrue(testLoginPage.getInputPassword().isDisplayed(), "User logging failed");
    }

}
