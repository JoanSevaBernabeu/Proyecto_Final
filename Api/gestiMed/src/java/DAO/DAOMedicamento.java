/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Medicamento;
import clases.Tratamiento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import static DAO.DAOTratamiento.getTratamientos;
import java.util.ArrayList;
import listas.ListaMedicamento;
import listas.ListaTratamiento;

/**
 *
 * @author joans
 */
public class DAOMedicamento {
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
            Logger.getLogger(DAOEnfermero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void desconectar() {
        try {
            // Cerrar conexión
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEnfermero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ListaMedicamento getMedicamentos(){
        ListaMedicamento lista = new ListaMedicamento();
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM medicamento";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                while(rs.next()){
                    Medicamento medicamento = new Medicamento(rs.getString("id"),rs.getString("nombre"),rs.getInt("cantidad"),rs.getBoolean("pedir"),rs.getInt("intervalo"));
                    ListaTratamiento tratamientos = getTratamientos(rs.getString("medicamento"));
                    medicamento.setTratamientoList(tratamientos.getLista());
                    lista.add(medicamento);
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOMedicamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return lista;
    }
    
    public static Medicamento getMedicamento(String id){
        Medicamento medicamento = null;
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM medicamento WHERE id LIKE '%"+id+"%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                medicamento = new Medicamento(rs.getString("id"),rs.getString("nombre"),rs.getInt("cantidad"),rs.getBoolean("pedir"),rs.getInt("intervalo"));
                ListaTratamiento tratamientos = getTratamientos(rs.getString("medicamento"));
                medicamento.setTratamientoList(tratamientos.getLista());
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOMedicamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return medicamento;
    }
    
    public static ListaTratamiento getTratamientos(String medicamento){
        ListaTratamiento tratamientos = new ListaTratamiento();
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM tratamiento WHERE medicamento LIKE '%"+medicamento+"%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                while(rs.next()){
                    Tratamiento tratamiento = DAOTratamiento.getTratamiento(rs.getString("nombre"));
                    tratamientos.add(tratamiento);
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOMedicamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return tratamientos;
    }
    

}
