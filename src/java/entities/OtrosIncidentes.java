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
@Table(name = "otros_incidentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OtrosIncidentes.findAll", query = "SELECT o FROM OtrosIncidentes o"),
    @NamedQuery(name = "OtrosIncidentes.findByOtrId", query = "SELECT o FROM OtrosIncidentes o WHERE o.otrId = :otrId"),
    @NamedQuery(name = "OtrosIncidentes.findByOtrClaseIncidente", query = "SELECT o FROM OtrosIncidentes o WHERE o.otrClaseIncidente = :otrClaseIncidente"),
    @NamedQuery(name = "OtrosIncidentes.findByOtrInmueble", query = "SELECT o FROM OtrosIncidentes o WHERE o.otrInmueble = :otrInmueble"),
    @NamedQuery(name = "OtrosIncidentes.findByOtrCantAfectados", query = "SELECT o FROM OtrosIncidentes o WHERE o.otrCantAfectados = :otrCantAfectados")})
public class OtrosIncidentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "otr_id")
    private String otrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "otr_clase_incidente")
    private String otrClaseIncidente;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "otr_danos")
    private String otrDanos;
    @Column(name = "otr_inmueble")
    private Integer otrInmueble;
    @Lob
    @Size(max = 65535)
    @Column(name = "otr_muebles")
    private String otrMuebles;
    @Column(name = "otr_cant_afectados")
    private Integer otrCantAfectados;
    @Lob
    @Size(max = 65535)
    @Column(name = "otr_observaciones")
    private String otrObservaciones;
    @JoinColumn(name = "otr_eme_id", referencedColumnName = "eme_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Emergencia otrEmeId;

    public OtrosIncidentes() {
    }

    public OtrosIncidentes(String otrId) {
        this.otrId = otrId;
    }

    public OtrosIncidentes(String otrId, String otrClaseIncidente, String otrDanos) {
        this.otrId = otrId;
        this.otrClaseIncidente = otrClaseIncidente;
        this.otrDanos = otrDanos;
    }

    public String getOtrId() {
        return otrId;
    }

    public void setOtrId(String otrId) {
        this.otrId = otrId;
    }

    public String getOtrClaseIncidente() {
        return otrClaseIncidente;
    }

    public void setOtrClaseIncidente(String otrClaseIncidente) {
        this.otrClaseIncidente = otrClaseIncidente;
    }

    public String getOtrDanos() {
        return otrDanos;
    }

    public void setOtrDanos(String otrDanos) {
        this.otrDanos = otrDanos;
    }

    public Integer getOtrInmueble() {
        return otrInmueble;
    }

    public void setOtrInmueble(Integer otrInmueble) {
        this.otrInmueble = otrInmueble;
    }

    public String getOtrMuebles() {
        return otrMuebles;
    }

    public void setOtrMuebles(String otrMuebles) {
        this.otrMuebles = otrMuebles;
    }

    public Integer getOtrCantAfectados() {
        return otrCantAfectados;
    }

    public void setOtrCantAfectados(Integer otrCantAfectados) {
        this.otrCantAfectados = otrCantAfectados;
    }

    public String getOtrObservaciones() {
        return otrObservaciones;
    }

    public void setOtrObservaciones(String otrObservaciones) {
        this.otrObservaciones = otrObservaciones;
    }

    public Emergencia getOtrEmeId() {
        return otrEmeId;
    }

    public void setOtrEmeId(Emergencia otrEmeId) {
        this.otrEmeId = otrEmeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (otrId != null ? otrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OtrosIncidentes)) {
            return false;
        }
        OtrosIncidentes other = (OtrosIncidentes) object;
        if ((this.otrId == null && other.otrId != null) || (this.otrId != null && !this.otrId.equals(other.otrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OtrosIncidentes[ otrId=" + otrId + " ]";
    }
    
}
