package br.com.dbccompany.ProvaSicredi.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.dbccompany.ProvaSicredi.core.DSL;
import br.com.dbccompany.ProvaSicredi.core.DriverFactory;

public class HomePage {

	@FindBy(id = "switch-version-select")
	private WebElement cbxSelectVersion;
	
	@FindBy(xpath = "//*[contains(., 'Add Customer') and contains(@class,'btn')]")
	private WebElement btnAddCustomer;
	
	@FindBy(xpath = "//*[contains(@class,'search-button')]")
	private WebElement btnSearch;
	
	@FindBy(className = "select-all-none")
	private WebElement cbxSelectAll;
	
	@FindBy(xpath = "//*[contains(@class,'delete-selected-button')]")
	private WebElement btnDelete;
	
	@FindBy(xpath = "//*[@data-growl='message']")
	private WebElement alertMessage;
	
	public HomePage() {
		PageFactory.initElements(DriverFactory.getWebDriver(), this);
	}
	
	public HomePage changeBootstrapVersion(String version) {
		DSL.selectOptionByText(cbxSelectVersion, version);
		return this;
	}
	
	public AddCustomerPage clickAddCustomerButton() {
		btnAddCustomer.click();
		return new AddCustomerPage();
	}
	
	public HomePage searchCustomer(String customerName) {
		DSL.searchByText(btnSearch, customerName);
		return this;
	}
	
	public HomePage clickSelectAllTableLines() {
		cbxSelectAll.click();
		return this;
	}
	
	public DeleteModalPage clickDeleteButton() {
		btnDelete.click();
		return new DeleteModalPage();
	}
	
	public String getAlertMessage() {
		return DSL.waitAndGetTextFromElement(alertMessage);
	}
}
