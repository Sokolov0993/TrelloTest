package elementFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class TextBox extends AbstractElement{
    private final Logger logger = LogManager.getRootLogger();
    public TextBox(WebElement wrappedElement) {
        super(wrappedElement);
    }
    public void sendKeys(String text) {
        waitForVisibilityOf();
        wrappedElement.sendKeys(text);
        logger.info("enter text in " + getClassName() + " with locator " + wrappedElement);
    }
}
