package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import projectspecification.BaseClass;

public class Homepage extends BaseClass {

	public Homepage(RemoteWebDriver recdriver) {
		this.driver = recdriver;
	}
	
	
	public CreateLeadPage Click_CreateLead_menu()
	{
		WebElement createleadmenu = Searchelement("xpath", "//a[text()='Create Lead']");
		clickAction(createleadmenu);
		
		return new CreateLeadPage(driver);
		
		
	}
	

	
	
	
}
