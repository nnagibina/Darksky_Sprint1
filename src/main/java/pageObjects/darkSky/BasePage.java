package pageObjects.darkSky;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='searchForm']/input")
    private WebElement searchForm;

    @FindBy(xpath = "//*[@id='searchForm']/a[2]/img")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='timeline']//div[@class='hours']")
    private WebElement hours;

    @FindBy(xpath = "//*[@id='week']/a[1]/span[1]/span[2]")
    private WebElement today;

    @FindBy(xpath = "//*[@id='week']/a[1]/span[2]/span[1]")
    private WebElement minTemp;

    @FindBy(xpath = "//*[@id='week']/a[1]/span[2]/span[3]")
    private WebElement maxTemp;

    @FindBy(xpath = "//*[@id='week']/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]")
    private WebElement minTempToCompare;

    @FindBy(xpath = "//*[@id='week']/div[2]/div[1]/div[2]/div[1]/span[3]/span[1]")
    private WebElement maxTempToCompare;

    public void clearSearchTextField() {
        this.searchForm.clear();
    }

    public void enterAddressOrZipcodeIntoTheSearchField(String data) {
        this.searchForm.sendKeys(data);
    }

    public void clickOnSearchMagnifyingGlass() {
        this.searchButton.click();
    }

    public WebElement getHours() {
        return this.hours;

    }

    public WebElement getToday() {
        return this.today;
    }

    public WebElement getMinTemp() {
        return this.minTemp;
    }

    public WebElement getMaxTemp() {
        return this.maxTemp;
    }

    public WebElement getMinTempToCompare() {
        return this.minTempToCompare;
    }

    public WebElement getMaxTempToCompare() {
        return this.maxTempToCompare;
    }

}