package Practica_4.Arboles;

import ListaGenerica.*;
import utilidades.ColaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() { //chequear si esta bien
		
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		ArbolBinario<T> arbol = null;
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()){
			arbol= cola.desencolar();
			if (arbol!=null){
			if ((!arbol.esHoja()) && ((!arbol.tieneHijoDerecho()) || (!arbol.tieneHijoIzquierdo()))  ){
				return false;
			}
			if (arbol.tieneHijoIzquierdo()){
				cola.encolar(arbol.getHijoIzquierdo());
			}
			if (arbol.tieneHijoDerecho()){
				cola.encolar(arbol.getHijoDerecho());
			}
			} else if (!cola.esVacia()){
				cola.encolar(null);
			}

		}
		
		return true;
	}

	 boolean esCompleto() {
		return true;
	}

	
	// imprime el arbol en preorden  
	public void printPreorden() {
		
        System.out.println(this.getDato());
        
        if (this.tieneHijoIzquierdo()){
            this.getHijoIzquierdo().printPreorden();

        }
       
        if (this.tieneHijoDerecho()){
            this.getHijoDerecho().printPreorden();

        }

	}

	// imprime el arbol en En orden
	public void printInorden() {
		if (this.tieneHijoIzquierdo()){
            this.getHijoIzquierdo().printInorden();

        }
        System.out.println(this.getDato());
        if (this.tieneHijoDerecho()){
            this.getHijoDerecho().printInorden();

        }

	}
	
	// imprime el arbol en postorden
	public void printPostorden() {
		if (this.tieneHijoIzquierdo()){
            this.getHijoIzquierdo().printPostorden();

        }
        if (this.tieneHijoDerecho()){
            this.getHijoDerecho().printPostorden();

        }
        System.out.println(this.getDato());

	}


	public void recorridoPorNiveles() {
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		ArbolBinario<T> arbol = null;
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()){
			arbol= cola.desencolar();
			if (arbol!=null){
			System.out.println(arbol.getDato());
			if (arbol.tieneHijoIzquierdo()){
				cola.encolar(arbol.getHijoIzquierdo());
			}
			if (arbol.tieneHijoDerecho()){
				cola.encolar(arbol.getHijoDerecho());
			}
			} else if (!cola.esVacia()){
				cola.encolar(null);
			}

		}
	}

	

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
		fronteraRecursivo(l);
		return l;
	}

	public ListaGenerica<T> fronteraRecursivo(ListaGenerica<T> lista) {
		
		if (this.esHoja()){
			lista.agregarFinal(this.getDato());
		}

		if (this.tieneHijoIzquierdo()){
            this.getHijoIzquierdo().fronteraRecursivo(lista);

        }
        if (this.tieneHijoDerecho()){
            this.getHijoDerecho().fronteraRecursivo(lista);

        }

		return lista;
	}
	


	// estaria bien , pero estimo que la otra forma seria la de anajo. private static int contador = 0; 

	public int contadorHojas(){
		int contador=0;
		contador = contarHojasRecursivo();
		return contador;

	}
	
	public int contarHojasRecursivo() {
		
		int contador=0;
		if (this.tieneHijoIzquierdo()){
            
			contador=this.hijoIzquierdo.contarHojasRecursivo();

        }
		
		if (this.esHoja()){
			return 1;
		}

        if (this.tieneHijoDerecho()){
            contador+=this.hijoDerecho.contarHojasRecursivo();

        }
		
        return contador;
	}

	//prueba del teorico ej4
	public void traverse(ArbolBinario<T> a){

		if (!a.esVacio()){
			System.out.println(a.getDato());
			if (a.tieneHijoIzquierdo()){
				traverse(a.getHijoIzquierdo());
			}

			if (a.tieneHijoDerecho()){
				traverse(a.getHijoDerecho());

			}

			System.out.println(a.getDato());
		}

	}


}
