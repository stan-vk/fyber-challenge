package com.github.stanvk.fyberchallenge.ui.common;

import com.github.stanvk.fyberchallenge.ui.interfaces.Visible;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
public class TableRow extends AbstractElement implements Visible {
    TableRow(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }
}
