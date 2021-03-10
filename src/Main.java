import PokemonDataBasePage.BusinessLogic.PokemonDBHomeBusinessLogic;
import PokemonDataBasePage.PageObjects.PokemonDBHome;
import QAMinds.Casa;
import Wrappers.WebPageWrapper;

public class Main {

    public static void main(String[] args) {

        WebPageWrapper wp = new WebPageWrapper("gc");
        PokemonDBHomeBusinessLogic dbHomeObj = new PokemonDBHomeBusinessLogic(wp);
        dbHomeObj.LoadThisPage();
        dbHomeObj.ClickTheModalOkButtonIfItsPresent();
        dbHomeObj.NavigateToNationalDexFromQuickLink();
        wp.CloseBrowser();

    }
}
