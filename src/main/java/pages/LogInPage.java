package pages;

import Model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//a[text()='Log in']")
    private WebElement logInButton;

    @FindBy(id = "user")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    public LogInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LogInPage openPage() {
        return this;
    }
    public MainPage login(User user)
    {
        inputLogin.sendKeys(user.getEMAIL());
        inputPassword.sendKeys(user.getPASSWORD());
        logInButton.click();
        logger.info("User "+user.getEMAIL() +" has logged ");
        return new MainPage(driver);
    }
}
