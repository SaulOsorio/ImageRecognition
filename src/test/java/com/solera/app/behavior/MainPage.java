package com.solera.app.behavior;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.solera.app.icon.IconTest;
import com.solera.app.utils.TestProperties;
import com.solera.app.utils.Utils;


public class MainPage {
	private static final Logger LOGGER = Logger.getLogger(IconTest.class);
	
	private static Properties properties = TestProperties.getProperties();
	
	public static void goToMainPage(WebDriver driver) {
		String url = properties.getProperty("soleraurl");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void acceptAllCookies(WebDriver driver) {
		String id = properties.getProperty("acceptcookiesbuttonid");
		new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.id(id)));
		WebElement cookieButton = driver.findElement(By.id(id));
		cookieButton.click();
	}
	
	public static void findSoleraIcon(Screen screen, WebDriver driver, float similarity) throws FindFailed, Exception {
		Pattern icon = new Pattern(properties.getProperty("soleraicon"));
		String id = properties.getProperty("soleraiconcenterid");
		new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.id(id)));
		try {
		screen.find(icon.similar((float)similarity));}
		catch(FindFailed findFailure){
			LOGGER.error(findFailure.getMessage());
			Utils.teardown(driver);
			throw findFailure;
		}catch(Exception e){
			throw e;
		}
	}
}
