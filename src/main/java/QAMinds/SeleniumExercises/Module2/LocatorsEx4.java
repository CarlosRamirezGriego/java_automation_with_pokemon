package QAMinds.SeleniumExercises.Module2;

import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;
import org.openqa.selenium.WebElement;

public class LocatorsEx4 {
    public void RunScript()
    {

        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.MaximizeWindow();
        wp.LoadWebPage("http://es.wikipedia.org/wiki/Portada");
        WebElementWrapper link1 = new WebElementWrapper("Portada","linkText");
        WebElementWrapper link2 = new WebElementWrapper("Página","partiallinktext");
        WebElementWrapper inputs = new WebElementWrapper("button","tagName");

        wp.SearchForThisElement(link1);
        wp.SearchForThisElement(link2);
        wp.SearchForThisElement(inputs);

        String ref1 = link1.allMatchingResults.get(0).getAttribute("href");
        System.out.println(ref1);

        for(WebElement w : link2.allMatchingResults)
        {
            System.out.println(w.getText());
            System.out.println(w.getAttribute("href"));
        }

        for(WebElement w : inputs.allMatchingResults)
        {
            System.out.println(w.getAttribute("href"));
        }

        wp.CloseBrowser();
    }
}
