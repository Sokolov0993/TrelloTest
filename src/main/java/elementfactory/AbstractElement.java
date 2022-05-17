package elementfactory;

import driver.DriverSingleton;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractElement implements Element   {
    protected final WebElement wrappedElement;
    private final Logger logger = LogManager.getRootLogger();

    protected AbstractElement(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    public void click() {
        waitToBeClickable();
        wrappedElement.click();
        logger.info("click on the " + getClassName() + " with locator " + wrappedElement);
    }

    public String getText() {
        waitForVisibilityOf();
        logger.info("get text from " + getClassName() + " with locator " + wrappedElement);
        return wrappedElement.getText();
    }

    public String getAttribute(String attribute) {
        waitForVisibilityOf();
        logger.info(String.format("get attribute %s of %s with locator %s", attribute, getClassName(), wrappedElement));
        return wrappedElement.getAttribute(attribute);
    }

    public String getCssValue(String cssAttribute) {
        waitForVisibilityOf();
        logger.info(String.format("get %s of the %s with locator %s", cssAttribute, getClassName(), wrappedElement));
        return wrappedElement.getCssValue(cssAttribute);
    }

    public void waitToBeClickable() {
        new WebDriverWait(DriverSingleton.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(wrappedElement));
    }

    public void waitForVisibilityOf() {
        new WebDriverWait(DriverSingleton.getDriver(), 10).until(ExpectedConditions.visibilityOf(wrappedElement));
    }

    public void waitForInVisibilityOf() {
        new WebDriverWait(DriverSingleton.getDriver(), 10).until(ExpectedConditions.invisibilityOf(wrappedElement));
    }

    public void waitForPresenceOfElement(String xpath) {
        new WebDriverWait(DriverSingleton.getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void waitForAttributeContainsText(String attribute, String text) {
        ExpectedCondition<Boolean> attributeContainsText =
                driver -> (Boolean) (wrappedElement.getAttribute(attribute).contains(text));
        new WebDriverWait(DriverSingleton.getDriver(), 10).until(attributeContainsText);
    }

    protected String getClassName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }
}


