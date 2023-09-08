package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentFactory
{
    public static final ExtentReports extentreport = new ExtentReports();

    public synchronized static ExtentReports getInstance()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/Report.html");
        reporter.config().setReportName("Project Extent Report");
        extentreport.attachReporter(reporter);
        return extentreport;
    }

}
