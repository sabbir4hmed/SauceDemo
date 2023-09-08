package drivers;

import org.openqa.selenium.WebDriver;

public class PageDriver
{
    public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();

    public static PageDriver instance = null;

    public static PageDriver getInstance() {
        if(instance == null)
        {
            instance = new PageDriver();
        }
        return instance;
    }

    public WebDriver getWebdriver() {

        return webdriver.get();
    }

    public void setWebdriver(WebDriver driver){
        webdriver.set(driver);
    }

    public PageDriver()
    {

    }

    public static WebDriver getcurrentdriver()
    {

        return getInstance().getWebdriver();
    }
}
