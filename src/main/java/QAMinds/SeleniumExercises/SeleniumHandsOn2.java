package QAMinds.SeleniumExercises;
import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;

import java.util.concurrent.TimeUnit;

public class SeleniumHandsOn2 {

    public void RunScript()
    {

        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.MaximizeWindow();
        wp.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String url = "http://www.google.com";
        wp.LoadWebPage(url);
        assert url == wp.GetPageURL();
        WebElementWrapper searchBox = new WebElementWrapper("q","name");
        WebElementWrapper tabs = new WebElementWrapper("pTwnEc","name");
        wp.EnterTextInElement(searchBox, "Pokemon");
        wp.PressEnterKey(searchBox);
        wp.SearchForThisElement(tabs);
        wp.CloseBrowser();
    }
}
