package tests;
import Model.User;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Model;
import pages.BoardPage;
import pages.LogInPage;
import pages.MainPage;

import java.time.Duration;

public class CreatingBoardTest extends Constants {
    @Test
    public void CreatingNewBoardTest() throws InterruptedException {
        MainPage testMainPage = new MainPage(driver);
        BoardPage testBoardPage = new BoardPage(driver);
        Assert.assertTrue(testMainPage.createBoard("new board").getAddListButton().isDisplayed(), "Board is not created");
        testMainPage.openPage();
        testBoardPage.deleteBoard("new board");


    }

}

