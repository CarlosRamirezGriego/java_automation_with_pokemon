package Wrappers;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ElementInterface {
    public String selector;
    public Options.SearchMethods selectorMethod;
    public List<WebElement> allMatchingResults = new ArrayList<WebElement>();
    public int amountElements = 0;
    public Options.ExpectedMatches expectedMatches;
    public Options.ExpectedMatches actualMatches;
    public Boolean doValidation = true;
    public Boolean hasBeenSearched = false;
    public Boolean needsScroll = false;
    public Boolean isSlowElement = false;


    public int getAmountElements() {
        return amountElements;
    }

    private void setAmountElements(int n) {
        this.amountElements = n;
    }

    public Options.ExpectedMatches getActualMatches() {
        return this.actualMatches;
    }

    private void setActualMatches(Options.ExpectedMatches m) {
        this.actualMatches = m;
    }

    public Options.ExpectedMatches getExpectedMatches() {
        return this.expectedMatches;
    }

    private void setColor(Options.ExpectedMatches m) {
        this.expectedMatches = m;
    }

    public ElementInterface()
    {
        this.expectedMatches = Options.ExpectedMatches.NONE;
        ExpectNoMatches();
    }

    public ElementInterface(String sel, Options.SearchMethods method)
    {
        this.selector = sel;
        this.selectorMethod = method;
        this.expectedMatches = Options.ExpectedMatches.ONE;
    }

    public ElementInterface(String sel, Options.SearchMethods method, Options.ExpectedMatches exp)
    {
        this.selector = sel;
        this.selectorMethod = method;
        this.expectedMatches = exp;
    }

    public void ResetElement()
    {
        this.allMatchingResults.clear();
        this.amountElements = 0;
        this.hasBeenSearched = false;
    }

    public void ExpectOneMatch()
    {
        this.expectedMatches = Options.ExpectedMatches.ONE;
    }

    public void ExpectNoMatches()
    {
        this.expectedMatches = Options.ExpectedMatches.NONE;
    }

    public void ExpectManyMatches()
    {
        this.expectedMatches = Options.ExpectedMatches.MANY;
    }

    public void ValidateMatches() throws Exception {
        if (this.expectedMatches != this.actualMatches)
        {
            throw new Exception("The Element with Selector Method: \"" + this.selectorMethod + "\" and Selector Path: \"" + this.selector + "\" has " + this.amountElements + " matching results.");
        }
    }

    public void CountMatchingElements()
    {
        this.amountElements = this.allMatchingResults.size();
        if (this.amountElements > 1)
        {
            this.actualMatches = Options.ExpectedMatches.MANY;
        }
        else if (amountElements == 0)
        {
            this.actualMatches = Options.ExpectedMatches.NONE;
        }
        else
        {
            this.actualMatches = Options.ExpectedMatches.ONE;
        }
    }

    public WebElement ReturnTheIWebElementInPosition(int i)
    {
        WebElement testWe = null;
        if (!(i <= 0 || i > this.amountElements))
        {
            testWe = this.allMatchingResults.get(i-1);
        }
        return testWe;
    }


    public int ReturnPositionOfElementThatHasThisText(String text)
    {
        int index = 1;
        Boolean isPresent = false;
        for(WebElement iwe : this.allMatchingResults)
        {
            if (iwe.getText() == text)
            {
                isPresent = true;
                break;
            }
            index = index + 1;
        }
        if (isPresent)
        {
            return index;
        }
        else
        {
            return 0;
        }
    }

    public String GetTextFromElementInThisPosition(int position)
    {
        String text = null;
        if (this.amountElements >= position && this.amountElements > 0 && position >= 1)
        {
            WebElement result = ReturnTheIWebElementInPosition(position);
            text = result.getText();
        }
        return text;
    }


    public List<String> GetTextFromAllMatchingElements()
    {
        List<String> text = new ArrayList<String>();
        for(WebElement iwe : this.allMatchingResults)
        {
            text.add(iwe.getText());
        }
        return text;
    }

}
