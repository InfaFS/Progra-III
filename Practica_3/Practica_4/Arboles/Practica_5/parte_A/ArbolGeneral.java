package Practica_4.Arboles.Practica_5.parte_A;

import ListaGenerica.ListaGenerica;
import ListaGenerica.ListaGenericaEnlazada;

import utilidades.ColaGenerica;
public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
	
		int niveles=0;

		if (this.esHoja()){
			return niveles;
		}

		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
 		ArbolGeneral<T> arbol_aux;
		cola.encolar(this);
 		while (!cola.esVacia()) {
		arbol_aux = cola.desencolar();
 		if (arbol_aux.tieneHijos()) {
 		ListaGenerica<ArbolGeneral<T>> hijos = arbol_aux.getHijos();
 		hijos.comenzar();
 			while (!hijos.fin()) {
				cola.encolar(hijos.proximo());
			 }
		niveles++;
	 	}

	 }

		return niveles;
	}

	public Integer nivel(T dato) {
		ArbolGeneral<T> elem;
		int niveles=0;
		
			if (this.dato.equals(dato)){
				return niveles;
			}
			if (!this.equals(dato) && this.esHoja()){
				return -1;
			}
	

		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
 		ArbolGeneral<T> arbol_aux;
		cola.encolar(this);
 		while (!cola.esVacia()) {
		arbol_aux = cola.desencolar();
 		if (arbol_aux.tieneHijos()) {
 		ListaGenerica<ArbolGeneral<T>> hijos = arbol_aux.getHijos();
 		hijos.comenzar();
		niveles++;
 			while (!hijos.fin()) {
				elem=hijos.proximo(); //guardo el elemento de hijos en elem ya que hijos apunta a lo que viene
				if (elem.dato.equals(dato)){
					return niveles;

				}
				cola.encolar(elem);
			 }
		
	 	}

	 }

		return -1;
	}

	public int ancho() {
		int niveles=0;
		int nivelesMax=0;
		int nodosMax=0;
		int nodos=0;

		if (this.esVacio()){
			return 0;
		}
		if (this.esHoja()){
			return 1;
		}

		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
 		ArbolGeneral<T> arbol_aux;
		cola.encolar(this);
 		while (!cola.esVacia()) {
		arbol_aux = cola.desencolar();
 		if (arbol_aux.tieneHijos()) {
		niveles++;
 		ListaGenerica<ArbolGeneral<T>> hijos = arbol_aux.getHijos();
 		hijos.comenzar();
 			while (!hijos.fin()) {
				cola.encolar(hijos.proximo());
				nodos++;
			 }
		
		if (nodos>nodosMax){
			nodosMax=nodos;
			nivelesMax=niveles;
		}

		nodos=0;
	 	}
		
		}
		System.out.println("Nivel con mas nodos "+nivelesMax);

		return nodosMax;

	}


	public boolean include(T entry){

		ArbolGeneral<T> elem;

		if (this.esVacio()){
			return false;
		}

		
		if (this.dato.equals(entry)){
				return true;
		}
	
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
 		ArbolGeneral<T> arbol_aux;
		cola.encolar(this);
 		while (!cola.esVacia()) {
		arbol_aux = cola.desencolar();
 		if (arbol_aux.tieneHijos()) {
 		ListaGenerica<ArbolGeneral<T>> hijos = arbol_aux.getHijos();
 		hijos.comenzar();
 			while (!hijos.fin()) {
				elem=hijos.proximo(); //guardo el elemento de hijos en elem ya que hijos apunta a lo que viene
				if (elem.dato.equals(entry)){
					return true;

				}
				cola.encolar(elem);
			 }
		
	 	}

	 }
		


		return false;
	}
}