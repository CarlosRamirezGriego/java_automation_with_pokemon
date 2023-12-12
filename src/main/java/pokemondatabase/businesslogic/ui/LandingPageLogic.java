package pokemondatabase.businesslogic.ui;
import pokemondatabase.pomclasses.landingpage.landingpage.PopularQuickLinksSection;
import systemclasses.support.WebDriverHelper;

public class LandingPageLogic {


    public static void loadNationalPokedexFromQuickLinks()
    {
        WebDriverHelper.waitForElementToBePresent(PopularQuickLinksSection.bulbapediaOption, true);
        WebDriverHelper.waitForElementToBeVisible(PopularQuickLinksSection.bulbapediaOption, true);
        WebDriverHelper.hoverOverThisElement(PopularQuickLinksSection.bulbapediaOption);
        WebDriverHelper.clickThisElement(PopularQuickLinksSection.nationalPokedexLink);
    }
}
