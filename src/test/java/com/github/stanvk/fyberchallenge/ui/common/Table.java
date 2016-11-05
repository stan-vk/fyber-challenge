package com.github.stanvk.fyberchallenge.ui.common;

import com.github.stanvk.fyberchallenge.ui.interfaces.Visible;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
public class Table extends AbstractElement implements Visible {
    private static final String ROW_XPATH = "tbody/tr";

    public Table(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }

    @Override
    public boolean isDisplayed() {
        return rootElement.isDisplayed();
    }

    public List<TableRow> getRows() {
        return rootElement.findElements(By.xpath(ROW_XPATH))
                .stream()
                .map(element -> new TableRow(webDriver, element))
                .collect(Collectors.toList());
    }
}
