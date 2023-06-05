public class ej10 {
    public static void main(String[] args) {
     Vertice<String> uno = new VerticeImplListAdy<String>("Jorge");
     Vertice<String> dos = new VerticeImplListAdy<String>("Ariel");
     Vertice<String> tres = new VerticeImplListAdy<String>("Juan");
     Vertice<String> cuatro = new VerticeImplListAdy<String>("Matias");
     Vertice<String> cinco = new VerticeImplListAdy<String>("Pepe");

     Grafo<String> puntos = new GrafoImplListAdy<String>();
     
     puntos.agregarVertice(uno);
     puntos.agregarVertice(dos);
     puntos.agregarVertice(tres);
     puntos.agregarVertice(cuatro);
     puntos.agregarVertice(cinco);

     puntos.conectar(uno, dos, 30);
     puntos.conectar(dos, uno, 30);

     puntos.conectar(uno, tres, 100);
     puntos.conectar(tres, uno, 100);

     puntos.conectar(dos, cuatro, 0);
     puntos.conectar(cuatro,dos,0);


     puntos.conectar(cuatro,cinco,0);
     puntos.conectar(cinco,cuatro,0);


    

     GradosDeSeparacion grado = new GradosDeSeparacion();
     System.out.println(grado.maximoGradoDeSeparacion(puntos));

    


    
    }
}