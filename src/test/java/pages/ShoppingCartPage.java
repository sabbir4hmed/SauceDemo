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

public class ShoppingCartPage extends Utilities
{
    ExtentTest test;
    public ShoppingCartPage(ExtentTest test)
    {
        PageFactory.initElements(PageDriver.getcurrentdriver(), this);
        this.test = test;
    }

    @FindAll
            ({
                    @FindBy(css = ".shopping_cart_link")
            })
    public WebElement cart;

    @FindAll
            ({
                    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
            })
    public WebElement remove;


    public void cart() throws IOException {
        cart.click();
        sleep();

        try {
            test.pass("<p style=\"color:green; font-size:13px\"><b>Cart</b></p>");
            timeout(5000);
            String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Cart Test Click Pass");
            String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Cart Test Click Pass";
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
            timeout(5000);
        } catch (Exception e) {
            test.fail("<p style=\\\"color:red; font-size:13px\\\"><b>Cart Test Click Fail</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Cart Test Click Fail");
            String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Cart Test Click Fail";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
        }

        timeout(10000);

    }

    public void remove() throws IOException {
        remove.click();
        sleep();

        try {
            test.pass("<p style=\"color:green; font-size:13px\"><b>Product Remove from Cart</b></p>");
            timeout(5000);
            String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Remove Test Click Pass");
            String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Remove Test Click Pass";
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
            timeout(5000);

        } catch (Exception e) {
            test.fail("<p style=\\\"color:red; font-size:13px\\\"><b>Product Remove from Cart</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Remove Test Click Fail");
            String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Remove Test Click Fail";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
        }

        timeout(10000);

    }

}
