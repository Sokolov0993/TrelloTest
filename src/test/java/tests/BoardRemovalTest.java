package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.MainPage;

public class BoardRemovalTest extends BaseTest {
    @Test
    public void BoardRemovalTest() throws InterruptedException {
        int boardsAmountBeforeRemoval= testMainPage.getCurrentListOfBoards().size();
        testBoardPage.deleteBoard("new board");
        int boardsAmountAfterRemoval= testMainPage.getCurrentListOfBoards().size();
        Assert.assertTrue(boardsAmountBeforeRemoval==boardsAmountAfterRemoval+1, "The board wasn't delete properly");
    }
}

