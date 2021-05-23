package Wrappers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.List;

public class WebPageInterface {

    public WebDriver testDriver;
    public int explicitWait = 5;
    public final int defaultExplicit = 5;
    public int milisecondsInterval = 10;
    public ElementInterface testElement = new ElementInterface();
    public Boolean isSeleniumGrid = false;
    public Boolean HighLightElements = false;
    public Options.Browsers testBrowser;


    private void setTestDriver(WebDriver wd)
    {
        this.testDriver = wd;
    }

    public WebDriver getTestDriver()
    {
        return this.testDriver;
    }


    private void setExplicitWait(int i)
    {
        this.explicitWait = i;
    }

    public int getExplicitWait()
    {
        return this.explicitWait;
    }

    private void setMilisecondsInterval(int i)
    {
        this.milisecondsInterval = i;
    }

    public int getMilisecondsInterval()
    {
        return this.milisecondsInterval;
    }

    private void setIsSeleniumGrid(Boolean i)
    {
        this.isSeleniumGrid = i;
    }

    public Boolean getIsSeleniumGrid()
    {
        return this.isSeleniumGrid;
    }

    public WebPageInterface()
    {
    }

    public WebPageInterface(WebDriver driver)
    {
        testDriver = driver;
    }

    public WebPageInterface(Options.Browsers testBrowser)
    {
        OpenBrowser(testBrowser);
    }

    public void OpenBrowser(Options.Browsers testBrowser)
    {
        this.testBrowser = testBrowser;
        if (this.testBrowser == Options.Browsers.CHROME)
        {
            this.testDriver = new ChromeDriver();
            this.isSeleniumGrid = false;
        }
        else
        {
            this.testDriver = new FirefoxDriver();
            this.isSeleniumGrid = false;
        }
    }


    public void UpdateSearchInterval(int i)
    {
        if (i > 0 && i <= 100)
        {
            this.milisecondsInterval = i;
        }
    }

    public void LoadWebPage(String url)
    {
        this.testDriver.get(url);
    }

    public void MaximizeWindow()
    {
        this.testDriver.manage().window().maximize();
    }

    public String ReturnWebPageTitle()
    {
        return this.testDriver.getTitle();
    }

    public String ReturnPageURL()
    {
        return this.testDriver.getCurrentUrl();
    }

    public String ReturnPageSourceCode()
    {
        return this.testDriver.getPageSource();
    }

    public void CloseBrowser()
    {
        if (this.isSeleniumGrid)
        {
            this.testDriver.quit();
        }
        else
        {
            this.testDriver.close();
        }
    }

    public void GoForward()
    {
        this.testDriver.navigate().forward();
    }

    public void GoBack()
    {
        this.testDriver.navigate().back();
    }


    public void RefreshBrowser()
    {
        this.testDriver.navigate().refresh();
    }

    public void UpdateExplicitWait(int seconds)
    {
        this.explicitWait = seconds;
    }



    public void HighLightAllTheElementsThatMatch(ElementInterface we)
    {
        List<WebElement> sourceElements = new ArrayList<WebElement>();
        JavascriptExecutor js = (JavascriptExecutor )this.testDriver;
        for (WebElement iwe : we.allMatchingResults)
        {
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", iwe, "color: yellow;  border: 2px solid yellow;");
            if (iwe.getAttribute("style") != null)
            {
                pause(250);
            }
        }
        for (WebElement iwe : we.allMatchingResults)
        {
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", iwe, "");
        }
    }



