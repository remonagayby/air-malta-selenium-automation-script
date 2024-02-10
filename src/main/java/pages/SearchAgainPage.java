package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchAgainPage extends BasePage{
    public SearchAgainPage(WebDriver driver) {
        super(driver);
    }

    private final By newDepartureDate = By.id("startDate_id");
    private final By selectNewDate = By.xpath("(//*[@aria-disabled='false'])[2]");
    private final By goButton = By.xpath("//*[@class='ButtonUI__Button-gOoDBI hYAUAg']");

    public SearchAgainPage clickNewDepartureDate() {
        driver.findElement(newDepartureDate).click();
        return this;
    }

    public SearchAgainPage selectNewDepartureDate() {
        driver.findElement(selectNewDate).click();
        return this;
    }

    public SearchAgainPage selectNewDestinationDate() {
        driver.findElement(selectNewDate).click();
        return this;
    }

    public FlightResultsPage clickGoButton() {
        driver.findElement(goButton).click();
        return new FlightResultsPage(driver);
    }
}
