package Bloco2.Exercicio2;

public class Circulo {
    private double raio;

    public double getRaio() {
        return raio;
    }
    public void setRaio(double raio) {
        if(raio <= 0){
            throw new IllegalArgumentException("É proibido adicionar valores negativos!");
        }
        
        this.raio = raio;
    }

    public double calcularArea() {
        double areaDoCirculo = 3.14 * (raio*raio);
        return areaDoCirculo;
    }

    public Circulo(double raio){
        setRaio(raio);
    }
}
