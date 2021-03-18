package QAMinds;

public class EjercicioOperadores {
    int edadPapa = 54;
    int edadRoberto = 18;
    int edadAmigo = 18;

    public EjercicioOperadores(int edadAmigo)
    {
        this.edadAmigo = edadAmigo;
    }

    public EjercicioOperadores(int edadPapa, int edadRoberto, int edadAmigo)
    {
        this.edadPapa = edadPapa;
        this.edadRoberto = edadRoberto;
        this.edadAmigo = edadAmigo;
    }

    public void LogicaEdadesIF()
    {
        String respuesta = null;
        System.out.println("La edad del Papá es de " + edadPapa + " años, la de Roberto es de " + edadRoberto + " años.");
        if(edadPapa < edadRoberto)
        {
            System.out.println("La edad del Papá es MENOR QUE la edad de Roberto");
        }
        else if(edadPapa <= edadRoberto)
        {
            System.out.println("La edad del Papá es MENOR O IGUAL QUE la edad de Roberto");
        }
        else if(edadPapa > edadRoberto)
        {
            System.out.println("La edad del Papá es MAYOR QUE la edad de Roberto");
        }
        else if(edadPapa >= edadRoberto)
        {
            System.out.println("La edad del Papá es MAYOR O IGUAL QUE la edad de Roberto");
        }
        else if(edadPapa == edadRoberto)
        {
            System.out.println("La edad del Papá es IGUAL QUE la edad de Roberto");
        }
        else
        {
            System.out.println("La edad del Papá es DIFERENTE QUE la edad de Roberto");
        }
    }

    private String LogicaEdadesGenerico(int amigo)
    {
        String respuesta = null;
        if(amigo < edadRoberto)
        {
            respuesta = "MENOR QUE";
        }
        else if(amigo <= edadRoberto)
        {
            respuesta = "MENOR O IGUAL QUE";
        }
        else if(amigo > edadRoberto)
        {
            respuesta = "MAYOR QUE";
        }
        else if(amigo >= edadRoberto)
        {
            respuesta = "MAYOR O IGUAL QUE";
        }
        else if(amigo == edadRoberto)
        {
            respuesta = "IGUAL QUE";

        }
        else
        {
            respuesta = "DIFERENTE QUE";
        }
        return respuesta;
    }



    public void LogicaEdadesSwitch(int amigo)
    {
        String comparacion = LogicaEdadesGenerico(amigo);
        switch(comparacion){
            case "MENOR QUE":
                System.out.println("La edad del Amigo es MENOR QUE la edad de Roberto");
                break;
            case "MENOR O IGUAL QUE":
                System.out.println("La edad del Amigo es MENOR O IGUAL QUE la edad de Roberto");
                break;
            case "MAYOR QUE":
                System.out.println("La edad del Amigo es MAYOR QUE la edad de Roberto");
                break;
            case "MAYOR O IGUAL QUE":
                System.out.println("La edad del Amigo es MAYOR O IGUAL QUE la edad de Roberto");
                break;
            case "IGUAL QUE":
                System.out.println("La edad del Amigo es MAYOR O IGUAL QUE la edad de Roberto");
                break;
            case "DIFERENTE QUE":
                System.out.println("La edad del Amigo es MAYOR O IGUAL QUE la edad de Roberto");
                break;
        }
    }

    public void LogicaEdadesSwitch()
    {
        String comparacion = LogicaEdadesGenerico(this.edadAmigo);
        switch(comparacion){
            case "MENOR QUE":
                System.out.println("La edad del Amigo es MENOR QUE la edad de Roberto");
                break;
            case "MENOR O IGUAL QUE":
                System.out.println("La edad del Amigo es MENOR O IGUAL QUE la edad de Roberto");
                break;
            case "MAYOR QUE":
                System.out.println("La edad del Amigo es MAYOR QUE la edad de Roberto");
                break;
            case "MAYOR O IGUAL QUE":
                System.out.println("La edad del Amigo es MAYOR O IGUAL QUE la edad de Roberto");
                break;
            case "IGUAL QUE":
                System.out.println("La edad del Amigo es MAYOR O IGUAL QUE la edad de Roberto");
                break;
            case "DIFERENTE QUE":
                System.out.println("La edad del Amigo es MAYOR O IGUAL QUE la edad de Roberto");
                break;
        }
    }

}
