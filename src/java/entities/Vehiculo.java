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
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByVehId", query = "SELECT v FROM Vehiculo v WHERE v.vehId = :vehId"),
    @NamedQuery(name = "Vehiculo.findByVehClase", query = "SELECT v FROM Vehiculo v WHERE v.vehClase = :vehClase"),
    @NamedQuery(name = "Vehiculo.findByVehPlaca", query = "SELECT v FROM Vehiculo v WHERE v.vehPlaca = :vehPlaca"),
    @NamedQuery(name = "Vehiculo.findByVehModelo", query = "SELECT v FROM Vehiculo v WHERE v.vehModelo = :vehModelo"),
    @NamedQuery(name = "Vehiculo.findByVehPropietario", query = "SELECT v FROM Vehiculo v WHERE v.vehPropietario = :vehPropietario"),
    @NamedQuery(name = "Vehiculo.findByVehSoat", query = "SELECT v FROM Vehiculo v WHERE v.vehSoat = :vehSoat"),
    @NamedQuery(name = "Vehiculo.findByVehServicio", query = "SELECT v FROM Vehiculo v WHERE v.vehServicio = :vehServicio"),
    @NamedQuery(name = "Vehiculo.findByVahMarca", query = "SELECT v FROM Vehiculo v WHERE v.vahMarca = :vahMarca"),
    @NamedQuery(name = "Vehiculo.findByVehEmpresa", query = "SELECT v FROM Vehiculo v WHERE v.vehEmpresa = :vehEmpresa"),
    @NamedQuery(name = "Vehiculo.findByVehConductor", query = "SELECT v FROM Vehiculo v WHERE v.vehConductor = :vehConductor"),
    @NamedQuery(name = "Vehiculo.findByVehCompaniaSeguro", query = "SELECT v FROM Vehiculo v WHERE v.vehCompaniaSeguro = :vehCompaniaSeguro"),
    @NamedQuery(name = "Vehiculo.findByVehEstado", query = "SELECT v FROM Vehiculo v WHERE v.vehEstado = :vehEstado")})
public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "veh_id")
    private String vehId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "veh_clase")
    private String vehClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "veh_placa")
    private String vehPlaca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "veh_modelo")
    private String vehModelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "veh_propietario")
    private String vehPropietario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "veh_soat")
    private String vehSoat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "veh_servicio")
    private String vehServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vah_marca")
    private String vahMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "veh_empresa")
    private String vehEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "veh_conductor")
    private String vehConductor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "veh_compania_seguro")
    private String vehCompaniaSeguro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "veh_estado")
    private boolean vehEstado;
    
    public Vehiculo() {
    }

    public Vehiculo(String vehId) {
        this.vehId = vehId;
    }

    public Vehiculo(String vehId, String vehClase, String vehPlaca, String vehModelo, String vehPropietario, String vehSoat, String vehServicio, String vahMarca, String vehEmpresa, String vehConductor, String vehCompaniaSeguro, boolean vehEstado) {
        this.vehId = vehId;
        this.vehClase = vehClase;
        this.vehPlaca = vehPlaca;
        this.vehModelo = vehModelo;
        this.vehPropietario = vehPropietario;
        this.vehSoat = vehSoat;
        this.vehServicio = vehServicio;
        this.vahMarca = vahMarca;
        this.vehEmpresa = vehEmpresa;
        this.vehConductor = vehConductor;
        this.vehCompaniaSeguro = vehCompaniaSeguro;
        this.vehEstado = vehEstado;
    }

    public String getVehId() {
        return vehId;
    }

    public void setVehId(String vehId) {
        this.vehId = vehId;
    }

    public String getVehClase() {
        return vehClase;
    }

    public void setVehClase(String vehClase) {
        this.vehClase = vehClase;
    }

    public String getVehPlaca() {
        return vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }

    public String getVehModelo() {
        return vehModelo;
    }

    public void setVehModelo(String vehModelo) {
        this.vehModelo = vehModelo;
    }

    public String getVehPropietario() {
        return vehPropietario;
    }

    public void setVehPropietario(String vehPropietario) {
        this.vehPropietario = vehPropietario;
    }

    public String getVehSoat() {
        return vehSoat;
    }

    public void setVehSoat(String vehSoat) {
        this.vehSoat = vehSoat;
    }

    public String getVehServicio() {
        return vehServicio;
    }

    public void setVehServicio(String vehServicio) {
        this.vehServicio = vehServicio;
    }

    public String getVahMarca() {
        return vahMarca;
    }

    public void setVahMarca(String vahMarca) {
        this.vahMarca = vahMarca;
    }

    public String getVehEmpresa() {
        return vehEmpresa;
    }

    public void setVehEmpresa(String vehEmpresa) {
        this.vehEmpresa = vehEmpresa;
    }

    public String getVehConductor() {
        return vehConductor;
    }

    public void setVehConductor(String vehConductor) {
        this.vehConductor = vehConductor;
    }

    public String getVehCompaniaSeguro() {
        return vehCompaniaSeguro;
    }

    public void setVehCompaniaSeguro(String vehCompaniaSeguro) {
        this.vehCompaniaSeguro = vehCompaniaSeguro;
    }

    public boolean getVehEstado() {
        return vehEstado;
    }

    public void setVehEstado(boolean vehEstado) {
        this.vehEstado = vehEstado;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehId != null ? vehId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.vehId == null && other.vehId != null) || (this.vehId != null && !this.vehId.equals(other.vehId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vehiculo[ vehId=" + vehId + " ]";
    }
    
}
