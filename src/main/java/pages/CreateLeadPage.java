package pages;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


import projectspecification.BaseClass;

public class CreateLeadPage extends BaseClass{

	public CreateLeadPage(RemoteWebDriver recdriver)
	{
		this.driver = recdriver;
	}
	
	public CreateLeadPage entercompanyname(String companynamestring) throws IOException
	{
		WebElement companyname = Searchelement("id", "createLeadForm_companyName");
		sendkeyfunction(companyname, companynamestring);
		
		test.info("Companyname is entered");
		return this;
	}
	
	
	
	
	public CreateLeadPage enterFirstname(String firstname)
	{
		WebElement fname = Searchelement("id", "createLeadForm_firstName");
		sendkeyfunction(fname, firstname);
		return this;
	}
	
	
	public CreateLeadPage enterLastname(String lastname)
	{
		WebElement lname = Searchelement("id", "createLeadForm_lastName");
		sendkeyfunction(lname, lastname);
		return this;
	}
	
	public CreateLeadPage SelectCurrency(String currencyname) throws IOException
	{
		//WebElement currencydropdown = Searchelement("id", "createLeadForm_currencyUomId");
		//clickAction(currencydropdown);
		List<WebElement> currencydropdownvalue = driver.findElements(By.xpath("//select[@id='createLeadForm_currencyUomId']//option"));
		for(WebElement ele : currencydropdownvalue)
		{
			String dpdownvalue = ele.getText();
			System.out.println("The dropdown value is "+dpdownvalue);
			if(dpdownvalue.contains(currencyname))
			{
				System.out.println(currencyname);
				ele.click();
			}
		}
		
		
		
		
		return this;
	}
	
	
	public ViewLeadPage click_Submit_CreateLead()
	{
		WebElement submitButton = Searchelement("class", "smallSubmit");
		clickAction(submitButton);
		
		return new ViewLeadPage(driver);
	}
	
}
