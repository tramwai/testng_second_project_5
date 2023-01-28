package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedBasePage;

public class UnitedBasePageTest extends UnitedBase {

    /**
     * Test Case 1: Validate "Main menu" navigation items
     * Given user is on "https://www.united.com/en/us"
     * Then user should see “Main menu” navigation items
     * |BOOK                	          	  |
     * |MY TRIPS            	          	  |
     * |TRAVEL INFO         	              |
     * |MILEAGEPLUS® PROGRAM|
     * |DEALS               	          	  |
     * |HELP
     */

    @BeforeMethod
    public void setPage() {
        unitedBasePage = new UnitedBasePage();
    }

    @Test(priority = 1, description = "Validate \"Main menu\" navigation items")
    public void validateMainMenuOptions() {
        String[] mainMenuOptionsText = {"BOOK",
                "MY TRIPS",
                "TRAVEL INFO",
                "MILEAGEPLUS® PROGRAM",
                "DEALS",
                "HELP"
        };
        for (int i = 0; i < 6; i++) {
            softAssert.assertTrue(unitedBasePage.mainMenuOptions.get(i).isDisplayed());
            softAssert.assertEquals(unitedBasePage.mainMenuOptions.get(i).getText(), mainMenuOptionsText[i]);
        }
    }

    /**
     * Test Case 2: Validate "Book travel menu" navigation items
     * Given user is on "https://www.united.com/en/us"
     * Then user should see "Book travel menu" navigation items
     * |Book             |
     * |Flight Status|
     * |Check-in       |
     * |My trips        |
     */

    @Test(priority = 2, description = "Validate \"Book travel menu\" navigation items")
    public void validateBookTravelMenuNavigationItems() {
        String[] navigationItemsText = {"Book",
                "Flight status",
                "Check-in",
                "My trips"
        };
        for (int i = 0; i < 4; i++) {
            softAssert.assertTrue(unitedBasePage.bookTravelMenuNavigationItems.get(i).isDisplayed());
            softAssert.assertEquals(unitedBasePage.bookTravelMenuNavigationItems.get(i).getText(), navigationItemsText[i]);
        }

    }

    /**
     * Test Case 3: Validate "Round-trip" and "One-way" radio buttons
     * Given user is on "https://www.united.com/en/us"
     * Then validate "Roundtrip" radio button is displayed, is enabled and is selected
     * And validate "One-way" radio button is displayed, is enabled but is not selected
     * When user clicks on "One-way" radio button
     * Then validate "One-way" radio button is selected while "Roundtrip" radio button is deselected
     */

    @Test(priority = 3, description = "Validate \"Round-trip\" and \"One-way\" radio buttons")
    public void validateRadioButtons() {
        //validate "Roundtrip" radio button is displayed, is enabled and is selected
        softAssert.assertTrue(unitedBasePage.roundtripRadioButtonLabel.isDisplayed());
        softAssert.assertTrue(unitedBasePage.roundtripRadioButtonInputBox.isEnabled());
        softAssert.assertTrue(unitedBasePage.roundtripRadioButtonInputBox.isSelected());

        // validate "One-way" radio button is displayed, is enabled but is not selected
        softAssert.assertTrue(unitedBasePage.onewayRadioButtonLabel.isDisplayed());
        softAssert.assertTrue(unitedBasePage.onewayRadioButtonInputBox.isEnabled());
        softAssert.assertFalse(unitedBasePage.onewayRadioButtonInputBox.isSelected());

        // user clicks on "One-way" radio button
        unitedBasePage.onewayRadioButtonLabel.click();

        // validate "One-way" radio button is selected
        softAssert.assertTrue(unitedBasePage.onewayRadioButtonInputBox.isSelected());
        // while "Roundtrip" radio button is deselected
        softAssert.assertFalse(unitedBasePage.roundtripRadioButtonLabel.isSelected());

    }


