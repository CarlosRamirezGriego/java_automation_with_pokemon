package systemclasses.support;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static java.lang.Thread.sleep;

public class WebDriverHelper {
    public static WebDriver testDriver;
    public static int explicitWaitTime = 3;
    public static int retryInterval = 100;
    public static boolean useWait = true;

    public static void navigateToThisURL(String url)
    {
        testDriver.get(url);
    }

    public static void initializeWebDriver(){
        WebDriverHelper.testDriver = WebDriverManager.chromedriver().create();
        WebDriverHelper.testDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    public static void initializeWebDriver(long timeout){
        WebDriverHelper.testDriver = WebDriverManager.chromedriver().create();
        WebDriverHelper.testDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
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
