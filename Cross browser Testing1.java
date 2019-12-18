package Browsertesting;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;


public class OrangehrmTest {
	public WebDriver driver=null;
	public static final String USERNAME = "usamaali3";
	  public static final String AUTOMATE_KEY = "Xk2pLizegzSsCjn4hpNy";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	
	@BeforeClass
    public void setup() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "64.0");
		//caps.setCapability("browserstack.local", "false");
		//caps.setCapability("browserstack.selenium_version", "3.5.2");
		caps.setCapability("resolution", "1024x768");
		
		driver=new RemoteWebDriver(new URL(URL),caps);

	}
	
	@Test
	public void verifyLogin()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
	
}
