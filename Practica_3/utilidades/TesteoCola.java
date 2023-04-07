package utilidades;

public class TesteoCola {

	public static void main(String[] args) {
		
		ColaGenerica <Integer> cola = new ColaGenerica<Integer>();
		
		cola.encolar(2);
		cola.encolar(5);
		cola.encolar(8);
		cola.encolar(1);
		
		System.out.println(cola.tope());
		
		cola.desencolar();
		cola.desencolar();

		
		System.out.println(cola.tope());
		
		System.out.println(cola.esVacia());

			
		cola.desencolar();
		cola.desencolar();

		System.out.println(cola.tope());
		System.out.println(cola.esVacia());
		
	}

}
