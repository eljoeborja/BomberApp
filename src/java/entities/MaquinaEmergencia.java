/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BuRr0X
 */
@Entity
@Table(name = "maquina_emergencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaquinaEmergencia.findAll", query = "SELECT m FROM MaquinaEmergencia m"),
    @NamedQuery(name = "MaquinaEmergencia.findByMaqEmeId", query = "SELECT m FROM MaquinaEmergencia m WHERE m.maqEmeId = :maqEmeId"),
    @NamedQuery(name = "MaquinaEmergencia.findByMaqEmeFechaSalida", query = "SELECT m FROM MaquinaEmergencia m WHERE m.maqEmeFechaSalida = :maqEmeFechaSalida"),
    @NamedQuery(name = "MaquinaEmergencia.findByMaqEmeHoraSalida", query = "SELECT m FROM MaquinaEmergencia m WHERE m.maqEmeHoraSalida = :maqEmeHoraSalida"),
    @NamedQuery(name = "MaquinaEmergencia.findByMaqEmeUnidades", query = "SELECT m FROM MaquinaEmergencia m WHERE m.maqEmeUnidades = :maqEmeUnidades"),
    @NamedQuery(name = "MaquinaEmergencia.findByMaqEmeFechaRegreso", query = "SELECT m FROM MaquinaEmergencia m WHERE m.maqEmeFechaRegreso = :maqEmeFechaRegreso"),
    @NamedQuery(name = "MaquinaEmergencia.findByMaqHoraRegreso", query = "SELECT m FROM MaquinaEmergencia m WHERE m.maqHoraRegreso = :maqHoraRegreso"),
    @NamedQuery(name = "MaquinaEmergencia.findByMaqEmeEstado", query = "SELECT m FROM MaquinaEmergencia m WHERE m.maqEmeEstado = :maqEmeEstado")})
public class MaquinaEmergencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "maq_eme_id")
    private String maqEmeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maq_eme_fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date maqEmeFechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maq_eme_hora_salida")
    @Temporal(TemporalType.TIME)
    private Date maqEmeHoraSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maq_eme_unidades")
    private int maqEmeUnidades;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maq_eme_fecha_regreso")
    @Temporal(TemporalType.DATE)
    private Date maqEmeFechaRegreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maq_hora_regreso")
    @Temporal(TemporalType.TIME)
    private Date maqHoraRegreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maq_eme_estado")
    private boolean maqEmeEstado;
    @JoinColumn(name = "maq_eme_eme", referencedColumnName = "eme_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Emergencia maqEmeEme;
    @JoinColumn(name = "maq_eme_npib", referencedColumnName = "uni_npib")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Unidad maqEmeNpib;
    @JoinColumn(name = "maq_eme_maq", referencedColumnName = "maq_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Maquina maqEmeMaq;

    public MaquinaEmergencia() {
    }

    public MaquinaEmergencia(String maqEmeId) {
        this.maqEmeId = maqEmeId;
    }

    public MaquinaEmergencia(String maqEmeId, Date maqEmeFechaSalida, Date maqEmeHoraSalida, int maqEmeUnidades, Date maqEmeFechaRegreso, Date maqHoraRegreso, boolean maqEmeEstado) {
        this.maqEmeId = maqEmeId;
        this.maqEmeFechaSalida = maqEmeFechaSalida;
        this.maqEmeHoraSalida = maqEmeHoraSalida;
        this.maqEmeUnidades = maqEmeUnidades;
        this.maqEmeFechaRegreso = maqEmeFechaRegreso;
        this.maqHoraRegreso = maqHoraRegreso;
        this.maqEmeEstado = maqEmeEstado;
    }

    public String getMaqEmeId() {
        return maqEmeId;
    }

    public void setMaqEmeId(String maqEmeId) {
        this.maqEmeId = maqEmeId;
    }

    public Date getMaqEmeFechaSalida() {
        return maqEmeFechaSalida;
    }

    public void setMaqEmeFechaSalida(Date maqEmeFechaSalida) {
        this.maqEmeFechaSalida = maqEmeFechaSalida;
    }

    public Date getMaqEmeHoraSalida() {
        return maqEmeHoraSalida;
    }

    public void setMaqEmeHoraSalida(Date maqEmeHoraSalida) {
        this.maqEmeHoraSalida = maqEmeHoraSalida;
    }

    public int getMaqEmeUnidades() {
        return maqEmeUnidades;
    }

    public void setMaqEmeUnidades(int maqEmeUnidades) {
        this.maqEmeUnidades = maqEmeUnidades;
    }

    public Date getMaqEmeFechaRegreso() {
        return maqEmeFechaRegreso;
    }

    public void setMaqEmeFechaRegreso(Date maqEmeFechaRegreso) {
        this.maqEmeFechaRegreso = maqEmeFechaRegreso;
    }

    public Date getMaqHoraRegreso() {
        return maqHoraRegreso;
    }

    public void setMaqHoraRegreso(Date maqHoraRegreso) {
        this.maqHoraRegreso = maqHoraRegreso;
    }

    public boolean getMaqEmeEstado() {
        return maqEmeEstado;
    }

    public void setMaqEmeEstado(boolean maqEmeEstado) {
        this.maqEmeEstado = maqEmeEstado;
    }

    public Emergencia getMaqEmeEme() {
        return maqEmeEme;
    }

    public void setMaqEmeEme(Emergencia maqEmeEme) {
        this.maqEmeEme = maqEmeEme;
    }

    public Unidad getMaqEmeNpib() {
        return maqEmeNpib;
    }

    public void setMaqEmeNpib(Unidad maqEmeNpib) {
        this.maqEmeNpib = maqEmeNpib;
    }

    public Maquina getMaqEmeMaq() {
        return maqEmeMaq;
    }

    public void setMaqEmeMaq(Maquina maqEmeMaq) {
        this.maqEmeMaq = maqEmeMaq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maqEmeId != null ? maqEmeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaquinaEmergencia)) {
            return false;
        }
        MaquinaEmergencia other = (MaquinaEmergencia) object;
        if ((this.maqEmeId == null && other.maqEmeId != null) || (this.maqEmeId != null && !this.maqEmeId.equals(other.maqEmeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MaquinaEmergencia[ maqEmeId=" + maqEmeId + " ]";
    }
    
}
