package elementFactory;

import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

public class DefaultElementFactory implements ElementFactory{
    @Override
    public <E extends webElementFactory.Element> E create(Class<E> elementClass, WebElement wrappedElement) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        return elementClass
                .getDeclaredConstructor(WebElement.class)
                .newInstance(wrappedElement);
    }
}
