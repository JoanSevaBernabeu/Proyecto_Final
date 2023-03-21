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
    private Short numHabitacion;
    @Column(name = "habOcupadas")
    private Short habOcupadas;
    @Column(name="habLlena")
    private boolean ocupada;
    @OneToMany(mappedBy = "numHabitacion")
    private List<Paciente> pacienteList;

    public Habitacion() {
    }

    public Habitacion(Short numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public Short getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(Short numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public Short getHabOcupadas() {
        return habOcupadas;
    }

    public void setHabOcupadas(Short habOcupadas) {
        this.habOcupadas = habOcupadas;
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

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
}
