/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joans
 */
@Entity
@Table(name = "habitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habitacion.findAll", query = "SELECT h FROM Habitacion h"),
    @NamedQuery(name = "Habitacion.findByNumHabitacion", query = "SELECT h FROM Habitacion h WHERE h.numHabitacion = :numHabitacion"),
    @NamedQuery(name = "Habitacion.findByHabOcupadas", query = "SELECT h FROM Habitacion h WHERE h.habOcupadas = :habOcupadas")})
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numHabitacion")
    private String numHabitacion;
    @Column(name = "numCamasTotales")
    private Short camTotales;
    @Column(name = "numCamasOcu")
    private Short camOcupadas;
    @OneToMany(mappedBy = "numHabitacion")
    private List<Paciente> pacienteList;

    public Habitacion() {
    }

    public Habitacion(String numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public Habitacion(String numHabitacion, Short camTotales, Short camOcupadas) {
        this.numHabitacion = numHabitacion;
        this.camTotales = camTotales;
        this.camOcupadas = camOcupadas;
    }
    

    public String getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(String numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public Short getCamTotales() {
        return camTotales;
    }

    public void setCamTotales(Short camTotales) {
        this.camTotales = camTotales;
    }

    public Short getCamOcupadas() {
        return camOcupadas;
    }

    public void setCamOcupadas(Short camOcupadas) {
        this.camOcupadas = camOcupadas;
    }
    
    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numHabitacion != null ? numHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.numHabitacion == null && other.numHabitacion != null) || (this.numHabitacion != null && !this.numHabitacion.equals(other.numHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Habitacion[ numHabitacion=" + numHabitacion + " ]";
    }

    
    
}
