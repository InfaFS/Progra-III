package Practica_4.Arboles.Practica_5.parte_A;

import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;
import Practica_4.Arboles.ArbolBinario;

public class Procesador {
    private ArbolBinario<Integer> arbol;

    public Procesador(ArbolBinario<Integer> arbol){
        this.arbol=arbol;
    }
    

    public ListaGenerica<ArbolBinario<Integer>> procesarArbol(){
        ListaGenerica<ArbolBinario<Integer>> lista = new ListaGenericaEnlazada<ArbolBinario<Integer>>();
        ArbolBinario<Integer> arbolAux= this.arbol; 

        if(!arbol.esVacio()){
            lista.comenzar();
            procesadorArbolRecursivo(arbolAux,lista);

        }


        return lista;


    }

    private void procesadorArbolRecursivo (ArbolBinario<Integer> arbol, ListaGenerica<ArbolBinario<Integer>> lista){
        if (arbol.esHoja()){
            if (arbol.getDato()==0){
                lista.agregarFinal(arbol);
            }
        }
        else if (arbol.tieneHijoIzquierdo() && !arbol.tieneHijoDerecho()){
            if (arbol.getDato()<= arbol.getHijoIzquierdo().getDato()){
                lista.agregarFinal(arbol);
            }
        }
        else if (!arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho()){
            if (arbol.getDato()<= arbol.getHijoDerecho().getDato()){
                lista.agregarFinal(arbol);
            }
        }
        else{
            int suma= arbol.getHijoDerecho().getDato() + arbol.getHijoIzquierdo().getDato();
            if (arbol.getDato()<=suma){
                lista.agregarFinal(arbol);
            }
        
        }

        if (arbol.tieneHijoIzquierdo()){
            procesadorArbolRecursivo(arbol.getHijoIzquierdo(), lista);
        }

        if (arbol.tieneHijoDerecho()){
            procesadorArbolRecursivo(arbol.getHijoDerecho(), lista);
        }


    }
}
