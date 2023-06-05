import java.beans.DesignMode;

public class GuiaTursimo2 {
    
    public ListaGenerica <String> caminoMenor(Grafo<String> grafo ,String origen, String destino){

        ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<String>();
        Resultado res= new Resultado();

        if (!grafo.esVacio() && grafo!=null ){
            res.setMontoSobrante(9999);
            ListaGenerica<Vertice<String>> Vertices = grafo.listaDeVertices();
            Vertice<String> vInicial=null;
            Vertice<String> vAux=null;
            Vertice<String> vFinal=null;
      
        
            boolean [] marca = new boolean[grafo.listaDeVertices().tamanio()];
            Vertices.comenzar();
            while ((!Vertices.fin())){
                vAux=Vertices.proximo();
                if (vAux.dato().equals(origen)){
                    vInicial=vAux;
                }
                if (vAux.dato().equals(destino)){
                    vFinal=vAux;
                }
            }
            
            if (vFinal!=null && vInicial!=null){
                int pesoMin=9999;
                dfs(vInicial,grafo,marca,destino,pesoMin,caminoActual,res);
            }
        }
        return res.getCamino();

    }

    private void dfs (Vertice<String> vInicial,Grafo<String> grafo, boolean marca[],String destino,int pesoMin,ListaGenerica<String> caminoActual, Resultado res ){
      
        marca[vInicial.getPosicion()]=true;
        caminoActual.agregarFinal(vInicial.dato());
        
        if (vInicial.dato().equals(destino)){
            int viajes=0;
            int sumatoria=0;
            
            while (sumatoria<100){
                sumatoria+=pesoMin;
                viajes++;
            }

            if(viajes<res.getMontoSobrante()){
                res.setCamino(caminoActual);
                res.setMontoSobrante(viajes);
            }
        }



        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vInicial);
        ady.comenzar();
        while (!ady.fin()){
            if (vInicial.getPosicion()==0){ //ver por que no 
                pesoMin=9999;
            }
            Arista<String> arista = ady.proximo();
            if (!marca[arista.getVerticeDestino().getPosicion()]){
                if (pesoMin>arista.peso()){ //para que el valor quede en el backtrackingx
                    dfs(arista.getVerticeDestino(),grafo,marca,destino,arista.peso(),caminoActual,res); 
                }
                else 
                dfs(arista.getVerticeDestino(),grafo,marca,destino,pesoMin,caminoActual,res);
            }



        }



        

        marca[vInicial.getPosicion()]=false;
        caminoActual.eliminarEn(caminoActual.tamanio()-1);



    }
}
