package Practica_4.Arboles.Practica_5.parte_A.parte_B;


import java.security.DrbgParameters.Reseed;

import ListaGenerica.ListaGenerica;

import Practica_4.Arboles.Practica_5.parte_A.ArbolGeneral;

public class testAguaPotable {

    public static void main(String[] args) {
        ArbolGeneral<Double> redAgua = new ArbolGeneral<Double>(0.0);
        ArbolGeneral<Double> redAgua_1 = new ArbolGeneral<Double>(0.0);
        ArbolGeneral<Double> redAgua_2 = new ArbolGeneral<Double>(0.0);
        ArbolGeneral<Double> redAgua_3 = new ArbolGeneral<Double>(0.0);
        ArbolGeneral<Double> redAgua_4 = new ArbolGeneral<Double>(0.0);
        ArbolGeneral<Double> redAgua_2_1 = new ArbolGeneral<Double>(0.0);
        ArbolGeneral<Double> redAgua_2_2 = new ArbolGeneral<Double>(0.0);
        ArbolGeneral<Double> redAgua_2_3 = new ArbolGeneral<Double>(0.0);

        redAgua.agregarHijo(redAgua_1);
        redAgua.agregarHijo(redAgua_2);
        redAgua.agregarHijo(redAgua_3);
        redAgua.agregarHijo(redAgua_4);
        redAgua_2.agregarHijo(redAgua_2_1);
        redAgua_2.agregarHijo(redAgua_2_2);
        redAgua_2.agregarHijo(redAgua_2_3);

        RedAguaPotable RED = new RedAguaPotable();

       System.out.println(RED.CalcularMinimoCaudal(redAgua, 1000)); 

    }
    
}
