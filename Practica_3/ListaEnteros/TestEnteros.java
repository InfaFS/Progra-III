package ListaEnteros;

public class TestEnteros {

	public static void main(String[] args) {
		
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada(); //si lo hago con lista generica tengo que ponerle <tipo_de_variable>
		
		lista.agregarFinal(2);
		
		lista.agregarFinal(99);
		
		lista.agregarFinal(4);
		
		lista.agregarFinal(33);
		
		lista.agregarFinal(22);
		
		lista.agregarFinal(5);
		
		lista=lista.mergeSort(lista);
		
		imprimir(lista);
		
		
	
	}
	
	public static void imprimir(ListaDeEnteros lista) {
		
		lista.comenzar();
		
		while(!lista.fin()) {
			
				System.out.println(lista.proximo());
		}	
		
		
	}
	
	public static void imprimirR(ListaDeEnteros lista) {
		lista.comenzar();
		imprimirRecursivo(lista);
	}
	
	public static void imprimirRecursivo(ListaDeEnteros lista) {
		if(!lista.fin()) {
			int aux=lista.proximo();
			imprimirRecursivo(lista);
			System.out.println(aux);
			
		}
		else {
			return;
		}
	}
}