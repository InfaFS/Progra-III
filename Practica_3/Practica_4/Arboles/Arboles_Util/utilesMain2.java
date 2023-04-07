package Practica_4.Arboles.Arboles_Util;

import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;
import Practica_4.Arboles.ArbolBinario;

public class utilesMain2 {
    public static void main(String[] args) {
        ArbolBinario<String> arbolBinarioB=new ArbolBinario<String>("Tiene 4 patas?");
        ArbolBinario<String> hijoIzquierdoB=new ArbolBinario<String>("Se mueve?");
        hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<String>("Es un perro"));
        ArbolBinario<String> hijoDerechoB=new ArbolBinario<String>("Tiene alguna pata?");
        arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
        arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

        utiles util = new utiles();

        ListaGenericaEnlazada<String> l = util.secuenciaConMasPreguntas(arbolBinarioB);

        
    }
    
}
