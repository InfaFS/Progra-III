package utilidades;


public class TesteoPila {

	public static void main(String[] args) {
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		pila.apilar('a');
		pila.apilar('b');
		pila.apilar('c');
		pila.apilar('d');
		pila.apilar('e');
		
		System.out.println("El tope de la lista actual es "+pila.tope());
		
		System.out.println("Valor desapilado: "+ pila.desapilar());
		
		System.out.println("Valor desapilado: "+ pila.desapilar());
		
		System.out.println("Valor desapilado: "+ pila.desapilar());
		
		System.out.println("Valor desapilado: "+ pila.desapilar());
		
		System.out.println("El tope de la lista actual es "+pila.tope());
		

	}

}