package br.com.dbccompany.ProvaSicredi.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.dbccompany.ProvaSicredi.core.DSL;
import br.com.dbccompany.ProvaSicredi.core.DriverFactory;

public class AddCustomerPage {

	@FindBy(id = "field-customerName")
	private WebElement txtName;

	@FindBy(id = "field-contactLastName")
	private WebElement txtLastName;

	@FindBy(id = "field-contactFirstName")
	private WebElement txtContactFirstName;

	@FindBy(id = "field-phone")
	private WebElement txtPhone;

	@FindBy(id = "field-addressLine1")
	private WebElement txtAddressLine1;

	@FindBy(id = "field-addressLine2")
	private WebElement txtAddressLine2;

	@FindBy(id = "field-city")
	private WebElement txtCity;

	@FindBy(id = "field-state")
	private WebElement txtState;

	@FindBy(id = "field-postalCode")
	private WebElement txtPostalCode;

	@FindBy(id = "field-country")
	private WebElement txtCountry;

	@FindBy(id = "field_salesRepEmployeeNumber_chosen")
	private WebElement cbxFromEmployeer;

	@FindBy(id = "field-creditLimit")
	private WebElement txtCreditLimit;

	@FindBy(xpath = "//*[normalize-space() ='Save']")
	private WebElement btnSave;

	@FindBy(id = "report-success")
	private WebElement msgSuccess;
	
	@FindBy(xpath = "//a[.='Go back to list']")
	private WebElement lnkBackToList;

	public AddCustomerPage() {
		PageFactory.initElements(DriverFactory.getWebDriver(), this);
	}

	public AddCustomerPage selectFromEmployeer(String employeer) {
		DSL.selectOptionByAutoCompleteText(cbxFromEmployeer, employeer);
		return this;
	}

	public AddCustomerPage typeName(String name) {
		txtName.sendKeys(name);
		return this;
	}

	public AddCustomerPage typeLastName(String lastName) {
		txtLastName.sendKeys(lastName);
		return this;
	}

	public AddCustomerPage typeContactFirstName(String contactFirstName) {
		txtContactFirstName.sendKeys(contactFirstName);
		return this;
	}

	public AddCustomerPage typePhone(String phone) {
		txtPhone.sendKeys(phone);
		return this;
	}

	public AddCustomerPage typeAddressLine1(String addressLine1) {
		txtAddressLine1.sendKeys(addressLine1);
		return this;
	}

	public AddCustomerPage typeAddressLine2(String addressLine2) {
		txtAddressLine2.sendKeys(addressLine2);
		return this;
	}

	public AddCustomerPage typeCity(String city) {
		txtCity.sendKeys(city);
		return this;
	}

	public AddCustomerPage typeState(String state) {
		txtState.sendKeys(state);
		return this;
	}

	public AddCustomerPage typePostalCode(String postalCode) {
		txtPostalCode.sendKeys(postalCode);
		return this;
	}

	public AddCustomerPage typeCountry(String country) {
		txtCountry.sendKeys(country);
		return this;
	}

	public AddCustomerPage typeCreditLimit(String creditLimit) {
		DSL.setElementValueUsingJS(txtCreditLimit, creditLimit);
		return this;
	}

	public AddCustomerPage clickSaveButton() {
		btnSave.click();
		return this;
	}

	public String getSuccessMessage() {
		return DSL.waitAndGetTextFromElement(msgSuccess);
	}

	public AddCustomerPage fillForm(String selectVersion, String name, String lastName, String contactFirstName,
			String phone, String addressLine1, String addressLine2, String city, String state, String postalCode,
			String country, String fromEmployeer, String creditLimit, String message) {
		typeName(name);
		typeLastName(lastName);
		typeContactFirstName(contactFirstName);
		typePhone(phone);
		typeAddressLine1(addressLine1);
		typeAddressLine2(addressLine2);
		typeCity(city);
		typeState(state);
		typePostalCode(postalCode);
		typeCountry(country);
		selectFromEmployeer(fromEmployeer);
		typeCreditLimit(creditLimit);
		return this;
	}
	
	public HomePage clickLinkBackToList() {
		lnkBackToList.click();
		return new HomePage();
	}

}