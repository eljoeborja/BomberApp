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
@Table(name = "maquina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquina.findAll", query = "SELECT m FROM Maquina m"),
    @NamedQuery(name = "Maquina.findByMaqId", query = "SELECT m FROM Maquina m WHERE m.maqId = :maqId"),
    @NamedQuery(name = "Maquina.findByMaqDescripcion", query = "SELECT m FROM Maquina m WHERE m.maqDescripcion = :maqDescripcion"),
    @NamedQuery(name = "Maquina.findByMaqEstadoFunc", query = "SELECT m FROM Maquina m WHERE m.maqEstadoFunc = :maqEstadoFunc"),
    @NamedQuery(name = "Maquina.findByMaqEstado", query = "SELECT m FROM Maquina m WHERE m.maqEstado = :maqEstado")})
public class Maquina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maq_id")
    private Short maqId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "maq_descripcion")
    private String maqDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maq_estado_func")
    private boolean maqEstadoFunc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maq_estado")
    private boolean maqEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maqEmeMaq", fetch = FetchType.LAZY)
    private Collection<MaquinaEmergencia> maquinaEmergenciaCollection;

    public Maquina() {
    }

    public Maquina(Short maqId) {
        this.maqId = maqId;
    }

    public Maquina(Short maqId, String maqDescripcion, boolean maqEstadoFunc, boolean maqEstado) {
        this.maqId = maqId;
        this.maqDescripcion = maqDescripcion;
        this.maqEstadoFunc = maqEstadoFunc;
        this.maqEstado = maqEstado;
    }

    public Short getMaqId() {
        return maqId;
    }

    public void setMaqId(Short maqId) {
        this.maqId = maqId;
    }

    public String getMaqDescripcion() {
        return maqDescripcion;
    }

    public void setMaqDescripcion(String maqDescripcion) {
        this.maqDescripcion = maqDescripcion;
    }

    public boolean getMaqEstadoFunc() {
        return maqEstadoFunc;
    }

    public void setMaqEstadoFunc(boolean maqEstadoFunc) {
        this.maqEstadoFunc = maqEstadoFunc;
    }

    public boolean getMaqEstado() {
        return maqEstado;
    }

    public void setMaqEstado(boolean maqEstado) {
        this.maqEstado = maqEstado;
    }

    @XmlTransient
    public Collection<MaquinaEmergencia> getMaquinaEmergenciaCollection() {
        return maquinaEmergenciaCollection;
    }

    public void setMaquinaEmergenciaCollection(Collection<MaquinaEmergencia> maquinaEmergenciaCollection) {
        this.maquinaEmergenciaCollection = maquinaEmergenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maqId != null ? maqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquina)) {
            return false;
        }
        Maquina other = (Maquina) object;
        if ((this.maqId == null && other.maqId != null) || (this.maqId != null && !this.maqId.equals(other.maqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Maquina[ maqId=" + maqId + " ]";
    }
    
}
