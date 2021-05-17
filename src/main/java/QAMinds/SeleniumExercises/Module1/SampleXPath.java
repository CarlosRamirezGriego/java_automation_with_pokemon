package QAMinds.SeleniumExercises.Module1;
import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;

public class SampleXPath {
    public void RunScript()
    {
        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.MaximizeWindow();
        String url = "https://www.mercadolibre.com.mx/";
        wp.LoadWebPage(url);

        WebElementWrapper searchBox = new WebElementWrapper("input[name='as_word']","css");
        WebElementWrapper searchButton = new WebElementWrapper("button.nav-search-btn","css");
        WebElementWrapper results = new WebElementWrapper("a[class='ui-search-item__group__element ui-search-link']",  "css");
        WebElementWrapper prices = new WebElementWrapper("div[class='ui-search-price ui-search-price--size-medium ui-search-item__group__element'] span.price-tag-fraction","css");

        wp.EnterTextInElement(searchBox, "PS4");
        wp.ClickElement(searchButton);
        wp.SearchForThisElementForAnAmountOfTime(results);
        wp.SearchForThisElementForAnAmountOfTime(prices);
        System.out.println("The first element price is: "+prices.allMatchingResults.get(0).getText());
        wp.ClickSpecificElementFromResults(results, 1);
        wp.pause(5000);
        wp.CloseBrowser();
    }

}
