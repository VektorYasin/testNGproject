package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    //Driver.getDriver-->driver
    private static WebDriver driver;//declare the driver

    //Driver.getDriver();
    //WebDriver: return type
    //static: static method'da kullanacağız
    //private: baskasi dogrudan ulasamasın diye

    public static WebDriver getDriver() {
        //getDriver() is used to instantiate the driver object

        if (driver == null) {  //null: not initialized
            //after selenium 4.5--->create()

            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }
            driver = WebDriverManager.chromedriver().create();//bunu neden yazdık
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //will wait for the visibility of webElement

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        //wait for the page loading.

        driver.manage().window().maximize();

        return driver;

    }

    public static void closeDriver() {

        if (driver != null) {  //if it is being used(pointing an object), then quit the driver.

            driver.quit();
            driver = null; //to create again, it must be null.
        }
    }
}