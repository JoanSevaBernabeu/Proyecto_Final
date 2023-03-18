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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "tratamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamiento.findAll", query = "SELECT t FROM Tratamiento t"),
    @NamedQuery(name = "Tratamiento.findByNombre", query = "SELECT t FROM Tratamiento t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tratamiento.findByDescripcion", query = "SELECT t FROM Tratamiento t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tratamiento.findBySolucion", query = "SELECT t FROM Tratamiento t WHERE t.solucion = :solucion")})
public class Tratamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "solucion")
    private String solucion;
    @OneToMany(mappedBy = "tratamiento")
    private List<Paciente> pacienteList;
    @JoinColumn(name = "medicamento", referencedColumnName = "id")
    @ManyToOne
    private Medicamento medicamento;

    public Tratamiento() {
    }

    public Tratamiento(String nombre, String descripcion, String solucion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.solucion = solucion;
    }

    
    
    public Tratamiento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamiento)) {
            return false;
        }
        Tratamiento other = (Tratamiento) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Tratamiento[ nombre=" + nombre + " ]";
    }
    
}
