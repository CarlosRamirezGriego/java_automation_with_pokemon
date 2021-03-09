package Wrappers;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebElementWrapper {
    public String selector;
    public String selectorMethod;
    public List<WebElement> allMatchingResults = new ArrayList<>();
    public String elementText = null;
    private int amountElements = 0;

    public WebElementWrapper()
    {
        this.selector = null;
        this.selectorMethod = null;
    }

    public void ResetElement()
    {
        allMatchingResults.clear();
        amountElements = 0;
    }

    public WebElementWrapper(String selector, String selectorMethod)
    {
        this.selector = selector;
        this.selectorMethod = selectorMethod;
    }

    public int GetAmountElements(){
        return amountElements;
    }

    public void CountMatchingElements()
    {
        amountElements = allMatchingResults.size();
    }

    public WebElement ReturnTheIWebElementInPosition(int i)
    {
        WebElement testElement = null;
        if (!(i <= 0 || i > amountElements))
        {
            testElement = allMatchingResults.get(i - 1);
        }
        return testElement;
    }

}
