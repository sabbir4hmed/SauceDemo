package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import drivers.BaseDriver;
import drivers.PageDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExtentFactory;

import java.io.IOException;

public class LoginTest extends BaseDriver
{
    ExtentTest parentest;
    ExtentReports report;
    ExtentTest childtest;


    @BeforeClass
    public void starturl()
    {
        report = ExtentFactory.getInstance();
        parentest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Click on login button</b></p>")
                .assignAuthor("Sabbir Ahmed").assignDevice("Linux");
        PageDriver.getcurrentdriver().get(baseurl);
        PageDriver.getcurrentdriver().manage().window().maximize();
    }

    @Test
    public void logintest() throws IOException {
        childtest = parentest.createNode("<p style=\\\"color:DarkBlue; font-size:20px\\\"><b>Click On Login Button.</b></p>");
        LoginPage loginPage = new LoginPage(childtest);
        loginPage.clickonlogin();

    }
    @AfterClass
    public void afterclass()
    {
        report.flush();
    }

}
