package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import drivers.PageDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckOutPage;

import java.io.IOException;

public class CheckOutTest
{
    ExtentReports reports;
    ExtentTest parentest;
    ExtentTest childtest;

    @BeforeClass
    public void url()
    {
        reports = new ExtentReports();
        parentest= reports.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Check Out Test</b></p>")
                .assignAuthor("Sabbir Ahmed").assignDevice("Linux");
        PageDriver.getcurrentdriver().manage().window().maximize();
    }

    @Test(priority = 0)
    public void checkouttest() throws IOException {
        childtest = parentest.createNode("<p style=\\\"color:DarkBlue; font-size:20px\\\"><b>Click On Check Out Button.</b></p>");
        CheckOutPage checkOutPage = new CheckOutPage(childtest);
        checkOutPage.checkout();
    }

    @Test(priority = 1)
    public void continuetest() throws IOException {
        childtest = parentest.createNode("<p style=\\\"color:DarkBlue; font-size:20px\\\"><b>Click On Chekout Continue Button.</b></p>");
        CheckOutPage checkOutPage = new CheckOutPage(childtest);
        checkOutPage.continuecheckout();
    }

    @AfterClass
    public void afterclass()
    {
        reports.flush();
    }
}
