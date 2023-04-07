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

	public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario){
		String raiz= new String();
		String padre= new String();
		String hijo= new String();
		ListaGenericaEnlazada<String> lista_max = new ListaGenericaEnlazada<String>();
		// l=abinario.frontera();//tengo lista de las hojas
		// lista_max.agregarInicio(l.elemento(0));//tengo una hoja
		//no busco con frontera ni de otra forma porque solo me sirven las hojas del ultimo nivel, recorrido por niveles
		raiz=abinario.getDato();
		lista_max.agregarInicio(buscarHojaLejana(abinario));//agrego hoja
		hijo=null;

		while(hijo!=raiz){//voy agregando elementos a la lista hasta que llegue a la raiz
			hijo=lista_max.elemento(0);
			padre=buscarPadre(abinario, hijo);
			lista_max.agregarInicio(padre);
		}
		

		lista_max.comenzar();
		while (!lista_max.fin()){
			System.out.println(lista_max.proximo());
		}

		return lista_max;
		


	}

	public String buscarHojaLejana(ArbolBinario<String> abinario){
		String respuesta = new String();

		ArbolBinario<String> nodo_act=null;//no olvidar de inicializarlo
		ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();

		cola.encolar(abinario);//encol raiz
		cola.encolar(null);//paso de nivel

		while(cola.esVacia()==false){
			nodo_act=cola.desencolar();
			if(nodo_act!=null){
				if(nodo_act.tieneHijoIzquierdo())
					cola.encolar(nodo_act.getHijoIzquierdo());
				if(nodo_act.tieneHijoDerecho())
					cola.encolar(nodo_act.getHijoDerecho());
				respuesta=nodo_act.getDato();//voy cargando el elmento del nivel en el que estoy, el último cargado es del ultimo nivel
			}
			else{
				if (cola.esVacia()==false)
					cola.encolar(null);//para el salto del inea
			}
		}
		return respuesta;
	}

	public String buscarHoja(ArbolBinario<String> abinario){
		String respuesta = new String();
		if(abinario.esHoja()){
			return abinario.getDato();
		}
			
		else if(abinario.getDato()!=null){
			if (abinario.getHijoIzquierdo()!=null)
				respuesta= buscarHoja(abinario.getHijoIzquierdo());
			if (abinario.getHijoDerecho()!=null)
				respuesta= buscarHoja(abinario.getHijoDerecho());
			
		}
		return respuesta;
	}

	public String buscarPadre(ArbolBinario<String> abinario, String hijo){//como buscar hoja, pero comparo a que sea distinto de un string en vez de un null
		String respuesta = new String();

		if((abinario!=null)&&(abinario.esHoja()==false))//chequeo si le puedo preguntar si es padre
			if( ((abinario.getHijoIzquierdo()!=null)&&(abinario.getHijoIzquierdo().getDato() == hijo)) || ((abinario.getHijoDerecho()!=null)&&(abinario.getHijoDerecho().getDato()== hijo)) )//if es padre
				return abinario.getDato();//si es el padre lo devuelvo
		
		else if(abinario.getDato()!=null){//sinó sigo buscando, asegurandome de no llegar a null
			if (abinario.getHijoIzquierdo()!=null)
				respuesta= buscarPadre(abinario.getHijoIzquierdo(), hijo);
			if (abinario.getHijoDerecho()!=null)
				respuesta= buscarPadre(abinario.getHijoDerecho(), hijo);
			
		}
		return respuesta;
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

