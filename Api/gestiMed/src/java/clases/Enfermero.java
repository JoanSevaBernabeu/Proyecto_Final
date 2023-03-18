/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joans
 */
@Entity
@Table(name = "enfermero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermero.findAll", query = "SELECT e FROM Enfermero e"),
    @NamedQuery(name = "Enfermero.findByDni", query = "SELECT e FROM Enfermero e WHERE e.dni = :dni"),
    @NamedQuery(name = "Enfermero.findByNombre", query = "SELECT e FROM Enfermero e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Enfermero.findByApellidos", query = "SELECT e FROM Enfermero e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Enfermero.findByEmail", query = "SELECT e FROM Enfermero e WHERE e.email = :email"),
    @NamedQuery(name = "Enfermero.findByContrasenya", query = "SELECT e FROM Enfermero e WHERE e.contrasenya = :contrasenya"),
    @NamedQuery(name = "Enfermero.findByNumContacto", query = "SELECT e FROM Enfermero e WHERE e.numContacto = :numContacto"),
    @NamedQuery(name = "Enfermero.findByTurno", query = "SELECT e FROM Enfermero e WHERE e.turno = :turno")})
public class Enfermero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dni")
    private String dni;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "apellidos")
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "contrasenya")
    private String contrasenya;
    @Size(max = 255)
    @Column(name = "numContacto")
    private String numContacto;
    @Size(max = 255)
    @Column(name = "turno")
    private String turno;
    @JoinTable(name = "cura", joinColumns = {
        @JoinColumn(name = "dni_enfermero", referencedColumnName = "dni")}, inverseJoinColumns = {
        @JoinColumn(name = "sip_paciente", referencedColumnName = "sip")})
    @ManyToMany
    private ArrayList<Paciente> pacienteList;

    public Enfermero(String dni, String nombre, String apellidos, String email, String contrasenya, String numContacto, String turno) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasenya = contrasenya;
        this.numContacto = numContacto;
        this.turno = turno;
    }
    
    

    public Enfermero() {
    }

    public Enfermero(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(ArrayList<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermero)) {
            return false;
        }
        Enfermero other = (Enfermero) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Enfermero{ dni= "+dni+"}";
    }
    
}
