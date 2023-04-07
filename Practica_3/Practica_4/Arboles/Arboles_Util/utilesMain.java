package Practica_4.Arboles.Arboles_Util;

import ListaEnteros.ListaDeEnteros;
import ListaEnteros.ListaDeEnterosEnlazada;
import Practica_4.Arboles.ArbolBinario;

public class utilesMain {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(7);
        ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(1);
        hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
        ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(3);
        hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
        hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(1));
        arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
        arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

        utiles util = new utiles();

        System.out.println(util.sumaMaximaVertical(arbolBinarioB));

        System.out.println(util.sumaHorizontal(arbolBinarioB));

        ListaDeEnterosEnlazada listaInt = new ListaDeEnterosEnlazada();
        
        listaInt = util.trayectoriaPesada(arbolBinarioB);
        
        System.out.println(listaInt.toString());
        
        
    }
    
}
