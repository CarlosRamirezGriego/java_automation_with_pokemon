package Wrappers;

public class Options {
    public enum Browsers{
        CHROME, FIREFOX;
    }

    public enum SearchMethods{
        ID, CSS, XPATH, LINK, PARTIALLINK, NAME, CLASSNAME;
    }

    public enum ExpectedMatches{
        NONE, MANY, ONE;
    }
}
