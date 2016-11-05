package com.github.stanvk.fyberchallenge.guice;

import com.github.stanvk.fyberchallenge.services.context.UiContextService;
import com.github.stanvk.fyberchallenge.services.webdriver.WebDriverService;
import com.github.stanvk.fyberchallenge.stepdefinitions.Hooks;
import com.google.inject.AbstractModule;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
class ServicesModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(WebDriverService.class);
        bind(UiContextService.class);
        bind(Hooks.class);
    }
}
