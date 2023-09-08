package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import drivers.PageDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;
import utils.ExtentFactory;

import java.io.IOException;

public class CartAndRemoveTest
{
    ExtentReports reports;
    ExtentTest parenttest;
    ExtentTest childtest;

    @BeforeClass
    public void starturl()
    {
        reports = ExtentFactory.getInstance();
        parenttest = reports.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Click on Cart & Remove button</b></p>")
                .assignAuthor("Sabbir Ahmed").assignDevice("Linux");
        PageDriver.getcurrentdriver().manage().window().maximize();
    }

    @Test(priority = 0)
    public void cartclick() throws IOException {
        childtest = parenttest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On Cart Button.</b></p>");
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(childtest);
        shoppingCartPage.cart();
    }

    @Test(priority = 1)
    public void removeclick() throws IOException {
        childtest = parenttest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On Remove Button.</b></p>");
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(childtest);
        shoppingCartPage.remove();
    }

    @AfterClass
    public void afterclass()
    {
        reports.flush();
    }
}
