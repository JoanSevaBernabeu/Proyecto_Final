/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import clases.Medico;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author joans
 */
public class ListaMedico implements Serializable{
    private ArrayList<Medico> lista = new ArrayList<Medico>();
    
    public ListaMedico(){
    }
    public ListaMedico(ArrayList<Medico> lista){
        this.lista = lista;
    }
    public ArrayList<Medico> getLista(){
        return lista;
    }
    public void setLista(ArrayList<Medico> lista){
        this.lista = lista;
    }
    public void add(Medico med){
        this.lista.add(med);
    }

    @Override
    public String toString() {
        return "[" +lista + ']';
    }
    
}
