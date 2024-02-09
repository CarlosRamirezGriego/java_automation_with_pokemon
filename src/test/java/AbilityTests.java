import org.junit.Assert;
import org.junit.Test;
import pokemonclasses.Ability;


public class AbilityTests {
    @Test
    public void abilityIdTests()
    {
        Ability ability01 = new Ability("static", "https://pokeapi.co/api/v2/ability/9/");
        Assert.assertEquals(9, ability01.getId());
    }
}
