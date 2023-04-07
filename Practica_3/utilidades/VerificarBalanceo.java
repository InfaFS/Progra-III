package utilidades;
import ListaGenerica.ListaGenericaEnlazada;
import ListaGenerica.ListaGenerica;
public class VerificarBalanceo {

	public static void main(String[] args) {
		 String cadena1 = "{( ) [ ( ) ] }";
	        String cadena2 = "( [ ) ]";
	        
	        System.out.println("La cadena \"" + cadena1 + "\" está balanceada? " + estaBalanceado(cadena1));
	        System.out.println("La cadena \"" + cadena2 + "\" está balanceada? " + estaBalanceado(cadena2));

	}
	
	public static boolean estaBalanceado(String cadena) {
	    ListaGenerica<Character> pila = new ListaGenericaEnlazada<Character>();
	    
	    for (int i = 0; i < cadena.length(); i++) {
	        char caracter = cadena.charAt(i);
	        
	        if (caracter == '(' || caracter == '[' || caracter == '{') {
	            pila.agregarFinal(caracter);
	        } else if (caracter == ')' || caracter == ']' || caracter == '}') {
	            if (pila.esVacia()) {
	                return false;
	            }
	            char tope = pila.elemento(pila.tamanio()-1);
	            if ((caracter == ')' && tope == '(') ||
	                (caracter == ']' && tope == '[') ||
	                (caracter == '}' && tope == '{')) {
	                pila.eliminarEn(pila.tamanio()-1);
	            } else {
	                return false;
	            }
	        }
	    }
	    
	    return pila.esVacia();
	}

}
