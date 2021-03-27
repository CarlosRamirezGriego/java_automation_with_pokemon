package QAMinds.Pizzeria;

public class Pizzeria {
    public IPizza OrdenarPizza(String tipoDePizza) throws Exception {
        IPizza pizza = null;

        if(tipoDePizza.equals("Queso")){
            return new PizzaDeQueso();
        }
        else if(tipoDePizza.equals("Mexicana")){
            return new PizzaMexicana();
        }
        else if(tipoDePizza.equals("Italiana")){
            return new PizzaItaliana();
        }
        else{
            throw new Exception("Lo Sentimos no tenemos la pizza ***"+ tipoDePizza.toUpperCase() +"*** en nuestro menú áun. \nPero te lo haremos saber en cuanto la tengamos!");
        }
    }
}
