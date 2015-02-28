/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BuRr0X
 */
@Entity
@Table(name = "victima_accidente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VictimaAccidente.findAll", query = "SELECT v FROM VictimaAccidente v"),
    @NamedQuery(name = "VictimaAccidente.findByVicId", query = "SELECT v FROM VictimaAccidente v WHERE v.vicId = :vicId"),
    @NamedQuery(name = "VictimaAccidente.findByVicEstado", query = "SELECT v FROM VictimaAccidente v WHERE v.vicEstado = :vicEstado")})
public class VictimaAccidente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "vic_id")
    private String vicId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vic_estado")
    private boolean vicEstado;
    @JoinColumn(name = "vic_per_id", referencedColumnName = "per_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Persona vicPerId;
    @JoinColumn(name = "vic_acc_id", referencedColumnName = "acc_id")
    @OneToOne(fetch = FetchType.LAZY)
    private AccidenteTransito vicAccId;

    public VictimaAccidente() {
    }

    public VictimaAccidente(String vicId) {
        this.vicId = vicId;
    }

    public VictimaAccidente(String vicId, boolean vicEstado) {
        this.vicId = vicId;
        this.vicEstado = vicEstado;
    }

    public String getVicId() {
        return vicId;
    }

    public void setVicId(String vicId) {
        this.vicId = vicId;
    }

    public boolean getVicEstado() {
        return vicEstado;
    }

    public void setVicEstado(boolean vicEstado) {
        this.vicEstado = vicEstado;
    }

    public Persona getVicPerId() {
        return vicPerId;
    }

    public void setVicPerId(Persona vicPerId) {
        this.vicPerId = vicPerId;
    }

    public AccidenteTransito getVicAccId() {
        return vicAccId;
    }

    public void setVicAccId(AccidenteTransito vicAccId) {
        this.vicAccId = vicAccId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vicId != null ? vicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VictimaAccidente)) {
            return false;
        }
        VictimaAccidente other = (VictimaAccidente) object;
        if ((this.vicId == null && other.vicId != null) || (this.vicId != null && !this.vicId.equals(other.vicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VictimaAccidente[ vicId=" + vicId + " ]";
    }
    
}
