package elementFactory;

import org.openqa.selenium.WebElement;
import webElementFactory.Element;

import java.lang.reflect.InvocationTargetException;

public interface ElementFactory {
    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException;
}
