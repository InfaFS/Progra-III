package Paquetito;

public abstract class Figura {
    String color;
    boolean relleno;


    //

    Figura (String color,boolean relleno){
        this.color=color;
        this.relleno=relleno;
    }

    public String getColor() {
        return color;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public String toString(){
        return "La figura tiene color" + this.color + ", estado del relleno: "+ this.relleno;
    }

    public abstract double getArea();
    public abstract double getPerimetro();
}
