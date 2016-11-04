package com.github.stanvk.fyberchallenge.services.webdriver;

import com.github.stanvk.fyberchallenge.config.FrameworkConfiguration;
import com.github.stanvk.fyberchallenge.config.WebDriverType;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
@Singleton
public class WebDriverService {
    @Inject
    private FrameworkConfiguration config;

    private volatile RemoteWebDriver webDriver;

    public RemoteWebDriver getWebDriver() {
        if (Objects.isNull(webDriver)) {
            WebDriverType type = config.getWebDriverType();
            instantiateWebDriver(type);
        }
        return webDriver;
    }

    private void instantiateWebDriver(WebDriverType type) {
        switch (type) {
            case FIREFOX:
                webDriver = firefoxWebDriver();
                break;
            case IE:
            case CHROME:
            default:
                throw new UnsupportedOperationException(type + " is not implemented yet");
        }
    }

    private RemoteWebDriver firefoxWebDriver() {
        if (Strings.isNullOrEmpty(System.getProperty("webdriver.gecko.driver"))) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        }

        return new FirefoxDriver();
    }
}
