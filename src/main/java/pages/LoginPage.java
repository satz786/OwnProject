package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import projectspecification.BaseClass;

public class LoginPage extends BaseClass{

	
	public LoginPage(RemoteWebDriver recdriver)
	{
		this.driver = recdriver;
	}
	
	
	
	


	public LoginPage EnterUserName(String uname) throws IOException
	{
		WebElement username = Searchelement("id", "username");
		sendkeyfunction(username, uname);
	reportstep("UserName Entered", "info");
		return this;
	}
	
	
	
	public LoginPage EnterPassword(String passwords) throws IOException
	{
		WebElement password = Searchelement("id", "password");
		sendkeyfunction(password, passwords);
		reportstep("Password Entered", "info");
		return this;
	}
	
	
	public Welcomepage ClickloginButton() throws IOException 
	{
		WebElement loginbtn = Searchelement("class", "decorativeSubmit");
		clickAction(loginbtn);
		reportstep("LoginButton Clicked", "info");
		return new Welcomepage(driver);
	}
	
	

}
