package QAMinds;


public class Suma extends CalculadoraBase{
    @Override
    public void calcular(){
        this.setResultado(getValor1() + getValor2());
    }
}