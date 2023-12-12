package pokemonclasses;

public class AbilitySettings {
    public final Ability ability;
    public final boolean isHidden;
    public final int slot;

    public AbilitySettings(Ability ability, int slot, boolean isHidden)
    {
        this.ability = ability;
        this.isHidden = isHidden;
        this.slot = slot;
    }

    public Ability getAbility() {
        return ability;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public int getSlot() {
        return slot;
    }
}
