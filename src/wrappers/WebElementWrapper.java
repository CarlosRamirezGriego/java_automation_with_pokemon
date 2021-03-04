package wrappers;

import org.openqa.selenium.WebElement;

import java.util.List;


public class WebElementWrapper {
    public String selector;
    public String selectorMethod;
    public List<WebElement> allMatchingResults;
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
        WebElement TestWE = null;
        if (!(i <= 0 || i > amountElements))
        {
            TestWE = allMatchingResults.get(i - 1);
        }
        return TestWE;
    }

}
