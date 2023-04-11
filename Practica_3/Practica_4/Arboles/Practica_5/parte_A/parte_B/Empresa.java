package Practica_4.Arboles.Practica_5.parte_A.parte_B;


import utilidades.ColaGenerica;


import ListaGenerica.ListaGenerica;
import Practica_4.Arboles.Practica_5.parte_A.ArbolGeneral;

public class Empresa {
    
    private ArbolGeneral<empleado> arbolJerarquico;

    

    public Empresa(ArbolGeneral<empleado> arbol){
        this.arbolJerarquico = arbol;
    }


    public int EmpleadosPorCategoria(int catego){
       catego=catego-1;  // ya que internamente manejamos valores con 1 menos, pero la categoria arranca en 1
        int cant=0;
        int niveles=0;

        if (!arbolJerarquico.esVacio() && catego==0){
            return 1;
        }

        ColaGenerica<ArbolGeneral<empleado>> cola= new ColaGenerica<ArbolGeneral<empleado>>();
        ArbolGeneral<empleado> arbol_aux;
        cola.encolar(this.arbolJerarquico);
        while(!cola.esVacia()) {
       arbol_aux = cola.desencolar();
        if (arbol_aux.tieneHijos()) {
            
        ListaGenerica<ArbolGeneral<empleado>> hijos = arbol_aux.getHijos();
        hijos.comenzar();
        niveles++;
            while (!hijos.fin()) {
               if (niveles==catego){
                cant++;
               }
                
               cola.encolar(hijos.proximo());
            }
            return cant;
    
        }
        
    }
   

        return cant;
        
    }



    public int CategoriaConMasEmpleados(){


    
        int cant=0;
        int niveles=0;
        int nivelMax=0;
        int cantMax=0;

        if (!arbolJerarquico.esVacio() && !arbolJerarquico.tieneHijos()){
            return 1;
        }

        ColaGenerica<ArbolGeneral<empleado>> cola= new ColaGenerica<ArbolGeneral<empleado>>();
        ArbolGeneral<empleado> arbol_aux;
        cola.encolar(this.arbolJerarquico);
        while(!cola.esVacia()) {
        arbol_aux = cola.desencolar();
        if (arbol_aux.tieneHijos()) {
            
        ListaGenerica<ArbolGeneral<empleado>> hijos = arbol_aux.getHijos();
        hijos.comenzar();
        niveles++;
            while (!hijos.fin()) {
                cant++;
                
               cola.encolar(hijos.proximo());
            }

            if (cant>cantMax){
                cantMax=cant;
                nivelMax=niveles;
            }
            cant=0;

    
        }
        
    }
   

        return nivelMax+1;
        

    }


    public int CantidadDeEmpleados(){


    
        int cantTotal=0;
      

        if (!arbolJerarquico.esVacio() && !arbolJerarquico.tieneHijos()){
            return 1;
        }

        cantTotal++;
        ColaGenerica<ArbolGeneral<empleado>> cola= new ColaGenerica<ArbolGeneral<empleado>>();
        ArbolGeneral<empleado> arbol_aux;
        cola.encolar(this.arbolJerarquico);
        while(!cola.esVacia()) {
        arbol_aux = cola.desencolar();
        if (arbol_aux.tieneHijos()) {
            
        ListaGenerica<ArbolGeneral<empleado>> hijos = arbol_aux.getHijos();
        hijos.comenzar();
            while (!hijos.fin()) {
                cantTotal++;
                
               cola.encolar(hijos.proximo());
            }


    
        }
        
    }
   

        return cantTotal;
        

    }

    
}
