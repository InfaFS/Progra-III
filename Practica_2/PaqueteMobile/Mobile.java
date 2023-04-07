package PaqueteMobile;

public class Mobile {
     private String marca;
     private String sistemaOperativo;
    private  String modelo;
     private double costo;

    public Mobile (String marca, String modelo, String sistemaOperativo, double costo){
        this.modelo=modelo;
        this.sistemaOperativo=sistemaOperativo;
        this.marca=marca;
        this.costo=costo;

    }

    public void setMarca(String marca){
        this.marca=marca;
    }

    public void setSistemaOperativo(String sistemaOperativo){
        this.sistemaOperativo=sistemaOperativo;
    }

    public void setModelo(String modelo){
        this.modelo=modelo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getSistemaOperativo(){
        return this.sistemaOperativo;
    }

    public String getModelo(){
        return this.modelo;
    }


    public double getCosto(){
        return this.costo;
    }

    @Override
    public String toString() {
        return ("El modelo del dispositivo es: "+getModelo()+ "\nLa marca del dispositivo es: " + getMarca() +"\nEl costo del dispositivo es de: "+ getCosto()+"\nEl sistema operativo del dispositivo es: "+getSistemaOperativo());
    }
}
