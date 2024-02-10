package tests;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.FlightResultsPage;
import pages.HomePage;

import java.util.Properties;
@Listeners
public class BaseTest {

    WebDriver driver;
    Properties properties;
    BaseClass baseClass;
    HomePage homePage;
    FlightResultsPage flightResultsPage;
    String departureCity;
    String destinationCity;


    @BeforeMethod
    public void setUp() {
        baseClass = new BaseClass();
        properties = baseClass.initiateProperties();
        driver = baseClass.initiateDriver(properties);
        departureCity = properties.getProperty("departureCity");
        destinationCity = properties.getProperty("destinationCity");
        homePage = new HomePage(driver);
        flightResultsPage = new FlightResultsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
