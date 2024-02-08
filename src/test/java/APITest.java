import org.junit.Assert;
import org.junit.Test;
import pokemonapi.businesslogic.PokemonAPILogic;
import pokemonclasses.Pokemon;

public class APITest {

    @Test
    public void testGetPokemonByName()
    {
        Assert.assertEquals(true, PokemonAPILogic.doesThisPokemonExists("Pikachu"));
        Assert.assertEquals(false, PokemonAPILogic.doesThisPokemonExists("Ratachu"));
    }

    @Test
    public void testGetPokemonByNumber()
    {
        Assert.assertEquals(true, PokemonAPILogic.doesThisPokemonExists(28));
        Assert.assertEquals(false, PokemonAPILogic.doesThisPokemonExists(1500));
    }

    @Test
    public void getPokemonInformation() {
        Pokemon pokemon =  PokemonAPILogic.returnPokemonInformation("pikachu");
        Assert.assertEquals("pikachu", pokemon.getName());
        Assert.assertEquals(25, pokemon.getId());
    }

}
