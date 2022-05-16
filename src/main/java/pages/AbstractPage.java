package pages;

import driver.DriverSingleton;
import elementfactory.ExtendedFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class  AbstractPage {
    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(){
        PageFactory.initElements(new ExtendedFieldDecorator(DriverSingleton.getDriver()), this);
    }
}
