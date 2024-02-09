import org.example.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class OtherTests {
    @Test
    public void calculator()
    {
        int[] testArray =  {4, 5, 6, 7, 4};
        Assert.assertEquals(4, Calculator.solution(testArray));
    }

}
