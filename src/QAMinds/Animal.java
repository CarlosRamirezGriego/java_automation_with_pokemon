package QAMinds;
import java.util.Objects;

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

    @Override
    public boolean equals(Object nuevoObjecto){
        if(this==nuevoObjecto){
            return true;
        }
        if(nuevoObjecto==null||nuevoObjecto.getClass()!=this.getClass()){
            return false;
        }
        if(nuevoObjecto instanceof Animal)
        {
            Animal objAnimal = (Animal)nuevoObjecto;
            return objAnimal.nombre.equals(this.nombre)
                    && objAnimal.piernas == this.piernas;
        }
        return false;
    }


    @Override
    public int hashCode(){
        return Objects.hash(this.nombre, this.piernas);
    }

    @Override
    public String toString(){
        String blablabla = "Clase Animal tiene las siguientes propiedades " + "{ nombre: "+this.nombre + ", piernas: " +
                this.piernas + "}";
        return blablabla;
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

