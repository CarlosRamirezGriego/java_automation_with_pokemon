package PokemonDataBasePage.BusinessLogic;

import PokemonDataBasePage.PageObjects.PokemonDBHome;
import Wrappers.WebPageInterface;

public class PokemonDBHomeBusinessLogic {
    public WebPageInterface webPage;

    public PokemonDBHomeBusinessLogic(WebPageInterface wp)
    {
        this.webPage = wp;
    }

    public void LoadThisPage()
    {
        PokemonDBHome pkdbhome = new PokemonDBHome(this.webPage);
        this.webPage.LoadWebPage("https://pokemondb.net/");
    }


    public void ClickModalOkButton()  throws Exception
    {
        PokemonDBHome pkdbhome = new PokemonDBHome(this.webPage);
        pkdbhome.ClickOKModalButton();
    }

    public void NavigateToNationalDexFromQuickLink() throws Exception {
        PokemonDBHome pkdbhome = new PokemonDBHome(this.webPage);
        pkdbhome.ClickNationalDexLink();
    }

}
