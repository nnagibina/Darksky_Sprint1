package pageObjects.darkSky;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void clearSearchTextField() {
        this.searchForm.clear();
    }

    public void enterAddressOrZipcodeIntoTheSearchField(String data) {
        this.searchForm.sendKeys(data);
    }

    public void clickOnSearchMagnifyingGlass() {
        this.searchButton.click();
    }

}