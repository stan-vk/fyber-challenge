package com.github.stanvk.fyberchallenge.ui.common;

import com.github.stanvk.fyberchallenge.ui.interfaces.Visible;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
public abstract class AbstractPage implements Visible {
    protected final RemoteWebDriver webDriver;

    protected AbstractPage(RemoteWebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
