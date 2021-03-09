package QAMinds;

public class Casa {
    public int ventana;
    public String color;
    public int restroom;


    public Casa(int ventana, int restroom){
        this("green");
        this.ventana = ventana;
        this.restroom = restroom;
    }

    public Casa(String color){
        this.color = color;
    }


}
