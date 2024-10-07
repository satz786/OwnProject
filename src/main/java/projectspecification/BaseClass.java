package projectspecification;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilsPack.PropertyClass;



public class BaseClass {
public RemoteWebDriver driver;
public static PropertyClass pc;
public static ExtentReports extent;
	
public static ExtentTest test;
public String testcaseName,testDescription,category,author;

//Logger logger = Logger.getLogger(BaseClass.class);


/*
 * @BeforeSuite public void setupReport() { ExtentSparkReporter reporter = new
 * ExtentSparkReporter("./Report/testreport.html"); extent = new
 * ExtentReports(); extent.attachReporter(reporter); }
 * 
 * @BeforeClass public void getvalue() { test = extent.createTest(testcaseName,
 * testDescription); test.assignAuthor(author); test.assignCategory(category);
 * 
 * }
 */


@BeforeSuite
public void startReporter() {
	ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Report/result.html");
	reporter.setAppendExisting(true);
	extent=new ExtentReports();
	extent.attachReporter(reporter);
}

@BeforeClass
public void testDetails() {
	test = extent.createTest(testcaseName,testDescription);
	test.assignCategory(category);
	test.assignAuthor(author);
}



public int takeSnap() throws IOException {
	
	int number= (int) (Math.random() * 999999+1000000);
	File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	File destination=new File("./snap/img"+number+".png");
	FileUtils.copyFile(screenshotAs, destination);
	return number;
}

public void reportstep(String stepInfo,String status) throws IOException {
	int randomSnapshot = takeSnap();
	if(status.equalsIgnoreCase("pass")) {
		test.pass(stepInfo,MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+randomSnapshot+".png").build());
	}else if (status.equalsIgnoreCase("fail")) {
		test.fail(stepInfo,MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+randomSnapshot+".png").build());
	   throw new RuntimeException("see the ExtentReports for more Details");
	}
}



@BeforeMethod
	public void StartApp() throws IOException
	{
	PropertyClass pc = new PropertyClass();
		String browsername = pc.getbrowsername();
		String url = pc.getURL();
	//	WebDriverManager.chromiumdriver().setup();
		if(browsername.equalsIgnoreCase("chrome"))
		{
			
			driver = new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	
@AfterMethod
public void postCondition(){
	driver.close();
}

@AfterSuite
public void endReport() {
	extent.flush();
}
	
	
	
	
	
	
	
	public WebElement Searchelement(String locatorType, String value)
	{
		switch(locatorType.toLowerCase()) 
		{
		case "id": return driver.findElement(By.id(value));
		case "name": return driver.findElement(By.name(value));
		case "class": return driver.findElement(By.className(value));
		case "link": return driver.findElement(By.linkText(value));
		case "xpath": return driver.findElement(By.xpath(value));
		}
		return null;
	}
	
	
	
	public void clickAction(WebElement element)
	{
		element.click();
	}
	
	
	public void sendkeyfunction(WebElement ele , String value)
	{
		ele.sendKeys(value);
	}
	
	
	
	
	
}
