package tests;

import Model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.MainPage;

  public class HeaderVisibilityTest extends Constants {
      @Test
      public void oneCanLoginGithub() {
          MainPage testMainPage = new MainPage(driver);
          Assert.assertTrue(testMainPage.IsHeaderVisible(), "Метод работает неверно");

      }
  }


