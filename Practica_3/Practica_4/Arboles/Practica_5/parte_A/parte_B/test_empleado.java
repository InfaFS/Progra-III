package Practica_4.Arboles.Practica_5.parte_A.parte_B;

import ListaGenerica.ListaGenerica;

import Practica_4.Arboles.Practica_5.parte_A.ArbolGeneral;

public class test_empleado {

    public static void main(String[] args) {
        
        empleado Presi = new empleado();
        Presi.setAntiguedad(50);
        Presi.setCategoria(1);
        Presi.setNombre("Pepe");

        empleado GerenA = new empleado();
        GerenA.setAntiguedad(20);
        GerenA.setCategoria(2);
        GerenA.setNombre("Carlos");

        empleado GerenB = new empleado();
        GerenB.setAntiguedad(45);
        GerenB.setCategoria(2);
        GerenB.setNombre("Pedro");

        empleado GerenC = new empleado();
        GerenC.setAntiguedad(32);
        GerenC.setCategoria(2);
        GerenC.setNombre("Jose");

        empleado peteA = new empleado();
        peteA.setAntiguedad(5);
        peteA.setCategoria(3);
        peteA.setNombre("Maria");

        empleado peteB = new empleado();
        peteB.setAntiguedad(10);
        peteB.setCategoria(3);
        peteB.setNombre("Carlitos");

        empleado peteC= new empleado();
        peteC.setAntiguedad(2);
        peteC.setCategoria(3);
        peteC.setNombre("Sacacorcho");

        ArbolGeneral<empleado> Presidente = new ArbolGeneral<empleado>(Presi);
        ArbolGeneral<empleado> Gerente1 = new ArbolGeneral<empleado>(GerenA);
        ArbolGeneral<empleado> Gerente2 = new ArbolGeneral<empleado>(GerenB);
        ArbolGeneral<empleado> pete1 = new ArbolGeneral<empleado>(peteA);
        ArbolGeneral<empleado> pete2 = new ArbolGeneral<empleado>(peteB);
        ArbolGeneral<empleado> pete3 = new ArbolGeneral<empleado>(peteC);

        Presidente.agregarHijo(Gerente1);
        Presidente.agregarHijo(Gerente2);
        Gerente1.agregarHijo(pete1);
        Gerente1.agregarHijo(pete3);
        Gerente2.agregarHijo(pete2);

        Empresa empresa = new Empresa(Presidente);

        System.out.println("Empleados en la categoria buscada: "+empresa.EmpleadosPorCategoria(2));
    
        System.out.println("Categoria con mas empleados: "+empresa.CategoriaConMasEmpleados());
        
        System.out.println("La cantidad de empleados en la empresa es de "+ empresa.CantidadDeEmpleados());

        ListaGenerica<empleado> lista = Presidente.porNiveles();

        while (!lista.fin()){
            System.out.println(lista.proximo().getNombre());
        }

        empresa.reemplazarPresidente();

        lista=Presidente.porNiveles();

        System.out.println("");
        while (!lista.fin()){
            System.out.println(lista.proximo().getNombre());
        }

    }
    
}
