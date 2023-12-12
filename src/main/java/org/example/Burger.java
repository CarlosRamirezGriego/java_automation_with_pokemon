package org.example;

public class Burger {
    String type;
    boolean hasOnion;
    boolean hasTomato;
    boolean hasLettuce;
    boolean hasBacon;
    boolean hasCheese;
    boolean tacos;

    public Burger() {
        this.setType();
        this.withCheese();
        this.withoutBacon();
        this.withLettuce();
        this.withTomato();
        this.withOnion();
    }

    public void setType() {
        this.type = "CHEESEBURGER";
    }

    public String getType() {
        return this.type;
    }

    public void withTomato() {
        this.hasTomato = true;
    }

    public void withOnion() {
        this.hasOnion = true;
    }

    public void withoutOnion() {
        this.hasOnion = false;
    }

    public void withLettuce() {
        this.hasLettuce = true;
    }

    public void withBacon() {
        this.hasBacon = true;
    }

    public void withoutBacon() {
        this.hasBacon = false;
    }

    public void withCheese() {
        this.hasCheese = true;
    }

    public void withoutCheese() {
        this.hasCheese = false;
    }


    public static BurgerBuilder VeggieBurger() {
        return new BurgerBuilder("VEGGIE");
    }

    public static BurgerBuilder CheeseBurger() {
        return new BurgerBuilder("Cheese");
    }

    public static BurgerBuilder BeefBurger() {
        return new BurgerBuilder("BEEF");
    }

    public static class BurgerBuilder {

        private String type;
        private Burger burger;


        public BurgerBuilder(String typeBurger) {
            this.type = typeBurger;
            this.burger = new Burger();
            if ("BEEF".equals(this.type)) {
                this.burger = new BeefBurger();
            } else if ("VEGGIE".equals(this.type)) {
                this.burger = new VeggieBurger();
            }
        }

        public BurgerBuilder withOnion(){
            this.burger.withOnion();
            return this;
        }

        public BurgerBuilder withoutOnion(){
            this.burger.withoutOnion();
            return this;
        }

        public BurgerBuilder withTomato(){
            this.burger.withTomato();
            return this;
        }

        public BurgerBuilder withLettuce(){
            this.burger.withLettuce();
            return this;
        }

        public BurgerBuilder withBacon(){
            this.burger.withBacon();
            return this;
        }

        public BurgerBuilder withoutBacon(){
            this.burger.withoutBacon();
            return this;
        }

        public BurgerBuilder withCheese(){
            this.burger.withCheese();
            return this;
        }

        public BurgerBuilder withoutCheese(){
            this.burger.withoutCheese();
            return this;
        }

        public Burger deliverBurger()
        {
            return this.burger;
        }
    }
}




        /*
        public BurgerBuilder(String type){

        }

        public BurgerBuilder withOnion(){
            this.burger.withOnion();
            return this;
        }

        public BurgerBuilder withTomato(){
            this.burger.withTomato();
            return this;
        }

        public BurgerBuilder withLettuce(){
            this.burger.withLettuce();
            return this;
        }

        public BurgerBuilder withBacon(){
            this.burger.withBacon();
            return this;
        }

        public BurgerBuilder withoutBacon(){
            this.burger.withoutBacon();
            return this;
        }

        public BurgerBuilder withCheese(){
            this.burger.withCheese();
            return this;
        }

        public BurgerBuilder withoutCheese(){
            this.burger.withoutCheese();
            return this;
        }

        public Burger deliverBurger()
        {
            return this.burger;
        }*/
