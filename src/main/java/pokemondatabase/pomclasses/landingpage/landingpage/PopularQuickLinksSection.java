package pokemondatabase.pomclasses.landingpage.landingpage;

public class PopularQuickLinksSection {
    public static final String bulbapediaOption = "ul[class='bg-global-nav-primary']>li:nth-child(2) a";
    public static final String nationalPokedexLink = bulbapediaOption + "+ ul > li:nth-child(1)+li li:nth-child(2)";

}
