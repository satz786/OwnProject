package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import projectspecification.BaseClass;
import utilsPack.Readexcel;

public class TC_003_CreateLead_with_valid_data extends BaseClass{

	
	
	@DataProvider(name = "createlead_with_validData")
	public String[][] SetData() throws IOException
	{	
		String[][] data = Readexcel.ReadExcelData("TC_003_CreateLead_With_validData.xlsx");
		return data;
	}
	
	
	@BeforeTest
	public void setdata()
	{	 
		 testcaseName="CreateLead";
		 testDescription="CreateLead_with_Valid_Data";
		 category="sanity";
		 author="Sathish";
		
	}
	
	
	@Test(dataProvider = "createlead_with_validData")
	public void CreateLead_with_ValidData(String uname, String passwords, String companyname, 
			String firstname, String secondname, String currency) throws IOException
	{
		new LoginPage(driver)
		.EnterUserName(uname)
		.EnterPassword(passwords)
		.ClickloginButton()
		.click_crmsfa()
		.Click_CreateLead_menu()
		.entercompanyname(companyname)
		.enterFirstname(firstname)
		.enterLastname(firstname)
		.SelectCurrency(currency)
		.click_Submit_CreateLead()
		.getViewLeadID()
		.verifyTitle();
		
		
		
	}
	
	
	
	
	
}
