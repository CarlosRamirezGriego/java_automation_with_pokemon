package QAMinds.SeleniumExercises;
import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;

import java.util.concurrent.TimeUnit;

public class SeleniumHandsOn3 {

    public void RunScript()
    {

        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.MaximizeWindow();
        wp.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String url = "http://www.facebook.com";
        wp.LoadWebPage(url);
        assert url == wp.GetPageURL();
        WebElementWrapper emailBox = new WebElementWrapper("email","id");
        WebElementWrapper passwordBox = new WebElementWrapper("pass","id");
        WebElementWrapper loginButton = new WebElementWrapper("button[data-testid='royal_login_button']","css");
        wp.EnterTextInElement(emailBox, "Pokemon@pokemon.com");
        wp.EnterTextInElement(passwordBox, "Pokemon");
        wp.ClickElement(loginButton);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wp.CloseBrowser();
    }
}
