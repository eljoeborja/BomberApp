
package entities;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BuRr0X
 */
@Entity
@Table(name = "material_utilizado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialUtilizado.findAll", query = "SELECT m FROM MaterialUtilizado m"),
    @NamedQuery(name = "MaterialUtilizado.findByMatUtiId", query = "SELECT m FROM MaterialUtilizado m WHERE m.matUtiId = :matUtiId"),
    @NamedQuery(name = "MaterialUtilizado.findByMatUtiCant", query = "SELECT m FROM MaterialUtilizado m WHERE m.matUtiCant = :matUtiCant"),
    @NamedQuery(name = "MaterialUtilizado.findByMatUtiEstado", query = "SELECT m FROM MaterialUtilizado m WHERE m.matUtiEstado = :matUtiEstado")})
public class MaterialUtilizado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "mat_uti_id")
    private String matUtiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_uti_cant")
    private int matUtiCant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_uti_estado")
    private boolean matUtiEstado;
    @JoinColumn(name = "mat_uti_eme_id", referencedColumnName = "eme_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Emergencia matUtiEmeId;
    @JoinColumn(name = "mat_uti_mat", referencedColumnName = "mat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Material matUtiMat;

    public MaterialUtilizado() {
    }

    public MaterialUtilizado(String matUtiId) {
        this.matUtiId = matUtiId;
    }

    public MaterialUtilizado(String matUtiId, int matUtiCant, boolean matUtiEstado) {
        this.matUtiId = matUtiId;
        this.matUtiCant = matUtiCant;
        this.matUtiEstado = matUtiEstado;
    }

    public String getMatUtiId() {
        return matUtiId;
    }

    public void setMatUtiId(String matUtiId) {
        this.matUtiId = matUtiId;
    }

    public int getMatUtiCant() {
        return matUtiCant;
    }

    public void setMatUtiCant(int matUtiCant) {
        this.matUtiCant = matUtiCant;
    }

    public boolean getMatUtiEstado() {
        return matUtiEstado;
    }

    public void setMatUtiEstado(boolean matUtiEstado) {
        this.matUtiEstado = matUtiEstado;
    }

    public Emergencia getMatUtiEmeId() {
        return matUtiEmeId;
    }

    public void setMatUtiEmeId(Emergencia matUtiEmeId) {
        this.matUtiEmeId = matUtiEmeId;
    }

    public Material getMatUtiMat() {
        return matUtiMat;
    }

    public void setMatUtiMat(Material matUtiMat) {
        this.matUtiMat = matUtiMat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matUtiId != null ? matUtiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialUtilizado)) {
            return false;
        }
        MaterialUtilizado other = (MaterialUtilizado) object;
        return !((this.matUtiId == null && other.matUtiId != null) || (this.matUtiId != null && !this.matUtiId.equals(other.matUtiId)));
    }

    @Override
    public String toString() {
        return "entities.MaterialUtilizado[ matUtiId=" + matUtiId + " ]";
    }
    
}
