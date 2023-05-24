

public class mapaCiudades {
    private Grafo<String> grafo;

    public mapaCiudades(Grafo <String> grafo) {
        this.grafo = grafo;
    }


    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
        Grafo<String> grafo=this.grafo;
        ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
        ListaGenerica<String> listaActual = new ListaGenericaEnlazada<String>();

        //usamos 2 listas, una con un camino que se ira actualizando recursivamente y uno que guarda el camini
        Vertice<String> origen = buscarVertice(ciudad1);
        //busco el origen dentro del grafo

        if (origen == null) { //si es null, devuelve nada
            return new ListaGenericaEnlazada<>();
        }

        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()]; //creo un vector que va marcando las posiciones visitadas
        boolean encontrado=false; //se pone en true si encontre mi objetivo
        int i=origen.getPosicion(); //guarda la poiscion de inicio determinada por el vertice origen
        recorrido_1(i, grafo, marca, lista,encontrado,listaActual,ciudad2); //voy al recursivo
        
        if (encontrado=false){
            return new ListaGenericaEnlazada<>();
        }

        lista.comenzar();
    
        return lista; 
    }

    

    private boolean recorrido_1(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> lista ,boolean encontrado, ListaGenerica<String> listaActual, String ciudad2) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);  
        //parto desde el vertice de la posicion origen
        listaActual.agregarFinal(v.dato()); //agrego a la lista actual que se ira borrando el primer dato
        if (v.dato().equals(ciudad2) && !encontrado){//si encontre la ciudad destino le agrego a la lista que devuelvo todos las ciudades

            listaActual.comenzar();
            while (!lista.esVacia()){
                lista.eliminarEn(lista.tamanio()-1);
            }
            while (!listaActual.fin()){
                lista.agregarFinal(listaActual.proximo());
                
            }
            encontrado=true;
            return encontrado;
        

        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v); //obtengo los adyacentes del vertice actual
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().getVerticeDestino().getPosicion();
            if (!marca[j] && !encontrado) {
                encontrado=recorrido_1(j, grafo, marca, lista,encontrado,listaActual,ciudad2); 
            }
            listaActual.eliminarEn(listaActual.tamanio()-1); //al volver de la recursion boror de la lista actual
            marca[j]=false; //desmarco porel que pase
        }   
        
        return encontrado;
        
    }



    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> lista_ciudades) {
        Grafo<String> grafo=this.grafo;
        ListaGenerica<String> listaRet = new ListaGenericaEnlazada<String>();
        ListaGenerica<String> listaActual = new ListaGenericaEnlazada<String>();


        Vertice<String> origen = buscarVertice(ciudad1);


        if (origen == null) {
            return new ListaGenericaEnlazada<>();
        }

        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        boolean encontrado=false;
        int i=origen.getPosicion();
        boolean[] baneadas= new boolean[grafo.listaDeVertices().tamanio()]; //lo mismo que el otro pero uso un vector extra para ver las posiciones banned

        Vertice<String> vertice;
        lista_ciudades.comenzar();
        while (!lista_ciudades.fin()){
            vertice=buscarVertice(lista_ciudades.proximo());
            if (vertice.dato().equals(ciudad1) || vertice.dato().equals(ciudad2)){ //si alguno de los 2 baneados es destino/origen ya retorno null
                return new ListaGenericaEnlazada<>();
            }
            baneadas[vertice.getPosicion()]=true; //sino baneo la ciudad
        }

        

        recorrido_2(i, grafo, marca, listaRet,encontrado,listaActual,lista_ciudades,baneadas,ciudad2); //recorro
        
        if (encontrado=false){
            return new ListaGenericaEnlazada<>();
        }

    
        return listaRet; 
    }


    private void recorrido_2(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> lista ,boolean encontrado, ListaGenerica<String> listaActual, ListaGenerica<String> lista_ciudades, boolean [] baneadas,String ciudad2) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);  

        listaActual.agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)){//modificar por una variable

            listaActual.comenzar();
            while (!lista.esVacia()){
                lista.eliminarEn(lista.tamanio()-1);
            }
            while (!listaActual.fin()){
                lista.agregarFinal(listaActual.proximo());
                
            }
            encontrado=true;
        

        }
        boolean entre=false; //uso un entre para que no me borre elementos en casa de que una de las ciudades adyacentes este baneada en el backtraking
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().getVerticeDestino().getPosicion();
            if (!marca[j] && !baneadas[j]) {
                
                entre=true; //si no esta baneada ni visitada,voy a la recursion
                recorrido_2(j, grafo, marca, lista,encontrado,listaActual,lista_ciudades,baneadas,ciudad2); 
            }
            if (entre){ //si entre elimino el que cargue antes de volver
                listaActual.eliminarEn(listaActual.tamanio()-1);
            }
            marca[j]=false; //pongo que no visite el otro
        }
        
    }

    public ListaGenerica<String> CaminoMasCorto(String ciudad1, String ciudad2) {
       
        ListaGenerica <Arista<String>> listaActual_aristas = new ListaGenericaEnlazada<Arista<String>>();
        ListaGenerica <String> listaMinima_ciudades= new ListaGenericaEnlazada<String>();
        ListaGenerica <String> listaActual_ciudades= new ListaGenericaEnlazada<String>();
    
    

        //usamos 2 listas, una con un camino que se ira actualizando recursivamente y uno que guarda el camini
        Vertice<String> origen = buscarVertice(ciudad1);
        //busco el origen dentro del grafo
        //usamos una lista de aristas para luego guardar un valor que se va actualizando
        if (origen == null) { //si es null, devuelve nada
            return new ListaGenericaEnlazada<>();
        }

        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()]; //creo un vector que va marcando las posiciones visitadas
        boolean encontrado=false; //se pone en true si encontre mi objetivo
        int i=origen.getPosicion(); //guarda la poiscion de inicio determinada por el vertice origen
        valorMin valorminimo = new valorMin();
        valorminimo.setValorMin(9999); //usamos un objeto para ir seteando el minimo a medida y relacionarlo con el camino a devolver
       boolean found= recorrido_3(i, grafo, marca, listaMinima_ciudades,encontrado,listaActual_ciudades,ciudad2,listaActual_aristas,valorminimo); //voy al recursivo
        
        if (found=false){
            return new ListaGenericaEnlazada<>();
        }

    
        return listaMinima_ciudades; 
    }

    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int Tanque) {
       

        ListaGenerica <String> listaMinima_ciudades= new ListaGenericaEnlazada<String>();
        ListaGenerica <String> listaActual_ciudades= new ListaGenericaEnlazada<String>();


        //usamos 2 listas, una con un camino que se ira actualizando recursivamente y uno que guarda el camini
        Vertice<String> origen = buscarVertice(ciudad1);
        //busco el origen dentro del grafo
        if (origen == null) { //si es null, devuelve nada
            return new ListaGenericaEnlazada<>();
        }

        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()]; //creo un vector que va marcando las posiciones visitadas
        boolean encontrado=false; //se pone en true si encontre mi objetivo
        int i=origen.getPosicion(); //guarda la poiscion de inicio determinada por el vertice origen
        valorMin TanqueAuto = new valorMin();
        TanqueAuto.setValorMin(Tanque); //reutilzamos el objeto para setear el valor del taque e ir descontandolo
        boolean found= recorrido_4(i, grafo, marca, listaMinima_ciudades,encontrado,listaActual_ciudades,ciudad2,TanqueAuto); //voy al recursivo
        
        if (!found){
            System.out.println("El auto se quedo sin combustible o no hay camino disponible");
            return new ListaGenericaEnlazada<>();
        }

    
        return listaMinima_ciudades; 
    }





    private boolean  recorrido_3(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> lista ,boolean encontrado, ListaGenerica<String> listaActual,String ciudad2,ListaGenerica <Arista<String>> listaActual_aristas,valorMin valorminimo) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);  

        listaActual.agregarFinal(v.dato());

        if (v.dato().equals(ciudad2)){//modificar por una variable
            int peso_actual=0;
            listaActual_aristas.comenzar();
            while(!listaActual_aristas.fin()){
                peso_actual+=listaActual_aristas.proximo().peso();
            }

            if (peso_actual<valorminimo.getValorMin()){
                valorminimo.setValorMin(peso_actual);
                listaActual.comenzar();

                while (!lista.esVacia()){
                    lista.eliminarEn(lista.tamanio()-1);
                }
                while (!listaActual.fin()){
                    lista.agregarFinal(listaActual.proximo());
                    
                }
                encontrado=true;
                return encontrado;
            
            }

        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<String> arista= ady.proximo();
            int j = arista.getVerticeDestino().getPosicion();
            if (!marca[j]) {
                listaActual_aristas.agregarFinal(arista);
              encontrado=recorrido_3(j, grafo, marca, lista,encontrado,listaActual,ciudad2,listaActual_aristas,valorminimo); 
            }
    
            listaActual.eliminarEn(listaActual.tamanio()-1);
            listaActual_aristas.eliminarEn(listaActual_aristas.tamanio()-1);
            marca[j]=false; //pongo que no visite el otro
        }
        return encontrado;

    }


    private boolean recorrido_4(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> lista ,boolean encontrado, ListaGenerica<String> listaActual, String ciudad2, valorMin TanqueAuto) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);  
        int litros = TanqueAuto.getValorMin();
        if (litros<=0)
        return false;
        litros=litros-20;

        TanqueAuto.setValorMin(litros);
        //parto desde el vertice de la posicion origen
        listaActual.agregarFinal(v.dato()); //agrego a la lista actual que se ira borrando el primer dato
        if (v.dato().equals(ciudad2) && TanqueAuto.getValorMin()>=1){//si encontre la ciudad destino le agrego a la lista que devuelvo todos las ciudades

            listaActual.comenzar();
            while (!lista.esVacia()){
                lista.eliminarEn(lista.tamanio()-1);
            }
            while (!listaActual.fin()){
                lista.agregarFinal(listaActual.proximo());
                
            }
            encontrado=true;
            return encontrado;

        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v); //obtengo los adyacentes del vertice actual
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().getVerticeDestino().getPosicion();
            if (!marca[j] && !encontrado) {
               encontrado= recorrido_4(j, grafo, marca, lista,encontrado,listaActual,ciudad2,TanqueAuto); 
            }
            listaActual.eliminarEn(listaActual.tamanio()-1); //al volver de la recursion boror de la lista actual
            marca[j]=false; //desmarco porel que pase
        }
        return encontrado;
    }

    public ListaGenerica<String> caminoCargandoCombustible(String ciudad1, String ciudad2, int Tanque) {
       

        ListaGenerica <String> listaMinima_ciudades= new ListaGenericaEnlazada<String>();
        ListaGenerica <String> listaActual_ciudades= new ListaGenericaEnlazada<String>();


        //usamos 2 listas, una con un camino que se ira actualizando recursivamente y uno que guarda el camini
        Vertice<String> origen = buscarVertice(ciudad1);
        //busco el origen dentro del grafo
        if (origen == null) { //si es null, devuelve nada
            return new ListaGenericaEnlazada<>();
        }

        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()]; //creo un vector que va marcando las posiciones visitadas
        boolean encontrado=false; //se pone en true si encontre mi objetivo
        int i=origen.getPosicion(); //guarda la poiscion de inicio determinada por el vertice origen
        valorMin TanqueAuto = new valorMin();
        valorMin recargadas = new valorMin();
        recargadas.setValorMin(9999);
        TanqueAuto.setValorMin(Tanque); //reutilzamos el objeto para setear el valor del taque e ir descontandolo
        int recargadas_actuales=0;
        boolean found= recorrido_5(i, grafo, marca, listaMinima_ciudades,encontrado,listaActual_ciudades,ciudad2,TanqueAuto,recargadas,recargadas_actuales); //voy al recursivo
        
        if (!found){
            System.out.println("El auto se quedo sin combustible o no hay camino disponible");
            return new ListaGenericaEnlazada<>();
        }

        System.out.println("El camino con menos recargadas tiene unas "+ recargadas.getValorMin());

    
        return listaMinima_ciudades; 
    }

    private boolean recorrido_5(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> lista ,boolean encontrado, ListaGenerica<String> listaActual, String ciudad2, valorMin TanqueAuto,valorMin Recargadas_min, int recargardas_actuales) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);  
        System.out.println("Se cargaron 100 litros al tanque en "+v.dato());
        recargardas_actuales++;
        int litros = TanqueAuto.getValorMin();
        litros+=100;
        TanqueAuto.setValorMin(litros);
        if (litros<=0)
        return false;
        System.out.println("Se sacaron 20 litros del tanque al ir rumbo a la proxima ciudad... ");
        litros=litros-20;
        TanqueAuto.setValorMin(litros);

        //parto desde el vertice de la posicion origen
        listaActual.agregarFinal(v.dato()); //agrego a la lista actual que se ira borrando el primer dato
        if (v.dato().equals(ciudad2) && TanqueAuto.getValorMin()>=1){//si encontre la ciudad destino le agrego a la lista que devuelvo todos las ciudades

            listaActual.comenzar();
            if (recargardas_actuales<Recargadas_min.getValorMin()){
                Recargadas_min.setValorMin(recargardas_actuales);
                while (!lista.esVacia()){
                    lista.eliminarEn(lista.tamanio()-1);
                }
                while (!listaActual.fin()){
                    lista.agregarFinal(listaActual.proximo());
                    
                }
                encontrado=true;
                return encontrado;
            }
          

        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v); //obtengo los adyacentes del vertice actual
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().getVerticeDestino().getPosicion();
            if (!marca[j]) {
               encontrado= recorrido_5(j, grafo, marca, lista,encontrado,listaActual,ciudad2,TanqueAuto,Recargadas_min,recargardas_actuales); 
            }
            listaActual.eliminarEn(listaActual.tamanio()-1); //al volver de la recursion boror de la lista actual
            marca[j]=false; //desmarco porel que pase
        }
        return encontrado;
    }

   

    private Vertice<String> buscarVertice(String ciudad) {
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
