package QAMinds.SeleniumExercises.Module2;

import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Tiktok {
    public void RunScript()
    {

        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.MaximizeWindow();
        wp.LoadWebPage("https://www.tiktok.com/");
        WebElementWrapper searchBox = new WebElementWrapper("q","name");
        WebElementWrapper searchButton = new WebElementWrapper("//button[@type='submit']","xpath");
        WebElementWrapper result = new WebElementWrapper("//a[contains(@class,'result-item')]","xpath");
        WebElementWrapper resultTitle = new WebElementWrapper(".//div/p[contains(@class,'title')][position()=1]","css");
        WebElementWrapper resultSubTitle = new WebElementWrapper(".//*[contains(@class,'sub-title')]","xpath");
        WebElementWrapper resultsDescription = new WebElementWrapper(".//*[contains(@class,'desc')]","xpath");

        wp.SearchForThisElement(searchBox);
        wp.EnterTextInElement(searchBox, "Selenium");
        wp.ClickElement(searchButton);
        wp.SearchForThisElementForAnAmountOfTime(result);
        result.allMatchingResults.forEach(iwe ->{
            String title = iwe.findElement(By.xpath(resultTitle.selector)).getText();
            String subtitle = iwe.findElement(By.xpath(resultSubTitle.selector)).getText();
            String desc = iwe.findElement(By.xpath(resultsDescription.selector)).getText();
            System.out.println(title+" - "+subtitle+" - "+desc);
        });

        wp.CloseBrowser();
    }
}
