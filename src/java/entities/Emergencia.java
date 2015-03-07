/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BuRr0X
 */
@Entity
@Table(name = "emergencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emergencia.findAll", query = "SELECT e FROM Emergencia e"),
    @NamedQuery(name = "Emergencia.findByEmeId", query = "SELECT e FROM Emergencia e WHERE e.emeId = :emeId"),
    @NamedQuery(name = "Emergencia.findByEmeFecha", query = "SELECT e FROM Emergencia e WHERE e.emeFecha = :emeFecha"),
    @NamedQuery(name = "Emergencia.findByEmeHora", query = "SELECT e FROM Emergencia e WHERE e.emeHora = :emeHora"),
    @NamedQuery(name = "Emergencia.findByEmeInformacionRecibida", query = "SELECT e FROM Emergencia e WHERE e.emeInformacionRecibida = :emeInformacionRecibida"),
    @NamedQuery(name = "Emergencia.findByEmeMedioInformacion", query = "SELECT e FROM Emergencia e WHERE e.emeMedioInformacion = :emeMedioInformacion"),
    @NamedQuery(name = "Emergencia.findByEmeDescripcionOtroMedio", query = "SELECT e FROM Emergencia e WHERE e.emeDescripcionOtroMedio = :emeDescripcionOtroMedio"),
    @NamedQuery(name = "Emergencia.findByEmePersonaConfirmacion", query = "SELECT e FROM Emergencia e WHERE e.emePersonaConfirmacion = :emePersonaConfirmacion"),
    @NamedQuery(name = "Emergencia.findByEmeMedioConfirmacion", query = "SELECT e FROM Emergencia e WHERE e.emeMedioConfirmacion = :emeMedioConfirmacion"),
    @NamedQuery(name = "Emergencia.findByEmeDescripcionOtroMedioC", query = "SELECT e FROM Emergencia e WHERE e.emeDescripcionOtroMedioC = :emeDescripcionOtroMedioC"),
    @NamedQuery(name = "Emergencia.findByEmeDireccion", query = "SELECT e FROM Emergencia e WHERE e.emeDireccion = :emeDireccion"),
    @NamedQuery(name = "Emergencia.findByEmeInmuebleClase", query = "SELECT e FROM Emergencia e WHERE e.emeInmuebleClase = :emeInmuebleClase"),
    @NamedQuery(name = "Emergencia.findByEmeInmueblePropietario", query = "SELECT e FROM Emergencia e WHERE e.emeInmueblePropietario = :emeInmueblePropietario"),
    @NamedQuery(name = "Emergencia.findByEmeInmuebleAdministrador", query = "SELECT e FROM Emergencia e WHERE e.emeInmuebleAdministrador = :emeInmuebleAdministrador"),
    @NamedQuery(name = "Emergencia.findByEmeInmuebleArrendatario", query = "SELECT e FROM Emergencia e WHERE e.emeInmuebleArrendatario = :emeInmuebleArrendatario"),
    @NamedQuery(name = "Emergencia.findByEmeEstado", query = "SELECT e FROM Emergencia e WHERE e.emeEstado = :emeEstado")})
