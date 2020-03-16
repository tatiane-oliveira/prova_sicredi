package br.com.dbccompany.ProvaSicredi.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.com.dbccompany.ProvaSicredi.core.BaseTest;
import br.com.dbccompany.ProvaSicredi.core.DriverFactory;
import br.com.dbccompany.ProvaSicredi.page.AddCustomerPage;
import br.com.dbccompany.ProvaSicredi.page.HomePage;
import br.com.dbcompany.ProvaSicredi.utils.CustomerUtils;

@RunWith(value = Parameterized.class)
public class Desafio2Test extends BaseTest {	
		
	public Desafio2Test(String selectVersion, String name, String lastName, 
						String contactFirstName, String phone,
						String addressLine1, String addressLine2, String city, 
						String state, String postalCode, String country,
						String fromEmployeer, String creditLimit, String message) {
		super(selectVersion, name, lastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode,
				country, fromEmployeer, creditLimit, message);
	}

	private AddCustomerPage addCustomerPage;

	@Before
	public void initialize() {		
		DriverFactory.getWebDriver().get("https://www.grocerycrud.com/demo/bootstrap_theme");
		
		addCustomerPage = new HomePage()
											.changeBootstrapVersion(selectVersion)
											.clickAddCustomerButton();
		
		addCustomerPage.fillForm(selectVersion, name, lastName, contactFirstName, phone, 
				addressLine1, addressLine2, city, state, postalCode, country, fromEmployeer, creditLimit, message);		
		addCustomerPage.clickSaveButton();		
	}
	
	@Test
	public void deleteCustomer() {
		CustomerUtils.deleteCustomerCreatedWithAssertsValidations(name);
	}
}
