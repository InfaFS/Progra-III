package Practica_4.Arboles.Practica_5.parte_A;

import java.util.ListResourceBundle;

import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;
import Practica_4.Arboles.ArbolBinario;

public class CodigoZigZag {

    public ListaGenerica<Character> descifrarCodigo(ArbolBinario<Character> arbol, ListaGenerica <String> listaDeSecuencias){
       String aux=" ";
       int i=0;
       int largoMSG=0;
       ListaGenerica<Character> listaBinaria = new ListaGenericaEnlazada<Character>();
        ListaGenerica<Character> decifrado = new ListaGenericaEnlazada<Character>() ;
            

        while (!listaDeSecuencias.fin()){
            aux =listaDeSecuencias.proximo();
            largoMSG=aux.length();
            for (i=0;i<largoMSG;i++){
                listaBinaria.agregarFinal(aux.charAt(i));
            }
            char devuelto= recorrerEstructura(arbol,listaBinaria);
            decifrado.agregarFinal(devuelto);
           while (!listaBinaria.esVacia()){
                listaBinaria.eliminarEn(listaBinaria.tamanio()-1);
           }
        }

        System.out.println(decifrado.toString());

        return decifrado;
    }

    public  char recorrerEstructura(ArbolBinario<Character> arbol, ListaGenerica<Character> listaBinaria){
        char dato=' ';


        if (arbol.esHoja()){
            return arbol.getDato();
        }
        
        char datoActual=listaBinaria.proximo();

        if (datoActual=='0'){
            if (arbol.tieneHijoIzquierdo()){
                dato=recorrerEstructura(arbol.getHijoIzquierdo(), listaBinaria);
            }

        }
        

        if (datoActual=='1'){
            if (arbol.tieneHijoDerecho()){
                dato=recorrerEstructura(arbol.getHijoDerecho(), listaBinaria);
            }

        }
        return dato;
    }
    
}
