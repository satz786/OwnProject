package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import projectspecification.BaseClass;
import utilsPack.Readexcel;

public class TC_001_LoginWithValidData extends BaseClass{

	
	
	@DataProvider(name = "Loginwithvaliddata")
	public String[][] Testdata() throws IOException
	{
		String[][] readExcelData = Readexcel.ReadExcelData("TC_001_loginwithvaliddata.xlsx");
		return readExcelData;
	}
	
	
	
	
	
	
	
	@BeforeTest
	public void setdata()
	{	 
		 testcaseName="Login";
		 testDescription="Login_with_Valid_Data";
		 category="sanity";
		 author="Sathish";
		
	}
	
	@Test(dataProvider = "Loginwithvaliddata")
	public void loginwithvaliddata(String uname , String passwords) throws InterruptedException, IOException
	{
		new LoginPage(driver)
		.EnterUserName(uname)
		.EnterPassword(passwords)
		.ClickloginButton()
		
		.validateloginwithvaliddata();
	}
	
	
	
	
	
	
}
