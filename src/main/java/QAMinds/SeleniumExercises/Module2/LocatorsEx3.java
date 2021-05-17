package QAMinds.SeleniumExercises.Module2;

import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LocatorsEx3 {
    public void RunScript()
    {

        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.MaximizeWindow();
        wp.LoadWebPage("http://www.nasa.gov");
        WebElementWrapper link1 = new WebElementWrapper("Missions","linkText");
        WebElementWrapper link2 = new WebElementWrapper("NASA TV","linkText");
        WebElementWrapper inputs = new WebElementWrapper("input","tagName");

        wp.SearchForThisElement(link1);
        wp.SearchForThisElement(link2);
        wp.SearchForThisElement(inputs);

        String ref1 = link1.allMatchingResults.get(0).getAttribute("href");
        System.out.println(ref1);

        String ref2 = link2.allMatchingResults.get(0).getAttribute("href");
        System.out.println(ref2);

        for(WebElement w : inputs.allMatchingResults)
        {
            System.out.println(w.getAttribute("href"));
        }

        wp.CloseBrowser();
    }
}
