package br.com.dbccompany.ProvaSicredi.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.dbccompany.ProvaSicredi.core.DSL;
import br.com.dbccompany.ProvaSicredi.core.DriverFactory;

public class DeleteModalPage {
	
	@FindBy(xpath = "//*[contains(@class,'delete-multiple-confirmation-button')]")
	private WebElement btnDelete;
	
	public DeleteModalPage() {
		PageFactory.initElements(DriverFactory.getWebDriver(), this);
	}

	public String getDeleteModalTextMessage() {
		return DSL.waitAndGetTextFromElement(By.className("alert-delete-multiple-one"));
	}
	
	public HomePage clickDeleteButton() {
		btnDelete.click();
		return new HomePage();
	}
}
