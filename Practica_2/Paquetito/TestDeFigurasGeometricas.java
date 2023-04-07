package Paquetito;
import java.util.*;
public class TestDeFigurasGeometricas {
    public static void main(String[] args) {
        Figura[] figuras = new Figura[3];

        figuras [0]= new Circulo(1,"Rojo", true);
        figuras [1]= new Rectangulo(4,2,"Azul",false);
        figuras[2]= new Cuadrado(2,2," Naranja ", true);


        for (Figura figura : figuras){ //para iterar arreglos con el foreach se se pone Nombre_Clase variable_iteradora : nombre_vector
            System.out.println(Arrays.toString(figuras));

        }


    }
}
