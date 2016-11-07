package com.github.stanvk.fyberchallenge.services.webdriver;

import com.github.stanvk.fyberchallenge.config.FrameworkConfiguration;
import com.github.stanvk.fyberchallenge.config.WebDriverType;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
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
            case CHROME:
                webDriver = chromeWebDriver();
                break;
            case IE:
            default:
                throw new UnsupportedOperationException(type + " is not implemented yet");
        }
    }

    private RemoteWebDriver chromeWebDriver() {
        if (Strings.isNullOrEmpty(System.getProperty("webdriver.chrome.driver"))) {
            String version = config.getWebDriverVersion();
            System.setProperty("webdriver.chrome.driver"
                    , String.format("drivers/chrome/%s/chromedriver.exe", version));
        }
        return new ChromeDriver();
    }

    private RemoteWebDriver firefoxWebDriver() {
        if (Strings.isNullOrEmpty(System.getProperty("webdriver.gecko.driver"))) {
            String version = config.getWebDriverVersion();
            System.setProperty("webdriver.gecko.driver"
                    , String.format("drivers/gecko/%s/geckodriver.exe", version));
        }

        return new FirefoxDriver(new FirefoxProfile());
    }
}
