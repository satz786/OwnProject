package pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import projectspecification.BaseClass;

public class ViewLeadPage extends BaseClass{
ArrayList<String> leadlist = new ArrayList<>();
	
	public ViewLeadPage(RemoteWebDriver recdriver) {
		
	
		 this.driver = recdriver;
	
	}

	public ViewLeadPage getViewLeadID()
	{
		WebElement idelement = Searchelement("xpath", "//span[@id='viewLead_companyName_sp']");
		String idwithname = idelement.getText();
		String leadid = idwithname.replaceAll("[^0-9]", "");
		System.out.println("The LeadID is "+leadid);
		leadlist.add(leadid);
		
		return this;
	}
	
	
	public ViewLeadPage verifyTitle() throws IOException
	{
		String actualResult="View Lead | opentaps CRM";
  		String expectedResult = driver.getTitle();
  		if(expectedResult.equals(actualResult)) {
  			//test.info("ViewLead page is displayed");
  			reportstep("ViewLead page is displayed", "Pass");
  		}else {
  			reportstep("ViewLead page is not displayed", "Fail");
  		}

		
		return this;
	}
	
}
