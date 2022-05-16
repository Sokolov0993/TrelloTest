package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class HeaderVisibilityTest extends BaseTest {
      @Test
      public void IsHeaderVisibleTest() throws InterruptedException {
          MainPage testMainPage = new MainPage();
          Assert.assertTrue(testMainPage.isHeaderVisible(), "Метод работает верно");

      }
  }


