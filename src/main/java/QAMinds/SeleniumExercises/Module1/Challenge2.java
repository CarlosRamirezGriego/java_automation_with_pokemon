package QAMinds.SeleniumExercises.Module1;
import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge2 {

    public void RunScript() {

        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.MaximizeWindow();
        wp.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String url = "http://www.wikipedia.com";
        wp.LoadWebPage(url);
        wp.implicitWaitSeconds = 5;
        assert url == wp.GetPageURL();

        WebElementWrapper searchBox = new WebElementWrapper("searchInput", "id");
        WebElementWrapper highlights = new WebElementWrapper("a.suggestion-link div.suggestion-text", "css");
        WebElementWrapper paragrahps = new WebElementWrapper("body p", "css");

        wp.SearchForThisElementForAnAmountOfTime(searchBox);
        String searchTerm = "selenium";
        wp.EnterTextInElement(searchBox, searchTerm);
        wp.SearchForThisElementForAnAmountOfTime(highlights);
        highlights.CountMatchingElements();
        System.out.println("The Search Selenium has these many matches: " + highlights.amountElements);
        wp.ClickSpecificElementFromResults(highlights, 1);
        wp.SearchForThisElementForAnAmountOfTime(paragrahps);
        paragrahps.CountMatchingElements();
        System.out.println("The Selenium page has this amount of paragraphs: " + paragrahps.amountElements);
        int totalMatches = CountMatchingResults(paragrahps, searchTerm);
        System.out.println("The word "+searchTerm+" is present these times: " + totalMatches);
        System.out.println("The current URL is: " + wp.GetPageURL());


        WebElementWrapper links = new WebElementWrapper("a[title*='"+searchTerm+"']","css");
        wp.SearchForThisElementForAnAmountOfTime(links);

        int index = 1;
        for(WebElement w : links.allMatchingResults)
        {
            WebElementWrapper localLinks = new WebElementWrapper("a[title*='"+searchTerm+"']","css");
            WebElementWrapper localParagraphs = new WebElementWrapper("body p", "css");
            wp.SearchForThisElementForAnAmountOfTime(localLinks);
            wp.ClickSpecificElementFromResults(localLinks, index);
            System.out.println("The current Page title is: " + wp.GetPageTitle());
            System.out.println("The current Page URL is: " + wp.GetPageURL());
            index = index + 1;
            wp.pause(1000);
            wp.SearchForThisElementForAnAmountOfTime(localParagraphs);
            int matches = CountMatchingResults(localParagraphs, searchTerm);
            System.out.println("The word "+searchTerm+" is present these times: " + matches);
            wp.GoBack();
        }

        wp.CloseBrowser();
    }

    public int CountMatchingResults(WebElementWrapper we, String searchTerm)
    {
        int total = 0;
        for(WebElement w : we.allMatchingResults)
        {
            String text = w.getText();
            int matches = countMatches(text, searchTerm);
            total = total + matches;
        }
        return total;
    }

    public int countMatches(String fullText, String searchTerm) {
        Matcher matcher = Pattern.compile(searchTerm).matcher(fullText.toLowerCase());
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
