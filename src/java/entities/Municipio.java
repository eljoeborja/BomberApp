/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author BuRr0X
 */
@Entity
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByMunId", query = "SELECT m FROM Municipio m WHERE m.munId = :munId"),
    @NamedQuery(name = "Municipio.findByMunCodigo", query = "SELECT m FROM Municipio m WHERE m.munCodigo = :munCodigo"),
    @NamedQuery(name = "Municipio.findByMunNombre", query = "SELECT m FROM Municipio m WHERE m.munNombre = :munNombre")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mun_id")
    private Integer munId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mun_codigo")
    private int munCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mun_nombre")
    private String munNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perMunicipio", fetch = FetchType.LAZY)
    private Collection<Persona> personaCollection;
    @JoinColumn(name = "mun_dep_codigo", referencedColumnName = "dep_codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departamento munDepCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aseMunId", fetch = FetchType.LAZY)
    private Collection<Aseguradora> aseguradoraCollection;

    public Municipio() {
    }

    public Municipio(Integer munId) {
        this.munId = munId;
    }

    public Municipio(Integer munId, int munCodigo, String munNombre) {
        this.munId = munId;
        this.munCodigo = munCodigo;
        this.munNombre = munNombre;
    }

    public Integer getMunId() {
        return munId;
    }

    public void setMunId(Integer munId) {
        this.munId = munId;
    }

    public int getMunCodigo() {
        return munCodigo;
    }

    public void setMunCodigo(int munCodigo) {
        this.munCodigo = munCodigo;
    }

    public String getMunNombre() {
        return munNombre;
    }

    public void setMunNombre(String munNombre) {
        this.munNombre = munNombre;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    public Departamento getMunDepCodigo() {
        return munDepCodigo;
    }

    public void setMunDepCodigo(Departamento munDepCodigo) {
        this.munDepCodigo = munDepCodigo;
    }

    @XmlTransient
    public Collection<Aseguradora> getAseguradoraCollection() {
        return aseguradoraCollection;
    }

    public void setAseguradoraCollection(Collection<Aseguradora> aseguradoraCollection) {
        this.aseguradoraCollection = aseguradoraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (munId != null ? munId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.munId == null && other.munId != null) || (this.munId != null && !this.munId.equals(other.munId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getMunNombre()+", "+this.getMunDepCodigo().getDepNombre();
    }
    
}
