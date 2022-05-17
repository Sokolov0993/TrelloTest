package pages;

import Model.User;
import elementfactory.TextBox;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import webelementfactory.WebButton;

public class LogInPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//button[@id='login-submit']")
    private WebButton logInButton;

    @FindBy(xpath = "//button[@id='google-auth-button']")
    private WebButton googleButton;

    @FindBy(xpath = "//input[@id='user']")
    private TextBox inputLoginBox;

    @FindBy(xpath = "//input[@id='login']")
    private WebButton atlassianButton;

    @FindBy(xpath = "//input[@name='password']")
    private TextBox inputPasswordBox;


    @Override
    public LogInPage openPage() {
        return this;
    }

    public TextBox getInputPassword() {
        return inputPasswordBox;
    }

    public WebButton getGoogleButton() {
        return googleButton;
    }

    public MainPage login(User user) throws InterruptedException {
        inputLoginBox.sendKeys(user.getEMAIL());
        atlassianButton.click();
        inputPasswordBox.sendKeys(user.getPASSWORD());
        logInButton.click();
        logger.info("User " + user.getEMAIL() + " has logged ");
        return new MainPage();
    }
}
