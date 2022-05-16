package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.MainPage;

import java.time.Duration;

public class HeaderVisibilityTest extends Constants {
      @Test
      public void IsHeaderVisibleTest() throws InterruptedException {
          MainPage testMainPage = new MainPage(driver);
          Assert.assertTrue(testMainPage.IsHeaderVisible(), "Метод работает верно");

      }
  }


