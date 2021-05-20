package QAMinds.SeleniumExercises.Module2;

import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonCSS01 {
    public void RunScript()
    {

        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.MaximizeWindow();
        wp.LoadWebPage("https://www.amazon.com.mx/");

        String searchTerm = "Nintendo Switch";
        WebElementWrapper searchBox = new WebElementWrapper("twotabsearchtextbox", "id");
        WebElementWrapper searchButton = new WebElementWrapper("nav-search-submit-button", "id");
        WebElementWrapper contenedorMarcas = new WebElementWrapper("brandsRefinements", "id");
        WebElementWrapper checkbox = new WebElementWrapper("li[aria-label='Nintendo'] div", "css");
        WebElementWrapper fourStars = new WebElementWrapper("i[class$='4']", "css");
        WebElementWrapper ordenarPor = new WebElementWrapper("select[id='s-result-sort-select']+span", "css");
        WebElementWrapper ordernarMenorMayorPrecio = new WebElementWrapper("li[aria-labelledby='s-result-sort-select_1']", "css");
        WebElementWrapper searchResultContainer = new WebElementWrapper("div[data-component-type='s-search-result']", "css");
        WebElementWrapper srText = new WebElementWrapper("h2>a[class$='a-text-normal']","css");
        WebElementWrapper strReview = new WebElementWrapper("a[href$='customerReviews']","css");
        WebElementWrapper srPrice = new WebElementWrapper(".//*[@class='a-price']", "xpath");

        wp.SearchForThisElementForAnAmountOfTime(searchBox);
        wp.EnterTextInElement(searchBox, searchTerm);
        wp.ClickElement(searchButton);

        wp.SearchForThisElementForAnAmountOfTime(contenedorMarcas);
        wp.SearchForThisElementForAnAmountOfTime(checkbox);
        wp.ClickElement(checkbox);

        wp.SearchForThisElementForAnAmountOfTime(fourStars);
        wp.ClickElement(fourStars);

        wp.SearchForThisElementForAnAmountOfTime(ordenarPor);
        wp.ClickElement(ordenarPor);

        wp.SearchForThisElementForAnAmountOfTime(ordernarMenorMayorPrecio);
        wp.ClickElement(ordernarMenorMayorPrecio);

        wp.SearchForThisElementForAnAmountOfTime(searchResultContainer);
        searchResultContainer.allMatchingResults.forEach(iwe ->{
            String title = iwe.findElement(By.cssSelector(srText.selector)).getText();
            String reviews = iwe.findElement(By.cssSelector(strReview.selector)).getText();
            List<WebElement> priceElements = iwe.findElements(By.xpath(srPrice.selector));
            String price = "";
            if(priceElements.size() > 0)
            {
                price = priceElements.get(0).getText();
            }
            System.out.println(title+" - "+price+" - "+reviews);
        });

        //wp.CloseBrowser();
    }
}
