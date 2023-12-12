package systemclasses.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class WebDriverHelper {

    public static WebDriver testDriver;
    public static int explicitWaitTime = 3;
    public static int retryInterval = 100;
    public static boolean useWait = true;


    public static void navigateToThisURL(String url)
    {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        testDriver.get(url);
    }

    public static void initializeWebDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        WebDriverHelper.testDriver = new ChromeDriver();
        WebDriverHelper.testDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public static void initializeWebDriver(long timeout){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        WebDriverHelper.testDriver = new ChromeDriver();
        WebDriverHelper.testDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public static boolean verifyElementIsPresentHandler(String selector){
        try{
            testDriver.findElement(By.cssSelector(selector));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


    public static boolean waitForElementToBePresent(String selector, boolean isExpectedToBePresent)
    {
        int timesToWait = (WebDriverHelper.explicitWaitTime * 1000) / WebDriverHelper.retryInterval;
        int interval = 0;
        boolean expectedWasMet = false;
        while(interval < timesToWait )
        {
            boolean wasFound = WebDriverHelper.verifyElementIsPresentHandler(selector);
            if(wasFound == isExpectedToBePresent)
            {
                expectedWasMet = true;
                break;
            }
            try {
                sleep(WebDriverHelper.retryInterval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            interval++;
        }
        return expectedWasMet;
    }


    public static boolean waitForElementToBeVisible(String selector, boolean isExpectedToBePresent)
    {
        int timesToWait = (WebDriverHelper.explicitWaitTime * 1000) / WebDriverHelper.retryInterval;
        int interval = 0;
        boolean expectedWasMet = false;
        while(interval < timesToWait )
        {
            WebElement link = WebDriverHelper.testDriver.findElement(By.cssSelector(selector));
            if(link.isDisplayed() == isExpectedToBePresent)
            {
                expectedWasMet = true;
                break;
            }
            try {
                sleep(WebDriverHelper.retryInterval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            interval++;
        }
        return expectedWasMet;
    }


    public static void hoverOverThisElement(String selector)
    {
        WebElement element = WebDriverHelper.returnThisWebElement(selector);
        Actions actions = new Actions(WebDriverHelper.testDriver);
        actions.moveToElement(element).perform();
    }

    public static void clickThisElement(String selector)
    {
        WebElement element = WebDriverHelper.returnThisWebElement(selector);
        Actions actions = new Actions(WebDriverHelper.testDriver);
        actions.click(element).perform();
    }


    public static WebElement returnThisWebElement(String selector){
        WebElement we = null;
        boolean isPresent = WebDriverHelper.verifyElementIsPresentHandler(selector);
        if(isPresent)
        {
            we = WebDriverHelper.testDriver.findElement(By.cssSelector(selector));
        }
        return we;
    }


}
