Feature File Code

Feature: OrangeHRM Login
  Scenario: Logo_presence_on_OrangeHRM_home_page
    Given I will launch chrome browser
    When i will open orange hrm home page
    Then i verify the logo present on page
    And close browser
    
                                                                      Step Definition File
  package StepDefinition;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrmSteps {

    WebDriver driver;
    @Given("I will launch chrome browser")
    public void i_will_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver","F:/chromedriver_win32/chromedriver.exe");
        driver=new ChromeDriver();

    }

    @When("i will open orange hrm home page")
    public void i_will_open_orange_hrm_home_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Then("i verify the logo present on page")
    public void i_verify_the_logo_present_on_page() {
        boolean status=driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).isDisplayed();
        Assert.assertEquals(true,status);
    }

    @Then("close browser")
    public void close_browser() {

        driver.quit();
    }

}

                                                            Test runner class
                                                            
package TestRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//Hp//IdeaProjects//SeleniumCucumberBDD//Features//OrangeHRM.feature",
        glue="StepDefinition",
        plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true

)
public class TestRunner {
}
    
