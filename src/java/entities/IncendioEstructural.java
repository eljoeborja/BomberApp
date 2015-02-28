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
@Table(name = "incendio_estructural")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IncendioEstructural.findAll", query = "SELECT i FROM IncendioEstructural i"),
    @NamedQuery(name = "IncendioEstructural.findByInceId", query = "SELECT i FROM IncendioEstructural i WHERE i.inceId = :inceId"),
    @NamedQuery(name = "IncendioEstructural.findByInceDanosm", query = "SELECT i FROM IncendioEstructural i WHERE i.inceDanosm = :inceDanosm"),
    @NamedQuery(name = "IncendioEstructural.findByInceInmueble", query = "SELECT i FROM IncendioEstructural i WHERE i.inceInmueble = :inceInmueble"),
    @NamedQuery(name = "IncendioEstructural.findByInceMuebles", query = "SELECT i FROM IncendioEstructural i WHERE i.inceMuebles = :inceMuebles"),
    @NamedQuery(name = "IncendioEstructural.findByInceCanAfectadas", query = "SELECT i FROM IncendioEstructural i WHERE i.inceCanAfectadas = :inceCanAfectadas")})
public class IncendioEstructural implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ince_id")
    private String inceId;
    @Size(max = 250)
    @Column(name = "ince_danosm")
    private String inceDanosm;
    @Size(max = 250)
    @Column(name = "ince_inmueble")
    private String inceInmueble;
    @Size(max = 250)
    @Column(name = "ince_muebles")
    private String inceMuebles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ince_can_afectadas")
    private int inceCanAfectadas;
    @Lob
    @Size(max = 65535)
    @Column(name = "ince_observaciones")
    private String inceObservaciones;
    @JoinColumn(name = "ince_eme_id", referencedColumnName = "eme_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Emergencia inceEmeId;

    public IncendioEstructural() {
    }

    public IncendioEstructural(String inceId) {
        this.inceId = inceId;
    }

    public IncendioEstructural(String inceId, int inceCanAfectadas) {
        this.inceId = inceId;
        this.inceCanAfectadas = inceCanAfectadas;
    }

    public String getInceId() {
        return inceId;
    }

    public void setInceId(String inceId) {
        this.inceId = inceId;
    }

    public String getInceDanosm() {
        return inceDanosm;
    }

    public void setInceDanosm(String inceDanosm) {
        this.inceDanosm = inceDanosm;
    }

    public String getInceInmueble() {
        return inceInmueble;
    }

    public void setInceInmueble(String inceInmueble) {
        this.inceInmueble = inceInmueble;
    }

    public String getInceMuebles() {
        return inceMuebles;
    }

    public void setInceMuebles(String inceMuebles) {
        this.inceMuebles = inceMuebles;
    }

    public int getInceCanAfectadas() {
        return inceCanAfectadas;
    }

    public void setInceCanAfectadas(int inceCanAfectadas) {
        this.inceCanAfectadas = inceCanAfectadas;
    }

    public String getInceObservaciones() {
        return inceObservaciones;
    }

    public void setInceObservaciones(String inceObservaciones) {
        this.inceObservaciones = inceObservaciones;
    }

    public Emergencia getInceEmeId() {
        return inceEmeId;
    }

    public void setInceEmeId(Emergencia inceEmeId) {
        this.inceEmeId = inceEmeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inceId != null ? inceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncendioEstructural)) {
            return false;
        }
        IncendioEstructural other = (IncendioEstructural) object;
        if ((this.inceId == null && other.inceId != null) || (this.inceId != null && !this.inceId.equals(other.inceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.IncendioEstructural[ inceId=" + inceId + " ]";
    }
    
}
