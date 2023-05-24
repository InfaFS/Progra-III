package Practica_4.Arboles;
import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;

public class ArbolesMain2 {
    public static void main(String[] args) {
        
        ArbolBinario<Character> arbolito = new ArbolBinario<Character>('C');
        ArbolBinario<Character> arbolitoHIJOIZQ = new ArbolBinario<Character>('A');
        ArbolBinario<Character> arbolitoHIJOIZQHIJODER = new ArbolBinario<Character>('B');
        ArbolBinario<Character> arbolitoHIJODER = new ArbolBinario<Character>('E');
        ArbolBinario<Character> arbolitHIJODERHIJOIZQ = new ArbolBinario<Character>('D');
        ArbolBinario<Character> arbolitoHIJODERHIJODER = new ArbolBinario<Character>('F');

        arbolito.agregarHijoIzquierdo(arbolitoHIJOIZQ);
        arbolito.agregarHijoDerecho(arbolitoHIJODER);
        arbolitoHIJOIZQ.agregarHijoDerecho(arbolitoHIJOIZQHIJODER);
        arbolitoHIJODER.agregarHijoIzquierdo(arbolitHIJODERHIJOIZQ);
        arbolitoHIJODER.agregarHijoDerecho(arbolitoHIJODERHIJODER);
        
        arbolito.traverse(arbolito);
    }
}
