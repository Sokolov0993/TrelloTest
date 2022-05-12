package tests;

import Model.User;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.MainPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HeaderVisibilityTest extends Constants {
      @Test
      public void oneCanLoginGithub() throws InterruptedException {
          MainPage testMainPage = new MainPage(driver);
          LogInPage testLoginPage = new LogInPage(driver);
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          testLoginPage.openPage();
          testLoginPage.login(new Model.User());
          Assert.assertTrue(testMainPage.IsHeaderVisible(), "Метод работает верно");

      }
  }


