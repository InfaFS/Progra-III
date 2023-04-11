package Practica_4.Arboles.Practica_5.parte_A.parte_B;

import Practica_4.Arboles.Practica_5.parte_A.ArbolGeneral;

public class test_empleado {

    public static void main(String[] args) {
        
        empleado Empleado = new empleado();
        Empleado.setAntiguedad(10);
        Empleado.setCategoria(1);
        Empleado.setNombre("Pepe");

        ArbolGeneral<empleado> Presidente = new ArbolGeneral<empleado>(Empleado);
        ArbolGeneral<empleado> Gerente1 = new ArbolGeneral<empleado>(Empleado);
        ArbolGeneral<empleado> Gerente2 = new ArbolGeneral<empleado>(Empleado);

        ArbolGeneral<empleado> pete1 = new ArbolGeneral<empleado>(Empleado);

        ArbolGeneral<empleado> pete2 = new ArbolGeneral<empleado>(Empleado);

        ArbolGeneral<empleado> pete3 = new ArbolGeneral<empleado>(Empleado);

        ArbolGeneral<empleado> pete4 = new ArbolGeneral<empleado>(Empleado);

        

        Presidente.agregarHijo(Gerente1);
        Presidente.agregarHijo(Gerente2);

        Gerente1.agregarHijo(pete1);
        Gerente1.agregarHijo(pete2);

        Gerente1.agregarHijo(pete3);
        Gerente1.agregarHijo(pete4);

        Empresa empresa = new Empresa(Presidente);

        System.out.println("Empleados en la categoria buscada: "+empresa.EmpleadosPorCategoria(1));
    
        System.out.println("Categoria con mas empleados: "+empresa.CategoriaConMasEmpleados()); //ver por que no funciona si le agregan los hijos a varios gerentes
        
        System.out.println("La cantidad de empleados en la empresa es de "+ empresa.CantidadDeEmpleados());

    }
    
}
