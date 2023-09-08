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

public class LoginPage extends Utilities
{
    ExtentTest test;
    public LoginPage(ExtentTest test)
    {
        PageFactory.initElements(PageDriver.getcurrentdriver(),this);
        this.test = test;
    }

    @FindAll(
            {
                    @FindBy(xpath = "//input[@id='user-name']")
            }
    )
    public WebElement username;

    @FindAll(
            {
                    @FindBy(xpath = "//input[@id='password']")
            }
    )
    public WebElement password;

    @FindAll(
            {
                    @FindBy(xpath = "//input[@id='login-button']")
            }
    )
    public WebElement loginbtn;

    public void clickonlogin() throws IOException {

        test.info("Login Click Test");

        try {
            username.isDisplayed();

            username.sendKeys("problem_user");
            sleep();
            //password.isDisplayed();
            password.sendKeys("secret_sauce");
            sleep();
            loginbtn.click();
            timeout(3000);
            test.pass("<p style=\"color:green; font-size:13px\"><b>Login Test Click Pass</b></p>");
            timeout(5000);
            String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Login Test Click Pass");
            String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Login Test Click Pass"+".png";
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
            timeout(5000);

        } catch (Exception e) {
           test.fail("<p style=\\\"color:red; font-size:13px\\\"><b>Login Test Failed</b></p>");
           Throwable t = new InterruptedException("Exception");
           test.fail(t);
           String sspath = ScreenshotFactory.capture(PageDriver.getcurrentdriver(), "Login Test Failed");
           String savess = System.getProperty("User.dir")+"\\screenshots\\"+"Login Test Failed";
           test.fail(MediaEntityBuilder.createScreenCaptureFromPath(sspath).build());
           Assert.assertTrue(username.isDisplayed());
           PageDriver.getcurrentdriver().quit();


        }

        timeout(10000);

    }

}
