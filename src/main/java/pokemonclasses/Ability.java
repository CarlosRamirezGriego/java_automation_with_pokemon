package pokemonclasses;

public class Ability {
    public final String name;
    public final String dataEndpoint;
    private int id;

    public Ability(String name, String url)
    {
        this.name = name;
        this.dataEndpoint = url;
        this.setIdFromDataEndpoint();
    }

    public void setIdFromDataEndpoint()
    {
        String[] arrOfStr = this.dataEndpoint.split("/", 0);
        this.id = Integer.valueOf(arrOfStr[arrOfStr.length - 1]);
    }


    public int getId()
    {
        return this.id;
    }
}
