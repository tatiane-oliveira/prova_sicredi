package br.com.dbccompany.ProvaSicredi.core;

import java.time.Duration;

import static br.com.dbccompany.ProvaSicredi.core.DriverFactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DSL {

	public static void selectOptionByText(WebElement selectElement, String text) {
		new Select(selectElement).selectByVisibleText(text);
	}
	
	public static void selectOptionByAutoCompleteText(WebElement selectElement, String text) {
		selectElement.click();
		WebDriver driver = getWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@class='chosen-search']/input")).sendKeys(text);
		By byResultOption = By.xpath(String.format("//*[contains(., '%s') and contains(@class,'active-result')]", text));
		wait.until(ExpectedConditions.elementToBeClickable(byResultOption));
		driver.findElement(byResultOption).click();
	}
	
	public static void setElementValueUsingJS(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor)getWebDriver();
		String script = String.format("arguments[0].value='%s';", text);
		js.executeScript(script, element);
	}
	
	public static String waitAndGetTextFromElement(WebElement element) {
		WebDriver driver = getWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	public static String waitAndGetTextFromElement(By by) {
		WebDriver driver = getWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver.findElement(by).getText();
	}
	
	public static void searchByText(WebElement searchElement, String text) {
		searchElement.click();
		WebElement txtSearch = getWebDriver().findElement(By.name("search"));
		txtSearch.sendKeys(text);
		txtSearch.sendKeys(Keys.ENTER);
	}
}
