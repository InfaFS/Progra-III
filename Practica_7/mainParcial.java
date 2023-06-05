

public class mainParcial {
        public static void main(String[] args) {
         Vertice<String> uno = new VerticeImplListAdy<String>("La Plata");
         Vertice<String> dos = new VerticeImplListAdy<String>("Quilmes");
         Vertice<String> tres = new VerticeImplListAdy<String>("Moreno");
         Vertice<String> cuatro = new VerticeImplListAdy<String>("Carlos Keen");
    
         Vertice<String> cinco = new VerticeImplListAdy<String>("Suipacha");
         Vertice<String> seis = new VerticeImplListAdy<String>("Navarro");
         Vertice<String> siete = new VerticeImplListAdy<String>("Saladillo");
         Vertice<String> ocho = new VerticeImplListAdy<String>("Abasto");
         Vertice<String> nueve = new VerticeImplListAdy<String>("Canuelas");
         Vertice<String> diez = new VerticeImplListAdy<String>("Lobos");
         Vertice<String> once = new VerticeImplListAdy<String>("Pinamar");

         Grafo<String> puntos = new GrafoImplListAdy<String>();
         
         puntos.agregarVertice(uno);
         puntos.agregarVertice(dos);
         puntos.agregarVertice(tres);
         puntos.agregarVertice(cuatro);
         puntos.agregarVertice(cinco);
         puntos.agregarVertice(seis);
         puntos.agregarVertice(siete);
         puntos.agregarVertice(ocho);
         puntos.agregarVertice(nueve);
         puntos.agregarVertice(diez);
         puntos.agregarVertice(once);
    
         puntos.conectar(uno, dos, 50);
         puntos.conectar(dos, uno, 50);
         puntos.conectar(uno, ocho, 100);
         puntos.conectar(ocho, uno, 100);
         puntos.conectar(uno, once, 300);
         puntos.conectar(once,uno, 300);
             
         puntos.conectar(dos, tres, 100);
         puntos.conectar(tres, dos, 100);

         puntos.conectar(tres, cuatro, 100);
         puntos.conectar(cuatro, tres, 100);


         puntos.conectar(tres, ocho, 100);
         puntos.conectar(ocho, tres, 100);

         puntos.conectar(cuatro, cinco, 100);
         puntos.conectar(cinco, cuatro, 100);

         puntos.conectar(cinco, seis, 50);
         puntos.conectar(seis,cinco, 50);
         
         puntos.conectar(seis, siete, 25);
         puntos.conectar(siete, seis, 25);

        puntos.conectar(ocho, nueve, 100);
        puntos.conectar(nueve, ocho, 100);

        puntos.conectar(nueve, seis, 200);
        puntos.conectar(seis, nueve, 200);

        Parcial parcial = new Parcial();
        Resultado res = new Resultado();
        res=parcial.resolver(puntos, "La Plata", 500);
        System.out.println(res.getCamino().toString());
        System.out.println("El monto sobrante es "+res.getMontoSobrante());
    
    
    
    
         
        }
        
    }
