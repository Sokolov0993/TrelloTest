package pages;

import webElementFactory.WebButton;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage extends AbstractPage {
    public final String PAGE_URL = "https://trello.com/userbedc9748f889f7b0630c2ac1d342812d/boards";
    private final Logger logger = LogManager.getLogger(MainPage.class);
    private WebButton header= new WebButton("//div[@id='header']");
    private WebButton createBoardButton = new WebButton("//span[text()='Create new board']");
    private WebButton confirmCreatingButton = new WebButton("//button[text()='Create']");


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("main page was opened");
        return this;
    }

    public boolean IsHeaderVisible() {
        logger.info("checking if header is displayed");
        return header.isDisplayed();
    }
    public BoardPage createBoard(String nameOfBoard) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        createBoardButton.click();
        WebElement nameOfBoardField = driver.findElement(By.xpath("/html/body/div[3]/div/section/div/form/div[1]/label/input"));
        nameOfBoardField.sendKeys(nameOfBoard);
        confirmCreatingButton.click();
        return new BoardPage(driver);
    }
}

