/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Habitacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import listas.ListaHabitaciones;

/**
 *
 * @author joans
 */
public class DAOHabitacion {
    static Connection con = null;
    static String mensaje= "";
    
    public static void conectar(){
        try {
            // Conexión a la BD
            String url;

            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://localhost:3306/gestimed";
            url += "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";

            String usuario = "root";
            String password = "1234";
            con = DriverManager.getConnection(url, usuario, password);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void desconectar() {
        try {
            // Cerrar conexión
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Habitacion getHabitacion(Short numHabitacion){
        Habitacion habitacion = new Habitacion();
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM habitacion WHERE numHabitacion LIKE '" +numHabitacion+"'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                habitacion.setNumHabitacion(rs.getString("numHabitacion"));
                habitacion.setCamTotales(rs.getShort("numCamasTotales"));
                habitacion.setCamOcupadas(rs.getShort("numCamasOcu"));
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return habitacion;
    }
    
    public static ListaHabitaciones obtenerHabitaciones(){
        ListaHabitaciones lista = new ListaHabitaciones();
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM habitaciones";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return lista;
    }
    public static void postHabitacion(Habitacion habitacion)
    {
        Statement statement = null;
        conectar();
        try{
            String sentencia = "INSERT INTO habitacion VALUES ('"+habitacion.getNumHabitacion()+"',"+habitacion.getCamTotales()+","+habitacion.getCamOcupadas()+";";
            ResultSet rs = statement.executeQuery(sentencia);
            
        }catch(SQLException ex){
            Logger.getLogger(DAOHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
    }
    public static boolean deleteHabitacion(String id){
        Statement statement = null;
        boolean ok = false;
        conectar();
        try{
            String sentencia = "DELETE FROM habitacion WHERE numHabitacion LIKE '"+id+"';";
            ResultSet rs = statement.executeQuery(sentencia);   
        }catch(SQLException ex){
            Logger.getLogger(DAOHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return ok;
    }
}
