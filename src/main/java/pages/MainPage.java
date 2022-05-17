package pages;

import webelementfactory.WebButton;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends AbstractPage {
    public final String PAGE_URL = "https://trello.com/userbedc9748f889f7b0630c2ac1d342812d/boards";
    private final Logger logger = LogManager.getLogger(MainPage.class);
    private WebButton header= new WebButton("//div[@id='header']");
    private WebButton createBoardButton = new WebButton("//span[text()='Create new board']");
    private WebButton confirmCreatingButton = new WebButton("//button[text()='Create']");



    @Override
    public MainPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("main page was opened");
        return this;
    }

    public boolean isHeaderVisible() {
        logger.info("checking if header is displayed");
        return header.isDisplayed();
    }
    public BoardPage createBoard(String BoardName) throws InterruptedException {
        createBoardButton.click();
        WebElement nameOfBoardField = driver.findElement(By.xpath("//input[@type='text']"));
        nameOfBoardField.sendKeys(BoardName);
        confirmCreatingButton.click();
        return new BoardPage();
    }
    public List<WebElement> getCurrentListOfBoards(){
        return driver.findElements(By.xpath("//h3[text()='YOUR WORKSPACES']/following::div[text()='new board']"));
    }
}

