package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import projectspecification.BaseClass;

public class Welcomepage extends BaseClass{

	
	public Welcomepage(RemoteWebDriver recdriver)
	{
		this.driver = recdriver;
	}
	
	
	public Welcomepage validate_Invalid_Data() throws IOException
	{
		WebElement invaliduser = Searchelement("xpath", "(//div[@id='errorDiv']//p)[2]");
		String invalidlogintext = invaliduser.getText();
		
		if(invalidlogintext.contains("User not found"))
		{
			reportstep("Validation Message displayed properly", "Pass");
		}
		else
		{
			reportstep("Validation Message is not displayed properly", "Fail");

		}

	return this;
	}
	
	
	
	
	
	
	
	public Welcomepage validateloginwithvaliddata() throws IOException
	{
		WebElement welcomemessage = Searchelement("xpath", "//div[@id='form']//h2");
		String welcomemsg = welcomemessage.getText();
		if(welcomemsg.contains("Welcome"))
		{
			reportstep("Logged-In Successfully", "Pass");
		}
		else
		{
			reportstep("Logged-In Successfully", "Fail");
		}

		return this;
	}
	
	
	
	public Homepage click_crmsfa()
	{
		WebElement crmsfalink = Searchelement("xpath", "//a[normalize-space(text()) = 'CRM/SFA']");
		clickAction(crmsfalink);
		return new Homepage(driver);
		
	}
	
	
}
