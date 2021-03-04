package wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebPageWrapper {
    WebDriver driver;
    public int implicitWaitSeconds = 0;
    public int timeOutSeconds = 0;
    public int explicitWait = 10;
    public int milisecondsInterval = 100;


    public WebPageWrapper()   {}

    public WebPageWrapper(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebPageWrapper(String browser)
    {
        OpenBrowser(browser);
    }

    public void OpenBrowser(String browser)
    {
        switch (browser)
        {
            case "gc":
                driver = new ChromeDriver();
                break;
            case "ff":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;

        }
    }

    public void LoadWebPage(String url)
    {
        driver.get(url);
    }
}
