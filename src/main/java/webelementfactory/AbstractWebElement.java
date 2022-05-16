package webelementfactory;

import driver.DriverSingleton;
import elementfactory.Element;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractWebElement implements Element {
    private String xpath;
    public AbstractWebElement(String xpath) {
        this.xpath = xpath;
    }
    private final Logger logger = LogManager.getRootLogger();

    public String getXpath() {
        return xpath;
    }

    public WebElement getElement() {
        return DriverSingleton.getDriver().findElement(By.xpath(xpath));
    }

    public void click() {
        waitForPresenceOfElement();
        waitForVisibilityOf();
        waitToBeClickable();
        getElement().click();
        logger.info(String.format("click on the %s with locator %s", getClassName(),
                getXpath()));
    }

    public boolean isDisplayed() {
        logger.info(String.format("Checking if element %s is displayed on the screen.", getClassName()));
        try {
            return getElement().isDisplayed();
        } catch (NoSuchElementException elementIsNotDisplayed) {
            logger.info(String.format("Element %s in not displayed on the screen!", getClassName()));
            return false;
        }
    }

    public String getText() {
        waitForPresenceOfElement();
        return getElement().getText();
    }

    public void waitToBeClickable() {
        new WebDriverWait(DriverSingleton.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(getElement()));
    }

    public void waitForPresenceOfElement() {
        new WebDriverWait(DriverSingleton.getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void waitForVisibilityOf() {
        new WebDriverWait(DriverSingleton.getDriver(), 10).until(ExpectedConditions.visibilityOf(getElement()));
    }

    protected String getClassName() {
        return this.getClass().getSimpleName();
    }
}

