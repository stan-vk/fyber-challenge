package com.github.stanvk.fyberchallenge.testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "classpath:com.github.stanvk.fyberchallenge.stepdefinitions",
        tags = "@IMDB",
        plugin = "json:target/cucumber.json")
public class CucumberImdbTest {
}
