package Paquetito;

public class Rectangulo extends Figura {
    double largo;
    double ancho;

    public Rectangulo(double largo, double ancho, String color, boolean relleno){
        super(color,relleno);
        this.ancho=ancho;
        this.largo=largo;
    }

    public double getLargo() {
        return largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }


    @Override
    public double getArea() {
        return this.ancho*this.largo;
    }

    @Override
    public double getPerimetro() {
        return (this.ancho*2) + (this.largo*2);
    }

    @Override
    public String toString() {
       return super.toString()+" La base del rectangulo es" + getAncho()+ ", el alto es "+ getLargo()+ ", el perimetro es "+ getPerimetro()+ "y el area es"+ getArea();
    }
}
