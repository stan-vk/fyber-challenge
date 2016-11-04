package com.github.stanvk.fyberchallenge.testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features", 
		glue = "classpath:com.github.stanvk.fyberchallenge.stepdefinitions")
public class CucumberTest {
}
