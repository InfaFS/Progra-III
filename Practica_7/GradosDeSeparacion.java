
public class GradosDeSeparacion {
    public int maximoGradoDeSeparacion(Grafo<String> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int separacion_maxima=0;
        if (grafo!=null && !grafo.esVacio()){
            int i=0;
            separacion_maxima= bfs(i,grafo,marca);

        }
          if (separacion_maxima==0){
            System.out.println("Hay nodos desconectados el grado es ");
          }
        
        return separacion_maxima;
    }

    private int bfs (int i, Grafo<String> grafo, boolean[] marca){
        ListaGenerica<Arista<String>> ady = null;
        int separacion_maxima=0;
        ColaGenerica<Vertice<String>> q = new ColaGenerica<Vertice<String>>();
        int cant_vertices=grafo.listaDeVertices().tamanio();
        int contador=1;
        q.encolar(grafo.listaDeVertices().elemento(i));
        q.encolar(null);
        marca[i]=true;

        while (!q.esVacia()){
            Vertice<String> v = q.desencolar();
            if (v!=null){

            
            System.out.println(v.dato());
            ady=grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                int j = arista.getVerticeDestino().getPosicion();
                if (!marca[j]){
                    contador++;
                    Vertice<String> w = arista.getVerticeDestino();
                    marca[j]=true;
                    q.encolar(w);

                }
                
            }
        
        }
        else{
            if (!q.esVacia()){
                separacion_maxima++;
                q.encolar(null);
            }

        }
    }
    if (contador==cant_vertices){
        return separacion_maxima;

    }
    else 
        return 0;
}

}

