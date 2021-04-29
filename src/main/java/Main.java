import PokemonDataBasePage.BusinessLogic.PokemonDBHomeBusinessLogic;
import QAMinds.FizzBuzz;
import QAMinds.Palindrome;
import Wrappers.WebPageWrapper;

public class Main {


    //public static void main(String[] args) throws MalformedURLException {
    public static void main(String[] args){

/***
         WebPageWrapper wp = new WebPageWrapper("gc");
         wp.MaximizeWindow();
         PokemonDBHomeBusinessLogic dbHomeObj = new PokemonDBHomeBusinessLogic(wp);
         dbHomeObj.LoadThisPage();
         dbHomeObj.ClickTheModalOkButtonIfItsPresent();
         dbHomeObj.NavigateToNationalDexFromQuickLink();
         wp.CloseBrowser();
 ***/


        FizzBuzz a = new FizzBuzz(150);
        a.RunFizzBuzz();


        Palindrome check = new Palindrome("texto");
        System.out.println(check.CheckIfPalindrome());
        check.value = "Madam.";
        System.out.println(check.CheckIfPalindrome());





    /***
    int[] indexes = new int[] {1, 3, 2, 8, 1};
    String[] tacos = new String[] {"Asada","Pastor", "Frijol", "Tripita" };

    for (int i : indexes)
    {
        try{
            System.out.println(tacos[i]);
        }
        catch (Exception e){
            throw new CafeDerramadoException();
        }
    }
     ***/











        /**



        LinkedList<Animal> animales = new LinkedList<Animal>();
        animales.add(new Animal("Perro", 4, "ladrar", "croquetas"));
        animales.add(new Animal("Pez", 0, "blob, blob", "placton"));
        animales.add(new Animal("Perico", 2));

        for (Animal var : animales)
        {
            var.emitirSonido();
        }

        System.out.println("--------------");
        animales.addFirst(new Animal("Gato", 4, "maullar", "Sardinas"));
        animales.addLast(new Animal("Ardilla", 2));

        for (Animal var : animales)
        {
            var.emitirSonido();
        }


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
}
