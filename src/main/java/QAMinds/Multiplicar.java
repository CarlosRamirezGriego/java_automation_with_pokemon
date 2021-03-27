package QAMinds;

public class Multiplicar extends CalculadoraBase{
    @Override
    public void calcular(){
        this.setResultado(getValor1() * getValor2());
    }
}