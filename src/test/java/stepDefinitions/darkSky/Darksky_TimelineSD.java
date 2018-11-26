package stepDefinitions.darkSky;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.darkSky.BasePage;
import pageObjects.darkSky.LandingPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Darksky_TimelineSD {

    private WebDriver driver;
    private BasePage home;
    private LandingPage landing;

    @Given("^I am on Darksky home page$")
    public void goTo() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get("https://darksky.net");
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimelineIsDisplayedWithTwoHoursIncrements() {
        this.home = new BasePage(this.driver);
        WebElement hours = this.home.getHours();
        String strHours = hours.getText();
        String[] arrStrHours = strHours.split("\n");
        String format = new SimpleDateFormat("haa").format(Calendar.getInstance().getTime());
//        Date currentDate = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("haa");
//        String currentHour = sdf.format(currentDate);
          arrStrHours[0] = format.toLowerCase();
        //           for (String hour : arrStrHours) {
        //            System.out.println(hour);
        //        }
        boolean isTimelineIsDisplayedWithTwoHoursIncrements = true;
        int i;
        for (i = 0; i < arrStrHours.length - 1; i++) {
            int hourNumber = Integer.parseInt(arrStrHours[i].substring(0, arrStrHours[i].length() - 2));
            //   System.out.println(hourNumber);
            int hourNext = Integer.parseInt(arrStrHours[i + 1].substring(0, arrStrHours[i + 1].length() - 2));

            switch (hourNumber) {
                case 11:
                    if (hourNext != 1) {
                        isTimelineIsDisplayedWithTwoHoursIncrements = false;
                    }
                    break;
                case 12:
                    if (hourNext != 2) {
                        isTimelineIsDisplayedWithTwoHoursIncrements = false;
                    }
                    break;
                default:
                    if (hourNumber + 2 != hourNext) {
                        isTimelineIsDisplayedWithTwoHoursIncrements = false;
                    }
            }
            if (!isTimelineIsDisplayedWithTwoHoursIncrements) {
                break;
            }
        }
        Assert.assertTrue(isTimelineIsDisplayedWithTwoHoursIncrements);

    }

}
