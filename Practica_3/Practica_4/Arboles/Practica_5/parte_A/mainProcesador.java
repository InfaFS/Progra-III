package Practica_4.Arboles.Practica_5.parte_A;

import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;
import Practica_4.Arboles.ArbolBinario;

public class mainProcesador {
    public static void main(String[] args){

		ArbolBinario<Integer> arbolBinarioA=new ArbolBinario<Integer>(1);		
		ArbolBinario<Integer> hijoIzquierdo=new ArbolBinario<Integer>(2);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(4));		
		ArbolBinario<Integer> hijoDerecho=new ArbolBinario<Integer>(5);
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(7));
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);

		Procesador p= new Procesador(arbolBinarioA);
		ListaGenerica <ArbolBinario<Integer>> lista = new ListaGenericaEnlazada<ArbolBinario<Integer>>();
		lista = p.procesarArbol();
		System.out.println(lista.toString());

    }
}