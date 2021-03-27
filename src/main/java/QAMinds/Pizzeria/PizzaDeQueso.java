package QAMinds.Pizzeria;

public class PizzaDeQueso implements IPizza{

    public String obtenerNombreDeLaPizza(){
        return "Pizza De Queso";
    }

    public void obtenerPrecio(){
        System.out.println("La Pizza de Queso vale $100");
    }
}
