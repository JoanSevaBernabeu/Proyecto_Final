/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAOPaciente.getPaciente;
import clases.Enfermero;
import listas.ListaEnfermero;
import clases.Paciente;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import listas.ListaPaciente;


/**
 *
 * @author joans
 */
public class DAOEnfermero {
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
    
    public static ListaPaciente obtenerPacientes(String dni){
        ListaPaciente pacientes = new ListaPaciente();
        Statement statement;
        conectar();
        try{
            String sentencia = "SELECT * FROM trata WHERE dni_enfermero LIKE '%"+dni+"%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                while(rs.next()){
                    Paciente paciente = getPaciente(rs.getString("sip_paciente"));
                    pacientes.add(paciente);
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOEnfermero.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return pacientes;
    }
    
    public static ListaEnfermero getEnfermeros(){
        ListaEnfermero lista = new ListaEnfermero();
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM enfermero";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                while(rs.next()){
                    Enfermero enf = new Enfermero(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("email"),rs.getString("contrasenya"),rs.getString("numContacto"),rs.getString("turno"));
                    ListaPaciente pacientes = obtenerPacientes(rs.getString("dni"));
                    enf.setPacienteList(pacientes.getLista());
                    lista.add(enf);
                }
            }
            rs.close();
        }catch(SQLException ex){
            Logger.getLogger(DAOEnfermero.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return lista;
    }
    
    public static Enfermero getEnfermero(String dni){
        Enfermero enfermero = null;
        Statement statement;
        conectar();
        try{
            String sentencia = "SELECT * FROM enfermero WHERE dni LIKE '%" + dni + "%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                enfermero = new Enfermero(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("email"),rs.getString("contrasenya"),rs.getString("numContacto"),rs.getString("turno"));
                ListaPaciente pacientes = obtenerPacientes(rs.getString("dni"));
                enfermero.setPacienteList(pacientes.getLista());
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOEnfermero.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return enfermero;
    }
    
    public static ListaEnfermero getEnfermeros(String turno){
        ListaEnfermero lista = new ListaEnfermero();
        Statement statement = null;
        conectar();
        try{
            String consulta = "SELECT * FROM enfermero WHERE turno LIKE '%" + turno + "%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(consulta);
            if(rs.next()){
                while(rs.next()){
                    Enfermero enfermero = new Enfermero(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("email"),rs.getString("contrasenya"),rs.getString("numContacto"),rs.getString("turno"));
                    ListaPaciente pacientes = obtenerPacientes(rs.getString("dni"));
                    enfermero.setPacienteList(pacientes.getLista());
                    lista.add(enfermero);
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOEnfermero.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return lista;
    }
}

