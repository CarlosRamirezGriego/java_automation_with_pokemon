package pokemonclasses;

public class PokemonTypeSettings {
    public final PokemonType type;
    public final int slot;

    public PokemonTypeSettings(PokemonType type, int slot)
    {
        this.type = type;
        this.slot = slot;
    }

    public PokemonType getType() {
        return type;
    }

    public int getSlot() {
        return slot;
    }
}
