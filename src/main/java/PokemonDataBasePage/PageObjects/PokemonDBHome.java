package PokemonDataBasePage.PageObjects;

import Wrappers.WebElementWrapper;
import Wrappers.WebPageWrapper;

public class PokemonDBHome {
    public WebElementWrapper nationalDexQuickLink = new WebElementWrapper("main[id='main'] a[href='/pokedex/national']", "css");
    public WebElementWrapper modalOkButton = new WebElementWrapper("button[class='btn btn-primary gdpr-accept']", "css");
    public WebPageWrapper webPage;

    public PokemonDBHome(WebPageWrapper webPage)
    {
        this.webPage = webPage;
    }

    public WebElementWrapper FindModalOkButton()
    {
        modalOkButton = this.webPage.SearchForThisElement(modalOkButton);
        return modalOkButton;
    }


    public boolean WasTheModalOKButtonPresentAfter(int time)
    {
        this.webPage.UpdateExplicitWait(time);
        boolean wasPresent = this.webPage.SearchForThisElementForAnAmountOfTime(modalOkButton);
        return wasPresent;
    }


    public WebElementWrapper ClickOKModalButton()
    {
        modalOkButton = this.webPage.ClickElement(modalOkButton);
        return modalOkButton;
    }


    public WebElementWrapper ClickNationalDexLink()
    {
        nationalDexQuickLink = this.webPage.ClickElement(nationalDexQuickLink);
        return nationalDexQuickLink;
    }
}
