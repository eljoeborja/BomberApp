/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BuRr0X
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPerId", query = "SELECT p FROM Persona p WHERE p.perId = :perId"),
    @NamedQuery(name = "Persona.findByPerCedula", query = "SELECT p FROM Persona p WHERE p.perCedula = :perCedula"),
    @NamedQuery(name = "Persona.findByPerApellidos", query = "SELECT p FROM Persona p WHERE p.perApellidos = :perApellidos"),
    @NamedQuery(name = "Persona.findByPerNombres", query = "SELECT p FROM Persona p WHERE p.perNombres = :perNombres"),
    @NamedQuery(name = "Persona.findByPerDireccion", query = "SELECT p FROM Persona p WHERE p.perDireccion = :perDireccion"),
    @NamedQuery(name = "Persona.findByPerTelefono", query = "SELECT p FROM Persona p WHERE p.perTelefono = :perTelefono"),
    @NamedQuery(name = "Persona.findByPerTipo", query = "SELECT p FROM Persona p WHERE p.perTipo = :perTipo"),
    @NamedQuery(name = "Persona.findByPerFechanac", query = "SELECT p FROM Persona p WHERE p.perFechanac = :perFechanac"),
    @NamedQuery(name = "Persona.findByPerEstado", query = "SELECT p FROM Persona p WHERE p.perEstado = :perEstado")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "per_id")
    private String perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "per_cedula")
    private String perCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_apellidos")
    private String perApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_nombres")
    private String perNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "per_direccion")
    private String perDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "per_telefono")
    private String perTelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_tipo")
    private boolean perTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_fechanac")
    @Temporal(TemporalType.DATE)
    private Date perFechanac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_estado")
    private boolean perEstado;
    @JoinColumn(name = "per_municipio", referencedColumnName = "mun_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipio perMunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uniPerId", fetch = FetchType.LAZY)
    private Collection<Unidad> unidadCollection;
    @OneToOne(mappedBy = "vicPerId", fetch = FetchType.LAZY)
    private VictimaAccidente victimaAccidente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emeInformante", fetch = FetchType.LAZY)
    private Collection<Emergencia> emergenciaCollection;

    public Persona() {
    }

    public Persona(String perId) {
        this.perId = perId;
    }

    public Persona(String perId, String perCedula, String perApellidos, String perNombres, String perDireccion, String perTelefono, boolean perTipo, Date perFechanac, boolean perEstado) {
        this.perId = perId;
        this.perCedula = perCedula;
        this.perApellidos = perApellidos;
        this.perNombres = perNombres;
        this.perDireccion = perDireccion;
        this.perTelefono = perTelefono;
        this.perTipo = perTipo;
        this.perFechanac = perFechanac;
        this.perEstado = perEstado;
    }

    public String getPerId() {
        return perId;
    }

    public void setPerId(String perId) {
        this.perId = perId;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public String getPerApellidos() {
        return perApellidos;
    }

    public void setPerApellidos(String perApellidos) {
        this.perApellidos = perApellidos;
    }

    public String getPerNombres() {
        return perNombres;
    }

    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    public boolean getPerTipo() {
        return perTipo;
    }

    public void setPerTipo(boolean perTipo) {
        this.perTipo = perTipo;
    }

    public Date getPerFechanac() {
        return perFechanac;
    }

    public void setPerFechanac(Date perFechanac) {
        this.perFechanac = perFechanac;
    }

    public boolean getPerEstado() {
        return perEstado;
    }

    public void setPerEstado(boolean perEstado) {
        this.perEstado = perEstado;
    }

    public Municipio getPerMunicipio() {
        return perMunicipio;
    }

    public void setPerMunicipio(Municipio perMunicipio) {
        this.perMunicipio = perMunicipio;
    }

    @XmlTransient
    public Collection<Unidad> getUnidadCollection() {
        return unidadCollection;
    }

    public void setUnidadCollection(Collection<Unidad> unidadCollection) {
        this.unidadCollection = unidadCollection;
    }

    public VictimaAccidente getVictimaAccidente() {
        return victimaAccidente;
    }

    public void setVictimaAccidente(VictimaAccidente victimaAccidente) {
        this.victimaAccidente = victimaAccidente;
    }

    @XmlTransient
    public Collection<Emergencia> getEmergenciaCollection() {
        return emergenciaCollection;
    }

    public void setEmergenciaCollection(Collection<Emergencia> emergenciaCollection) {
        this.emergenciaCollection = emergenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Persona[ perId=" + perId + " ]";
    }
    
}
