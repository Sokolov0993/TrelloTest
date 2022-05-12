package pages;

import Model.User;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(id= "login-submit")
    private WebElement logInButton;
    @FindBy(id= "google-auth-button")
    private WebElement googleButton;
    @FindBy(id = "user")
    private WebElement inputLogin;

    @FindBy(id = "login")
    private WebElement atlassianButton;

    @FindBy(name = "password")
    private  WebElement inputPassword;

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getGoogleButton() {
        return googleButton;
    }

    public LogInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LogInPage openPage() {
        return this;
    }
    public MainPage login(User user) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        inputLogin.sendKeys(user.getEMAIL());
        atlassianButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(googleButton));
        inputPassword.sendKeys(user.getPASSWORD());
        logInButton.click();
        logger.info("User "+user.getEMAIL() +" has logged ");
        return new MainPage(driver);
    }
}
