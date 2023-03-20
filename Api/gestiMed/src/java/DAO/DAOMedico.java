/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAOPaciente.getPaciente;
import clases.Medico;
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
import listas.ListaMedico;
import listas.ListaPaciente;

/**
 *
 * @author joans
 */
public class DAOMedico {
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
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void desconectar() {
        try {
            // Cerrar conexión
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ListaMedico getMedicos(){
        ListaMedico lista = new ListaMedico();
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM medico";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                while(rs.next()){
                    Medico med = new Medico(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("email"),rs.getString("contrasenya"),rs.getString("numContacto"),rs.getString("turno"));
                    ListaPaciente pacientes = obtenerPacientes(rs.getString("dni"));
                    med.setPacienteList(pacientes.getLista());
                    lista.add(med);
                }
            }
            rs.close();
        }catch(SQLException ex){
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return lista    ;
    }
    
    public static ListaMedico getMedicos(String turno){
        ListaMedico lista = new ListaMedico();
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM medico WHERE turno LIKE '%" + turno + "%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                while(rs.next()){
                    Medico med = new Medico(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("email"),rs.getString("contrasenya"),rs.getString("numContacto"),rs.getString("turno"));
                    ListaPaciente pacientes = obtenerPacientes(rs.getString("dni"));
                    med.setPacienteList(pacientes.getLista());
                    lista.add(med);
                }
            }
            rs.close();
        }catch(SQLException ex){
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return lista;
    }
    
    public static Medico getMedico(String dni){
        Medico med = null;
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM medico WHERE dni LIKE '%" + dni + "%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                med = new Medico(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("email"),rs.getString("contrasenya"),rs.getString("numContacto"),rs.getString("turno"));
                ListaPaciente pacientes = obtenerPacientes(rs.getString("dni"));
                med.setPacienteList(pacientes.getLista());
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return med;
    }
    
    public static ListaPaciente obtenerPacientes(String dni){
        ListaPaciente lista = new ListaPaciente();
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM cura WHERE dni_enfermero LIKE '%"+dni+"%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                while(rs.next()){
                    Paciente paciente = getPaciente(rs.getString("sip_paciente"));
                    lista.add(paciente);
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return lista;
    }

}
