package PokemonDataBasePage.BusinessLogic;

import PokemonDataBasePage.PageObjects.PokemonDBHome;
import Wrappers.WebPageWrapper;

public class PokemonDBHomeBusinessLogic {
    public WebPageWrapper webPage;

    public PokemonDBHomeBusinessLogic(WebPageWrapper wp)
    {
        this.webPage = wp;
    }

    public void LoadThisPage()
    {
        PokemonDBHome pkdbhome = new PokemonDBHome(this.webPage);
        this.webPage.LoadWebPage("https://pokemondb.net/");
    }

    public void ClickTheModalOkButtonIfItsPresent()
    {
        PokemonDBHome pkdbhome = new PokemonDBHome(this.webPage);
        boolean isModalPresent = pkdbhome.WasTheModalOKButtonPresentAfter(3);
        if(isModalPresent)
        {
            pkdbhome.ClickOKModalButton();
        }
    }

    public void NavigateToNationalDexFromQuickLink()
    {
        PokemonDBHome pkdbhome = new PokemonDBHome(this.webPage);
        pkdbhome.ClickNationalDexLink();
    }

}
