package br.com.dbcompany.ProvaSicredi.utils;

import org.junit.Assert;

import br.com.dbccompany.ProvaSicredi.page.AddCustomerPage;
import br.com.dbccompany.ProvaSicredi.page.DeleteModalPage;
import br.com.dbccompany.ProvaSicredi.page.HomePage;

public abstract class CustomerUtils {

	public static void deleteCustomerCreatedWithAssertsValidations(String customerName) {
		deleteCustomerCreated(customerName, true);	
	}
	
	public static void deleteCustomerCreatedWithoutAssertsValidations(String customerName) {
		deleteCustomerCreated(customerName, true);
	}
	
	private static void deleteCustomerCreated(String customerName, boolean validate) {
		HomePage homePage = new AddCustomerPage().clickLinkBackToList();
		DeleteModalPage deleteModalPage = homePage
			.searchCustomer(customerName)
			.clickSelectAllTableLines()
			.clickDeleteButton();
		
		if (validate) {
			String modalTextMessage = deleteModalPage.getDeleteModalTextMessage();
			Assert.assertEquals("Are you sure that you want to delete this 1 item?", modalTextMessage);
		}		
		
		homePage = deleteModalPage.clickDeleteButton();
		
		if (validate) {
			String alertMessage = homePage.getAlertMessage();
			Assert.assertEquals("Your data has been successfully deleted from the database.", alertMessage);
		}		
	}
}
