package com.solera.app.icon;

import java.util.Properties;
import com.solera.app.utils.TestProperties;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import com.solera.app.utils.Utils;
import com.solera.app.behavior.MainPage;
public class IconTest {

	private static Properties properties= TestProperties.getProperties();
	
	@Test
	public void iconTest() throws Exception{	
			Screen screen = new Screen();
			Float similarityThreshold = Float.valueOf(properties.getProperty("similaritythreshold"));
			WebDriver driver = Utils.setup("chrome");
			MainPage.goToMainPage(driver);
			MainPage.acceptAllCookies(driver);
			MainPage.findSoleraIcon(screen, driver,similarityThreshold);
			Utils.teardown(driver);
	}
}
