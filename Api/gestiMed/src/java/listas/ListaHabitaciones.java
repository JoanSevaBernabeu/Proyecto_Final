/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import clases.Habitacion;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author joans
 */
public class ListaHabitaciones implements Serializable{
    private ArrayList<Habitacion> lista = new ArrayList<Habitacion>();
    
    public ListaHabitaciones(){
    }
    public ListaHabitaciones(ArrayList<Habitacion> lista){
        this.lista = lista;
    }
    public ArrayList<Habitacion> getLista(){
        return lista;
    }
    public void setLista(ArrayList<Habitacion> lista){
        this.lista = lista;
    }
    public void add(Habitacion habitacion){
        this.lista.add(habitacion);
    }
}
