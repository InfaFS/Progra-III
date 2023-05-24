package Practica_4.Arboles;

public class AB_ejparcial1 {

    public static void main(String[] args) {
        ArbolBinario<Character> arbol = new ArbolBinario<Character>('p');
        ArbolBinario<Character> arbol1 = new ArbolBinario<Character>('z');
        ArbolBinario<Character> arbol2 = new ArbolBinario<Character>('g');
        ArbolBinario<Character> arbol3 = new ArbolBinario<Character>('u');
        ArbolBinario<Character> arbol4 = new ArbolBinario<Character>('o');
        ArbolBinario<Character> arbol5 = new ArbolBinario<Character>('a');
        ArbolBinario<Character> arbol6 = new ArbolBinario<Character>('b');
        ArbolBinario<Character> arbol7 = new ArbolBinario<Character>('t');
        ArbolBinario<Character> arbol8 = new ArbolBinario<Character>('s');
        ArbolBinario<Character> arbol9 = new ArbolBinario<Character>('k');



        
        arbol.agregarHijoIzquierdo(arbol1);
        arbol.agregarHijoDerecho(arbol2);
        arbol1.agregarHijoIzquierdo(arbol3);
        arbol3.agregarHijoIzquierdo(arbol5);
        arbol3.agregarHijoDerecho(arbol6);
        arbol6.agregarHijoDerecho(arbol8);
        arbol2.agregarHijoIzquierdo(arbol4);
        arbol4.agregarHijoIzquierdo(arbol7);
        //arbol5.agregarHijoIzquierdo(arbol9);
        ProcesadorArbol procesadorArbol = new ProcesadorArbol(arbol);
        int K=0;
        System.out.println("la cantidad es "+procesadorArbol.procesar(K));
        K=2;
        System.out.println("La cantidad es "+procesadorArbol.procesar2(K));


    }
    
}
