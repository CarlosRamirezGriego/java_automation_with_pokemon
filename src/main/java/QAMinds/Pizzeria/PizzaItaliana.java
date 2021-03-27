package QAMinds.Pizzeria;

public class PizzaItaliana  implements IPizza{
    public String obtenerNombreDeLaPizza(){
        return "Pizza Italiana";
    }
    public void obtenerPrecio(){
        System.out.println("La Pizza Italiana vale $105");
    }
}
