package Practica_4.Arboles.Practica_5.parte_A.parte_B;


import utilidades.ColaGenerica;


import ListaGenerica.ListaGenerica;
import Practica_4.Arboles.Practica_5.parte_A.ArbolGeneral;


public class RedAguaPotable {
    
    public double CalcularMinimoCaudal(ArbolGeneral<Double> RedAgua, double litros){
        ArbolGeneral<Double> arbol = RedAgua;
        double lit=litros;
        int cant=0;
        ColaGenerica<ArbolGeneral<Double>> cola= new ColaGenerica<ArbolGeneral<Double>>();
        ArbolGeneral<Double> arbol_aux;
        cola.encolar(arbol);
        cola.encolar(null);
        while(!cola.esVacia()) {

        arbol_aux = cola.desencolar();
        
        if(arbol_aux!=null){
        cant++;   
        if (arbol_aux.tieneHijos()) {

        ListaGenerica<ArbolGeneral<Double>> hijos = arbol_aux.getHijos();
        hijos.comenzar();
            while (!hijos.fin()) {  
               cola.encolar(hijos.proximo());
            }
    
        }
        }
        else {
            
            lit=lit/cant;
            
            cant=0;
           if  (!cola.esVacia())
            cola.encolar(null);

           
        }
    
        
    }
   
    return lit;


    }
    
    

}
