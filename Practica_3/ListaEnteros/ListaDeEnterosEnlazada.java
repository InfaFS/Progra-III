package ListaEnteros;

public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	/* primer nodo de la lista, si la lista esta vacia, inicio es null */
	private NodoEntero inicio;

	/*
	 * nodo actual que se va actualizando a medida que recorremos la lista, si
	 * la lista esta vacia, actual es null
	 */
	private NodoEntero actual;

	/* ultimo nodo de la lista, si la lista esta vacia, fin es null */
	private NodoEntero fin;

	/* cantidad de nodos en la lista */
	private int tamanio;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public Integer proximo() {
		Integer elem = this.actual.getDato();
		this.actual = this.actual.getSiguiente();
		return elem;
	}

	@Override
	public boolean fin() {
		return (this.actual == null);
	}

	@Override
	public Integer elemento(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // no es posicion valida
			return null;
		NodoEntero n = this.inicio;
		while (pos-- > 0)
			n = n.getSiguiente();
		return n.getDato();
	}

	@Override
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 0 || pos > this.tamanio()) // posicion no valida
			return false;
		this.tamanio++;
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (pos == 0) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
		} else {
			NodoEntero n = this.inicio;
			NodoEntero ant = null;
			int posActual = 0;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);

			if (aux.getSiguiente() == null)
				this.fin = aux;
		}
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);

		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			aux.setSiguiente(this.inicio);
			this.inicio = aux;
		}
		this.tamanio++;
		return true;
	}

	@Override
	public boolean agregarFinal(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}

	@Override
	public boolean eliminar(Integer elem) {
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while ((n != null) && (!n.getDato().equals(elem))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				this.inicio = this.inicio.getSiguiente();
			else
				ant.setSiguiente(n.getSiguiente());
			this.tamanio--;

			return true;
		}
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // posicion no valida
			return false;
		this.tamanio--;
		if (pos == 0) {
			this.inicio = this.inicio.getSiguiente();
			return true;
		}
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while (!(n == null) && (pos > 0)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		if (ant.getSiguiente() == null)
			this.fin = ant;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
		NodoEntero n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		NodoEntero n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}

	@Override
	public boolean esVacia() {
		return this.tamanio() == 0;
	}
	
	
	
	
	
	public ListaDeEnterosEnlazada ordenar() {
		ListaDeEnterosEnlazada copia = new ListaDeEnterosEnlazada();
		this.comenzar();
		while (!this.fin()) {
			copia.agregarFinal(this.proximo());
		}
		
		ListaDeEnterosEnlazada retornable= new ListaDeEnterosEnlazada();
		int syze=this.tamanio;
		int min;
		int valor;
		while (syze!=0) {
			copia.comenzar();
			min=9999;
			while (!copia.fin()){
				valor=copia.proximo();
				if (valor<min) {
					min=valor;
					
				}
				
			}
			copia.eliminar(min);
			retornable.agregarFinal(min);
			syze--;
		}
		return retornable;
		
	}
	
	public ListaDeEnterosEnlazada combinarOrdenado(ListaDeEnterosEnlazada listaParam) {
		
		ListaDeEnterosEnlazada nuevaLista = new ListaDeEnterosEnlazada();
		int valorInterna=0;
		int valorParam=0;
		this.comenzar();
		listaParam.comenzar();
		
		while (!this.fin() && !listaParam.fin()) {
		
			valorInterna=this.actual.getDato();
			valorParam=listaParam.actual.getDato();
			
			if (valorInterna<valorParam) {
				nuevaLista.agregarFinal(valorInterna);
				this.proximo();
					
				}
				
			else if (valorInterna>valorParam) {
				nuevaLista.agregarFinal(valorParam);
				listaParam.proximo();
			}
				
		
		}
		
		while (!this.fin()) {
			nuevaLista.agregarFinal(this.proximo());
		}
		
		while (!listaParam.fin()) {
			nuevaLista.agregarFinal(listaParam.proximo());
		}

		
		

		
		return nuevaLista;
		
	}
	

	    public ListaDeEnterosEnlazada mergeSort(ListaDeEnterosEnlazada lista) {
	        if (lista.tamanio() <= 1) {
	            return lista;
	        }

	        ListaDeEnterosEnlazada listaIzquierda = new ListaDeEnterosEnlazada();
	        ListaDeEnterosEnlazada listaDerecha = new ListaDeEnterosEnlazada();
	        int medio = lista.tamanio() / 2;

	        for (int i = 0; i < medio; i++) {
	            listaIzquierda.agregarFinal(lista.elemento(i));
	        }

	        for (int i = medio; i < lista.tamanio(); i++) {
	            listaDerecha.agregarFinal(lista.elemento(i));
	        }

	        listaIzquierda = mergeSort(listaIzquierda);
	        listaDerecha = mergeSort(listaDerecha);

	        return merge(listaIzquierda, listaDerecha);
	    }

	    private ListaDeEnterosEnlazada merge(ListaDeEnterosEnlazada listaIzquierda, ListaDeEnterosEnlazada listaDerecha) {
	        ListaDeEnterosEnlazada listaOrdenada = new ListaDeEnterosEnlazada();

	        while (!listaIzquierda.esVacia() && !listaDerecha.esVacia()) {
	            if (listaIzquierda.elemento(0) < listaDerecha.elemento(0)) {
	                listaOrdenada.agregarFinal(listaIzquierda.elemento(0));
	                listaIzquierda.eliminarEn(0);
	            } else {
	                listaOrdenada.agregarFinal(listaDerecha.elemento(0));
	                listaDerecha.eliminarEn(0);
	            }
	        }

	        while (!listaIzquierda.esVacia()) {
	            listaOrdenada.agregarFinal(listaIzquierda.elemento(0));
	            listaIzquierda.eliminarEn(0);
	        }

	        while (!listaDerecha.esVacia()) {
	            listaOrdenada.agregarFinal(listaDerecha.elemento(0));
	            listaDerecha.eliminarEn(0);
	        }

	        return listaOrdenada;
	    }
	
	
	


	
}
