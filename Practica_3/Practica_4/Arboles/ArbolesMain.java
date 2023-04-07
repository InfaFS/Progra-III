package Practica_4.Arboles;

import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;

public class ArbolesMain {
    public static void main(String[] args) {

        System.out.println("Comienza la carga del arbol...\n");
        
        ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(1);
        ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
        hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
        hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
        ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
        hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
        hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
        arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
        arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

        arbolBinarioB.printInorden();
    
        System.out.println(arbolBinarioB.contadorHojas());
        
        ListaGenerica<Integer> lista = new ListaGenericaEnlazada<Integer>();




        System.out.println("Lista...");
        lista= arbolBinarioB.frontera();

        while (!lista.fin()){
            System.out.println(lista.proximo());
        }


        System.out.println(arbolBinarioB.esLleno());
    


        System.out.println("Finalizada...\n");

    }
}
