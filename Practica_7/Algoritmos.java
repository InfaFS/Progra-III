public class Algoritmos<T> {
    
   
    public boolean subgrafoCuadrado (Grafo<T> grafo) {
            boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
            for (int i=0; i<marca.length; i++) {
            if (!marca[i])
            this.bfs(i, grafo, marca);
            }

            return true;
        }
    
        private void  bfs (int i, Grafo<T> grafo, boolean[] marca){
            ListaGenerica<Arista<T>> ady = null;
            ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
            
            q.encolar(grafo.listaDeVertices().elemento(i));
            marca[i]=true;
    
            while (!q.esVacia()){
                Vertice<T> v = q.desencolar();
                System.out.println(v);
                ady=grafo.listaDeAdyacentes(v);
                ady.comenzar();
                while(!ady.fin()){
                    Arista<T> arista = ady.proximo();
                    int j = arista.getVerticeDestino().getPosicion();
                    if (!marca[j]){
                        Vertice<T> w = arista.getVerticeDestino();
                        marca[j]=true;
                        q.encolar(w);
    
                    }
                }
            }
        }

}
