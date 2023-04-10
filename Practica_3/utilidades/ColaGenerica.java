package utilidades;
import ListaGenerica.ListaGenericaEnlazada;



public class ColaGenerica <T> {

	public ListaGenericaEnlazada<T> Datos;
	
	public ColaGenerica() {
		 this.Datos = new 	ListaGenericaEnlazada<T>();
		
	}
	
	public void encolar(T elem) {
		
		this.Datos.agregarInicio(elem);
		
	}
	
	public T desencolar () {
		
			T elemDesencolado = this.Datos.elemento(this.Datos.tamanio()-1);
			this.Datos.eliminarEn(this.Datos.tamanio()-1);
			return elemDesencolado;
		
	}
	
	public T tope() {
		
		T top= this.Datos.elemento(this.Datos.tamanio()-1);
		
		return top;
	}
	
	public boolean esVacia() {
		
		if (this.Datos.esVacia()) {
			return true;
		}
		else {
			return false;
		}
		

	}

}
