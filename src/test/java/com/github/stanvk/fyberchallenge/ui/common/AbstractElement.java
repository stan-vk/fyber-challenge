package com.github.stanvk.fyberchallenge.ui.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
public abstract class AbstractElement {
    protected final RemoteWebDriver webDriver;
    protected final WebElement rootElement;

    protected AbstractElement(RemoteWebDriver webDriver, WebElement rootElement) {
        this.webDriver = webDriver;
        this.rootElement = rootElement;
    }
}
