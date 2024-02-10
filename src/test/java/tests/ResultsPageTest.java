package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Constants;

public class ResultsPageTest extends BaseTest {

    @Test
    @Description("Should get the first available today flight price or the day over")
    public void getFirstFlightPrice() {

        homePage.clickTripTypeDropdown()
                .selectOneTrip()
                .clickDepartingFrom()
                .searchDepartureCity(departureCity)
                .selectDepartureCity(departureCity)
                .clickFlyingTo()
                .selectDestinationCity(destinationCity)
                .clickDepartureDate()
                .selectTodayDate()
                .clickFindFlights()
                .checkFlightAvailability();
        String pageTitle = flightResultsPage.resultsPageTitle();
        Assert.assertEquals(pageTitle, Constants.RESULTS_PAGE_TITLE);
    }
}
