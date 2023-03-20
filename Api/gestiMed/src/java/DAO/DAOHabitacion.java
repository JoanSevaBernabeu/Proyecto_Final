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
    
    public static Habitacion getHabitacion(int numHabitacion){
        Habitacion habitacion = new Habitacion();
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM habitacion WHERE numHabitacion LIKE '%" +numHabitacion+"%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                habitacion.setNumHabitacion(rs.getShort("numHabitacion"));
                habitacion.setHabOcupadas(rs.getShort("habOcupadas"));
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return habitacion;
    }
}
