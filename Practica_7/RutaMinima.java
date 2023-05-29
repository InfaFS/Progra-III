public class RutaMinima<String> {

    private ListaGenerica <String> camino;
    private boolean boleto;
    
    public void setCamino(ListaGenerica<String> lista){
        this.camino=lista;
    }   
    public void setBoleto(boolean boleto){
        this.boleto=boleto;
    }

    public ListaGenerica<String> getCamino(){
        return this.camino;
    }

    public boolean getBoleto(){
        return this.boleto;
    }

}
