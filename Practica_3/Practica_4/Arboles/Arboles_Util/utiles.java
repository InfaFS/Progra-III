package Practica_4.Arboles.Arboles_Util;

import ListaGenerica.ListaGenericaEnlazada;
import Practica_4.Arboles.*;
import utilidades.ColaGenerica;

import java.util.Scanner;

import ListaEnteros.ListaDeEnteros;
import ListaEnteros.ListaDeEnterosEnlazada;

public class utiles {

    public int sumaMaximaVertical  ( ArbolBinario<Integer> arbolParam){
		return sumaMaximaVerticalRecursivo(arbolParam,0);
    }

	public int sumaMaximaVerticalRecursivo( ArbolBinario<Integer> nodo, int suma){
		if (nodo == null) {
            return suma;
        }
        
        int nuevaSuma = suma + (int)nodo.getDato();
        
        if (nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null) {
            return nuevaSuma;
        }
        
        int sumaIzquierdo = sumaMaximaVerticalRecursivo(nodo.getHijoIzquierdo(), nuevaSuma);
        int sumaDerecho = sumaMaximaVerticalRecursivo(nodo.getHijoDerecho(), nuevaSuma);
        
        return Math.max(sumaIzquierdo, sumaDerecho);

	}
	
    
	public int sumaHorizontal (ArbolBinario<Integer> arbolParam){
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();

		int sumaTotal=-1;
		int sumaActual=0;
		int nivel=0;

		ArbolBinario<Integer> arbol = null;
		cola.encolar(arbolParam);
		cola.encolar(null);
		while (!cola.esVacia()){
			arbol= cola.desencolar();
			if (arbol!=null){
			sumaActual+=arbol.getDato();
			if (arbol.tieneHijoIzquierdo()){
				cola.encolar(arbol.getHijoIzquierdo());
			}
			if (arbol.tieneHijoDerecho()){
				cola.encolar(arbol.getHijoDerecho());
			}
			} else if (arbol==null){
			if (sumaActual>sumaTotal){
				sumaTotal=sumaActual;
			}
			System.out.println("La suma de los valores del nivel: "+ nivel + " es :"+ sumaActual);

			nivel++;
			sumaActual=0;	
			if (!cola.esVacia()){
				cola.encolar(null);
			}
		}
			


		}

		return sumaTotal;


	}

	
	public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario) { //creditos a @Ricrubrom
		ListaGenericaEnlazada<String> izq= new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<String> der= new ListaGenericaEnlazada<String>();
		if (abinario.esHoja()) {
		  ListaGenericaEnlazada<String> res = new ListaGenericaEnlazada<String>();
		  res.agregarInicio(abinario.getDato());
		  return res;
		}
		if (abinario.tieneHijoIzquierdo()) {
		  izq = secuenciaConMasPreguntas(abinario.getHijoIzquierdo());
		}
		if (abinario.tieneHijoDerecho()) {
		  der = secuenciaConMasPreguntas(abinario.getHijoDerecho());
		}
		if (izq.tamanio() >= der.tamanio()) {
		  izq.agregarInicio("Si");
		  izq.agregarInicio(abinario.getDato());
		  return izq;
		} else {
		  der.agregarInicio("No");
		  der.agregarInicio(abinario.getDato());
		  return der;
		}
	  }
	
	
		//creditos a @Ricrubrom
	  public  ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntas2(ArbolBinario<String> abinario) {
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> izq = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> der = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> res = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		if (abinario.esHoja()) {
		  ListaGenericaEnlazada<String> res1 = new ListaGenericaEnlazada<String>();
		  res1.agregarInicio(abinario.getDato());
		  res.agregarInicio(res1);
		  return res;
		}
		if (abinario.tieneHijoIzquierdo()) {
		  izq = secuenciaConMasPreguntas2(abinario.getHijoIzquierdo());
		}
		if (abinario.tieneHijoDerecho()) {
		  der = secuenciaConMasPreguntas2(abinario.getHijoDerecho());
		}
		izq.comenzar();
		der.comenzar();
		if ((izq.elemento(0)!=null && der.elemento(0)!=null) && (izq.elemento(0).tamanio() > der.elemento(0).tamanio())) {
		  int i = 0;
		  while (izq.elemento(i)!=null) {
			izq.elemento(i).agregarInicio("Si");
			izq.elemento(i).agregarInicio(abinario.getDato());
			i++;
		  }
		  return izq;
		} else if ((izq.elemento(0)!=null && der.elemento(0)!=null) && (izq.elemento(0).tamanio() < der.elemento(0).tamanio())){
			int i = 0;
			while (der.elemento(i)!=null) {
			  der.elemento(i).agregarInicio("Si");
			  der.elemento(i).agregarInicio(abinario.getDato());
			  i++;
			}
			return der;
		  } else {
			int i = 0;
			while (izq.elemento(i) != null) {
			  izq.elemento(i).agregarInicio("Si");
			  izq.elemento(i).agregarInicio(abinario.getDato());
			  res.agregarFinal(izq.elemento(i));
			  i++;
			}
			i = 0;
			while (der.elemento(i)!=null) {
			  der.elemento(i).agregarInicio("Si");
			  der.elemento(i).agregarInicio(abinario.getDato());
			  res.agregarFinal(der.elemento(i));
			  i++;
			}
		  return res;
		}
	  }
















	
	
	public ListaDeEnterosEnlazada trayectoriaPesada (ArbolBinario<Integer> ab ){
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();

		trayectoriaPesadaRecursiva(ab,l,0,0);
		return l;
	}
 

	public void trayectoriaPesadaRecursiva (ArbolBinario<Integer> ab, ListaDeEnterosEnlazada lista, int suma, int nivel ){

        int nuevaSuma = suma + (int)ab.getDato()*nivel;
		nivel++;
        
        if (ab.getHijoIzquierdo() == null && ab.getHijoDerecho() == null) {
			lista.agregarFinal(ab.getDato()); // le agrego en que hoja me encuentro!
			lista.agregarFinal(nuevaSuma);
			nuevaSuma=0;
			nivel=0;
        }
        
       if (ab.tieneHijoIzquierdo()){
		trayectoriaPesadaRecursiva(ab.getHijoIzquierdo(), lista, nuevaSuma, nivel);
	   }
	   if (ab.tieneHijoDerecho()){
		trayectoriaPesadaRecursiva(ab.getHijoDerecho(), lista, nuevaSuma, nivel);
	   }


	}

	}

