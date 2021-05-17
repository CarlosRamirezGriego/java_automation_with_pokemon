import QAMinds.SeleniumExercises.Module1.SampleXPath;
import QAMinds.SeleniumExercises.Module2.*;
import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    //public static void main(String[] args) throws MalformedURLException {
    public static void main(String[] args) {



        SelectMethodEx sel = new SelectMethodEx();
        sel.RunScript();


























/**
         //Ejercicio 1
         WebPageWrapper wp = new WebPageWrapper("gc");
         wp.MaximizeWindow();
         wp.LoadWebPage("http://www.google.com");
         System.out.println(wp.GetPageTitle());
         System.out.println(wp.GetSourceCode());
         wp.CloseBrowser();

 **/
/**
        //Ejercicio 2
        WebPageWrapper wp2 = new WebPageWrapper("gc");
        wp2.MaximizeWindow();
        wp2.LoadWebPage("http://www.google.com");
        String sourceCode = wp2.GetSourceCode();
        int count1 = countMatches(sourceCode, "function");
        int count2 = countMatches(sourceCode, "script");
        int count3 = countMatches(sourceCode, "class");
        int count4 = countMatches(sourceCode, "id");
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
        System.out.println(count4);
        wp2.CloseBrowser();
**/
/**
         //Ejercicio 3
         WebPageWrapper wp3 = new WebPageWrapper("gc");
         wp3.MaximizeWindow();
         wp3.LoadWebPage("http://www.google.com");
         System.out.println(wp3.GetPageTitle());
         wp3.LoadWebPage("http://www.facebook.com");
         System.out.println(wp3.GetPageTitle());
         wp3.LoadWebPage("https://www.espn.com.mx/");
         System.out.println(wp3.GetPageTitle());
         wp3.GoBack();
         wp3.GoBack();
         System.out.println(wp3.GetPageTitle());
         wp3.GoForward();
         System.out.println(wp3.GetPageTitle());
         assert "Facebook - Log In or Sign Up" == wp3.GetPageTitle();
         wp3.RefreshBrowser();
         System.out.println(wp3.GetPageTitle());
         wp3.CloseBrowser();
 **/

/**
        WebPageWrapper wp4 = new WebPageWrapper("gc");
        wp4.MaximizeWindow();
        wp4.LoadWebPage("http://www.youtube.com");
        WebElementWrapper barraBusqueda = new WebElementWrapper("search_query","name");
        WebElementWrapper botonBuscar = new WebElementWrapper("search-icon-legacy","id");
        wp4.SearchForThisElement(barraBusqueda);
        if(barraBusqueda.allMatchingResults.get(0).isDisplayed()  &&  barraBusqueda.allMatchingResults.get(0).isEnabled())
        {
            wp4.ClickElement(barraBusqueda);
            wp4.EnterTextInElement(barraBusqueda, "Selenium");
            wp4.ClickElement(botonBuscar);
        }
        wp4.CloseBrowser();

**/



        /**
         PokemonDBHomeBusinessLogic dbHomeObj = new PokemonDBHomeBusinessLogic(wp);
         dbHomeObj.LoadThisPage();
         dbHomeObj.ClickTheModalOkButtonIfItsPresent();
         dbHomeObj.NavigateToNationalDexFromQuickLink();
         wp.CloseBrowser();
         **/


        /**
         DesiredCapabilities cap = DesiredCapabilities.chrome();
         cap.setCapability("version","");
         cap.setPlatform(Platform.LINUX);
         String Node = "http://192.168.8.53:4444/wd/hub";

         WebDriver driver = new RemoteWebDriver(new URL(Node), cap);
         **/
    }


    public static int countMatches(String text, String str) {
        Matcher matcher = Pattern.compile(str).matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}