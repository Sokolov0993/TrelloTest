package elementfactory;

import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

public class DefaultElementFactory implements ElementFactory {

    @Override
    public <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return elementClass
                .getDeclaredConstructor(WebElement.class)
                .newInstance(wrappedElement);
    }
}