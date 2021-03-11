package QAMinds;

public class Animal{

    // Estado (Atributos y su valor)
    private String nombre;
    private int piernas;
    private String sonido;
    private String comida;

    // Comportamiento
    public void emitirSonido(){
        System.out.println("El sonido de " + nombre + " es: " + sonido);
    }

    public Animal(String nombre, int piernas, String sonido, String comida)
    {
        this.nombre = nombre;
        this.piernas = piernas;
        this.sonido = sonido;
        this.comida = comida;
    }

    public Animal()
    {

    }


    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }


    public void setPiernas(int piernas)
    {
        this.piernas = piernas;
    }

    public int getPiernas()
    {
        return this.piernas;
    }

    public void setSonido(String sonido)
    {
        this.sonido = sonido;
    }

    public String getSonido()
    {
        return this.sonido;
    }


    public void setComida(String comida)
    {
        this.comida = comida;
    }

    public String getComida()
    {
        return this.comida;
    }
}

