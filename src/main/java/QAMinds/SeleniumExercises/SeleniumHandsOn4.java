package QAMinds.SeleniumExercises;
import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;

import java.util.concurrent.TimeUnit;

public class SeleniumHandsOn4 {

    public void RunScript()
    {

        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.MaximizeWindow();
        wp.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String url = "http://www.amazon.com.mx";
        wp.LoadWebPage(url);
        assert url == wp.GetPageURL();
        WebElementWrapper searchbox = new WebElementWrapper("twotabsearchtextbox","id");
        wp.EnterTextInElement(searchbox, "Selenium");
        wp.PressEnterKey(searchbox);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wp.CloseBrowser();
    }
}
