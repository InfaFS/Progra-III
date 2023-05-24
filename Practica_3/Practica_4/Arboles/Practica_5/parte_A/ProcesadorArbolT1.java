package Practica_4.Arboles.Practica_5.parte_A;

import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;
import Practica_4.Arboles.ArbolBinario;
import Practica_4.Arboles.Practica_5.parte_A.almacen;

public class ProcesadorArbolT1 {

    private ArbolBinario<Integer> arbol;

    public ProcesadorArbolT1(ArbolBinario<Integer> arbolito){

        this.arbol=arbolito;
    }

    public almacen procesarArbol(){
        ArbolBinario<Integer> arbol = this.arbol;
        ListaGenerica<ArbolBinario<Integer>> lista = new ListaGenericaEnlazada<ArbolBinario<Integer>>() ;
        almacen Almacenado = new almacen();
        lista.comenzar();
        if (!(this.arbol.esVacio())){
            int valor= procesarRecursivo(arbol,lista);
            Almacenado.setValor(valor);
            Almacenado.setLista(lista);
        }

        return Almacenado;
    }

    private int procesarRecursivo(ArbolBinario<Integer> arbol, ListaGenerica<ArbolBinario<Integer>> lista){
        int contador=0;
        
        if ((arbol.tieneHijoIzquierdo())&& (arbol.tieneHijoDerecho()) && (arbol.getDato() % 2==0)){
            lista.agregarFinal(arbol);
        }
        
        if (arbol.getDato() % 2 ==0){
            contador ++;
        }

        if (arbol.tieneHijoIzquierdo()){
            contador+=procesarRecursivo(arbol.getHijoIzquierdo(),lista);

        }

        if (arbol.tieneHijoDerecho()){
            contador+=procesarRecursivo(arbol.getHijoDerecho(),lista);
       }

       return contador;

    }
    
}
