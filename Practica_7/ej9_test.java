public class ej9_test {
    public static void main(String[] args) {
     Vertice<String> uno = new VerticeImplListAdy<String>("1");
     Vertice<String> dos = new VerticeImplListAdy<String>("2");
     Vertice<String> tres = new VerticeImplListAdy<String>("3");
     Vertice<String> cuatro = new VerticeImplListAdy<String>("4");

     Vertice<String> cinco = new VerticeImplListAdy<String>("5");
     Vertice<String> seis = new VerticeImplListAdy<String>("6");
     Vertice<String> siete = new VerticeImplListAdy<String>("7");

     Grafo<String> puntos = new GrafoImplListAdy<String>();
     
     puntos.agregarVertice(uno);
     puntos.agregarVertice(dos);
     puntos.agregarVertice(tres);
     puntos.agregarVertice(cuatro);
     puntos.agregarVertice(cinco);
     puntos.agregarVertice(seis);
     puntos.agregarVertice(siete);

     puntos.conectar(uno, dos, 30);
     puntos.conectar(uno, cuatro, 10);
     puntos.conectar(uno, tres, 15);

     puntos.conectar(dos, cinco, 60);
     puntos.conectar(dos, cuatro, 25);
    
     puntos.conectar(cinco, siete, 20);
     puntos.conectar(cuatro, siete, 35);
     puntos.conectar(cuatro, tres, 40);

     puntos.conectar(tres, seis, 20);

     puntos.conectar(seis,siete, 30);

        GuiaDeTurismo guia = new GuiaDeTurismo();
    ListaGenerica<String> lista= guia.caminoConMenorNrodeViajes(puntos, "1", "7");
    System.out.println(lista.toString());





     
    }
    
}