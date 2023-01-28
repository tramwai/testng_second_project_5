package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UnitedBasePage {

    // constructor to initialize each web element
    public UnitedBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // all main menu options locators
    @FindBy(css = "a[id^='headerNav']")
    public List<WebElement> mainMenuOptions;

    // Book travel menu navigation items
    @FindBy(css = "ul[class$='travelNav--3RNBj'] li")
    public List<WebElement> bookTravelMenuNavigationItems;

    // Roundtrip radio button input box
    @FindBy(css = "#roundtrip")
    public WebElement roundtripRadioButtonInputBox;

    // Roundtrip radio button label
    @FindBy(css = "label[for='roundtrip']")
    public WebElement roundtripRadioButtonLabel;


    // One-way radio button input box
    @FindBy(css = "#oneway")
    public WebElement onewayRadioButtonInputBox;

    // One-way radio button label
    @FindBy(css = "label[for='oneway']")
    public WebElement onewayRadioButtonLabel;

    // Book with miles and flexible dates checkbox inputs
    @FindBy(css = "div[class*='checkboxWrapper']>input")
    public List<WebElement> checkboxInput;

    // Book with miles and flexible dates checkbox labels
    @FindBy(css = "div[class*='checkboxWrapper']>label")
    public List<WebElement> checkboxLabels;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromOriginInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toDestinationInputBox;

    @FindBy(id = "DepartDate")
    public WebElement departDateInputBox;

    @FindBy(css = "#passengerSelector>button")
    public WebElement passengerSelectorButton;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement addAdultPlusSignButton;

    @FindBy(id = "cabinType")
    public WebElement cabinTypeDropdownMenu;

    @FindBy(css = "li[id^='cabinType_item-2']")
    public WebElement cabinTypeItems;

    @FindBy(css = "button[aria-label='Find flights']")
    public WebElement findFlightsButton;
}
