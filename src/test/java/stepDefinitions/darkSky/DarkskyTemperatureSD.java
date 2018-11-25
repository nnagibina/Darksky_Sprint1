package stepDefinitions.darkSky;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.darkSky.BasePage;
import pageObjects.darkSky.LandingPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class DarkskyTemperatureSD {
    private WebDriver driver;
    private BasePage home;
    private LandingPage landing;


    @Given("^I am on Darksky home Page$")
    public void goTo() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get("https://darksky.net");
    }

    @When("^I expand todays timeline$")
    public void iExpandTodaysTimeline() {
        this.home = new BasePage(this.driver);
        JavascriptExecutor jse = (JavascriptExecutor)this.driver;
        jse.executeScript("scroll(0, 600);");
        this.home.getToday().click();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void iVerifyLowestAndHighestTempIsDisplayedCorrectly() {
        this.home = new BasePage(this.driver);
        String minTemp = this.home.getMinTemp().getText();
        String maxTemp = this.home.getMaxTemp().getText();
        String minTempToCompare = this.home.getMinTempToCompare().getText();
        String maxTempToCompare = this.home.getMaxTempToCompare().getText();
        Assert.assertTrue(minTemp.equals(minTempToCompare) && maxTemp.equals(maxTempToCompare));
    }
}
