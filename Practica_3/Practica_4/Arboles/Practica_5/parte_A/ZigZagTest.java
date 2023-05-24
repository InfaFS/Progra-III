package Practica_4.Arboles.Practica_5.parte_A;

import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;
import Practica_4.Arboles.ArbolBinario;

public class ZigZagTest {

    public static void main(String[] args) {
        
        ArbolBinario<Character> esquema = new ArbolBinario<Character>(' ');
        ArbolBinario<Character> arbol1 = new ArbolBinario<Character>(' ');
        ArbolBinario<Character> arbol2 = new ArbolBinario<Character>(' ');
        ArbolBinario<Character> arbol3 = new ArbolBinario<Character>(' ');
        ArbolBinario<Character> arbol4 = new ArbolBinario<Character>(' ');
        ArbolBinario<Character> arbol5 = new ArbolBinario<Character>(' ');
        ArbolBinario<Character> arbol6 = new ArbolBinario<Character>('C');
        ArbolBinario<Character> arbol7 = new ArbolBinario<Character>('S');
        ArbolBinario<Character> arbol8 = new ArbolBinario<Character>(' ');
        ArbolBinario<Character> arbol9 = new ArbolBinario<Character>('E');
        ArbolBinario<Character> arbol10 = new ArbolBinario<Character>('D');
        ArbolBinario<Character> arbol11 = new ArbolBinario<Character>(' ');
        ArbolBinario<Character> arbol12 = new ArbolBinario<Character>(' ');
        ArbolBinario<Character> arbol13 = new ArbolBinario<Character>('R');
        ArbolBinario<Character> arbol14 = new ArbolBinario<Character>('O');
        ArbolBinario<Character> arbol15 = new ArbolBinario<Character>('A');
        ArbolBinario<Character> arbol16 = new ArbolBinario<Character>('G');


        esquema.agregarHijoIzquierdo(arbol1);
        esquema.agregarHijoDerecho(arbol2);
        arbol1.agregarHijoIzquierdo(arbol3);
        arbol3.agregarHijoIzquierdo(arbol6);
        arbol3.agregarHijoDerecho(arbol7);
        arbol2.agregarHijoIzquierdo(arbol4);
        arbol2.agregarHijoDerecho(arbol5);
        arbol4.agregarHijoIzquierdo(arbol8);
        arbol4.agregarHijoDerecho(arbol9);
        arbol8.agregarHijoIzquierdo(arbol12);
        arbol8.agregarHijoDerecho(arbol13);
        arbol12.agregarHijoIzquierdo(arbol15);
        arbol12.agregarHijoDerecho(arbol16);
        arbol5.agregarHijoIzquierdo(arbol10);
        arbol5.agregarHijoDerecho(arbol11);
        arbol11.agregarHijoDerecho(arbol14);

      CodigoZigZag decifrar = new CodigoZigZag();
        String uno = "101";
        String dos = "001";
        String tres = "10001";
        String cuatro = "1111";
        String cinco = "1001";
        String seis = "110";
        String siete = "1111";        

        ListaGenerica<String> MENSAJE = new ListaGenericaEnlazada<String>();
        MENSAJE.agregarFinal(uno);
        MENSAJE.agregarFinal(dos);
        MENSAJE.agregarFinal(tres);
        MENSAJE.agregarFinal(cuatro);
        MENSAJE.agregarFinal(cinco);
        MENSAJE.agregarFinal(seis);
        MENSAJE.agregarFinal(siete);
        
       ListaGenerica<Character> decifrado= new ListaGenericaEnlazada<Character>();
       decifrado=decifrar.descifrarCodigo(esquema, MENSAJE);
      
       System.out.println(decifrar.toString());
        
    }
    
}
