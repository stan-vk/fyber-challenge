package com.github.stanvk.fyberchallenge.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;

public class CucumberInjectorSource implements InjectorSource {

	@Override
	public Injector getInjector() {
		return Guice.createInjector(
				Stage.PRODUCTION, 
				CucumberModules.SCENARIO, 
				new ConfigurationModule(),
				new WebDriverModule());
	}

}
