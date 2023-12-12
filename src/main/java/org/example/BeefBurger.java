package org.example;

public class BeefBurger extends Burger {

    public BeefBurger()
    {
        this.setType();
        this.setType();
        this.withCheese();
        this.withoutBacon();
        this.withLettuce();
        this.withOnion();
        this.withTomato();
    }
    public void setType()
    {
        this.type = "BEEF";
    }

}
