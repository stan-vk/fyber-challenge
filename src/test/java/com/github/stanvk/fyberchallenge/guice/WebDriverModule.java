package com.github.stanvk.fyberchallenge.guice;

import com.github.stanvk.fyberchallenge.services.webdriver.WebDriverService;
import com.google.inject.AbstractModule;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
class WebDriverModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(WebDriverService.class);
    }
}
