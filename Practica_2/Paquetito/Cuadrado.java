package Paquetito;

public class Cuadrado extends Rectangulo {


    public Cuadrado(double largo, double ancho, String color, boolean relleno) {
        super(largo, ancho, color, relleno);
    }

    @Override
    public double getPerimetro() {
        return ancho*4;
    }

    @Override
    public double getArea() {
        return this.ancho*2;
    }

    @Override
    public String toString() {
        return(isRelleno() + getColor() + getPerimetro()+ " y un area de "+ getArea());
    }
}
