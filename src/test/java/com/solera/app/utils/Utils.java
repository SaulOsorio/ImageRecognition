package com.solera.app.utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Utils {
	public static WebDriver setup(String browser) throws Exception {
		Properties properties = TestProperties.getProperties();
		WebDriver driver = null;
		if (browser.toLowerCase().matches("chrome")) {
			System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverLocation"));
			driver = new ChromeDriver();
		} else if (browser.toLowerCase().matches("firefox")) {
			System.setProperty("webdriver.gecko.driver", properties.getProperty("firefoxDriverLocation"));
			driver = new FirefoxDriver();
		}else {
			throw new Exception("Invalid browser"); 
		}
		return driver;
	}
	
	public static void teardown(WebDriver driver) {
		driver.quit();
	}
}
