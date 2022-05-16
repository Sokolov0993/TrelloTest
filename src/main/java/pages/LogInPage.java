package pages;

import Model.User;
import elementFactory.TextBox;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElementFactory.WebButton;

import java.time.Duration;

public class LogInPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private WebButton logInButton = new WebButton(("//button[@id='login-submit']"));
    private WebButton googleButton = new WebButton("//button[@id='google-auth-button']");
    private WebElement inputLogin = driver.findElement(By.xpath("//input[@id='user']"));
    private TextBox inputLoginBox = new TextBox(inputLogin);
    private WebButton atlassianButton = new WebButton("//input[@id='login']");
    private WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
    private TextBox inputPasswordBox = new TextBox(inputPassword);

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebButton getGoogleButton() {
        return googleButton;
    }

    public LogInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    @Override
    public LogInPage openPage() {
        return this;
    }

    public MainPage login(User user) throws InterruptedException {
        inputLoginBox.sendKeys(user.getEMAIL());
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='login']")));
        atlassianButton.click();
        inputPasswordBox.sendKeys(user.getPASSWORD());
        logInButton.click();
        logger.info("User " + user.getEMAIL() + " has logged ");

        return new MainPage(driver);
    }
}
