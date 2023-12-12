package pokemonclasses;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("height")
    private int height;
    @JsonIgnore
    private List<PokemonTypeSettings> types;
    @JsonIgnore
    private List<AbilitySettings> abilities;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<PokemonTypeSettings> getTypes() {
        return this.types;
    }

    public void addType(PokemonTypeSettings type) {
        if(this.types != null && this.types.size() < 2) {
            this.types.add(type);
        }
    }

    public List<AbilitySettings> getAbilities() {
        return this.abilities;
    }

    public void addAbility(AbilitySettings ability) {
        if(this.abilities != null && this.abilities.size() < 3) {
            this.abilities.add(ability);
        }
    }


    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return  this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
