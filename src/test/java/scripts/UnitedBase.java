package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.UnitedBasePage;
import pages.UnitedFlightResultsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class UnitedBase {

    WebDriver driver;
    SoftAssert softAssert;
    UnitedBasePage unitedBasePage;
    UnitedFlightResultsPage unitedFlightResultsPage;


    // before anything, setup page
    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        softAssert = new SoftAssert();
        unitedBasePage = new UnitedBasePage();
        unitedFlightResultsPage = new UnitedFlightResultsPage();
    }

    // after method for quiting driver
    @AfterMethod
    public void teardown() {
        softAssert.assertAll();
        Driver.quitDriver();
    }

}
