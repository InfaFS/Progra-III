package PaqueteMobile;

public class SmartPhone extends Mobile {
    private int numero;


    public SmartPhone (String marca, String modelo, String sistemaOperativo, double costo, int numero){
        super(marca,modelo,sistemaOperativo,costo);
        this.numero=numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    @Override
    public boolean equals(Object obj) {
        boolean result=false;
        if ((obj!=null) && (obj instanceof Mobile)){
            Mobile m= (SmartPhone) obj;
            if ( (m.getCosto()==this.getCosto())  && (m.getModelo()==this.getModelo()) && (m.getMarca()==this.getMarca())  && (m.getSistemaOperativo() == this.getSistemaOperativo())&& (getNumero()==this.numero)){
                result=true;}
        }
        return result;

    }
    @Override
    public String toString() {
        return super.toString()+"\nEl numero del dispositivo es: "+ getNumero();
    }
}
