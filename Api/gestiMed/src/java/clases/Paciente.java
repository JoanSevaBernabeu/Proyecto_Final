/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joans
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findBySip", query = "SELECT p FROM Paciente p WHERE p.sip = :sip"),
    @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paciente.findByApellidos", query = "SELECT p FROM Paciente p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Paciente.findByNumContacto", query = "SELECT p FROM Paciente p WHERE p.numContacto = :numContacto"),
    @NamedQuery(name = "Paciente.findByNacimiento", query = "SELECT p FROM Paciente p WHERE p.nacimiento = :nacimiento"),
    @NamedQuery(name = "Paciente.findByUrgencia", query = "SELECT p FROM Paciente p WHERE p.urgencia = :urgencia")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sip")
    private String sip;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 255)
    @Column(name = "numContacto")
    private String numContacto;
    @Column(name = "nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nacimiento;
    @Size(max = 255)
    @Column(name = "urgencia")
    private String urgencia;
    @ManyToMany(mappedBy = "pacienteList")
    private ArrayList<Medico> medicoList;
    @JoinColumn(name = "numHabitacion", referencedColumnName = "numHabitacion")
    @ManyToOne
    private Habitacion numHabitacion;
    @JoinColumn(name = "tratamiento", referencedColumnName = "nombre")
    @ManyToOne
    private Tratamiento tratamiento;

    public Paciente() {
    }

    public Paciente(String sip, String nombre, String apellidos, String numContacto, Date nacimiento, String urgencia) {
        this.sip = sip;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numContacto = numContacto;
        this.nacimiento = nacimiento;
        this.urgencia = urgencia;
    }
    
    

    public Paciente(String sip) {
        this.sip = sip;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
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

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    @XmlTransient
    public ArrayList<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(ArrayList<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    public Habitacion getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(Habitacion numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sip != null ? sip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.sip == null && other.sip != null) || (this.sip != null && !this.sip.equals(other.sip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Paciente[ sip=" + sip + " ]";
    }
    
}
