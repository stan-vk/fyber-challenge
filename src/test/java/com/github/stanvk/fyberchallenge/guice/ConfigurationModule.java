package com.github.stanvk.fyberchallenge.guice;

import com.github.stanvk.fyberchallenge.config.FrameworkConfiguration;
import com.google.inject.AbstractModule;

class ConfigurationModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FrameworkConfiguration.class);
	}

}
