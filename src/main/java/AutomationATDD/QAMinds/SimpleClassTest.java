package AutomationATDD.QAMinds;
import QAMinds.SimpleClass;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleClassTest {

    @DataProvider
    protected Object[][] listaValoresSuma(){
        return new Object[][] {{1,1,2}, {1,2,3}, {2,2,4}};
    }



    @Test(dataProvider = "listaValoresSuma")
    public void GivenThatIAddTwoNumbers_TheClassShouldAddThem(int a, int b, int expectedResult)
    {
        // Arrange
        SimpleClass sc = new SimpleClass();

        //Act
        int actualResult = sc.SumarCosas(a, b);

        //Assert
        Assert.assertEquals(actualResult, expectedResult);

    }
}
