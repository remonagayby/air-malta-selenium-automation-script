package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage{

    private final By departureFrom = By.xpath("//*[@class = 'route-selection-origin']");
    private final By departureSearch = By.name("Origin1");
    private final By departureCitySelection = By.cssSelector(".airport-option ");
    private final By destinationFrom = By.className("route-selection-destination");
    private final By destinationCitySelection = By.cssSelector(".airport-option");
    private final By departureDateForm = By.name("DepartureDate1");
    private final By departureDateSelection = By.cssSelector(".DayPicker-Day.DayPicker-Day--today");
    private final By destinationDateSelection = By.cssSelector(".DayPicker-Day.DayPicker-Day--today");
    private final By findFlightsButton = By.xpath("//*[text()='Find flights']");
    private final By tripTypeDropdown = By.xpath("//*[@class='select-input input-holder']");
    private final By tripType = By.cssSelector(".select-option");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String homePageTitle() {
        return driver.getTitle();
    }

    public HomePage clickDepartureFrom() {
        driver.findElement(departureFrom).click();
        return this;
    }

    public HomePage searchDepartureCity(String city) {
        driver.findElement(departureSearch).sendKeys(city);
        return this;
    }

    public HomePage selectDepartureCity(String departureCity) {
        List<WebElement> departureCityOptions =  driver.findElements(departureCitySelection);
        for (WebElement cityOption : departureCityOptions) {
            if (cityOption.getText().contains(departureCity)) {
                cityOption.click();
                break;
            }
        }
        return this;
    }

    public HomePage clickDestinationFrom() {
        driver.findElement(destinationFrom).click();
        return this;
    }

    public HomePage clickDestinationCity() {
        driver.findElement(destinationCitySelection).click();
        return this;
    }

    public HomePage selectDestinationCity(String destinationCity) {
        List <WebElement> destinationCityOptions = driver.findElements(destinationCitySelection);
        for (WebElement cityOption: destinationCityOptions) {
            if (cityOption.getText().contains(destinationCity)) {
                cityOption.click();
                break;
            }
        }
        return this;
    }

    public HomePage clickDepartureDate() {
        driver.findElement(departureDateForm).click();
        return this;
    }

    public HomePage selectDepartureDate() {
        driver.findElement(departureDateSelection).click();
        return this;
    }

    public HomePage selectDestinationDate() {
        driver.findElement(destinationDateSelection).click();
        return this;
    }

    public FlightResultsPage clickFindFlights() {
        driver.findElement(findFlightsButton).click();
        return new FlightResultsPage(driver);
    }

    public HomePage clickTripTypeDropdown() {
        driver.findElement(tripTypeDropdown).click();
        return this;
    }
    public HomePage selectOneTrip () {
        List<WebElement> tripTypeOptions =  driver.findElements(tripType);
        for (WebElement typeOption : tripTypeOptions) {
            if (typeOption.getText().equals("One way")) {
                typeOption.click();
                break;
            }
        }
        return this;
    }
}
