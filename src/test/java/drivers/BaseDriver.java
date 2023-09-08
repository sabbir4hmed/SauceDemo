package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseDriver
{

    WebDriver driver;
    public static String baseurl = "https://www.saucedemo.com/";

    @BeforeSuite
    public void startdriver()
    {
        String browser =  System.getProperty("browser","chrome");
        if(browser.contains("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.contains("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }

        PageDriver.getInstance().setWebdriver(driver);
    }

    @AfterSuite
    public void closedriver()
    {
        PageDriver.getcurrentdriver().quit();
    }




}
