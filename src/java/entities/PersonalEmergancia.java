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
@Table(name = "personal_emergancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalEmergancia.findAll", query = "SELECT p FROM PersonalEmergancia p"),
    @NamedQuery(name = "PersonalEmergancia.findByPeremeId", query = "SELECT p FROM PersonalEmergancia p WHERE p.peremeId = :peremeId")})
public class PersonalEmergancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pereme_id")
    private String peremeId;
    @JoinColumn(name = "pereme_em_id", referencedColumnName = "eme_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Emergencia peremeEmId;
    @JoinColumn(name = "pereme_npid", referencedColumnName = "uni_npib")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Unidad peremeNpid;

    public PersonalEmergancia() {
    }

    public PersonalEmergancia(String peremeId) {
        this.peremeId = peremeId;
    }

    public String getPeremeId() {
        return peremeId;
    }

    public void setPeremeId(String peremeId) {
        this.peremeId = peremeId;
    }

    public Emergencia getPeremeEmId() {
        return peremeEmId;
    }

    public void setPeremeEmId(Emergencia peremeEmId) {
        this.peremeEmId = peremeEmId;
    }

    public Unidad getPeremeNpid() {
        return peremeNpid;
    }

    public void setPeremeNpid(Unidad peremeNpid) {
        this.peremeNpid = peremeNpid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peremeId != null ? peremeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalEmergancia)) {
            return false;
        }
        PersonalEmergancia other = (PersonalEmergancia) object;
        if ((this.peremeId == null && other.peremeId != null) || (this.peremeId != null && !this.peremeId.equals(other.peremeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PersonalEmergancia[ peremeId=" + peremeId + " ]";
    }
    
}
