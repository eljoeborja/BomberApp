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
@Table(name = "incendio_forestal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IncendioForestal.findAll", query = "SELECT i FROM IncendioForestal i"),
    @NamedQuery(name = "IncendioForestal.findByIncfId", query = "SELECT i FROM IncendioForestal i WHERE i.incfId = :incfId"),
    @NamedQuery(name = "IncendioForestal.findByIncfArea", query = "SELECT i FROM IncendioForestal i WHERE i.incfArea = :incfArea"),
    @NamedQuery(name = "IncendioForestal.findByIncfTipoArea", query = "SELECT i FROM IncendioForestal i WHERE i.incfTipoArea = :incfTipoArea"),
    @NamedQuery(name = "IncendioForestal.findByIncfOtro", query = "SELECT i FROM IncendioForestal i WHERE i.incfOtro = :incfOtro"),
    @NamedQuery(name = "IncendioForestal.findByIncfCanAfectados", query = "SELECT i FROM IncendioForestal i WHERE i.incfCanAfectados = :incfCanAfectados")})
public class IncendioForestal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "incf_id")
    private String incfId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "incf_area")
    private String incfArea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "incf_tipo_area")
    private int incfTipoArea;
    @Size(max = 50)
    @Column(name = "incf_otro")
    private String incfOtro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "incf_can_afectados")
    private int incfCanAfectados;
    @Lob
    @Size(max = 65535)
    @Column(name = "incf_observaciones")
    private String incfObservaciones;
    @JoinColumn(name = "incf_eme_id", referencedColumnName = "eme_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Emergencia incfEmeId;

    public IncendioForestal() {
    }

    public IncendioForestal(String incfId) {
        this.incfId = incfId;
    }

    public IncendioForestal(String incfId, String incfArea, int incfTipoArea, int incfCanAfectados) {
        this.incfId = incfId;
        this.incfArea = incfArea;
        this.incfTipoArea = incfTipoArea;
        this.incfCanAfectados = incfCanAfectados;
    }

    public String getIncfId() {
        return incfId;
    }

    public void setIncfId(String incfId) {
        this.incfId = incfId;
    }

    public String getIncfArea() {
        return incfArea;
    }

    public void setIncfArea(String incfArea) {
        this.incfArea = incfArea;
    }

    public int getIncfTipoArea() {
        return incfTipoArea;
    }

    public void setIncfTipoArea(int incfTipoArea) {
        this.incfTipoArea = incfTipoArea;
    }

    public String getIncfOtro() {
        return incfOtro;
    }

    public void setIncfOtro(String incfOtro) {
        this.incfOtro = incfOtro;
    }

    public int getIncfCanAfectados() {
        return incfCanAfectados;
    }

    public void setIncfCanAfectados(int incfCanAfectados) {
        this.incfCanAfectados = incfCanAfectados;
    }

    public String getIncfObservaciones() {
        return incfObservaciones;
    }

    public void setIncfObservaciones(String incfObservaciones) {
        this.incfObservaciones = incfObservaciones;
    }

    public Emergencia getIncfEmeId() {
        return incfEmeId;
    }

    public void setIncfEmeId(Emergencia incfEmeId) {
        this.incfEmeId = incfEmeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incfId != null ? incfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncendioForestal)) {
            return false;
        }
        IncendioForestal other = (IncendioForestal) object;
        if ((this.incfId == null && other.incfId != null) || (this.incfId != null && !this.incfId.equals(other.incfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.IncendioForestal[ incfId=" + incfId + " ]";
    }
    
}
