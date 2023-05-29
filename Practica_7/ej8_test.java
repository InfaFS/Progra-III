public class ej8_test {
    public static void main(String[] args) {
     Vertice<String> muelle = new VerticeImplListAdy<String>("MUELLE");
     Vertice<String> v1 = new VerticeImplListAdy<String>("Isla 1");
     Vertice<String> v2 = new VerticeImplListAdy<String>("Isla 2");
     Vertice<String> v3 = new VerticeImplListAdy<String>("Isla 3");

     Vertice<String> v4 = new VerticeImplListAdy<String>("Isla 4");
     Vertice<String> v5 = new VerticeImplListAdy<String>("Isla 5");
     Vertice<String> v6 = new VerticeImplListAdy<String>("Isla 6");
     Vertice<String> v7 = new VerticeImplListAdy<String>("Isla 7");
     Grafo<String> Islas = new GrafoImplListAdy<String>();
     
      Islas.agregarVertice(muelle);
      Islas.agregarVertice(v1);
      Islas.agregarVertice(v2);
      Islas.agregarVertice(v3);
     // Islas.agregarVertice(v4);
     // Islas.agregarVertice(v5);
     // Islas.agregarVertice(v6);
     // Islas.agregarVertice(v7);

      Islas.conectar(muelle, v1, 0);
      Islas.conectar(v1, muelle, 1);

      Islas.conectar(v1, v2, 0);
      Islas.conectar(v2, v1, 0);

      Islas.conectar(v1, v3,100);
      Islas.conectar(v3, v1, 100);

      Islas.conectar(v2, v3, 50);
      Islas.conectar(v3, v2, 50);
      
     // Islas.conectar(muelle,v4, 0);
     // Islas.conectar(v4, muelle, 0);

     // Islas.conectar(v4, v5, 0);
     // Islas.conectar(v5, v4, 0);

   //   Islas.conectar(v5, v6, 0);
    //  Islas.conectar(v6, v5, 0);

     // Islas.conectar(v6, v7, 0);
     // Islas.conectar(v7, v6, 0);

     // Islas.conectar(v3, v7, 100);

      Delta delta = new Delta<>();
      RutaMinima ruta = new RutaMinima();
      System.out.println(delta.MaxIslasDistintas(Islas));

      ruta=delta.camonoMinimo(Islas,"Isla 3","Isla 1");
      System.out.println(ruta.getCamino().toString()+" "+"el estado de boleto es "+ ruta.getBoleto());
    }
    
}