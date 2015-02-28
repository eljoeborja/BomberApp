/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "accidente_transito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccidenteTransito.findAll", query = "SELECT a FROM AccidenteTransito a"),
    @NamedQuery(name = "AccidenteTransito.findByAccId", query = "SELECT a FROM AccidenteTransito a WHERE a.accId = :accId"),
    @NamedQuery(name = "AccidenteTransito.findByAccColisionObjMov", query = "SELECT a FROM AccidenteTransito a WHERE a.accColisionObjMov = :accColisionObjMov"),
    @NamedQuery(name = "AccidenteTransito.findByAccColisionObjFijo", query = "SELECT a FROM AccidenteTransito a WHERE a.accColisionObjFijo = :accColisionObjFijo"),
    @NamedQuery(name = "AccidenteTransito.findByAccVolcamiento", query = "SELECT a FROM AccidenteTransito a WHERE a.accVolcamiento = :accVolcamiento"),
    @NamedQuery(name = "AccidenteTransito.findByAccPeatonAtropellado", query = "SELECT a FROM AccidenteTransito a WHERE a.accPeatonAtropellado = :accPeatonAtropellado"),
    @NamedQuery(name = "AccidenteTransito.findByAccCiclistaAtropellado", query = "SELECT a FROM AccidenteTransito a WHERE a.accCiclistaAtropellado = :accCiclistaAtropellado")})
public class AccidenteTransito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "acc_id")
    private String accId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "acc_descripcion")
    private String accDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acc_colision_obj_mov")
    private boolean accColisionObjMov;
    @Column(name = "acc_colision_obj_fijo")
    private Boolean accColisionObjFijo;
    @Column(name = "acc_volcamiento")
    private Boolean accVolcamiento;
    @Column(name = "acc_peaton_atropellado")
    private Boolean accPeatonAtropellado;
    @Column(name = "acc_ciclista_atropellado")
    private Boolean accCiclistaAtropellado;
    @Lob
    @Size(max = 65535)
    @Column(name = "acc_descripcion_otros")
    private String accDescripcionOtros;
    @JoinColumn(name = "acc_eme_id", referencedColumnName = "eme_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Emergencia accEmeId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vehcomAccId", fetch = FetchType.LAZY)
    private VehiculoComprometido vehiculoComprometido;
    @OneToOne(mappedBy = "vicAccId", fetch = FetchType.LAZY)
    private VictimaAccidente victimaAccidente;

    public AccidenteTransito() {
    }

    public AccidenteTransito(String accId) {
        this.accId = accId;
    }

    public AccidenteTransito(String accId, String accDescripcion, boolean accColisionObjMov) {
        this.accId = accId;
        this.accDescripcion = accDescripcion;
        this.accColisionObjMov = accColisionObjMov;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getAccDescripcion() {
        return accDescripcion;
    }

    public void setAccDescripcion(String accDescripcion) {
        this.accDescripcion = accDescripcion;
    }

    public boolean getAccColisionObjMov() {
        return accColisionObjMov;
    }

    public void setAccColisionObjMov(boolean accColisionObjMov) {
        this.accColisionObjMov = accColisionObjMov;
    }

    public Boolean getAccColisionObjFijo() {
        return accColisionObjFijo;
    }

    public void setAccColisionObjFijo(Boolean accColisionObjFijo) {
        this.accColisionObjFijo = accColisionObjFijo;
    }

    public Boolean getAccVolcamiento() {
        return accVolcamiento;
    }

    public void setAccVolcamiento(Boolean accVolcamiento) {
        this.accVolcamiento = accVolcamiento;
    }

    public Boolean getAccPeatonAtropellado() {
        return accPeatonAtropellado;
    }

    public void setAccPeatonAtropellado(Boolean accPeatonAtropellado) {
        this.accPeatonAtropellado = accPeatonAtropellado;
    }

    public Boolean getAccCiclistaAtropellado() {
        return accCiclistaAtropellado;
    }

    public void setAccCiclistaAtropellado(Boolean accCiclistaAtropellado) {
        this.accCiclistaAtropellado = accCiclistaAtropellado;
    }

    public String getAccDescripcionOtros() {
        return accDescripcionOtros;
    }

    public void setAccDescripcionOtros(String accDescripcionOtros) {
        this.accDescripcionOtros = accDescripcionOtros;
    }

    public Emergencia getAccEmeId() {
        return accEmeId;
    }

    public void setAccEmeId(Emergencia accEmeId) {
        this.accEmeId = accEmeId;
    }

    public VehiculoComprometido getVehiculoComprometido() {
        return vehiculoComprometido;
    }

    public void setVehiculoComprometido(VehiculoComprometido vehiculoComprometido) {
        this.vehiculoComprometido = vehiculoComprometido;
    }

    public VictimaAccidente getVictimaAccidente() {
        return victimaAccidente;
    }

    public void setVictimaAccidente(VictimaAccidente victimaAccidente) {
        this.victimaAccidente = victimaAccidente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accId != null ? accId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccidenteTransito)) {
            return false;
        }
        AccidenteTransito other = (AccidenteTransito) object;
        if ((this.accId == null && other.accId != null) || (this.accId != null && !this.accId.equals(other.accId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccidenteTransito[ accId=" + accId + " ]";
    }
    
}
