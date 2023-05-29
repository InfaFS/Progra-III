public class Delta<String> {
    

    public int MaxIslasDistintas(Grafo <String> grafo){
        int cant_maxima=0;

        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        //i=0 estara reservado para el muelle principal
        int valor_actual=0;
        for (int i = 1; i < marca.length; i++) {
        
            if (!marca[i]) {
            valor_actual=recorrido_1(i, grafo, marca);
            if (valor_actual>cant_maxima)
                cant_maxima=valor_actual;
            }

        }
       
        cant_maxima++;//agrego uno mas por el trayecto desde el muelle
        


        return cant_maxima;
    }



    private int recorrido_1(int i, Grafo<String> grafo, boolean[] marca ) {
        int cont=0;
        marca[i] = true;
       
        Vertice<String> v = grafo.listaDeVertices().elemento(i);       
       // System.out.println("Arribando en "+v.dato());
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().getVerticeDestino().getPosicion();
            if (!marca[j] && j!=0) {
          //      System.out.println("Dirigiendose a la isla "+j);
                cont++;
                cont+=recorrido_1(j, grafo, marca); 
            }
        }
        return cont;
    }

    public RutaMinima camonoMinimo(Grafo <String> grafo,String islaO, String islaD){
        
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        ListaGenerica<String> listaActual= new ListaGenericaEnlazada<>();
        ListaGenerica<String> listaTotal= new ListaGenericaEnlazada<>();
        ListaGenerica<Arista<String>> listaAristasActual= new ListaGenericaEnlazada<Arista<String>>();

       Vertice<String> verticeO= buscarVertice(islaO, grafo);
       Vertice<String> verticeD= buscarVertice(islaD, grafo);
       RutaMinima<String> objeto = new RutaMinima<String>();
       int peso_actual=0;
       pesoMax pesoMin = new pesoMax();
       pesoMin.setPeso(9999);
       objeto.setCamino(null);
       if (verticeD!=null && verticeO!=null){
        recorrido_2(verticeO.getPosicion(), grafo, marca,islaD,listaActual,listaTotal,pesoMin,objeto,listaAristasActual);

       }

        return objeto;

        }
       
    
    


    private void recorrido_2(int i, Grafo<String> grafo, boolean[] marca, String islaD,   ListaGenerica<String> listaActual,   ListaGenerica<String> listaTotal, pesoMax pesoMin,RutaMinima<String> objeto,ListaGenerica<Arista<String>> listaActualAristas) {
  
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);     
        listaActual.agregarFinal(v.dato());  
        System.out.println("Arribando en "+v.dato());
        if (v.dato().equals(islaD)){
            int peso_actual=0;
            listaActualAristas.comenzar();
            while (!listaActualAristas.fin()){
                peso_actual+=listaActualAristas.proximo().peso();
            }
            listaActual.comenzar();
            listaTotal.comenzar();
            if (peso_actual<pesoMin.getPeso()){
                pesoMin.setPeso(peso_actual);
                while (!listaTotal.fin())
                    listaTotal.eliminarEn(listaTotal.tamanio()-1);
                while (!listaActual.fin()){
                    listaTotal.agregarFinal(listaActual.proximo());
                }
               objeto.setCamino(listaTotal);

                if (marca[0]==true){
                    objeto.setBoleto(true);
                
                }
                if (marca[0]==false)
                    objeto.setBoleto(false);
                
            }


        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);

     // Arista<String>  arista=ady.proximo();
    //  if (arista!=null)  
        ady.comenzar();
        while (!ady.fin()) {

            Arista<String> arista=ady.proximo();
            listaActualAristas.agregarFinal(arista);
            int j = arista.getVerticeDestino().getPosicion();
            if (!marca[j]) {
                System.out.println("Dirigiendose a la isla "+j);
                recorrido_2(j, grafo, marca,islaD,listaActual,listaTotal,pesoMin,objeto,listaActualAristas);
                listaActualAristas.eliminarEn(listaActualAristas.tamanio()-1);
            }

        }
;
        listaActual.eliminarEn(listaActual.tamanio()-1);
        marca[i]=false; 
    
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