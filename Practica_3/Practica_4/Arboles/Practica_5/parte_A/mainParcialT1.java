package Practica_4.Arboles.Practica_5.parte_A;

import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;
import Practica_4.Arboles.ArbolBinario;
import Practica_4.Arboles.Practica_5.parte_A.almacen;

public class mainParcialT1 {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol= new ArbolBinario<Integer>(10);
        ArbolBinario<Integer> arbol1= new ArbolBinario<Integer>(6);
        ArbolBinario<Integer> arbol2= new ArbolBinario<Integer>(2);
        ArbolBinario<Integer> arbol3= new ArbolBinario<Integer>(1);
        ArbolBinario<Integer> arbol4= new ArbolBinario<Integer>(9);
        ArbolBinario<Integer> arbol5= new ArbolBinario<Integer>(8);
        ArbolBinario<Integer> arbol6= new ArbolBinario<Integer>(3);
        ArbolBinario<Integer> arbol7= new ArbolBinario<Integer>(20);
        ArbolBinario<Integer> arbol8= new ArbolBinario<Integer>(11);
        ArbolBinario<Integer> arbol9= new ArbolBinario<Integer>(5);
        ArbolBinario<Integer> arbol10= new ArbolBinario<Integer>(2);
        ArbolBinario<Integer> arbol11= new ArbolBinario<Integer>(4);
        
        arbol.agregarHijoIzquierdo(arbol1);
        arbol.agregarHijoDerecho(arbol2);
        arbol1.agregarHijoIzquierdo(arbol3);
        arbol1.agregarHijoDerecho(arbol4);
        arbol3.agregarHijoDerecho(arbol7);
        arbol4.agregarHijoIzquierdo(arbol8);
        arbol4.agregarHijoDerecho(arbol9);

        arbol2.agregarHijoIzquierdo(arbol5);
        arbol5.agregarHijoIzquierdo(arbol10);
        arbol5.agregarHijoDerecho(arbol11);
        arbol2.agregarHijoDerecho(arbol6);

        almacen almacen = new almacen();
        ProcesadorArbolT1 procesador = new ProcesadorArbolT1(arbol);
        almacen=procesador.procesarArbol();

        System.out.println("Numeros pares = "+almacen.getValor());
        System.out.println(almacen.getLista().toString());
    }  

}
