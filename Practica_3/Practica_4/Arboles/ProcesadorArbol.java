package Practica_4.Arboles;

import ListaGenerica.ListaGenericaEnlazada;

public class ProcesadorArbol {

    private ArbolBinario<Character> arbol;

    public ProcesadorArbol(ArbolBinario<Character> arbol){
        this.arbol=arbol;
    }
    
    public int procesar(int K){
        boolean anterior=false;
        ArbolBinario<Character> arbolitoAux = this.arbol;

       K=procesar_recursivo(arbolitoAux,anterior);

        return K;



    }

    public int procesar_recursivo(ArbolBinario<Character> arbol,boolean anterior){
        int contador=0;
        if (arbol.esHoja() && anterior==true){
           return 1;
        }
        
        if ((arbol.tieneHijoIzquierdo() && !arbol.tieneHijoDerecho()) || (!arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho())){
            anterior=true;
        }
        else anterior=false;

        if (arbol.tieneHijoIzquierdo()){
            contador+=procesar_recursivo(arbol.getHijoIzquierdo(),anterior);

        }
        if (arbol.tieneHijoDerecho()){
           contador+= procesar_recursivo(arbol.getHijoDerecho(),anterior);
        
        }
        return contador;
    }

    // con un solo metodo

    public int procesar2 (int K){
        // if(this.arbol==null){//esto es por si me llegan a mandar una r bol null de una
        //     if(K==0)
        //         return 1;
        //     else
        //         return 0;
        // }        

        int cont=0;
        if(this.arbol.esHoja()&&K==0)//si el camino cumple la condicion
            return 1;
        
        if(this.arbol.tieneHijoIzquierdo()&& !this.arbol.tieneHijoDerecho()){//el nodo cumple la condicion por izquierda
            this.arbol=this.arbol.getHijoIzquierdo();
            K--;
            cont+=this.procesar2(K);
        }
        else{
            if(this.arbol.tieneHijoDerecho()&& !this.arbol.tieneHijoIzquierdo()){//el nodo cumple la condicion con derecha
                this.arbol=this.arbol.getHijoDerecho();
                K--;
                cont+=this.procesar2(K);
            }
        }

        if(!this.arbol.esHoja()){//tiene ambos hijos
            ArbolBinario<Character> aux=this.arbol.getHijoDerecho();
            this.arbol=this.arbol.getHijoIzquierdo();
            cont+=this.procesar2(K);
            this.arbol=aux;
            cont+=this.procesar2(K);
        }

        return cont;
        
    }
}