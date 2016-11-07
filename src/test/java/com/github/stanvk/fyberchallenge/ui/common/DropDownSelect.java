package com.github.stanvk.fyberchallenge.ui.common;

import com.github.stanvk.fyberchallenge.ui.interfaces.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Stanislav Kostsov on 06.11.2016.
 */
public class DropDownSelect extends AbstractElement implements DropDown {
    public DropDownSelect(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }

    @Override
    public boolean isExpanded() {
        return getItems().stream().anyMatch(o -> o.isDisplayed() && o.isEnabled());
    }

    @Override
    public void expand() {
        leftMouseClick();
    }

    @Override
    public void collapse() {
        new Actions(webDriver).sendKeys(Keys.ESCAPE).perform();
    }

    @Override
    public List<Option> getItems() {
        return rootElement.findElements(By.tagName("option"))
                .stream()
                .map(element -> new Option(webDriver, element))
                .collect(Collectors.toList());
    }

    @Override
    public Option getSelectedItem() {
        return rootElement.findElements(By.tagName("option"))
                .stream()
                .map(element -> new Option(webDriver, element))
                .filter(Option::isSelected)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Option getItemByText(String text) {
        String selector = String.format(".//option[contains(text(),'%s')]", text);
        WebElement element = rootElement.findElement(By.xpath(selector));
        if (Objects.isNull(element)) {
            throw new UiException("Drop down item was not found by selector: " + selector);
        }
        return new Option(webDriver, element);
    }

    @Override
    public void selectItemWithKeyboard(String text) {
        expand();
        Option selected = getSelectedItem();
        if (Objects.isNull(getSelectedItem())) {
            throw new UiException("No items selected");
        }
        String firstSelectedText = Objects.requireNonNull(selected.getText()).trim();
        List<Option> options = getItems();
        int firstSelectedIndex = IntStream.range(0, options.size())
                .filter(i -> options.get(i).getText().contains(firstSelectedText))
                .findFirst().orElseThrow(() -> new UiException("Could not find selected item"));
        int requiredIndex = IntStream.range(0, options.size())
                .filter(i -> options.get(i).getText().contains(text))
                .findFirst().orElseThrow(() -> new UiException("Could not find required item"));

        if (requiredIndex > firstSelectedIndex) {
            IntStream.range(firstSelectedIndex, requiredIndex)
                    .forEach(i -> new Actions(webDriver).sendKeys(Keys.DOWN).perform());
        }
        else if (requiredIndex > firstSelectedIndex) {
            IntStream.range(firstSelectedIndex, requiredIndex)
                    .forEach(i -> new Actions(webDriver).sendKeys(Keys.UP).perform());
       }

        new Actions(webDriver).sendKeys(Keys.RETURN).perform();
    }
}
