package ListaGenerica;

public class testeoListaGenerica {

	public static void main(String[] args) {
		
		ListaGenericaEnlazada<Integer> lista = new 	ListaGenericaEnlazada<Integer>();
		
		lista.agregarFinal(1);
		lista.agregarFinal(2);
		lista.agregarFinal(3);
		lista.agregarFinal(4);
		lista.agregarFinal(5);
		
		imprimirT(lista);
		
		ListaGenericaEnlazada<Integer> listaReves = lista.invertir();
		
		System.out.println("\n");
		
		imprimirT(listaReves);
	}
	
	public static void imprimirT(ListaGenericaEnlazada<Integer> lista) {
		
		lista.comenzar();
		
		while(!lista.fin()) {
			
				System.out.println(lista.proximo());
		}	
		
		
	}

}
