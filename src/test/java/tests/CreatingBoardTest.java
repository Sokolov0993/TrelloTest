package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.MainPage;

public class CreatingBoardTest extends BaseTest {
    @Test
    public void CreatingNewBoardTest() throws InterruptedException {
        Assert.assertTrue(testMainPage.createBoard("new board").getAddListButton().isDisplayed(), "Board is not created");
        testMainPage.openPage();
        testBoardPage.deleteBoard("new board");


    }

}

