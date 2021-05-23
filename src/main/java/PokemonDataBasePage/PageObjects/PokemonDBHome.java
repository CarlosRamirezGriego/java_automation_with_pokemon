package PokemonDataBasePage.PageObjects;

import Wrappers.*;

public class PokemonDBHome {
    public ElementInterface nationalDexQuickLink = new ElementInterface("main[id='main'] a[href='/pokedex/national']", Options.SearchMethods.CSS);
    public ElementInterface modalOkButton = new ElementInterface("button[class='btn btn-primary gdpr-accept']", Options.SearchMethods.CSS);
    public WebPageInterface webPage;

    public PokemonDBHome(WebPageInterface webPage)
    {
        this.webPage = webPage;
    }

    public void FindModalOkButton() throws Exception {
        this.webPage.SearchForTheseSelectorsData(this.modalOkButton);
    }

    public String GetThisPageTitle()
    {
        String title = this.webPage.ReturnWebPageTitle();
        return title;
    }

    public void ClickOKModalButton() throws Exception {
        this.webPage.ClickThisElement(this.modalOkButton);
        this.modalOkButton.ExpectNoMatches();
        this.webPage.SearchForTheseSelectorsData(this.modalOkButton);
    }


    public void SearchForNationalDexLink() throws Exception {
        this.webPage.SearchForTheseSelectorsData(this.nationalDexQuickLink);
    }

    public void ClickNationalDexLink() throws Exception {
        this.webPage.ThisElementShouldBeEnabled(this.nationalDexQuickLink);
        this.webPage.ClickThisElement(this.nationalDexQuickLink);
    }
}
