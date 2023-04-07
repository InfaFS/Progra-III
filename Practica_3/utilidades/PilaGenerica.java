package utilidades;
import ListaGenerica.ListaGenericaEnlazada;

public class PilaGenerica<T> {
	
	ListaGenericaEnlazada<T> Datos;
	
	public PilaGenerica(){
		this.Datos = new ListaGenericaEnlazada<T>();
		
	}
	

	public void apilar( T elem) {	
		this.Datos.agregarFinal(elem);
	}

	public T desapilar() {
		int posicion=this.Datos.tamanio()-1;
		T valorDesapilado = this.Datos.elemento(this.Datos.tamanio()-1);
		
		this.Datos.eliminarEn(posicion);
		
		return valorDesapilado;
	}

	public T tope() {
		return this.Datos.elemento((this.Datos.tamanio())-1);
		
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
