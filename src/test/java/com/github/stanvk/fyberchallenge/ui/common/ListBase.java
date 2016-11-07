package com.github.stanvk.fyberchallenge.ui.common;

import com.github.stanvk.fyberchallenge.ui.interfaces.HasItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Stanislav Kostsov on 07.11.2016.
 */
public class ListBase extends AbstractElement implements HasItems<ListBaseItem> {
    public ListBase(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }

    @Override
    public List<ListBaseItem> getItems() {
        return rootElement.findElements(By.tagName("li"))
                .stream()
                .map(element -> new ListBaseItem(webDriver, element))
                .collect(Collectors.toList());
    }

    @Override
    public ListBaseItem getItemByText(String text) {
        return new ListBaseItem(webDriver, getWebElementItemByText(text));
    }

    protected WebElement getWebElementItemByText(String text) {
        String selector = String.format(".//li[descendant-or-self::*[contains(text(), '%s')]]", text);
        WebElement element = rootElement.findElement(By.xpath(selector));
        if (Objects.isNull(element)) {
            throw new UiException("List item was not found by selector: " + selector);
        }
        return element;
    }
}
