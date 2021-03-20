import PokemonDataBasePage.BusinessLogic.PokemonDBHomeBusinessLogic;
import PokemonDataBasePage.PageObjects.PokemonDBHome;
import QAMinds.*;
import Wrappers.WebPageWrapper;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class Main {


    //public static void main(String[] args) throws MalformedURLException {
    public static void main(String[] args)  {


        Multiplicar calc = new Multiplicar();
        realizarElCalculo(calc, 3, 4);


/**
        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.MaximizeWindow();
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

        WebPageWrapper wp = new WebPageWrapper(driver);
        wp.MaximizeWindow();
        PokemonDBHomeBusinessLogic dbHomeObj = new PokemonDBHomeBusinessLogic(wp);
        dbHomeObj.LoadThisPage();
        dbHomeObj.ClickTheModalOkButtonIfItsPresent();
        dbHomeObj.NavigateToNationalDexFromQuickLink();
        wp.CloseBrowser();
**/

    }

    static void realizarElCalculo(CalculadoraBase calculadoraBase, double valor1, double valor2){
        calculadoraBase.setValor1(valor1);
        calculadoraBase.setValor2(valor2);
        calculadoraBase.calcular();
        System.out.println(calculadoraBase.getResultado());
    }
}
