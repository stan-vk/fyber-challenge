package com.github.stanvk.fyberchallenge.ui.common;

import com.github.stanvk.fyberchallenge.ui.interfaces.CanBeSelected;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;

/**
 * Created by Stanislav Kostsov on 06.11.2016.
 */
public class Option extends ButtonBase implements CanBeSelected {
    public Option(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }

    @Override
    public boolean isSelected() {
        String selected = rootElement.getAttribute("selected");
        return !Objects.isNull(selected) && selected.equals("true");
    }

    @Override
    public void select() {
        leftMouseClick();
    }
}
