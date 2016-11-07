package com.github.stanvk.fyberchallenge.ui.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Stanislav Kostsov on 07.11.2016.
 */
public class ListBaseItem extends ButtonBase {
    public ListBaseItem(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }
}
