public class Resultado {
    private ListaGenerica<String> lista;
    private int montoMax;
    private int grado;
    public Resultado(){
        this.montoMax=0;
        this.lista= new ListaGenericaEnlazada<String>();
    }

    public void setCamino( ListaGenerica<String> listaEntry){

        this.lista.comenzar();
        while (!this.lista.esVacia()){
            this.lista.eliminarEn(this.lista.tamanio()-1);
        }
        listaEntry.comenzar();
        while (!listaEntry.fin()){
            this.lista.agregarFinal(listaEntry.proximo());
        }


        
    }
    
    public ListaGenerica<String> getCamino(){
        return this.lista;
    }

    public void setMontoSobrante(int montomax){
        this.montoMax=montomax;
    }

    public int getMontoSobrante (){
        return this.montoMax;
    }

    public void setGrado(int grado){
        this.grado=grado;
    }

    public int getGrado (){
        return this.grado;
    }
}
