import javax.swing.event.ListDataListener;

public class GuiaDeTurismo {
    

    public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen, String puntoInteresDestino){
       Vertice<String> vertice_origen= buscarVertice(puntoInteresOrigen, grafo);
       Vertice<String> vertice_destino= buscarVertice(puntoInteresDestino, grafo);
        ListaGenerica<String> caminoActual= new ListaGenericaEnlazada<>();
        ListaGenerica<String> caminoTotal= new ListaGenericaEnlazada<>();
        objetoGuiaTurismo caminoMin = new objetoGuiaTurismo();

       if (vertice_destino!=null && vertice_origen!=null){
        int pesoMin=9999;
        caminoMin.setpesoMin(pesoMin);
        caminoMin.setViajes(9999);
        int i= vertice_origen.getPosicion();
        String destino= vertice_destino.dato();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        dfs(i,grafo,marca,caminoActual,caminoTotal,caminoMin,pesoMin,destino);
        
       }




        return caminoTotal;
    }


    private void dfs(int i, Grafo<String> grafo, boolean[] marca,ListaGenerica<String> caminoActual,  ListaGenerica<String> caminoTotal, objetoGuiaTurismo objeto, int pesoMin, String destino) {
        marca[i] = true;
       
        Vertice<String> v = grafo.listaDeVertices().elemento(i);       
       System.out.println(v.dato());
        caminoActual.agregarFinal(v.dato());
        if (v.dato().equals(destino)){
         
                pesoMin=pesoMin-1;
                int vueltas=0;
                int repes=0;
                while (repes<100){
                    repes+=pesoMin;
                    vueltas++;

                }
            
                if (vueltas<objeto.getViaje()){
                    caminoTotal.comenzar();
                    caminoActual.comenzar();
                    while (!caminoTotal.esVacia()){
                        caminoTotal.eliminarEn(caminoTotal.tamanio()-1);
                    }
                        
                    while (!caminoActual.fin()){
                        caminoTotal.agregarFinal(caminoActual.proximo());
                    }
                
                    objeto.setViajes(vueltas);
                }
              System.out.println(vueltas);
            
            
        }
        if (v.dato()!=destino){
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<String> arista= ady.proximo();
        
            int j = arista.getVerticeDestino().getPosicion();
            if (!marca[j]) {
               System.out.println(arista.peso());
                if (arista.peso()<pesoMin){
                    pesoMin=arista.peso();
                }
            dfs(j, grafo, marca,caminoActual,caminoTotal, objeto,pesoMin,destino); 
            marca[j]=false;
            caminoActual.eliminarEn(caminoActual.tamanio()-1);
            }

           

        }
            
        }
        

    }


    private Vertice<String> buscarVertice(String ciudad, Grafo<String> grafo) {
        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
        vertices.comenzar();

        while (!vertices.fin()) {
            Vertice<String> vertice = vertices.proximo();
            if (vertice.dato().equals(ciudad)) {
                return vertice;
            }
        }

        return null;
    }

}
