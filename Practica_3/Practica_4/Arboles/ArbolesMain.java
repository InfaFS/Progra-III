package Practica_4.Arboles;


import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;


public class ArbolesMain {

    
    
    public static void main(String[] args) {
        ArbolBinario<Character> arbol = new ArbolBinario<Character>('A');
        ArbolBinario<Character> hijo1 = new ArbolBinario<Character>('B');
        ArbolBinario<Character> hijo2 = new ArbolBinario<Character>('C');
        ArbolBinario<Character> hijo1_1 = new ArbolBinario<Character>('D');
        ArbolBinario<Character> hijo1_1_2 = new ArbolBinario<Character>('E');
        ArbolBinario<Character> hijo2_1 = new ArbolBinario<Character>('F');

        arbol.agregarHijoIzquierdo(hijo1);
        arbol.agregarHijoDerecho(hijo2);
        hijo1.agregarHijoIzquierdo(hijo1_1);
        hijo1_1.agregarHijoDerecho(hijo1_1_2);
        hijo2.agregarHijoDerecho(hijo2_1);

        ListaGenerica<Character> l = new ListaGenericaEnlazada<Character>() ;
        l=caminoMaslargo(arbol);
        System.out.println(l.toString());
    
    }
    private static void copiarLista(ListaGenerica<Character> CaminoActual, ListaGenerica<Character> caminoMax){
        while (!caminoMax.esVacia()){
            caminoMax.eliminarEn(caminoMax.tamanio()-1);
        }
    
        caminoMax.comenzar();

        while (!CaminoActual.fin()){
            caminoMax.agregarFinal(CaminoActual.proximo());
        }
    }

    public static ListaGenerica<Character> caminoMaslargo (ArbolBinario<Character> arbol){
        ListaGenerica<Character> caminoActual = new ListaGenericaEnlazada<Character>();
        ListaGenerica<Character> caminoMax = new ListaGenericaEnlazada<Character>();
        if (arbol !=null && !arbol.esVacio()){
            caminoActual.agregarFinal(arbol.getDato());
            caminoMasLargoRec(caminoActual, caminoMax, arbol);
        }
        return caminoMax;
    
            
    }
    
    private static void caminoMasLargoRec(ListaGenerica<Character> caminoActual, ListaGenerica<Character> caminoMax, ArbolBinario<Character> arbol){
    
        if (arbol.esHoja()){
            if (caminoActual.tamanio()>caminoMax.tamanio())
                copiarLista(caminoActual,caminoMax);
        }
        else{
            if (arbol.tieneHijoIzquierdo()){
                caminoActual.agregarFinal(arbol.getHijoIzquierdo().getDato());
                caminoMasLargoRec(caminoActual, caminoMax, arbol.getHijoIzquierdo());
                caminoActual.eliminarEn(caminoActual.tamanio()-1);
    
            }
            if (arbol.tieneHijoDerecho()){
                caminoActual.agregarFinal(arbol.getHijoDerecho().getDato());
                caminoMasLargoRec(caminoActual, caminoMax, arbol.getHijoDerecho());
                caminoActual.eliminarEn(caminoActual.tamanio()-1);
    
            }
        }
    
    
    
    }
}