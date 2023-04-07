package PaqueteMobile;

public class Tabletsita extends Mobile {
    private int pulgadas;


    public Tabletsita(String marca, String modelo, String sistemaOperativo, double costo, int pulgadas) {
        super(marca, modelo, sistemaOperativo, costo);
        this.pulgadas = pulgadas;
    }

    public int getPulgadas() {
        return pulgadas;
    }


    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result=false;
        if ((obj!=null) && (obj instanceof Mobile)){
            Mobile m= (Tabletsita)obj;
            if ( (m.getCosto()==this.getCosto())  && (m.getModelo()==this.getModelo()) && (m.getMarca()==this.getMarca())  && (m.getSistemaOperativo() == this.getSistemaOperativo())&& (getPulgadas()==this.pulgadas)){
            result=true;}
        }
        return result;
        }
    @Override
    public String toString() {
        return super.toString()+"\n Las pulgadas del dispositivo son: "+getPulgadas();
    }
    }
