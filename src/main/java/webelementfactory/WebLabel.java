package webelementfactory;

import driver.DriverSingleton;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebLabel extends AbstractWebElement{
    private final Logger logger = LogManager.getRootLogger();

    public WebLabel(String xpath) {
        super(xpath);
    }

    public void dragAndDrop(String destinationXpath) {
        waitForPresenceOfElement();
        WebElement destination = DriverSingleton.getDriver().findElement(By.xpath(destinationXpath));
        new Actions(DriverSingleton.getDriver()).dragAndDrop(getElement(), destination).build().perform();
        logger.info(String.format("drag and drop the %s with locator %s to the %s with locator %s", this.getClass().getSimpleName(),
                getXpath(), destination.getClass().getSimpleName(), destinationXpath));
    }
}
