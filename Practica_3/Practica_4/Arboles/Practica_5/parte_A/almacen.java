package Practica_4.Arboles.Practica_5.parte_A;

import java.util.List;

import ListaGenerica.ListaGenerica;
import Practica_4.Arboles.ArbolBinario;

public class almacen {

    private ListaGenerica<ArbolBinario<Integer>> Lista;

    private int valor;


    public void setValor(int valor){
        this.valor=valor;
    }

    public void setLista(ListaGenerica<ArbolBinario<Integer>> lista){
        this.Lista=lista;
    }
    
    public int getValor(){
        return this.valor;
    }

    public ListaGenerica<ArbolBinario<Integer>> getLista(){
        return this.Lista;
    }
}
