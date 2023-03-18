/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import clases.Enfermero;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author joans
 */
public class ListaEnfermero implements Serializable{
    private ArrayList<Enfermero> lista = new ArrayList<Enfermero>();
    
    public ListaEnfermero(){}
    
    public ListaEnfermero(ArrayList<Enfermero> lista){
        this.lista = lista;
    }
    public ArrayList<Enfermero> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Enfermero> lista) {
        this.lista = lista;
    }
    public void add(Enfermero enf){
        this.lista.add(enf);
    }
}
