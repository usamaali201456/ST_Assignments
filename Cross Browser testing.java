package Browsertesting;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClassBrowserParallel {
	public WebDriver driver;
	public static final String USERNAME = "usamaali3";
	  public static final String AUTOMATE_KEY = "Xk2pLizegzSsCjn4hpNy";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	
	@Test(dataProvider="browserStackTestData")
	public void openSTM(Platform platform,String Bname,String Bversion) throws Exception {
             
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setPlatform(platform);
		capability.setBrowserName(Bname);
		capability.setVersion(Bversion);
		capability.setCapability("browserstack.debug", "true");
		// Creatng URL object
		URL browserStackUrl = new URL(URL);
	
		driver = new RemoteWebDriver (browserStackUrl, capability);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String actualURL = driver.getCurrentUrl();
		System.out.println("URL is "+actualURL);
		driver.quit();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/";
                //Assert to verify the actual and expected values
		Assert.assertEquals(actualURL, expectedURL,"Expected and Actual are not same");		
	}

@DataProvider(name="browserStackTestData",parallel=true)
public Object[][] getData(){
	
	Object[][] testData = new Object[][]{
		{Platform.MAC, "chrome", "62.0"},
		{Platform.WIN8, "chrome", "62.0"},
		{Platform.WINDOWS, "firefox", "57"}
	};
	
	return testData;		
}
}

