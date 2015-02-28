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
@Table(name = "aseguradora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aseguradora.findAll", query = "SELECT a FROM Aseguradora a"),
    @NamedQuery(name = "Aseguradora.findByAseNit", query = "SELECT a FROM Aseguradora a WHERE a.aseNit = :aseNit"),
    @NamedQuery(name = "Aseguradora.findByAseRazonSocial", query = "SELECT a FROM Aseguradora a WHERE a.aseRazonSocial = :aseRazonSocial"),
    @NamedQuery(name = "Aseguradora.findByAseDireccion", query = "SELECT a FROM Aseguradora a WHERE a.aseDireccion = :aseDireccion"),
    @NamedQuery(name = "Aseguradora.findByAseTelefono", query = "SELECT a FROM Aseguradora a WHERE a.aseTelefono = :aseTelefono"),
    @NamedQuery(name = "Aseguradora.findByAseFax", query = "SELECT a FROM Aseguradora a WHERE a.aseFax = :aseFax"),
    @NamedQuery(name = "Aseguradora.findByAseEmail", query = "SELECT a FROM Aseguradora a WHERE a.aseEmail = :aseEmail"),
    @NamedQuery(name = "Aseguradora.findByAsePaginaWeb", query = "SELECT a FROM Aseguradora a WHERE a.asePaginaWeb = :asePaginaWeb")})
public class Aseguradora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ase_nit")
    private String aseNit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ase_razon_social")
    private String aseRazonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ase_direccion")
    private String aseDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ase_telefono")
    private String aseTelefono;
    @Size(max = 25)
    @Column(name = "ase_fax")
    private String aseFax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ase_email")
    private String aseEmail;
    @Size(max = 50)
    @Column(name = "ase_pagina_web")
    private String asePaginaWeb;
    @JoinColumn(name = "ase_mun_id", referencedColumnName = "mun_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipio aseMunId;

    public Aseguradora() {
    }

    public Aseguradora(String aseNit) {
        this.aseNit = aseNit;
    }

    public Aseguradora(String aseNit, String aseRazonSocial, String aseDireccion, String aseTelefono, String aseEmail) {
        this.aseNit = aseNit;
        this.aseRazonSocial = aseRazonSocial;
        this.aseDireccion = aseDireccion;
        this.aseTelefono = aseTelefono;
        this.aseEmail = aseEmail;
    }

    public String getAseNit() {
        return aseNit;
    }

    public void setAseNit(String aseNit) {
        this.aseNit = aseNit;
    }

    public String getAseRazonSocial() {
        return aseRazonSocial;
    }

    public void setAseRazonSocial(String aseRazonSocial) {
        this.aseRazonSocial = aseRazonSocial;
    }

    public String getAseDireccion() {
        return aseDireccion;
    }

    public void setAseDireccion(String aseDireccion) {
        this.aseDireccion = aseDireccion;
    }

    public String getAseTelefono() {
        return aseTelefono;
    }

    public void setAseTelefono(String aseTelefono) {
        this.aseTelefono = aseTelefono;
    }

    public String getAseFax() {
        return aseFax;
    }

    public void setAseFax(String aseFax) {
        this.aseFax = aseFax;
    }

    public String getAseEmail() {
        return aseEmail;
    }

    public void setAseEmail(String aseEmail) {
        this.aseEmail = aseEmail;
    }

    public String getAsePaginaWeb() {
        return asePaginaWeb;
    }

    public void setAsePaginaWeb(String asePaginaWeb) {
        this.asePaginaWeb = asePaginaWeb;
    }

    public Municipio getAseMunId() {
        return aseMunId;
    }

    public void setAseMunId(Municipio aseMunId) {
        this.aseMunId = aseMunId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aseNit != null ? aseNit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aseguradora)) {
            return false;
        }
        Aseguradora other = (Aseguradora) object;
        if ((this.aseNit == null && other.aseNit != null) || (this.aseNit != null && !this.aseNit.equals(other.aseNit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Aseguradora[ aseNit=" + aseNit + " ]";
    }
    
}
