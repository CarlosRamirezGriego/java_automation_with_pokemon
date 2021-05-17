package QAMinds.SeleniumExercises.Module2;

import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMethodEx {
    public void RunScript()
    {

        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.MaximizeWindow();
        wp.LoadWebPage("https://www.amazon.com.mx/");
        WebElementWrapper dropdown = new WebElementWrapper("searchDropdownBox","id");
        wp.SearchForThisElement(dropdown);

        Select select = new Select(dropdown.allMatchingResults.get(0));

        List<WebElement> listOptions = select.getOptions();
        for(WebElement option : listOptions)
        {
            System.out.println(option.getText());
            System.out.println(option.getAttribute("value"));
        }

        System.out.println("Is multiple: "+select.isMultiple());

        select.selectByVisibleText("Electrónicos");
        WebElement option = select.getFirstSelectedOption();
        System.out.println(option.getText());
        System.out.println(option.getAttribute("value"));

        select.selectByIndex(4);
        option = select.getFirstSelectedOption();
        System.out.println(option.getText());
        System.out.println(option.getAttribute("value"));

        select.selectByValue("search-alias=specialty-aps-sns");
        option = select.getFirstSelectedOption();
        System.out.println(option.getText());
        System.out.println(option.getAttribute("value"));

        wp.CloseBrowser();
    }
}
