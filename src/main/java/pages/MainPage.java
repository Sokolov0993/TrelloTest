package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    private final String PAGE_URL = "https://trello.com/userbedc9748f889f7b0630c2ac1d342812d/boards";
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(id = "//div[@id='header']")
    private WebElement header;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected MainPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("main page was opened");
        return this;
    }

    public boolean IsHeaderVisible() {
        logger.info("checking if header is displayed");
        return header.isDisplayed();
    }
}
