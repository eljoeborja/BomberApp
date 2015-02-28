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
@Table(name = "inundacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inundacion.findAll", query = "SELECT i FROM Inundacion i"),
    @NamedQuery(name = "Inundacion.findByInuId", query = "SELECT i FROM Inundacion i WHERE i.inuId = :inuId"),
    @NamedQuery(name = "Inundacion.findByInuArea", query = "SELECT i FROM Inundacion i WHERE i.inuArea = :inuArea"),
    @NamedQuery(name = "Inundacion.findByInuCantInmuebles", query = "SELECT i FROM Inundacion i WHERE i.inuCantInmuebles = :inuCantInmuebles"),
    @NamedQuery(name = "Inundacion.findByInuCantAfectados", query = "SELECT i FROM Inundacion i WHERE i.inuCantAfectados = :inuCantAfectados")})
public class Inundacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "inu_id")
    private String inuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inu_area")
    private double inuArea;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "inu_danos")
    private String inuDanos;
    @Column(name = "inu_cant_inmuebles")
    private Integer inuCantInmuebles;
    @Lob
    @Size(max = 65535)
    @Column(name = "inu_muebles")
    private String inuMuebles;
    @Column(name = "inu_cant_afectados")
    private Integer inuCantAfectados;
    @Lob
    @Size(max = 65535)
    @Column(name = "inu_observaciones")
    private String inuObservaciones;
    @JoinColumn(name = "inu_eme_id", referencedColumnName = "eme_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Emergencia inuEmeId;

    public Inundacion() {
    }

    public Inundacion(String inuId) {
        this.inuId = inuId;
    }

    public Inundacion(String inuId, double inuArea, String inuDanos) {
        this.inuId = inuId;
        this.inuArea = inuArea;
        this.inuDanos = inuDanos;
    }

    public String getInuId() {
        return inuId;
    }

    public void setInuId(String inuId) {
        this.inuId = inuId;
    }

    public double getInuArea() {
        return inuArea;
    }

    public void setInuArea(double inuArea) {
        this.inuArea = inuArea;
    }

    public String getInuDanos() {
        return inuDanos;
    }

    public void setInuDanos(String inuDanos) {
        this.inuDanos = inuDanos;
    }

    public Integer getInuCantInmuebles() {
        return inuCantInmuebles;
    }

    public void setInuCantInmuebles(Integer inuCantInmuebles) {
        this.inuCantInmuebles = inuCantInmuebles;
    }

    public String getInuMuebles() {
        return inuMuebles;
    }

    public void setInuMuebles(String inuMuebles) {
        this.inuMuebles = inuMuebles;
    }

    public Integer getInuCantAfectados() {
        return inuCantAfectados;
    }

    public void setInuCantAfectados(Integer inuCantAfectados) {
        this.inuCantAfectados = inuCantAfectados;
    }

    public String getInuObservaciones() {
        return inuObservaciones;
    }

    public void setInuObservaciones(String inuObservaciones) {
        this.inuObservaciones = inuObservaciones;
    }

    public Emergencia getInuEmeId() {
        return inuEmeId;
    }

    public void setInuEmeId(Emergencia inuEmeId) {
        this.inuEmeId = inuEmeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inuId != null ? inuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inundacion)) {
            return false;
        }
        Inundacion other = (Inundacion) object;
        if ((this.inuId == null && other.inuId != null) || (this.inuId != null && !this.inuId.equals(other.inuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Inundacion[ inuId=" + inuId + " ]";
    }
    
}
