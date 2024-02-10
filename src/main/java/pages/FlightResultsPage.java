package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Constants;

public class FlightResultsPage extends BasePage {
    public FlightResultsPage(WebDriver driver) {
        super(driver);
    }

    private final By getWarningMessage = By.xpath("//*[@class='AlertUI__AlertMessage-eMSWPX krfPmN']");
    private final By getAvailableFlight = By.xpath("//*[@class ='sc-iPahhU ivsWJx']");
    private final By getFirstFlight = By.xpath("//*[@class='sc-dLmyTH fZhVgI']");
    private final By noFlight = By.xpath("//*[@class='sc-bRimrq dqrUVO']//*[text() = 'No flight']");
    private final By searchAgain = By.xpath("//a[normalize-space()='SEARCH']");

    public String resultsPageTitle() {
        return driver.getTitle();
    }


    public String warningMessage() {
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(getWarningMessage));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return driver.findElement(getWarningMessage).getText();
    }

    public void checkFlightAvailability() {
        String flight = "";

        if (warningMessage().equals(Constants.FAIL_MESSAGE_Warning) &&
                driver.findElement(noFlight).getText().contains("No flight")) {
            clickSearch()
                    .clickNewDepartureDate()
                    .selectNewDepartureDate()
                    .selectNewDestinationDate()
                    .clickGoButton()
                    .checkFlightAvailability();
        } else if (warningMessage().equals(Constants.SUCCESS_MESSAGE_Warning)){
            flight = driver.findElement(getAvailableFlight).getText();
            System.out.println("The first available flight price is " + flight.substring(11, 18).trim() + " €");
        } else {
            flight = driver.findElement(getFirstFlight).getText();
            System.out.println("The first available flight price is " + flight.substring(6, 14).trim() + " €");
        }
    }

    public SearchAgainPage clickSearch() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(searchAgain));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        driver.findElement(searchAgain).click();
        return new SearchAgainPage(driver);
    }
}
