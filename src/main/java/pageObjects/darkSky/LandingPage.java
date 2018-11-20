package pageObjects.darkSky;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='title']/span[1]/span[2]/span[1]")
    private WebElement tempCurrentValue;

    @FindBy(xpath = "//*[@id='title']/span[1]/span[2]/span[2]/span[2]")
    private WebElement tempLowValue;

    @FindBy(xpath = "//*[@id='title']/span[1]/span[2]/span[2]/span[3]")
    private WebElement tempHighValue;

    public int getCurrentValueOfTemperature() {
        return this.getNumberFromString(this.tempCurrentValue.getText(), 0);
    }

    public int getLowValueOfTemperature() {
        return this.getNumberFromString(this.tempLowValue.getText(), 1);
    }

    public int getHighValueOfTemperature() {
        return this.getNumberFromString(this.tempHighValue.getText(), 1);
    }

    private int getNumberFromString(String str, int index) {
        return Integer.parseInt(str.split(" ")[index].substring(0, str.split(" ")[index].length() - 1));
    }


}