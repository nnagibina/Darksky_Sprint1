package stepDefinitions.darkSky;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import pageObjects.darkSky.BasePage;
import pageObjects.darkSky.LandingPage;

public class BasePageSD {

    private WebDriver driver;
    private BasePage home;
    private LandingPage landing;

    @Given("^Goto$")
    public void goTo() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get("https://darksky.net");
    }

    @When("^Clear search text field$")
    public void clearSearchTextField() {
        this.home = new BasePage(this.driver);
        this.home.clearSearchTextField();
    }

    @And("^Enter address or zipcode into the search field \"([^\"]*)\"$")
    public void enterAddressOrZipcodeIntoTheSearchField(String data) {
        this.home = new BasePage(this.driver);
        this.home.enterAddressOrZipcodeIntoTheSearchField(data);
    }

    @And("^Click on search magnifying glass$")
    public void clickOnSearchMagnifyingGlass() {
        this.home = new BasePage(this.driver);
        this.home.clickOnSearchMagnifyingGlass();
    }

    @And("^Verify current temperature is between low and high value$")
    public void verifyCurrentTemperatureIsBetweenLowAndHighValue() {
        this.home = new BasePage(this.driver);
        this.landing = new LandingPage(this.driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(
                this.landing.getCurrentValueOfTemperature() >= this.landing.getLowValueOfTemperature() &&
                        this.landing.getCurrentValueOfTemperature() <= this.landing.getHighValueOfTemperature());
    }

}