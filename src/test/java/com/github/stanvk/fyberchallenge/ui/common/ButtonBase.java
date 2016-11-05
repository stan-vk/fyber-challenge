package com.github.stanvk.fyberchallenge.ui.common;

import com.github.stanvk.fyberchallenge.ui.interfaces.CanBeEnabled;
import com.github.stanvk.fyberchallenge.ui.interfaces.Clickable;
import com.github.stanvk.fyberchallenge.ui.interfaces.HasText;
import com.github.stanvk.fyberchallenge.ui.interfaces.Visible;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
public class ButtonBase extends AbstractElement implements Visible, HasText, Clickable, CanBeEnabled {

    public ButtonBase(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
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
    public String getText() {
        return rootElement.getText();
    }

    @Override
    public boolean isDisplayed() {
        return rootElement.isDisplayed();
    }

    @Override
    public boolean isEnabled() {
        return rootElement.isEnabled();
    }
}
