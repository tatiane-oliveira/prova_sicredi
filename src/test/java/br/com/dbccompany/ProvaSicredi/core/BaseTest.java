package br.com.dbccompany.ProvaSicredi.core;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.dbcompany.ProvaSicredi.utils.CustomerUtils;

@RunWith(value = Parameterized.class)
public class BaseTest {
	
	protected String selectVersion; 
	protected String name;
	protected String lastName;
	protected String contactFirstName;
	protected String phone;
	protected String addressLine1;
	protected String addressLine2; 
	protected String city;
	protected String state;
	protected String postalCode;
	protected String country;
	protected String fromEmployeer;
	protected String creditLimit; 
	protected String message;
		
	public BaseTest(String selectVersion, 
			String name,
			String lastName, 
			String contactFirstName,
			String phone, 
			String addressLine1,
			String addressLine2, 
			String city,
			String state, 
			String postalCode,
			String country, 
			String fromEmployeer,
			String creditLimit, 
			String message) {
		this.selectVersion = selectVersion;
		this.name = name;
		this.lastName = lastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.fromEmployeer = fromEmployeer;
		this.creditLimit = creditLimit;
		this.message = message;
	}
	
	@Parameters(name = "{index} - selectVersion={0},name={1},lastName={2},contactFirstName={3},phone={4},addressLine1={5},addressLine2={6},city={7},state={8},postalCode={9},country={10},fromEmployeer={11},creditLimit={12},message={13}")
    public static Collection<String[]> data() {
        return Arrays.asList(new String[][]{
                {"Bootstrap V4 Theme","Teste Sicredi","Teste","Tatiane","51 9999-9999","Av Assis Brasil 3970", "Torre D", "Porto Alegre", "RS", "91000-000", "Brasil", "Fixter", "200", "Your data has been successfully stored into the database."}
        });
    }
	
	@Rule
	public TestName testName = new TestName();
	
	private void takeScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) DriverFactory.getWebDriver();
		File file = ts.getScreenshotAs(OutputType.FILE);
		String dateTime = new SimpleDateFormat("dd-MM-yyyy_hh.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		try {
			FileUtils.copyFile(file, new File("target" + File.separator + "screenshots" + File.separator + extractMethodNameWithoutParameters() + dateTime + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String extractMethodNameWithoutParameters() {
		String methodNameWithParameters = testName.getMethodName();
		
		if (methodNameWithParameters.contains("[")) {
			for (int i = 0; i < methodNameWithParameters.length(); i++) {
				if (methodNameWithParameters.charAt(i) == '[') {
					return methodNameWithParameters.substring(0, (i - 1));
				}
			}
		}
		return methodNameWithParameters;
	}

	@After
	public void finalize() {
		takeScreenshot();
		if (testName.getMethodName().contains("addCustomerTest")) {
			CustomerUtils.deleteCustomerCreatedWithoutAssertsValidations(name);
		}
		DriverFactory.killWebDriver();
	}
}
