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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"),
    @NamedQuery(name = "Unidad.findByUniNpib", query = "SELECT u FROM Unidad u WHERE u.uniNpib = :uniNpib"),
    @NamedQuery(name = "Unidad.findByUniCbv", query = "SELECT u FROM Unidad u WHERE u.uniCbv = :uniCbv"),
    @NamedQuery(name = "Unidad.findByUniRango", query = "SELECT u FROM Unidad u WHERE u.uniRango = :uniRango"),
    @NamedQuery(name = "Unidad.findByUniGsrh", query = "SELECT u FROM Unidad u WHERE u.uniGsrh = :uniGsrh"),
    @NamedQuery(name = "Unidad.findByUniMaquinista", query = "SELECT u FROM Unidad u WHERE u.uniMaquinista = :uniMaquinista"),
    @NamedQuery(name = "Unidad.findByUniEstado", query = "SELECT u FROM Unidad u WHERE u.uniEstado = :uniEstado")})
public class Unidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "uni_npib")
    private String uniNpib;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "uni_cbv")
    private String uniCbv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "uni_rango")
    private String uniRango;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "uni_gsrh")
    private String uniGsrh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uni_maquinista")
    private Character uniMaquinista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uni_estado")
    private boolean uniEstado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "peremeNpid", fetch = FetchType.LAZY)
    private PersonalEmergancia personalEmergancia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maqEmeNpib", fetch = FetchType.LAZY)
    private Collection<MaquinaEmergencia> maquinaEmergenciaCollection;
    @JoinColumn(name = "uni_per_id", referencedColumnName = "per_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona uniPerId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuNpib", fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emeComandante", fetch = FetchType.LAZY)
    private Collection<Emergencia> emergenciaCollection;

    public Unidad() {
    }

    public Unidad(String uniNpib) {
        this.uniNpib = uniNpib;
    }

    public Unidad(String uniNpib, String uniCbv, String uniRango, String uniGsrh, Character uniMaquinista, boolean uniEstado) {
        this.uniNpib = uniNpib;
        this.uniCbv = uniCbv;
        this.uniRango = uniRango;
        this.uniGsrh = uniGsrh;
        this.uniMaquinista = uniMaquinista;
        this.uniEstado = uniEstado;
    }

    public String getUniNpib() {
        return uniNpib;
    }

    public void setUniNpib(String uniNpib) {
        this.uniNpib = uniNpib;
    }

    public String getUniCbv() {
        return uniCbv;
    }

    public void setUniCbv(String uniCbv) {
        this.uniCbv = uniCbv;
    }

    public String getUniRango() {
        return uniRango;
    }

    public void setUniRango(String uniRango) {
        this.uniRango = uniRango;
    }

    public String getUniGsrh() {
        return uniGsrh;
    }

    public void setUniGsrh(String uniGsrh) {
        this.uniGsrh = uniGsrh;
    }

    public Character getUniMaquinista() {
        return uniMaquinista;
    }

    public void setUniMaquinista(Character uniMaquinista) {
        this.uniMaquinista = uniMaquinista;
    }

    public boolean getUniEstado() {
        return uniEstado;
    }

    public void setUniEstado(boolean uniEstado) {
        this.uniEstado = uniEstado;
    }

    public PersonalEmergancia getPersonalEmergancia() {
        return personalEmergancia;
    }

    public void setPersonalEmergancia(PersonalEmergancia personalEmergancia) {
        this.personalEmergancia = personalEmergancia;
    }

    @XmlTransient
    public Collection<MaquinaEmergencia> getMaquinaEmergenciaCollection() {
        return maquinaEmergenciaCollection;
    }

    public void setMaquinaEmergenciaCollection(Collection<MaquinaEmergencia> maquinaEmergenciaCollection) {
        this.maquinaEmergenciaCollection = maquinaEmergenciaCollection;
    }

    public Persona getUniPerId() {
        return uniPerId;
    }

    public void setUniPerId(Persona uniPerId) {
        this.uniPerId = uniPerId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (uniNpib != null ? uniNpib.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.uniNpib == null && other.uniNpib != null) || (this.uniNpib != null && !this.uniNpib.equals(other.uniNpib))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ uniNpib=" + uniNpib + " ]";
    }    
}