public class Emergencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "eme_id")
    private String emeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eme_fecha")
    @Temporal(TemporalType.DATE)
    private Date emeFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eme_hora")
    @Temporal(TemporalType.TIME)
    private Date emeHora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eme_informacion_recibida")
    private String emeInformacionRecibida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eme_medio_informacion")
    private Integer emeMedioInformacion;
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eme_descripcion_otro_medio")
    private String emeDescripcionOtroMedio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eme_persona_confirmacion")
    private String emePersonaConfirmacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eme_medio_confirmacion")
    private Integer emeMedioConfirmacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eme_descripcion_otro_medio_c")
    private String emeDescripcionOtroMedioC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eme_direccion")
    private String emeDireccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eme_inmueble_clase")
    private boolean emeInmuebleClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eme_inmueble_propietario")
    private String emeInmueblePropietario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eme_inmueble_administrador")
    private String emeInmuebleAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eme_inmueble_arrendatario")
    private String emeInmuebleArrendatario;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "eme_novedades")
    private String emeNovedades;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eme_estado")
    private boolean emeEstado;
    @OneToOne(mappedBy = "accEmeId", fetch = FetchType.LAZY)
    private AccidenteTransito accidenteTransito;
    @OneToOne(mappedBy = "costoEmeId", fetch = FetchType.LAZY)
    private Costo costo;
    @OneToOne(mappedBy = "inuEmeId", fetch = FetchType.LAZY)
    private Inundacion inundacion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "peremeEmId", fetch = FetchType.LAZY)
    private PersonalEmergancia personalEmergancia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maqEmeEme", fetch = FetchType.LAZY)
    private Collection<MaquinaEmergencia> maquinaEmergenciaCollection;
    @OneToOne(mappedBy = "incfEmeId", fetch = FetchType.LAZY)
    private IncendioForestal incendioForestal;
    @OneToOne(mappedBy = "otrEmeId", fetch = FetchType.LAZY)
    private OtrosIncidentes otrosIncidentes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "inceEmeId", fetch = FetchType.LAZY)
    private IncendioEstructural incendioEstructural;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matUtiEmeId", fetch = FetchType.LAZY)
    private Collection<MaterialUtilizado> materialUtilizadoCollection;
    @JoinColumn(name = "eme_informante", referencedColumnName = "per_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona emeInformante;
    @JoinColumn(name = "eme_comandante", referencedColumnName = "uni_npib")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Unidad emeComandante;

    public Emergencia() {
    }

    public Emergencia(String emeId) {
        this.emeId = emeId;
    }

    public Emergencia(String emeId, Date emeFecha, Date emeHora, String emeInformacionRecibida, Integer emeMedioInformacion, String emeDescripcionOtroMedio, String emePersonaConfirmacion, Integer emeMedioConfirmacion, String emeDescripcionOtroMedioC, String emeDireccion, boolean emeInmuebleClase, String emeInmueblePropietario, String emeInmuebleAdministrador, String emeInmuebleArrendatario, String emeNovedades, boolean emeEstado) {
        this.emeId = emeId;
        this.emeFecha = emeFecha;
        this.emeHora = emeHora;
        this.emeInformacionRecibida = emeInformacionRecibida;
        this.emeMedioInformacion = emeMedioInformacion;
        this.emeDescripcionOtroMedio = emeDescripcionOtroMedio;
        this.emePersonaConfirmacion = emePersonaConfirmacion;
        this.emeMedioConfirmacion = emeMedioConfirmacion;
        this.emeDescripcionOtroMedioC = emeDescripcionOtroMedioC;
        this.emeDireccion = emeDireccion;
        this.emeInmuebleClase = emeInmuebleClase;
        this.emeInmueblePropietario = emeInmueblePropietario;
        this.emeInmuebleAdministrador = emeInmuebleAdministrador;
        this.emeInmuebleArrendatario = emeInmuebleArrendatario;
        this.emeNovedades = emeNovedades;
        this.emeEstado = emeEstado;
    }

    public String getEmeId() {
        return emeId;
    }

    public void setEmeId(String emeId) {
        this.emeId = emeId;
    }

    public Date getEmeFecha() {
        return emeFecha;
    }

    public void setEmeFecha(Date emeFecha) {
        this.emeFecha = emeFecha;
    }

    public Date getEmeHora() {
        return emeHora;
    }

    public void setEmeHora(Date emeHora) {
        this.emeHora = emeHora;
    }

    public String getEmeInformacionRecibida() {
        return emeInformacionRecibida;
    }

    public void setEmeInformacionRecibida(String emeInformacionRecibida) {
        this.emeInformacionRecibida = emeInformacionRecibida;
    }

    public Integer getEmeMedioInformacion() {
        return emeMedioInformacion;
    }

    public void setEmeMedioInformacion(Integer emeMedioInformacion) {
        this.emeMedioInformacion = emeMedioInformacion;
    }

    public String getEmeDescripcionOtroMedio() {
        return emeDescripcionOtroMedio;
    }

    public void setEmeDescripcionOtroMedio(String emeDescripcionOtroMedio) {
        this.emeDescripcionOtroMedio = emeDescripcionOtroMedio;
    }

    public String getEmePersonaConfirmacion() {
        return emePersonaConfirmacion;
    }

    public void setEmePersonaConfirmacion(String emePersonaConfirmacion) {
        this.emePersonaConfirmacion = emePersonaConfirmacion;
    }

    public Integer getEmeMedioConfirmacion() {
        return emeMedioConfirmacion;
    }

    public void setEmeMedioConfirmacion(Integer emeMedioConfirmacion) {
        this.emeMedioConfirmacion = emeMedioConfirmacion;
    }

    public String getEmeDescripcionOtroMedioC() {
        return emeDescripcionOtroMedioC;
    }

    public void setEmeDescripcionOtroMedioC(String emeDescripcionOtroMedioC) {
        this.emeDescripcionOtroMedioC = emeDescripcionOtroMedioC;
    }

    public String getEmeDireccion() {
        return emeDireccion;
    }

    public void setEmeDireccion(String emeDireccion) {
        this.emeDireccion = emeDireccion;
    }

    public boolean getEmeInmuebleClase() {
        return emeInmuebleClase;
    }

    public void setEmeInmuebleClase(boolean emeInmuebleClase) {
        this.emeInmuebleClase = emeInmuebleClase;
    }

    public String getEmeInmueblePropietario() {
        return emeInmueblePropietario;
    }

    public void setEmeInmueblePropietario(String emeInmueblePropietario) {
        this.emeInmueblePropietario = emeInmueblePropietario;
    }

    public String getEmeInmuebleAdministrador() {
        return emeInmuebleAdministrador;
    }

    public void setEmeInmuebleAdministrador(String emeInmuebleAdministrador) {
        this.emeInmuebleAdministrador = emeInmuebleAdministrador;
    }

    public String getEmeInmuebleArrendatario() {
        return emeInmuebleArrendatario;
    }

    public void setEmeInmuebleArrendatario(String emeInmuebleArrendatario) {
        this.emeInmuebleArrendatario = emeInmuebleArrendatario;
    }

    public String getEmeNovedades() {
        return emeNovedades;
    }

    public void setEmeNovedades(String emeNovedades) {
        this.emeNovedades = emeNovedades;
    }

    public boolean getEmeEstado() {
        return emeEstado;
    }

    public void setEmeEstado(boolean emeEstado) {
        this.emeEstado = emeEstado;
    }

    public AccidenteTransito getAccidenteTransito() {
        return accidenteTransito;
    }

    public void setAccidenteTransito(AccidenteTransito accidenteTransito) {
        this.accidenteTransito = accidenteTransito;
    }

    public Costo getCosto() {
        return costo;
    }

    public void setCosto(Costo costo) {
        this.costo = costo;
    }

    public Inundacion getInundacion() {
        return inundacion;
    }

    public void setInundacion(Inundacion inundacion) {
        this.inundacion = inundacion;
    }

    public PersonalEmergancia getPersonalEmergancia() {
        return personalEmergancia;
    }

    public void setPersonalEmergancia(PersonalEmergancia personalEmergancia) {
        this.personalEmergancia = personalEmergancia;
    }

    @XmlTransient
    public Collection<MaquinaEmergencia> getMaquinaEmergenciaCollection() {
        return maquinaEmergenciaCollection;
    }

    public void setMaquinaEmergenciaCollection(Collection<MaquinaEmergencia> maquinaEmergenciaCollection) {
        this.maquinaEmergenciaCollection = maquinaEmergenciaCollection;
    }

    public IncendioForestal getIncendioForestal() {
        return incendioForestal;
    }

    public void setIncendioForestal(IncendioForestal incendioForestal) {
        this.incendioForestal = incendioForestal;
    }

    public OtrosIncidentes getOtrosIncidentes() {
        return otrosIncidentes;
    }

    public void setOtrosIncidentes(OtrosIncidentes otrosIncidentes) {
        this.otrosIncidentes = otrosIncidentes;
    }

    public IncendioEstructural getIncendioEstructural() {
        return incendioEstructural;
    }

    public void setIncendioEstructural(IncendioEstructural incendioEstructural) {
        this.incendioEstructural = incendioEstructural;
    }

    @XmlTransient
    public Collection<MaterialUtilizado> getMaterialUtilizadoCollection() {
        return materialUtilizadoCollection;
    }

    public void setMaterialUtilizadoCollection(Collection<MaterialUtilizado> materialUtilizadoCollection) {
        this.materialUtilizadoCollection = materialUtilizadoCollection;
    }

    public Persona getEmeInformante() {
        return emeInformante;
    }

    public void setEmeInformante(Persona emeInformante) {
        this.emeInformante = emeInformante;
    }

    public Unidad getEmeComandante() {
        return emeComandante;
    }

    public void setEmeComandante(Unidad emeComandante) {
        this.emeComandante = emeComandante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emeId != null ? emeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emergencia)) {
            return false;
        }
        Emergencia other = (Emergencia) object;
        if ((this.emeId == null && other.emeId != null) || (this.emeId != null && !this.emeId.equals(other.emeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ Fecha: " + emeFecha +", Hora: "+ emeHora + ", Direccion: "+emeDireccion+" ]";
    }
    
}
