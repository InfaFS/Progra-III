

public class objetoGuiaTurismo {
    private ListaGenerica<String> lista;
    private int viajes;
    private int pesoMin;
    public int getViaje(){
        return this.viajes;
    }
    
    public ListaGenerica<String> getLista(){
        return this.lista;
    }

    public void setLista(ListaGenerica<String> listita){
        this.lista=listita;
    }

    public void setViajes(int cant_viajes){
        this.viajes=cant_viajes;
    }


    public void setpesoMin(int peso){
        this.pesoMin=peso;
    }

    public int getPesoMin(){
        return this.pesoMin;
    }
}