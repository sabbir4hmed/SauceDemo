package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;

public class ScreenshotFactory
{
    public  static String capture (WebDriver driver , String screenshotname) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String savess = System.getProperty("user.dir") + "\\ScreenShot Name\\" + screenshotname + ".png";
        File file = new File(savess);
        FileUtils.copyFile(source,file);

        return savess;
    }
}
