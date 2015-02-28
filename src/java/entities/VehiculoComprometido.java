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
@Table(name = "vehiculo_comprometido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiculoComprometido.findAll", query = "SELECT v FROM VehiculoComprometido v"),
    @NamedQuery(name = "VehiculoComprometido.findByVehcomId", query = "SELECT v FROM VehiculoComprometido v WHERE v.vehcomId = :vehcomId")})
public class VehiculoComprometido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "vehcom_id")
    private String vehcomId;
    @JoinColumn(name = "vehcom_acc_id", referencedColumnName = "acc_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private AccidenteTransito vehcomAccId;
    @JoinColumn(name = "vehcom_veh_id", referencedColumnName = "veh_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo vehcomVehId;

    public VehiculoComprometido() {
    }

    public VehiculoComprometido(String vehcomId) {
        this.vehcomId = vehcomId;
    }

    public String getVehcomId() {
        return vehcomId;
    }

    public void setVehcomId(String vehcomId) {
        this.vehcomId = vehcomId;
    }

    public AccidenteTransito getVehcomAccId() {
        return vehcomAccId;
    }

    public void setVehcomAccId(AccidenteTransito vehcomAccId) {
        this.vehcomAccId = vehcomAccId;
    }

    public Vehiculo getVehcomVehId() {
        return vehcomVehId;
    }

    public void setVehcomVehId(Vehiculo vehcomVehId) {
        this.vehcomVehId = vehcomVehId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehcomId != null ? vehcomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoComprometido)) {
            return false;
        }
        VehiculoComprometido other = (VehiculoComprometido) object;
        if ((this.vehcomId == null && other.vehcomId != null) || (this.vehcomId != null && !this.vehcomId.equals(other.vehcomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VehiculoComprometido[ vehcomId=" + vehcomId + " ]";
    }
    
}