    public ElementInterface SearchForTheseSelectorsData(ElementInterface we) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.ONE)
        {
            return ThisElementShouldHaveOneMatch(we);
        }
        else if (we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            return ThisElementShouldHaveMultipleMatches(we);
        }
        else
        {
            return ThisElementShouldHaveNoMatch(we);
        }
    }



    //This looks for a Child Element search results in side a Parent Element, by default in the Element 1 of the Parent
    public ElementInterface SearchForTheseSelectorsData(ElementInterface parent, ElementInterface child) throws Exception {
        if (!parent.hasBeenSearched)
        {
            parent = SearchForTheseSelectorsData(parent);
        }
        if (parent.amountElements > 1 || parent.amountElements == 1)
        {
            WebElement parentIWE = parent.ReturnTheIWebElementInPosition(1);
            if (child.expectedMatches == Options.ExpectedMatches.ONE)
            {
                return ThisElementShouldHaveOneMatch(child, parentIWE);
            }
            else if (child.expectedMatches == Options.ExpectedMatches.MANY)
            {
                return ThisElementShouldHaveMultipleMatches(child, parentIWE);
            }
            else
            {
                return ThisElementShouldHaveNoMatch(child, parentIWE);
            }
        }
        else
        {
            throw new Exception("The Parent Element with selector Method " + parent.selectorMethod.toString() + " and Search String \"" + parent.selector + "\" had Zero matches");
        }
    }

    //This looks for a Child Element search results in side a Parent Element, in the Element that the user specifies from the Parent
    public ElementInterface SearchForTheseSelectorsData(ElementInterface parent, ElementInterface child, int positionIWE) throws Exception {
        if (!parent.hasBeenSearched)
        {
            parent = SearchForTheseSelectorsData(parent);
        }
        if (positionIWE > 0 && positionIWE <= parent.amountElements)
        {
            if (parent.amountElements > 1 || parent.amountElements == 1)
            {
                WebElement parentIWE = parent.ReturnTheIWebElementInPosition(positionIWE);
                if (child.expectedMatches == Options.ExpectedMatches.ONE)
                {
                    return ThisElementShouldHaveOneMatch(child, parentIWE);
                }
                else if (child.expectedMatches == Options.ExpectedMatches.MANY)
                {
                    return ThisElementShouldHaveMultipleMatches(child, parentIWE);
                }
                else
                {
                    return ThisElementShouldHaveNoMatch(child, parentIWE);
                }
            }
            else
            {
                throw new Exception("The Parent Element with selector Method " + parent.selectorMethod.toString() + " and Search String \"" + parent.selector + "\" had Zero matches");
            }
        }
        else
        {
            throw new Exception("The Parent Element with selector Method " + parent.selectorMethod.toString() + " and Search String \"" + parent.selector + "\" had only " + parent.amountElements + " elements");
        }

    }



    public void ClickThisElement(ElementInterface we) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.NONE || we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \""
                    + we.selector + "\" is currently expecting No or Multiple matches, this function only works with elements that expect one match");
        }
        else
        {
            if (we.hasBeenSearched)
            {
                WebElement result = we.ReturnTheIWebElementInPosition(1);
                if(we.needsScroll)
                {
                    ScrollToThisElement(we);
                }
                if(we.isSlowElement)
                {
                    pause(200);
                }
                ActualClickAction(result);
            }
            else
            {
                SearchForTheseSelectorsData(we);
                WebElement result = we.ReturnTheIWebElementInPosition(1);
                if(we.needsScroll)
                {
                    ScrollToThisElement(we);
                }
                if(we.isSlowElement)
                {
                    pause(200);
                }
                ActualClickAction(result);
            }
        }
    }

    public void ClickElementFromListByIndex(ElementInterface we, int index) throws Exception {
        if (we.hasBeenSearched)
        {
            if (we.amountElements >= index && we.amountElements > 0)
            {
                if(we.needsScroll)
                {
                    ScrollToThisElement(we);
                }
                if(we.isSlowElement)
                {
                    pause(200);
                }
                WebElement result = we.ReturnTheIWebElementInPosition(index);
                ActualClickAction(result);
            }
            else
            {
                throw new Exception("Click Index provided is out of range from the actual available elements");
            }
        }
        else
        {
            SearchForTheseSelectorsData(we);
            if (we.amountElements >= index && we.amountElements > 0)
            {
                if(we.needsScroll)
                {
                    ScrollToThisElement(we);
                }
                if(we.isSlowElement)
                {
                    pause(200);
                }
                WebElement result = we.ReturnTheIWebElementInPosition(index);
                ActualClickAction(result);
            }
            else
            {
                throw new Exception("Click Index provided is out of range from the actual available elements");
            }
        }

    }

    private void ActualClickAction(WebElement iwe)
    {
        Actions actions = new Actions(testDriver);
        actions.click(iwe);
        actions.perform();
    }


    public void EnterTextInThisElement(ElementInterface we, String text) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.NONE || we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \""
                    + we.selector + "\" is currently expecting No or Multiple matches, this function only works with elements that expect one match");
        }
        else
        {
            int cycles = (explicitWait * 1000) / milisecondsInterval / 2;
            int counter = 0;
            Boolean mainCheck = false;
            while (counter <= cycles)
            {
                ThisElementShouldExistRegardlessVisibility(we);
                List<WebElement> result = we.allMatchingResults;
                Boolean isVisible = ValidateElementsAreVisible(result);
                Boolean isEnabled = ValidateElementsAreEnabled(result);
                {
                    if (isVisible && isEnabled)
                    {
                        mainCheck = true;
                        break;
                    }
                }
                counter = counter + 1;
            }
            if (mainCheck)
            {
                WebElement result = we.ReturnTheIWebElementInPosition(1);
                if(we.needsScroll)
                {
                    ScrollToThisElement(we);
                }
                ActualEnterTextAction(result, text);
            }
            else
            {
                throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \"" + we.selector + "\" was never set to Invisible State");
            }


        }
    }

    private void ActualEnterTextAction(WebElement iwe, String text)
    {
        iwe.sendKeys(text);
    }



    public String GetThisElementText(ElementInterface we) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.NONE || we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \""
                    + we.selector + "\" is currently expecting No or Multiple matches, this function only works with elements that expect one match");
        }
        else
        {
            int cycles = (explicitWait * 1000) / milisecondsInterval / 2;
            int counter = 0;
            Boolean mainCheck = false;
            while (counter <= cycles)
            {
                ThisElementShouldExistRegardlessVisibility(we);
                List<WebElement> result = we.allMatchingResults;
                if (result.size() == 1)
                {
                    mainCheck = true;
                    break;
                }
                result.clear();
                counter = counter + 1;
            }
            if (mainCheck)
            {
                WebElement result = we.ReturnTheIWebElementInPosition(1);
                if(we.needsScroll)
                {
                    ScrollToThisElement(we);
                }
                return result.getText();
            }
            else
            {
                throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \"" + we.selector + "\" was never set to Invisible State");
            }
        }
    }


    public ElementInterface ValidateAnElementHasThisText(ElementInterface we, String text) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.NONE || we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \""
                    + we.selector + "\" is currently expecting No or Multiple matches, this function only works with elements that expect one match");
        }
        else
        {
            int cycles = (explicitWait * 1000) / milisecondsInterval / 2;
            int counter = 0;
            Boolean mainCheck = false;
            while (counter <= cycles)
            {
                ThisElementShouldExistRegardlessVisibility(we);
                List<WebElement> result = we.allMatchingResults;
                Boolean hasText = ValidateAnElementHasThisText(result, text);
                {
                    if (hasText)
                    {
                        mainCheck = true;
                        break;
                    }
                }
                counter = counter + 1;
            }
            if (mainCheck)
            {
                return we;
            }
            else
            {
                throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \"" + we.selector + "\" didnt have the text " + text);
            }
        }
    }


    public void MoveIntoViewToThisElement(ElementInterface we) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.NONE || we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \""
                    + we.selector + "\" is currently expecting No or Multiple matches, this function only works with elements that expect one match");
        }
        else
        {
            ThisElementShouldExistRegardlessVisibility(we);
            Actions actions = new Actions(testDriver);
            WebElement result = we.ReturnTheIWebElementInPosition(1);
            actions.moveToElement(result);
            actions.perform();
        }

    }

    public void ScrollToThisElement(ElementInterface we) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.NONE || we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \""
                    + we.selector + "\" is currently expecting No or Multiple matches, this function only works with elements that expect one match");
        }
        else
        {
            ThisElementShouldExistRegardlessVisibility(we);
            JavascriptExecutor js = (JavascriptExecutor)testDriver;
            js.executeScript("arguments[0].scrollIntoView();", we.ReturnTheIWebElementInPosition(1));
        }
    }


    public ElementInterface ThisElementShouldNotBeVisible(ElementInterface we) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.NONE || we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \""
                    + we.selector + "\" is currently expecting No or Multiple matches, this function only works with elements that expect one match");
        }
        else
        {
            int cycles = (explicitWait * 1000) / milisecondsInterval / 2;
            int counter = 0;
            Boolean mainCheck = false;
            while (counter <= cycles)
            {
                ThisElementShouldExistRegardlessVisibility(we);
                List<WebElement> result = we.allMatchingResults;
                Boolean isInvisible = ValidateElementsAreInvisible(result);
                {
                    if (isInvisible)
                    {
                        mainCheck = true;
                        break;
                    }
                }
                counter = counter + 1;
            }
            if (mainCheck)
            {
                return we;
            }
            else
            {
                throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \"" + we.selector + "\" was never set to Invisible State");
            }
        }
    }




    public ElementInterface ThisElementShouldBeVisible(ElementInterface we) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.NONE || we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \""
                    + we.selector + "\" is currently expecting No or Multiple matches, this function only works with elements that expect one match");
        }
        else
        {
            int cycles = (explicitWait * 1000) / milisecondsInterval / 2;
            int counter = 0;
            Boolean mainCheck = false;
            while (counter <= cycles)
            {
                ThisElementShouldExistRegardlessVisibility(we);
                List<WebElement> result = we.allMatchingResults;
                Boolean isInvisible = ValidateElementsAreVisible(result);
                {
                    if (isInvisible)
                    {
                        mainCheck = true;
                        break;
                    }
                }
                counter = counter + 1;
            }
            if (mainCheck)
            {
                return we;
            }
            else
            {
                throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \"" + we.selector + "\" was never set to Invisible State");
            }
        }
    }



    public ElementInterface GetThisElementAttributeNamed(ElementInterface we, String attName) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.NONE || we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \""
                    + we.selector + "\" is currently expecting No or Multiple matches, this function only works with elements that expect one match");
        }
        else
        {
            int cycles = (explicitWait * 1000) / milisecondsInterval / 2;
            int counter = 0;
            Boolean mainCheck = false;
            while (counter <= cycles)
            {
                ThisElementShouldExistRegardlessVisibility(we);
                List<WebElement> result = we.allMatchingResults;
                Boolean hasAtt = ValidateAnElementHasAnAttribute(result, attName);
                {
                    if (hasAtt)
                    {
                        mainCheck = true;
                        break;
                    }
                }
                counter = counter + 1;
            }
            if (mainCheck)
            {
                return we;
            }
            else
            {
                throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \"" + we.selector + "\" didnt have an attribute named \"" + attName + "\"");
            }
        }
    }

    public ElementInterface TheFollowingAttributeShouldHaveThisValue(ElementInterface we, String attName, String value) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.NONE || we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \""
                    + we.selector + "\" is currently expecting No or Multiple matches, this function only works with elements that expect one match");
        }
        else
        {
            int cycles = (explicitWait * 1000) / milisecondsInterval / 2;
            int counter = 0;
            Boolean mainCheck = false;
            while (counter <= cycles)
            {
                ThisElementShouldExistRegardlessVisibility(we);
                List<WebElement> result = we.allMatchingResults;
                GetThisElementAttributeNamed(we, attName);
                Boolean hasAtt = ValidateAnElementHasAnAttributeWithThisValue(result, attName, value);
                {
                    if (hasAtt)
                    {
                        mainCheck = true;
                        break;
                    }
                }
                counter = counter + 1;
            }
            if (mainCheck)
            {
                return we;
            }
            else
            {
                throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \"" + we.selector + "\" didnt have an attribute named \"" + attName + "\" set to the value \"" + value + "\"");
            }
        }
    }





    public ElementInterface ThisElementShouldBeEnabled(ElementInterface we) throws Exception {
        if (we.expectedMatches == Options.ExpectedMatches.NONE || we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \""
                    + we.selector + "\" is currently expecting No or Multiple matches, this function only works with elements that expect one match");
        }
        else
        {
            int cycles = (explicitWait * 1000) / milisecondsInterval / 2;
            int counter = 0;
            Boolean mainCheck = false;
            while (counter <= cycles)
            {
                ThisElementShouldExistRegardlessVisibility(we);
                List<WebElement> result = we.allMatchingResults;
                Boolean isEnabled = ValidateElementsAreEnabled(result);
                {
                    if (isEnabled)
                    {
                        mainCheck = true;
                        break;
                    }
                }
                counter = counter + 1;
            }
            if (mainCheck)
            {
                return we;
            }
            else
            {
                throw new Exception("The Element with Selector Method: \"" + we.selectorMethod.toString() + "\" and Selector Path: \"" + we.selector + "\" was never set to Invisible State");
            }
        }
    }






    private ElementInterface ThisElementShouldHaveOneMatch(ElementInterface we) throws Exception {
        we.ResetElement();
        if (we.expectedMatches == Options.ExpectedMatches.ONE)
        {
            if(we.isSlowElement)
            {explicitWait = 30;}
            List<WebElement> matchingResults = SearchLoop(Options.ExpectedMatches.ONE, we.selectorMethod, we.selector);
            ThisElementShouldBeVisible(we);
            int amountElements = matchingResults.size();
            if (amountElements == 1)
            {
                if (ValidateElementsAreVisible(matchingResults))
                {
                    we.allMatchingResults = matchingResults;
                    we.CountMatchingElements();
                    we.hasBeenSearched = true;
                    if (HighLightElements)
                    {
                        HighLightAllTheElementsThatMatch(we);
                    }
                    this.explicitWait = this.defaultExplicit;
                    return we;
                }
                else
                {
                    throw new Exception("The Element with selector Method " + we.selectorMethod.toString() + " and Search String \"" + we.selector + "\" had one element but was not Visible");
                }
            }
            else
            {
                throw new Exception("The Element with selector Method " + we.selectorMethod.toString() + " and Search String \"" + we.selector + "\" returned " + amountElements + " elements. We expected only one");
            }
        }
        else
        {
            throw new Exception("The Method only work with Elements that expect ONE matching result");
        }
    }

    private ElementInterface ThisElementShouldExistRegardlessVisibility(ElementInterface we) throws Exception {
        we.ResetElement();
        if (we.expectedMatches == Options.ExpectedMatches.ONE)
        {
            if(we.isSlowElement)
            {explicitWait = 30;}
            List<WebElement> matchingResults = SearchLoop(Options.ExpectedMatches.ONE, we.selectorMethod, we.selector);
            int amountElements = matchingResults.size();
            if (amountElements == 1)
            {
                we.allMatchingResults = matchingResults;
                we.CountMatchingElements();
                we.hasBeenSearched = true;
                this.explicitWait = this.defaultExplicit;
                return we;
            }
            else
            {
                throw new Exception("The Element with selector Method " + we.selectorMethod.toString() + " and Search String \"" + we.selector + "\" returned " + amountElements + " elements. We expected only one");
            }
        }
        else
        {
            throw new Exception("The Method only work with Elements that expect ONE matching result");
        }
    }

    private ElementInterface ThisElementShouldHaveNoMatch(ElementInterface we) throws Exception {
        we.ResetElement();
        if (we.expectedMatches == Options.ExpectedMatches.NONE)
        {
            if(we.isSlowElement)
            {explicitWait = 30;}
            List<WebElement> matchingResults = SearchLoop(Options.ExpectedMatches.NONE, we.selectorMethod, we.selector);
            int amountElements = matchingResults.size();
            if (amountElements == 0)
            {
                we.hasBeenSearched = true;
                this.explicitWait = this.defaultExplicit;
                return we;
            }
            else
            {
                throw new Exception("The Element with selector Method " + we.selectorMethod.toString() + " and Search String \"" + we.selector + "\" returned " + amountElements + " elements. We expected NONE");
            }
        }
        else
        {
            throw new Exception("The Method only work with Elements that expect NO matching result");
        }
    }

    private ElementInterface ThisElementShouldHaveMultipleMatches(ElementInterface we) throws Exception {
        we.ResetElement();
        if (we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            if(we.isSlowElement)
            {explicitWait = 30;}
            List<WebElement> matchingResults = SearchLoop(Options.ExpectedMatches.MANY, we.selectorMethod, we.selector);
            int amountElements = matchingResults.size();
            if (amountElements >= 1)
            {
                we.allMatchingResults = matchingResults;
                we.CountMatchingElements();
                we.hasBeenSearched = true;
                if (HighLightElements)
                {
                    HighLightAllTheElementsThatMatch(we);
                }
                this.explicitWait = this.defaultExplicit;
                return we;
            }
            else
            {
                throw new Exception("The Element with selector Method " + we.selectorMethod.toString() + " and Search String \"" + we.selector + "\" returned " + amountElements + " elements. We expected Many");
            }
        }
        else
        {
            throw new Exception("The Method only work with Elements that expect ONE matching result");
        }
    }

    private ElementInterface ThisElementShouldHaveOneMatch(ElementInterface we, WebElement iwe) throws Exception {
        we.ResetElement();
        if (we.expectedMatches == Options.ExpectedMatches.ONE)
        {
            if(we.isSlowElement)
            {explicitWait = 30;}
            List<WebElement> matchingResults = SearchLoop(Options.ExpectedMatches.ONE, we.selectorMethod, we.selector, iwe);
            int amountElements = matchingResults.size();
            if (amountElements == 1)
            {
                if (ValidateElementsAreVisible(matchingResults))
                {
                    we.allMatchingResults = matchingResults;
                    we.CountMatchingElements();
                    we.hasBeenSearched = true;
                    if (HighLightElements)
                    {
                        HighLightAllTheElementsThatMatch(we);
                    }
                    this.explicitWait = this.defaultExplicit;
                    return we;
                }
                else
                {
                    throw new Exception("The Element with selector Method " + we.selectorMethod.toString() + " and Search String \"" + we.selector + "\" had one element but was not Visible");
                }
            }
            else
            {
                throw new Exception("The Element with selector Method " + we.selectorMethod.toString() + " and Search String \"" + we.selector + "\" returned " + amountElements + " elements. We expected only one");
            }
        }
        else
        {
            throw new Exception("The Method only work with Elements that expect ONE matching result");
        }
    }

    private ElementInterface ThisElementShouldExistRegardlessVisibility(ElementInterface we, WebElement iwe) throws Exception {
        we.ResetElement();
        if (we.expectedMatches == Options.ExpectedMatches.ONE)
        {
            if(we.isSlowElement)
            {explicitWait = 30;}
            List<WebElement> matchingResults = SearchLoop(Options.ExpectedMatches.ONE, we.selectorMethod, we.selector, iwe);
            int amountElements = matchingResults.size();
            if (amountElements == 1)
            {
                we.allMatchingResults = matchingResults;
                we.CountMatchingElements();
                we.hasBeenSearched = true;
                this.explicitWait = this.defaultExplicit;
                return we;
            }
            else
            {
                throw new Exception("The Element with selector Method " + we.selectorMethod.toString() + " and Search String \"" + we.selector + "\" returned " + amountElements + " elements. We expected only one");
            }
        }
        else
        {
            throw new Exception("The Method only work with Elements that expect ONE matching result");
        }
    }

    private ElementInterface ThisElementShouldHaveNoMatch(ElementInterface we, WebElement iwe) throws Exception {
        we.ResetElement();
        if (we.expectedMatches == Options.ExpectedMatches.NONE)
        {
            if(we.isSlowElement)
            {explicitWait = 30;}
            List<WebElement> matchingResults = SearchLoop(Options.ExpectedMatches.NONE, we.selectorMethod, we.selector, iwe);
            int amountElements = matchingResults.size();
            if (amountElements == 0)
            {
                we.hasBeenSearched = true;
                this.explicitWait = this.defaultExplicit;
                return we;
            }
            else
            {
                throw new Exception("The Element with selector Method " + we.selectorMethod.toString() + " and Search String \"" + we.selector + "\" returned " + amountElements + " elements. We expected NONE");
            }
        }
        else
        {
            throw new Exception("The Method only work with Elements that expect NO matching result");
        }
    }

    private ElementInterface ThisElementShouldHaveMultipleMatches(ElementInterface we, WebElement iwe) throws Exception {
        we.ResetElement();
        if (we.expectedMatches == Options.ExpectedMatches.MANY)
        {
            if(we.isSlowElement)
            {explicitWait = 30;}
            List<WebElement> matchingResults = SearchLoop(Options.ExpectedMatches.MANY, we.selectorMethod, we.selector, iwe);
            int amountElements = matchingResults.size();
            if (amountElements > 1)
            {
                we.allMatchingResults = matchingResults;
                we.CountMatchingElements();
                we.hasBeenSearched = true;
                if (HighLightElements)
                {
                    HighLightAllTheElementsThatMatch(we);
                }
                this.explicitWait = this.defaultExplicit;
                return we;
            }
            else
            {
                throw new Exception("The Element with selector Method " + we.selectorMethod.toString() + " and Search String \"" + we.selector + "\" returned " + amountElements + " elements. We expected Many");
            }
        }
        else
        {
            throw new Exception("The Method only work with Elements that expect ONE matching result");
        }
    }





    private List<WebElement> SearchLoop(Options.ExpectedMatches expNumber, Options.SearchMethods method, String sel)
    {
        List<WebElement> matchingResults = new ArrayList<WebElement>();
        int cycles = (explicitWait * 1000) / milisecondsInterval / 2;
        int counter = 0;
        while (counter <= cycles)
        {
            matchingResults = PerformSearchInPage(method, sel);
            if (matchingResults.size() == 0 && expNumber == Options.ExpectedMatches.NONE)
            {
                break;
            }
            else if (matchingResults.size() > 1 && expNumber == Options.ExpectedMatches.MANY)
            {
                break;
            }
            else if (matchingResults.size() == 1 && expNumber == Options.ExpectedMatches.ONE)
            {
                break;
            }
            else
            {
                matchingResults.clear();
                pause(this.milisecondsInterval);
                counter = counter + 1;
            }
        }
        return matchingResults;
    }



    private List<WebElement> SearchLoop(Options.ExpectedMatches expNumber, Options.SearchMethods method, String sel, WebElement iwe)
    {
        List<WebElement> matchingResults = new ArrayList<WebElement>();
        int cycles = (explicitWait * 1000) / milisecondsInterval / 2;
        int counter = 0;
        while (counter <= cycles)
        {
            matchingResults = PerformSearchInElement(method, sel, iwe);
            if (matchingResults.size() == 0 && expNumber == Options.ExpectedMatches.NONE)
            {
                break;
            }
            else if (matchingResults.size() > 1 && expNumber == Options.ExpectedMatches.MANY)
            {
                break;
            }
            else if (matchingResults.size() == 1 && expNumber == Options.ExpectedMatches.ONE)
            {
                break;
            }
            else
            {
                matchingResults.clear();
                pause(this.milisecondsInterval);
                counter = counter + 1;
            }
        }
        return matchingResults;
    }



    private Boolean ValidateElementsAreVisible(List<WebElement> elements)
    {
        Boolean areVisible = true;
        for (WebElement iwe : elements)
        {
            if (!iwe.isDisplayed())
            {
                areVisible = false;
                break;
            }
        }
        return areVisible;
    }

    private Boolean ValidateElementsAreInvisible(List<WebElement> elements)
    {
        Boolean nonVisible = true;
        for (WebElement iwe : elements)
        {
            if (iwe.isDisplayed())
            {
                nonVisible = false;
                break;
            }
        }
        return nonVisible;
    }

    private Boolean ValidateElementsAreEnabled(List<WebElement> elements)
    {
        Boolean areEnabled = true;
        for (WebElement iwe : elements)
        {
            if (!iwe.isEnabled())
            {
                areEnabled = false;
                break;
            }
        }
        return areEnabled;
    }

    private Boolean ValidateAnElementHasThisText(List<WebElement> elements, String text)
    {
        Boolean hasText = false;
        for (WebElement iwe : elements)
        {
            if (iwe.getText() == text)
            {
                hasText = true;
                break;
            }
        }
        return hasText;
    }

    private Boolean ValidateAnElementHasAnAttribute(List<WebElement> elements, String attributeName)
    {
        //If an element has no attribute, GetAttribute returns null
        //If an element has an attribute but is not set, it is set to "", an empty string
        //If an element has an attribut that is set, the method returns a string with the value
        Boolean hasAttribute = false;
        for (WebElement iwe : elements)
        {
            String value = iwe.getAttribute(attributeName);
            if (value != null)
            {
                hasAttribute = true;
                break;
            }
        }
        return hasAttribute;
    }

    private Boolean ValidateAnElementHasAnAttributeWithThisValue(List<WebElement> elements, String attributeName, String expValue)
    {
        //If an element has no attribute, GetAttribute returns null
        //If an element has an attribute but is not set, it is set to "", an empty string
        //If an element has an attribut that is set, the method returns a string with the value
        Boolean hasValue = false;
        for(WebElement iwe : elements)
        {
            String value = iwe.getAttribute(attributeName);
            if (value == expValue)
            {
                hasValue = true;
                break;
            }
        }
        return hasValue;
    }



    public List<WebElement> PerformSearchInPage(Options.SearchMethods method, String selector)
    {
        List<WebElement> elements = new ArrayList<WebElement>();
        if (method == Options.SearchMethods.ID)
        {
            elements = this.testDriver.findElements(By.id(selector));
        }
        if (method == Options.SearchMethods.CLASSNAME)
        {
            elements = this.testDriver.findElements(By.className(selector));
        }
        if (method == Options.SearchMethods.NAME)
        {
            elements = this.testDriver.findElements(By.name(selector));
        }
        if (method == Options.SearchMethods.CSS)
        {
            elements = this.testDriver.findElements(By.cssSelector(selector));
        }
        if (method == Options.SearchMethods.XPATH)
        {
            elements = this.testDriver.findElements(By.xpath(selector));
        }
        if (method == Options.SearchMethods.LINK)
        {
            elements = this.testDriver.findElements(By.linkText(selector));
        }
        if (method == Options.SearchMethods.PARTIALLINK)
        {
            elements = this.testDriver.findElements(By.partialLinkText(selector));
        }
        return elements;
    }


    public List<WebElement> PerformSearchInElement(Options.SearchMethods method, String selector, WebElement iwe)
    {
        List<WebElement> elements = new ArrayList<WebElement>();
        if (method == Options.SearchMethods.ID)
        {
            List<WebElement> elementsListID = iwe.findElements(By.id(selector));
        }
        if (method == Options.SearchMethods.CLASSNAME)
        {
            List<WebElement> elementsListClass = iwe.findElements(By.className(selector));
        }
        if (method == Options.SearchMethods.NAME)
        {
            List<WebElement> elementsListName = iwe.findElements(By.name(selector));
        }
        if (method == Options.SearchMethods.CSS)
        {
            List<WebElement> elementsListCss = iwe.findElements(By.cssSelector(selector));
        }
        if (method == Options.SearchMethods.XPATH)
        {
            List<WebElement> elementsListXpath = iwe.findElements(By.xpath(selector));
        }
        if (method == Options.SearchMethods.LINK)
        {
            List<WebElement> elementsListLinkText = iwe.findElements(By.linkText(selector));
        }
        if (method == Options.SearchMethods.PARTIALLINK)
        {
            List<WebElement> elementsListLinkText = iwe.findElements(By.partialLinkText(selector));
        }
        return elements;
    }

    public void pause(long ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

}
