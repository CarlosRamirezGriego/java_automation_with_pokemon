package QAMinds;

public class Palindrome {
    public String value;

    public Palindrome(String value){
        this.value = value;
    }

    public Boolean CheckIfPalindrome()
    {
        String original  = this.value;
        String reversed = "";
        original =  original.replaceAll("[^a-zA-Z0-9]", "");
        original =  original.toLowerCase();
        int length = original.length();
        for ( int i = length - 1; i >= 0; i-- ) {
            reversed = reversed + original.charAt(i);
        }
        if (original.equals(reversed)) {
            return true;
        }
        else{
            return false;
        }
    }
}
