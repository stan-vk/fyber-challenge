package com.github.stanvk.fyberchallenge.ui.common;

import com.github.stanvk.fyberchallenge.ui.interfaces.Clickable;
import com.github.stanvk.fyberchallenge.ui.interfaces.Visible;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
public abstract class AbstractElement implements Clickable, Visible {
    protected final RemoteWebDriver webDriver;
    protected final WebElement rootElement;

    protected AbstractElement(RemoteWebDriver webDriver, WebElement rootElement) {
        this.webDriver = webDriver;
        this.rootElement = rootElement;
    }

    @Override
    public boolean isDisplayed() {
        return rootElement.isDisplayed();
    }

    public void leftMouseClick() {
//        scrollIntoView();
        new Actions(webDriver).moveToElement(rootElement).click().perform();
    }

    @Override
    public void rightMouseClick() {
        new Actions(webDriver).moveToElement(rootElement).contextClick().perform();
    }

    @Override
    public void moveMouseTo() {
//        moveTo(rootElement);
        new Actions(webDriver).moveToElement(rootElement).perform();
    }

    public void scrollIntoView() {
        webDriver.executeScript("arguments[0].scrollIntoView(true);", rootElement);
    }

//    private Robot moveTo(WebElement element) {
//        Rectangle rectangle = element.getRect();
//        Robot robot;
//        try {
//            robot = new Robot();
//        } catch (AWTException e) {
//            throw new UiException("Robot initialization exception", e);
//        }
//        robot.mouseMove(rectangle.getX() + rectangle.getWidth() / 2, rectangle.getY() + rectangle.getHeight() / 2);
//        return robot;
//    }
}
