package org.example;

public class VeggieBurger extends Burger {
    public VeggieBurger()
    {
        this.setType();
        this.withoutBacon();
        this.withoutCheese();
        this.withLettuce();
        this.withOnion();
        this.withTomato();
    }
    public void setType()
    {
        this.type = "VEGGIE";
    }
}
