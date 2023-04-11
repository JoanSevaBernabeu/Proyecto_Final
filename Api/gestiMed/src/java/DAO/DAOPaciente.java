/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAOHabitacion.getHabitacion;
import static DAO.DAOMedico.getMedico;
import static DAO.DAOTratamiento.getTratamiento;
import clases.Habitacion;
import clases.Medico;
import clases.Paciente;
import clases.Tratamiento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import listas.ListaMedico;
import listas.ListaPaciente;

/**
 *
 * @author joans
 */
public class DAOPaciente {
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
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void desconectar() {
        try {
            // Cerrar conexión
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ListaPaciente getPacientes(){
        ListaPaciente lista = new ListaPaciente();
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM Paciente";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                while(rs.next()){
                    Paciente paciente = new Paciente(rs.getString("sip"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("numContacto"),rs.getDate("nacimiento"),rs.getString("urgencia"));
                    Tratamiento tratamiento = getTratamiento(rs.getString("tratamiento"));
                    paciente.setTratamiento(tratamiento);
                    ListaMedico medicos = obtenerMedicos(rs.getString("sip"));
                    paciente.setMedicoList(medicos.getLista());
                    lista.add(paciente);
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return lista;
    }
    
    public static Paciente getPaciente(String sip){
        Paciente paciente = null;
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM Paciente WHERE sip LIKE '%"+sip+"%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                paciente = new Paciente(rs.getString("sip"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("numContacto"),rs.getDate("nacimiento"),rs.getString("urgencia"));
                Tratamiento tratamiento = getTratamiento(rs.getString("tratamiento"));
                paciente.setTratamiento(tratamiento);
                ListaMedico medicos = obtenerMedicos(rs.getString("sip"));
                paciente.setMedicoList(medicos.getLista());
                Habitacion habitacion = getHabitacion(rs.getShort("numHabitacion"));
                paciente.setNumHabitacion(habitacion);
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return paciente;
    }
    
    
    
    public static ListaMedico obtenerMedicos(String sip){
        ListaMedico lista = new ListaMedico();
        List<Medico> listaMedicos = null;
        Statement statement = null;
        conectar();
        try{
            String sentencia = "SELECT * FROM trata WHERE sip_paciente LIKE '%"+sip+"%'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sentencia);
            if(rs.next()){
                while(rs.next()){
                    Medico medico = getMedico(rs.getString("dni_medico"));
                    lista.add(medico);
                }
                
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return lista;
    }
    
    
    public static void pacientePost(Paciente paciente){
        Statement statement = null;
        ArrayList<Medico> listaMedicos = paciente.getMedicoList();
        conectar();
        try{
            statement = con.createStatement();
            String insertPaciente = "INSERT INTO paciente(sip,nombre,apellidos,numContacto,nacimiento,tratamiento) VALUES ('"+
                    paciente.getSip()+"','"+paciente.getNombre()+"','"+paciente.getApellidos()+"','"
                    +paciente.getNumContacto()+"','"+paciente.getNacimiento()+"','"+paciente.getTratamiento()
                    +"');";
            ResultSet rs = statement.executeQuery(insertPaciente);
            insertaMedicos(listaMedicos,paciente);
            
        }catch(SQLException ex){
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
    }
    
    public static void insertaMedicos(ArrayList<Medico> medicos,Paciente paciente) throws SQLException{
        Statement statement = null;
        statement = con.createStatement();
        for(Medico med : medicos){
            String consulta = "INSERT INTO cura VALUES ('"+med.getDni()+"','"+paciente.getSip()+"')";
            ResultSet rs = statement.executeQuery(consulta);
        }
    }
    
    
    public static void pacienteDelete(String sip){
        Statement statement = null;
        conectar();
        try{
            statement = con.createStatement();
            String delete = "DELETE FROM paciente WHERE sip LIKE '%"+sip+"%'";
            ResultSet rs = statement.executeQuery(delete);
            deleteTrata(sip);
            deleteCura(sip);
        }catch(SQLException ex){
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
    }
    
    public static void deleteTrata(String sip) throws SQLException{
        Statement statement = con.createStatement();
        
        String delete = "DELETE FROM trata WHERE sip_paciente LIKE '%"+sip+"%'";
        ResultSet rs = statement.executeQuery(delete);
    }
    
    public static void deleteCura(String sip) throws SQLException{
        Statement statement = con.createStatement();
        String delete = "DELETE FROM cura WHERE sip_paciente LIKE '%"+sip+"%'";
        ResultSet rs = statement.executeQuery(delete);
    }
}
