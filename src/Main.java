import AutomationClasses.WebPageWrapper;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
        WebPageWrapper wp = new WebPageWrapper("gc");
        wp.LoadWebPage("http://www.google.com");
    }
}
