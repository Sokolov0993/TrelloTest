package pages;

import webElementFactory.WebButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BoardPage extends AbstractPage{
    public static final String TEXT_YOUR_WORKSPACES_FOLLOWING_DIV_TEXT_S = "//*[text()='YOUR WORKSPACES']/following::div[text()='%s']";
    private WebButton addListButton = new WebButton("//input[@value='Add list']");
    private WebButton showMenuButton = new WebButton("//span[text() = 'Show menu']");
    private WebButton moreButton = new WebButton( "//*[@id=\"content\"]/div/div[2]/div/div/div[2]/div/ul[1]/li[5]/a");
    private WebButton closeBoardButton= new WebButton("//a[@class='board-menu-navigation-item-link js-close-board']");
    private WebButton submitClosingBoard = new WebButton("//input[@class='js-confirm full nch-button nch-button--danger']");
    private WebButton deleteBoardButton = new WebButton("//button[@class='_3ZZkvSn-U9BxDK _3TTqkG5muwOzqZ _1Tu9wiuW4Te8Rx']");
    private WebButton confirmDeleteBoardButton = new WebButton("//button[text()='Delete']");


    public WebButton getAddListButton() {
        return addListButton;
    }

    @Override
    protected BoardPage openPage() {
        return null;
    }

public MainPage deleteBoard(String boardName){
       WebElement selectedBoard= driver.findElement(By.xpath(String.format("//h3[text()='YOUR WORKSPACES']/following::div[text()='%s']", boardName)));
       selectedBoard.click();
       showMenuButton.click();
       moreButton.click();
       closeBoardButton.click();
       submitClosingBoard.click();
       deleteBoardButton.click();
       confirmDeleteBoardButton.click();
        return new MainPage();
}
}
