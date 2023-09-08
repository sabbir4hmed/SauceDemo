package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import drivers.BaseDriver;
import drivers.PageDriver;
import net.bytebuddy.build.Plugin;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProductSelectPage;
import utils.ExtentFactory;

import java.io.IOException;

public class ProductSelectTest extends BaseDriver
{
    ExtentTest test;
    ExtentReports reports;
    ExtentTest parentest;
    ExtentTest childtest;
    @BeforeClass
    public void starturl()
    {
        reports = ExtentFactory.getInstance();
        parentest = reports.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Click on product button</b></p>")
                .assignAuthor("Sabbir Ahmed").assignDevice("Linux");
        PageDriver.getcurrentdriver().manage().window().maximize();

    }

    @Test
    public void productselecttest() throws IOException {
       // childtest = parentest;
        childtest = parentest.createNode("<p style=\\\"color:DarkBlue; font-size:20px\\\"><b>Click On Product Button.</b></p>");
        ProductSelectPage productSelectPage = new ProductSelectPage(childtest);
        productSelectPage.selectproduct();


    }
@AfterClass
    public void afterclass()
    {
        reports.flush();
    }
}
