package elementfactory;

import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

public interface ElementFactory {

    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException;
}
