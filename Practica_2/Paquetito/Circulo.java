package Paquetito;

public class Circulo extends Figura {

    double radio;


    Circulo(double radio, String color,boolean relleno){
        super(color,relleno);
        this.radio=radio;

    }
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double getPerimetro() {
        return 2*Math.PI*radio;
    }

    @Override
    public double getArea() {
        return Math.PI* this.radio* this.radio;
    }

    @Override
    public String toString() {
        return super.toString()+" El radio del circulo es "+getRadio()+", el perimetro es " + getPerimetro() + " y el area es "+ getArea();
    }
}
