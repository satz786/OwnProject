package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import projectspecification.BaseClass;
import utilsPack.Readexcel;

public class TC_002_LoginWithInvalidData extends BaseClass{

	
	@DataProvider(name = "login_with_invalid_Data")
	public String[][] testdata() throws IOException
	{
		String[][] readExcelData = Readexcel.ReadExcelData("TC_002_Login_With_Invalid_data.xlsx");
		return readExcelData;
		
	}
	
	@BeforeTest
	public void setdata()
	{	 
		 testcaseName="Login";
		 testDescription="Login_with_InValid_Data";
		 category="sanity";
		 author="Sathish";
		
	}
	
	
	
	
	@Test(dataProvider = "login_with_invalid_Data")
	public void login_with_invalid_data(String uname , String passwords) throws IOException
	{
		
		new LoginPage(driver)
		.EnterUserName(uname)
		.EnterPassword(passwords)
		.ClickloginButton()
		.validate_Invalid_Data();
	
		
		
	}
	
	
}
