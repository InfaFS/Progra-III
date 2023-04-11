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
        int categoriaActual=1;  // ya que internamente manejamos valores con 1 menos, pero la categoria arranca en 1
        int cant=0;
      

        if (!arbolJerarquico.esVacio() && catego==1){
            return 1;
        }

        ColaGenerica<ArbolGeneral<empleado>> cola= new ColaGenerica<ArbolGeneral<empleado>>();
        ArbolGeneral<empleado> arbol_aux;
        cola.encolar(this.arbolJerarquico);
        cola.encolar(null);
        while(!cola.esVacia()) {

        arbol_aux = cola.desencolar();
        
        if(arbol_aux!=null){
        cant++;   
        if (arbol_aux.tieneHijos()) {

        ListaGenerica<ArbolGeneral<empleado>> hijos = arbol_aux.getHijos();
        hijos.comenzar();
            while (!hijos.fin()) {  
               cola.encolar(hijos.proximo());
            }
    
        }
        }
        else if (!cola.esVacia()){
            cola.encolar(null);
            if (categoriaActual==catego){
                return cant;
            }
            
            cant=0;
            categoriaActual++;
        }
        
        
    }
   

        return cant;
        
    }



    public int CategoriaConMasEmpleados(){


    
        int cant=0;
        int categoriaActual=1;
        int categoriaMax=1;
        int cantMax=Integer.MIN_VALUE;

        if (!arbolJerarquico.esVacio() && !arbolJerarquico.tieneHijos()){
            return 1;
        }

        ColaGenerica<ArbolGeneral<empleado>> cola= new ColaGenerica<ArbolGeneral<empleado>>();
        ArbolGeneral<empleado> arbol_aux;
        cola.encolar(this.arbolJerarquico);
        cola.encolar(null);
        while(!cola.esVacia()) {

            arbol_aux = cola.desencolar();
            
            if(arbol_aux!=null){
            cant++;   
            if (arbol_aux.tieneHijos()) {
    
            ListaGenerica<ArbolGeneral<empleado>> hijos = arbol_aux.getHijos();
            hijos.comenzar();
                while (!hijos.fin()) {  
                   cola.encolar(hijos.proximo());
                }
        
            }
            }
            else {
                if (cant>cantMax){
                    cantMax=cant;
                    categoriaMax=categoriaActual;
                }
                if (!cola.esVacia()){
                cola.encolar(null);
                cant=0;
                categoriaActual++;
                }
            }
        
        
        }
   

        return categoriaMax;
        

    }


    public int CantidadDeEmpleados(){


    
        int cant=0;
      

        if (!arbolJerarquico.esVacio() && !arbolJerarquico.tieneHijos()){
            return 1;
        }

        
        ColaGenerica<ArbolGeneral<empleado>> cola= new ColaGenerica<ArbolGeneral<empleado>>();
        ArbolGeneral<empleado> arbol_aux;
        cola.encolar(this.arbolJerarquico);
        cola.encolar(null);
        while(!cola.esVacia()) {

            arbol_aux = cola.desencolar();
            
            if(arbol_aux!=null){
            cant++;   
            if (arbol_aux.tieneHijos()) {
    
            ListaGenerica<ArbolGeneral<empleado>> hijos = arbol_aux.getHijos();
            hijos.comenzar();
                while (!hijos.fin()) {  
                   cola.encolar(hijos.proximo());
                }
        
            }
            }
    
        
         }
         
         return cant;
        

    }

    public void reemplazarPresidente(){
        ArbolGeneral<empleado> arbol = this.arbolJerarquico;

        while (arbol!=null){
            ListaGenerica<ArbolGeneral<empleado>> lista = arbol.getHijos();
            lista.comenzar();
            ArbolGeneral<empleado> e = lista.proximo();
            while(!lista.fin()){
                ArbolGeneral<empleado> e2= lista.proximo();

                if (e.getDato().getAntiguedad() < e2.getDato().getAntiguedad()){
                    e=e2;
                }
            
            }

            e.getDato().setCategoria(e.getDato().getCategoria()-1);
            arbol.setDato(e.getDato());
            if (e.esHoja()){
                arbol.eliminarHijo(e);
                break;
            }
            arbol = e;
            }




        }

    }

    
