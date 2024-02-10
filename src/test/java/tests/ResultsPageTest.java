package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.Constants;

public class ResultsPageTest extends BaseTest {

    @Test
    public void getFirstFlightPrice() {

        homePage.clickTripTypeDropdown()
                .selectOneTrip()
                .clickDepartureFrom()
                .searchDepartureCity(departureCity)
                .selectDepartureCity(departureCity)
                .clickDestinationFrom()
                .clickDestinationCity()
                .selectDestinationCity(destinationCity)
                .clickDepartureDate()
                .selectDepartureDate()
                .clickFindFlights()
                .checkFlightAvailability();
        String pageTitle = flightResultsPage.resultsPageTitle();
        Assert.assertEquals(pageTitle, Constants.RESULTS_PAGE_TITLE);
    }
}
