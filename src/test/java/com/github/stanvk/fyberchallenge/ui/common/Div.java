package com.github.stanvk.fyberchallenge.ui.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Stanislav Kostsov on 08.11.2016.
 */
public class Div extends AbstractElement {
    public Div(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }
}
