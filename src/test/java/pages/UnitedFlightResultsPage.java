package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnitedFlightResultsPage extends UnitedBasePage {
    public UnitedFlightResultsPage() {
        super();
    }

    // @FindBy(xpath = "//*[@id=\"flightResults-content\"]/div[2]/div/div/div/div[1]/div/span")  -> full xpath works
    ///@FindBy(css = "div[class$='sticky--1-Jdl'] span b")
    //(//div[@class$='sticky--1-Jdl'] span b)[1]
    // (//div[@id='flightResults-content']//b)[1]/..
    // //div[#'flightResults-content']/div/div/span[@innertext=' February 28']
    //  @FindBy(xpath = "(//div[@id='flightResults-content']//b)[1]/../..")

    // css = ".app-components-Shopping-ColumnSortResultHeader-styles__detailHeading--2d8nC > span"
    @FindBy(xpath = "(//div[@id='flightResults-content']//b)[2]/..")
    public WebElement departureDateConfirmation;
}
