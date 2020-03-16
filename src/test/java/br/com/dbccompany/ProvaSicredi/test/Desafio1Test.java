package br.com.dbccompany.ProvaSicredi.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dbccompany.ProvaSicredi.core.BaseTest;
import br.com.dbccompany.ProvaSicredi.core.DriverFactory;
import br.com.dbccompany.ProvaSicredi.page.AddCustomerPage;
import br.com.dbccompany.ProvaSicredi.page.HomePage;

public class Desafio1Test extends BaseTest {

	public Desafio1Test(String selectVersion, String name, String lastName, 
						String contactFirstName, String phone,
						String addressLine1, String addressLine2, String city, 
						String state, String postalCode, String country,
						String fromEmployeer, String creditLimit, String message) {
		super(selectVersion, name, lastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode,
				country, fromEmployeer, creditLimit, message);
	}

	@Before
	public void inicialize() {
		DriverFactory.getWebDriver().get("https://www.grocerycrud.com/demo/bootstrap_theme");
	}

	@Test
	public void addCustomerTest() {		
		AddCustomerPage addCustomerPage = new HomePage()
				.changeBootstrapVersion(selectVersion)
				.clickAddCustomerButton();
		
		addCustomerPage
			.typeName(name)
			.typeLastName(lastName)
			.typeContactFirstName(contactFirstName)
			.typePhone(phone)
			.typeAddressLine1(addressLine1)
			.typeAddressLine2(addressLine2)
			.typeCity(city)
			.typeState(state)
			.typePostalCode(postalCode)
			.typeCountry(country)			
			.selectFromEmployeer(fromEmployeer)
			.typeCreditLimit(creditLimit)
			.clickSaveButton();
		
		String successMessage = addCustomerPage.getSuccessMessage();
		Assert.assertTrue(successMessage.contains(message));
	}
}
