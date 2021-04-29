package QAMinds;

public class FizzBuzz
{
    public int top;

    public FizzBuzz(int top){
        this.top = top;
    }

    public void RunFizzBuzz(){
        for(int i = 0; i <= this.top; i++){
            int result3 = i % 3;
            int result5 = i % 5;
            if(result3 == 0 && result5 == 0)
            {
                System.out.println(i+" is FizzBuzz");
            }
            else if (result3 == 0 && result5 != 0) {
                System.out.println(i + " is Fizz");
            }
            else if (result3 != 0 && result5 == 0) {
                System.out.println(i+" is Buzz");
            }
        }
    }
}
