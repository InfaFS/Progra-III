package Practica_4.Arboles.Practica_5.parte_A;

public class mainArbolesGenerales {

    public static void main(String[] args) {
        
        ArbolGeneral<Integer> arbolito =new ArbolGeneral<Integer>(1);
        ArbolGeneral<Integer> arbolito2 =new ArbolGeneral<Integer>(5);
        ArbolGeneral<Integer> arbolito3 =new ArbolGeneral<Integer>(2);
        ArbolGeneral<Integer> arbolito4 =new ArbolGeneral<Integer>(7);
        ArbolGeneral<Integer> arbolito6 =new ArbolGeneral<Integer>(2);
        ArbolGeneral<Integer> arbolito5 =new ArbolGeneral<Integer>(7);
        ArbolGeneral<Integer> arbolito7 =new ArbolGeneral<Integer>(2);
        ArbolGeneral<Integer> arbolito8 =new ArbolGeneral<Integer>(7);
        ArbolGeneral<Integer> arbolito9 =new ArbolGeneral<Integer>(7);

        arbolito.agregarHijo(arbolito2);
        arbolito.agregarHijo(arbolito3);
        arbolito2.agregarHijo(arbolito4);
        arbolito2.agregarHijo(arbolito6);
        arbolito2.agregarHijo(arbolito5);
        arbolito2.agregarHijo(arbolito7);
        arbolito2.agregarHijo(arbolito8);
        arbolito3.agregarHijo(arbolito9);
        
        
        System.out.println("Altura "+ arbolito.altura());
        
        if (arbolito.include(2)){
            System.out.println("Incluye el valor seleccionado.");
        }
        else{
            System.out.println("No lo incluye :( ");
        }

        System.out.println("El elemento ingresado se encuentra en el nivel: "+ arbolito.nivel(1));

        System.out.println("El nivel con mas nodos tiene "+ arbolito.ancho()+ " nodos");

    }
    
}
