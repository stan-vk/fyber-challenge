package com.github.stanvk.fyberchallenge.tools;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyTest {
	
	@Test
	public void firstTest() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.imdb.com/chart/top");
		
		driver.close();
	}

}
