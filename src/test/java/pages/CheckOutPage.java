package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import drivers.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScreenshotFactory;
import utils.Utilities;

import java.io.IOException;

public class CheckOutPage extends Utilities
{
    ExtentTest test;
    public CheckOutPage(ExtentTest test)
    {
        PageFactory.initElements(PageDriver.getcurrentdriver(), this);
        this.test = test;
    }

    @FindAll
            ({
                    @FindBy(xpath = "//button[@id='checkout']")
            })

    public WebElement checkoutbtn;


    @FindAll
            ({
                    @FindBy(xpath = "//input[@id='first-name']")
            })
    public WebElement firstname;

    @FindAll
            (
                    {
                            @FindBy(css = "#last-name")
                    }

            )
    public WebElement lastnamee;

    @FindAll
            (
                    {
                            @FindBy(xpath = "//input[@id='postal-code']")
                    }
            )
    public WebElement postalcode;

    @FindAll
            ({
                    @FindBy(xpath = "//input[@id='continue']")
            })

    public WebElement continuebtn;


    public void checkout() throws IOException {
        checkoutbtn.click();
        sleep();

        try {
            timeout(3000);
            test.pass("<p style=\"color:green; font-size:13px\"><b>Chekout Button Click</b></p>");
            timeout(5000);
            String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Chekout Button Click Pass");
            String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Chekout Button Click Pass"+".png";
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
            timeout(5000);
        } catch (Exception e) {
            test.fail("<p style=\\\"color:red; font-size:13px\\\"><b>Chekout Button Click</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Chekout Button Click Failed");
            String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Chekout Button Click Failed";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
        }

        timeout(10000);
    }

    public void continuecheckout() throws IOException {
        firstname.sendKeys("Sabbir");
        timeout(2000);
        lastnamee.sendKeys("ahmed");
        timeout(2000);
        postalcode.sendKeys("1900");
        sleep();
        continuebtn.click();

        try {
            timeout(3000);
            test.pass("<p style=\"color:green; font-size:13px\"><b>Checkout Continue Button Click</b></p>");
            timeout(5000);
            String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Checkout Continue Button Click Pass");
            String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Checkout Continue Button Click Pass"+".png";
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
            timeout(5000);
        } catch (Exception e) {
            test.fail("<p style=\\\"color:red; font-size:13px\\\"><b>Checkout Continue Button Click</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Checkout Continue Button Click Failed");
            String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Checkout Continue Button Click Failed";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
        }

        timeout(10000);
    }

}
