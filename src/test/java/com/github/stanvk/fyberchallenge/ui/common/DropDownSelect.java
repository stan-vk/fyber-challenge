package com.github.stanvk.fyberchallenge.ui.common;

import com.github.stanvk.fyberchallenge.ui.interfaces.Clickable;
import com.github.stanvk.fyberchallenge.ui.interfaces.Expandable;
import com.github.stanvk.fyberchallenge.ui.interfaces.Visible;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Stanislav Kostsov on 06.11.2016.
 */
public class DropDownSelect extends AbstractElement implements Visible, Clickable, Expandable {
    public DropDownSelect(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }

    @Override
    public boolean isDisplayed() {
        return rootElement.isDisplayed();
    }

    @Override
    public void leftMouseClick() {
        rootElement.click();
    }

    @Override
    public void rightMouseClick() {
        new Actions(webDriver).contextClick(rootElement).perform();
    }

    @Override
    public boolean isExpanded() {
        return getItems().stream().anyMatch(o -> o.isDisplayed() && o.isEnabled());
    }

    @Override
    public void expand() {
        if (isExpanded()) {
            return;
        }
        leftMouseClick();
    }

    @Override
    public void collapse() {
        if (!isExpanded()) {
            return;
        }
        new Actions(webDriver).sendKeys(Keys.ESCAPE);
    }

    public List<Option> getItems() {
        return rootElement.findElements(By.tagName("option"))
                .stream()
                .map(element -> new Option(webDriver, element))
                .collect(Collectors.toList());
    }

    public Option getItemByText(String text) {
        String selector = String.format(".//option[contains(text(),'%s')]", text);
        WebElement element = rootElement.findElement(By.xpath(selector));
        if (Objects.isNull(element)) {
            throw new UiException("Drop down item was not found by selector: " + selector);
        }
        return new Option(webDriver, element);
    }
}
