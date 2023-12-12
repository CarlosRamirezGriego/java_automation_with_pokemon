package pokemonclasses;

public class PokemonType {
    public int id;
    public String name;
    public String url;

    public PokemonType()
    {

    }

    public PokemonType(String name, String url)
    {
        this.name = name;
        this.url = url;
        this.setIdFromDataEndpoint();
    }

    public void setIdFromDataEndpoint()
    {
        String[] arrOfStr = this.url.split("/", 0);
        this.id = Integer.valueOf(arrOfStr[arrOfStr.length - 1]);
    }


    public int getId()
    {
        return this.id;
    }
}
