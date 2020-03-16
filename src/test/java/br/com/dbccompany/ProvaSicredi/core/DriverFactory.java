package br.com.dbccompany.ProvaSicredi.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.dbcompany.ProvaSicredi.utils.PropertiesReader;

public class DriverFactory {
	
	private static WebDriver driver;
	
	public static WebDriver getWebDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", new PropertiesReader().getChromeDriverPath());
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void killWebDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
