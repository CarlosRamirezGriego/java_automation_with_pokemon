package QAMinds.Pizzeria;

public class PizzaMexicana  implements IPizza{
    public String obtenerNombreDeLaPizza(){
        return "Pizza Mexicana";
    }
    public void obtenerPrecio(){
        System.out.println("La Pizza Mexicana vale $95");
    }
}
