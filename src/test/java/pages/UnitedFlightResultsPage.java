package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnitedFlightResultsPage extends UnitedBasePage {
    public UnitedFlightResultsPage() {
        super();
    }

    ///@FindBy(css = "div[class$='sticky--1-Jdl'] span b")
    @FindBy(xpath = "//*[@id=\"flightResults-content\"]/div[2]/div/div/div/div[1]/div/span")
    public WebElement departureDateConfirmation;
}
