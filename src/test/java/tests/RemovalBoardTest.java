package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardPage;

import java.util.List;

public class RemovalBoardTest extends Constants{
    @Test
    public void LogInAbility() throws InterruptedException {
        BoardPage testBoardPage = new BoardPage();
        List<WebElement> before =driver.findElements(By.xpath("//h3[text()='YOUR WORKSPACES']/following::div[text()='new board']"));
        testBoardPage.deleteBoard("new board");
        List<WebElement> after =driver.findElements(By.xpath("//h3[text()='YOUR WORKSPACES']/following::div[text()='new board']"));
        Assert.assertTrue(before.size()==after.size()+1, "User removed board successfully");
    }
}
