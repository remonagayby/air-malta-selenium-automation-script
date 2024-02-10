package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Properties properties;

    public WebDriver initiateDriver(Properties properties) {
        String browserName = properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-notifications");
            driver = new FirefoxDriver(options);
        }
        else {
            System.out.println("Invalid Browser Name " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("url"));

        return driver;
    }

    public Properties initiateProperties() {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/Config.properties");
            properties.load(file);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String fileLocation = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(fileLocation));
    }
}
