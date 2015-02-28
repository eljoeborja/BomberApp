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
@Table(name = "costo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costo.findAll", query = "SELECT c FROM Costo c"),
    @NamedQuery(name = "Costo.findByCostoId", query = "SELECT c FROM Costo c WHERE c.costoId = :costoId"),
    @NamedQuery(name = "Costo.findByCostoCombustible", query = "SELECT c FROM Costo c WHERE c.costoCombustible = :costoCombustible"),
    @NamedQuery(name = "Costo.findByCostoGalones", query = "SELECT c FROM Costo c WHERE c.costoGalones = :costoGalones"),
    @NamedQuery(name = "Costo.findByCostoAlimentos", query = "SELECT c FROM Costo c WHERE c.costoAlimentos = :costoAlimentos"),
    @NamedQuery(name = "Costo.findByCostoDanos", query = "SELECT c FROM Costo c WHERE c.costoDanos = :costoDanos"),
    @NamedQuery(name = "Costo.findByCostoOtros", query = "SELECT c FROM Costo c WHERE c.costoOtros = :costoOtros"),
    @NamedQuery(name = "Costo.findByCostoTotal", query = "SELECT c FROM Costo c WHERE c.costoTotal = :costoTotal")})
public class Costo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "costo_id")
    private String costoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_combustible")
    private double costoCombustible;
    @Column(name = "costo_galones")
    private Integer costoGalones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_alimentos")
    private Double costoAlimentos;
    @Column(name = "costo_danos")
    private Double costoDanos;
    @Lob
    @Size(max = 65535)
    @Column(name = "costo_otrosdes")
    private String costoOtrosdes;
    @Column(name = "costo_otros")
    private Double costoOtros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_total")
    private double costoTotal;
    @Lob
    @Size(max = 65535)
    @Column(name = "costo_observaciones")
    private String costoObservaciones;
    @JoinColumn(name = "costo_eme_id", referencedColumnName = "eme_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Emergencia costoEmeId;

    public Costo() {
    }

    public Costo(String costoId) {
        this.costoId = costoId;
    }

    public Costo(String costoId, double costoCombustible, double costoTotal) {
        this.costoId = costoId;
        this.costoCombustible = costoCombustible;
        this.costoTotal = costoTotal;
    }

    public String getCostoId() {
        return costoId;
    }

    public void setCostoId(String costoId) {
        this.costoId = costoId;
    }

    public double getCostoCombustible() {
        return costoCombustible;
    }

    public void setCostoCombustible(double costoCombustible) {
        this.costoCombustible = costoCombustible;
    }

    public Integer getCostoGalones() {
        return costoGalones;
    }

    public void setCostoGalones(Integer costoGalones) {
        this.costoGalones = costoGalones;
    }

    public Double getCostoAlimentos() {
        return costoAlimentos;
    }

    public void setCostoAlimentos(Double costoAlimentos) {
        this.costoAlimentos = costoAlimentos;
    }

    public Double getCostoDanos() {
        return costoDanos;
    }

    public void setCostoDanos(Double costoDanos) {
        this.costoDanos = costoDanos;
    }

    public String getCostoOtrosdes() {
        return costoOtrosdes;
    }

    public void setCostoOtrosdes(String costoOtrosdes) {
        this.costoOtrosdes = costoOtrosdes;
    }

    public Double getCostoOtros() {
        return costoOtros;
    }

    public void setCostoOtros(Double costoOtros) {
        this.costoOtros = costoOtros;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getCostoObservaciones() {
        return costoObservaciones;
    }

    public void setCostoObservaciones(String costoObservaciones) {
        this.costoObservaciones = costoObservaciones;
    }

    public Emergencia getCostoEmeId() {
        return costoEmeId;
    }

    public void setCostoEmeId(Emergencia costoEmeId) {
        this.costoEmeId = costoEmeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (costoId != null ? costoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costo)) {
            return false;
        }
        Costo other = (Costo) object;
        if ((this.costoId == null && other.costoId != null) || (this.costoId != null && !this.costoId.equals(other.costoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Costo[ costoId=" + costoId + " ]";
    }
    
}
