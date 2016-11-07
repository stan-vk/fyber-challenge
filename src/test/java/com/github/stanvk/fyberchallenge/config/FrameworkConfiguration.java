package com.github.stanvk.fyberchallenge.config;

import com.google.inject.Singleton;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;


@Singleton
public class FrameworkConfiguration {
    private static final Logger log = LoggerFactory.getLogger(FrameworkConfiguration.class);

    private static final String CONFIG_DEFAULT_PATH = "automation.conf";

    private static final String WEB_DRIVER_TYPE_PROP = "automation.web.driver.type";
    private static final String WEB_DRIVER_VERSION_PROP_FORMAT = "automation.web.driver.%s.version";

    private Config config;

    public FrameworkConfiguration() {
        readConfiguration();
    }

    public WebDriverType getWebDriverType() {
        return Optional.ofNullable(config.getString(WEB_DRIVER_TYPE_PROP))
                .map(WebDriverType::valueOf)
                .orElseThrow(() -> getConfigurationException(WEB_DRIVER_TYPE_PROP));
    }

    public String getWebDriverVersion(WebDriverType webDriverType) {
        String prop = String.format(WEB_DRIVER_VERSION_PROP_FORMAT, webDriverType.name());
        return Optional.ofNullable(config.getString(prop))
                .orElseThrow(() -> getConfigurationException(prop));
    }

    private void readConfiguration() {
        config = ConfigFactory.load(CONFIG_DEFAULT_PATH);
        log.info("{}", config.getConfig("automation"));
    }

    private FrameworkConfigurationException getConfigurationException(String property) {
        return new FrameworkConfigurationException("Unspecified property: " + property);
    }
}