public class Algoritmos<T> {
    
    public boolean subgrafoCuadradoPorNivel(Grafo<T> grafo) {
        boolean encontrado = false;
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        
        for (int i = 0; i < marca.length; i++) {
            if (!marca[i] && !encontrado) {
                encontrado = recorridoBFS(i, grafo, marca);
            }
        }
        
        return encontrado;
    }
    
    private boolean recorridoBFS(int i, Grafo<T> grafo, boolean[] marca) {
        ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
        int[] nivel = new int[grafo.listaDeVertices().tamanio()];
        
        q.encolar(grafo.listaDeVertices().elemento(i));
        marca[i] = true;
        nivel[i] = 0;
        
        while (!q.esVacia()) {
            Vertice<T> v = q.desencolar();
         //   System.out.print(v.dato());
            int nivelV = nivel[v.getPosicion()];
            
            if (nivelV == 4) {
                if (marca[v.getPosicion()]) {
                    return true; // Se encontró un subgrafo cuadrado con vértice destino ya visitado
            }
            }
            
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            
            while (!ady.fin()) {
                Arista<T> arista = ady.proximo();
                int j = arista.getVerticeDestino().getPosicion();
                
                if (!marca[j]) {
                    Vertice<T> w = arista.getVerticeDestino();
                    marca[j] = true;
                    nivel[j] = nivelV + 1;
                    q.encolar(w);
                }
            }
        }
        
        return false; // No se encontró un subgrafo cuadrado
    }
    

   public boolean subgrafoCuadrado_recursivo(Grafo<T> grafo) {    //no tener en cuenta estas aplicaciones 
            boolean encontrado=false;
            boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
            for (int i = 0; i < marca.length; i++) {
                if (!marca[i] && !encontrado) {
                    int contador=0;
                    encontrado=dfs(i, grafo, marca,contador,encontrado);
                }
            }
            return encontrado;
        }
    
        private boolean dfs(int i, Grafo<T> grafo, boolean[] marca,int contador ,boolean encontrado) {    //no tener en cuenta estas aplicaciones 
            contador++;
            marca[i] = true;
            Vertice<T> v = grafo.listaDeVertices().elemento(i);       
         //  System.out.println(v.dato());
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                int j = ady.proximo().getVerticeDestino().getPosicion();
                if (!marca[j]) {
                   encontrado= dfs(j, grafo, marca,contador,encontrado); 
                }  
                else if (marca[j] && contador==4){
                    return true;
                }
            }
           // contador=0;
            return encontrado;
        }


        public int getGrado(Grafo<T> grafo) {
            boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
            int valor=0;
            int valorMax=0; //utilizamos 2 valores para ir almacenando, para cada iteracion el grado maximo de cada una
            for (int i = 0; i < marca.length; i++) {
                if (!marca[i]) {
                 valor= recorridoBFS_2(i, grafo, marca);
                 if (valor>valorMax) //si el valor proporcionado anteriormente es mayor,lo actualizamos
                    valorMax=valor;
                }
            }
            return valorMax;
            
        }

        private int recorridoBFS_2(int i, Grafo<T> grafo, boolean[] marca) {
            ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
            int[] suma = new int[grafo.listaDeVertices().tamanio()]; //vamos a ir sumando en un vector de cada vertice, las sumas de sus entradas y sus salidas
            marca[i] = true;
            q.encolar(grafo.listaDeVertices().elemento(i));
        
            
            while (!q.esVacia()) {
                Vertice<T> v = q.desencolar();
               // System.out.print(v.dato());
                

                ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
                ady.comenzar();
                
                while (!ady.fin()) {
                    suma[v.getPosicion()]++; //por cada vez que entramos al while, son la cantidad de adyacentes que tiene el vertice, cada adyacente es una salida a agregar
                    Arista<T> arista = ady.proximo();
                    int j = arista.getVerticeDestino().getPosicion();
                    suma[j]++; //por cada while(independiente de que vertice este operando),sumamos en el mismo vector 1 en la posicion j,que determina el vertice que esta apuntando(independiente si lo visita o no)
                    if (!marca[j]) {
                        Vertice<T> w = arista.getVerticeDestino();
                        marca[j] = true;
                        q.encolar(w);
                    }
                }
            }
            int maximo=0; //una vez finalizado, recorremos el vector en busca del maximo y lo retornamos
           for (i=0;i<grafo.listaDeVertices().tamanio();i++){
            if (suma[i]>maximo)
                maximo=suma[i];
           }
           return maximo;
        }


        public boolean tieneCiclo(Grafo<T> grafo) {
            boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
            boolean tiene=false;
            for (int i = 0; i < marca.length; i++) {
                if (!marca[i] && !tiene) 
                 tiene=recorridoBFS_3(i, grafo, marca);

            }
            return tiene;
        }

        private boolean recorridoBFS_3(int i, Grafo<T> grafo, boolean[] marca) { //consideramos que tiene que tener longitud 2 el ciclo minimo
            ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
            q.encolar(grafo.listaDeVertices().elemento(i));
        
            
            while (!q.esVacia()) {
                Vertice<T> v = q.desencolar();
               // System.out.print(v.dato());
                

                ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
                ady.comenzar();
                
                while (!ady.fin()) {
                   
                    Arista<T> arista = ady.proximo();
                    int j = arista.getVerticeDestino().getPosicion();
        
                    if (!marca[j]) {
                        Vertice<T> w = arista.getVerticeDestino();
                        marca[j] = true;
                        q.encolar(w);
                    }
                    else if (marca[j]){
                        if (arista.getVerticeDestino()!=v){
                            return true;
                        } //si el vertice apuntado por la arista no es el mismo que el propio vertice, ya no es un loop por ende retorno true
                          
                    }
                }
            }
            return false;
        }
}
