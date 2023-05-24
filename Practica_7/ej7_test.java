public class ej7_test {
    public static void main(String[] args) {
     Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
     Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
     Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
     Vertice<String> v4 = new VerticeImplListAdy<String>("London");
     Vertice<String> v5 = new VerticeImplListAdy<String>("New York");
     Vertice<String> v6 = new VerticeImplListAdy<String>("Madagascar");  
     Vertice<String> v7 = new VerticeImplListAdy<String>("Miameee"); 
     Vertice<String> v8 = new VerticeImplListAdy<String>("Guatemala"); 
     Vertice<String> adicional1 = new VerticeImplListAdy<String>("extra_1"); 
     Vertice<String> adicional2 = new VerticeImplListAdy<String>("extra_2"); 
     Vertice<String> adicional3 = new VerticeImplListAdy<String>("extra_3"); 
     Grafo<String> ciudades = new GrafoImplListAdy<String>();
     ciudades.agregarVertice(v1);
     ciudades.agregarVertice(v2);
     ciudades.agregarVertice(v3);
     ciudades.agregarVertice(v4);
     ciudades.agregarVertice(v5);
     ciudades.agregarVertice(v6);
     ciudades.agregarVertice(v7); 
     ciudades.agregarVertice(v8);
     ciudades.agregarVertice(adicional1);
     ciudades.agregarVertice(adicional2);
     ciudades.agregarVertice(adicional3);

     ciudades.conectar(v1, v2, 3);
     ciudades.conectar(v1, v3, 2);
     ciudades.conectar(v4, v5, 0);



    ciudades.conectar(v5, v6, 1);
    ciudades.conectar(v5, adicional1, 0);
    ciudades.conectar(v5, adicional2, 0);
    ciudades.conectar(v5, adicional3, 0);
     ciudades.conectar(v6, v7, 0);
     ciudades.conectar(v7, v4, 1);
     
     Algoritmos algoritmo= new Algoritmos<>();
     boolean ok=algoritmo.subgrafoCuadradoPorNivel(ciudades);
     if(ok){
        System.out.println("Hay subgrafo cuadrado.");
     }
     else
        System.out.println("No hay subgrafo cuadrado.");

        System.out.println("El grado del grafo es: "+ algoritmo.getGrado(ciudades));

        ok=algoritmo.tieneCiclo(ciudades);
        if(ok){
            System.out.println("Hay ciclo.");
         }
         else
            System.out.println("No hay ciclo.");
    }
    
}