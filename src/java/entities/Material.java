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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByMatId", query = "SELECT m FROM Material m WHERE m.matId = :matId"),
    @NamedQuery(name = "Material.findByMatDescripcion", query = "SELECT m FROM Material m WHERE m.matDescripcion = :matDescripcion"),
    @NamedQuery(name = "Material.findByMatTipo", query = "SELECT m FROM Material m WHERE m.matTipo = :matTipo"),
    @NamedQuery(name = "Material.findByMatEstado", query = "SELECT m FROM Material m WHERE m.matEstado = :matEstado")})
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mat_id")
    private Integer matId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "mat_descripcion")
    private String matDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "mat_tipo")
    private String matTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_estado")
    private boolean matEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matUtiMat", fetch = FetchType.LAZY)
    private Collection<MaterialUtilizado> materialUtilizadoCollection;

    public Material() {
    }

    public Material(Integer matId) {
        this.matId = matId;
    }

    public Material(Integer matId, String matDescripcion, String matTipo, boolean matEstado) {
        this.matId = matId;
        this.matDescripcion = matDescripcion;
        this.matTipo = matTipo;
        this.matEstado = matEstado;
    }

    public Integer getMatId() {
        return matId;
    }

    public void setMatId(Integer matId) {
        this.matId = matId;
    }

    public String getMatDescripcion() {
        return matDescripcion;
    }

    public void setMatDescripcion(String matDescripcion) {
        this.matDescripcion = matDescripcion;
    }

    public String getMatTipo() {
        return matTipo;
    }

    public void setMatTipo(String matTipo) {
        this.matTipo = matTipo;
    }

    public boolean getMatEstado() {
        return matEstado;
    }

    public void setMatEstado(boolean matEstado) {
        this.matEstado = matEstado;
    }

    @XmlTransient
    public Collection<MaterialUtilizado> getMaterialUtilizadoCollection() {
        return materialUtilizadoCollection;
    }

    public void setMaterialUtilizadoCollection(Collection<MaterialUtilizado> materialUtilizadoCollection) {
        this.materialUtilizadoCollection = materialUtilizadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matId != null ? matId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.matId == null && other.matId != null) || (this.matId != null && !this.matId.equals(other.matId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Material[ matId=" + matId + " ]";
    }
    
}
