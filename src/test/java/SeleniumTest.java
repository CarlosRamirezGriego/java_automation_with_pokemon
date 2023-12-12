import org.junit.Test;
import systemclasses.support.WebDriverHelper;
import pokemondatabase.businesslogic.ui.LandingPageLogic;

public class SeleniumTest {
    @Test
    public void testLoadPokemonDB()
    {
        WebDriverHelper.initializeWebDriver();
        WebDriverHelper.navigateToThisURL("https://bulbapedia.bulbagarden.net/");
        LandingPageLogic.loadNationalPokedexFromQuickLinks();
    }

}
