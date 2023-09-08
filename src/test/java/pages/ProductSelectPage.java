package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import drivers.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ScreenshotFactory;
import utils.Utilities;

import java.io.IOException;

public class ProductSelectPage extends Utilities
{
    ExtentTest test;
    public ProductSelectPage(ExtentTest test)
    {
        PageFactory.initElements(PageDriver.getcurrentdriver(),this);
        this.test = test;
    }


    @FindAll
            ({
                    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
            })
    public WebElement product1;

    @FindAll
            ({
                    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
            })
    public WebElement product2;

    @FindAll
            ({
                    @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']")
            })

    public WebElement product3;


    public  void selectproduct() throws IOException {

        try {
            product1.click();
            sleep();
            product2.click();
            sleep();
            product3.click();
            test.pass("<p style=\"color:green; font-size:13px\"><b>Product Button Clicked Pass.</b></p>");
            timeout(5000);
            String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Product Button Clicked Pass");
            String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Product Button Clicked Pass";
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
            timeout(5000);
        } catch (Exception e) {
            test.fail("<p style=\\\"color:red; font-size:13px\\\"><b>Product Button Clicked Fail.</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Product Button Clicked Fail");
            String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Product Button Clicked Fail";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
            Assert.assertTrue(product1.isDisplayed());
            Assert.assertTrue(product2.isDisplayed());
            Assert.assertTrue(product3.isDisplayed());
            PageDriver.getcurrentdriver().quit();
        }
        timeout(10000);


    }


}
