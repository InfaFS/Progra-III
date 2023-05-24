package Practica_4.Arboles;



import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;


public class ArbolesMain3_lista_listas {

    
    
    public static void main(String[] args) {
        ArbolBinario<Character> arbol = new ArbolBinario<Character>('A');
        ArbolBinario<Character> arbol1 = new ArbolBinario<Character>('B');
        ArbolBinario<Character> arbol2 = new ArbolBinario<Character>('C');
        ArbolBinario<Character> arbol3 = new ArbolBinario<Character>('F');
        ArbolBinario<Character> arbol4 = new ArbolBinario<Character>('G');
        ArbolBinario<Character> arbol5 = new ArbolBinario<Character>('D');
        ArbolBinario<Character> arbol6 = new ArbolBinario<Character>('H');
        ArbolBinario<Character> arbol7 = new ArbolBinario<Character>('E');

        arbol.agregarHijoIzquierdo(arbol1);
        arbol.agregarHijoDerecho(arbol2);
        arbol1.agregarHijoIzquierdo(arbol3);
        arbol1.agregarHijoDerecho(arbol4);
        arbol4.agregarHijoIzquierdo(arbol6);
        arbol2.agregarHijoIzquierdo(arbol5);
        arbol5.agregarHijoDerecho(arbol7);

        ListaGenerica<ListaGenerica<Character>> l = new ListaGenericaEnlazada<ListaGenerica<Character>>() ;
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

    public static ListaGenerica<ListaGenerica<Character>> caminoMaslargo (ArbolBinario<Character> arbol){
        ListaGenerica<ListaGenerica<Character>> lista_de_listas = new ListaGenericaEnlazada<ListaGenerica<Character>>() ;
        ListaGenerica<Character> caminoActual = new ListaGenericaEnlazada<Character>();
        ListaGenerica<Character> caminoMax = new ListaGenericaEnlazada<Character>();
    
        if (arbol !=null && !arbol.esVacio()){
            caminoActual.agregarFinal(arbol.getDato());
            caminoMasLargoRec(caminoActual, caminoMax, arbol, lista_de_listas);
        }
        System.out.println(lista_de_listas.tamanio());
        return lista_de_listas;
    
            
    }
    
    private static void caminoMasLargoRec(ListaGenerica<Character> caminoActual, ListaGenerica<Character> caminoMax, ArbolBinario<Character> arbol, ListaGenerica<ListaGenerica<Character>> lista_de_listas){
        char Aux= arbol.getDato();
        if (arbol.esHoja()){
          
            if (caminoActual.tamanio()>caminoMax.tamanio()){
              
                copiarLista(caminoActual,caminoMax);
                lista_de_listas.comenzar();
               while (!lista_de_listas.esVacia()){
                    lista_de_listas.eliminarEn(lista_de_listas.tamanio()-1);
               }
               lista_de_listas.agregarFinal(caminoMax);
            
            }
            else if (caminoActual.tamanio()== caminoMax.tamanio()){
                copiarLista(caminoActual, caminoMax);
                lista_de_listas.agregarFinal(caminoMax);
            }
        }
        else{
            if (arbol.tieneHijoIzquierdo()){
                caminoActual.agregarFinal(arbol.getHijoIzquierdo().getDato());
                caminoMasLargoRec(caminoActual, caminoMax, arbol.getHijoIzquierdo(),lista_de_listas);
                caminoActual.eliminarEn(caminoActual.tamanio()-1);
    
            }
            if (arbol.tieneHijoDerecho()){
                caminoActual.agregarFinal(arbol.getHijoDerecho().getDato());
                caminoMasLargoRec(caminoActual, caminoMax, arbol.getHijoDerecho(),lista_de_listas);
                caminoActual.eliminarEn(caminoActual.tamanio()-1);
    
            }
        }
    
    
    
    }
}