    /**
     * Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
     * Given user is on "https://www.united.com/en/us"
     * Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
     * And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
     * When user clicks both checkboxes
     * Then validate both checkboxes are selected
     * When user clicks on both selected checkboxes again
     * Then validate both checkboxes are deselected
     */

    @Test(priority = 4, description = "Validate \"Book with miles\" and \"Flexible dates\" checkboxes")
    public void validateBookWithMilesAndFlexibleDatesCheckboxes() {

        // validate "Book with miles" checkbox is displayed is enabled but is not selected
        softAssert.assertTrue(unitedBasePage.checkboxLabels.get(0).isDisplayed());
        softAssert.assertTrue(unitedBasePage.checkboxInput.get(0).isEnabled());
        softAssert.assertFalse(unitedBasePage.checkboxInput.get(0).isSelected());

        //validate "Flexible dates" checkbox is displayed, is enabled but is not selected
        softAssert.assertTrue(unitedBasePage.checkboxLabels.get(1).isDisplayed());
        softAssert.assertTrue(unitedBasePage.checkboxInput.get(1).isEnabled());
        softAssert.assertFalse(unitedBasePage.checkboxInput.get(1).isSelected());

        //  user clicks both checkboxes
        unitedBasePage.checkboxLabels.get(0).click();
        unitedBasePage.checkboxLabels.get(1).click();

        // Then validate both checkboxes are selected
        softAssert.assertTrue(unitedBasePage.checkboxInput.get(0).isSelected());
        softAssert.assertTrue(unitedBasePage.checkboxInput.get(1).isSelected());

        // When user clicks on both selected checkboxes again
        unitedBasePage.checkboxLabels.get(0).click();
        unitedBasePage.checkboxLabels.get(1).click();

        // Then validate both checkboxes are deselected
        softAssert.assertFalse(unitedBasePage.checkboxInput.get(0).isSelected());
        softAssert.assertFalse(unitedBasePage.checkboxInput.get(1).isSelected());
    }

    /**
     * Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”
     * Given user is on "https://www.united.com/en/us"
     * When user selects "One-way" ticket radio button
     * And user enters "Chicago, IL, US (ORD)" to from input box
     * And user enters "Miami, FL, US (MIA)" to to input box
     * And user selects "Feb 28" to the dates input box
     * And user selects "2 Adults" from travelers selector
     * And user selects "Business or First" from cabin dropdown
     * And user clicks on "Find Flights" button
     * Then validate departure equals to "DEPART ON: February 28"
     */

    @Test(priority = 5, description = "Validate One-way ticket search results \"from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”")
    public void validateOneWayTicketSearchResults() {

        // user selects "One-way" ticket radio button
        unitedBasePage.onewayRadioButtonLabel.click();

        // user enters "Chicago, IL, US (ORD)" to from input box
        unitedBasePage.fromOriginInputBox.click();
        unitedBasePage.fromOriginInputBox.clear();
        unitedBasePage.fromOriginInputBox.sendKeys("Chicago, IL, US (ORD)");

        // user enters "Miami, FL, US (MIA)" to input box
        unitedBasePage.toDestinationInputBox.click();
        unitedBasePage.toDestinationInputBox.sendKeys("Miami, FL, US (MIA)");

        // user selects "Feb 28" to the dates input box
        unitedBasePage.departDateInputBox.click();
        unitedBasePage.departDateInputBox.clear();
        unitedBasePage.departDateInputBox.sendKeys("Feb 28");
        unitedBasePage.departDateInputBox.click();

        // user selects "2 Adults" from travelers selector
        unitedBasePage.passengerSelectorButton.click();
        unitedBasePage.addAdultPlusSignButton.click();

        // user selects "Business or First" from cabin dropdown
        unitedBasePage.cabinTypeDropdownMenu.click();
        unitedBasePage.cabinTypeItems.click();

        // user clicks on "Find Flights" button
        unitedBasePage.findFlightsButton.click();

        // validate departure equals to "DEPART ON: February 28"
        Assert.assertEquals(unitedFlightResultsPage.departureDateConfirmation.getText(), "DEPART ON: February 28");

    }
}
