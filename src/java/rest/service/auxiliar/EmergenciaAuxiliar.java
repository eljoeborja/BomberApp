package rest.service.auxiliar;

import java.io.Serializable;



public class EmergenciaAuxiliar implements Serializable{
    private Integer emeId;
    private String emeFecha;
    private String emeHora;
    private Integer emeInformante;
    private String emeInformacionRecibida;
    private Integer emeMedioInformacion;
    private String emeDescripcionOtroMedio;
    private String emePersonaConfirmacion;
    private Integer emeMedioConfirmacion;
    private String emeDescripcionOtroMedioC;
    private String emeDireccion;
    private Integer emeInmuebleClase;
    private String emeInmueblePropietario;
    private String emeInmuebleAdministrador;
    private String emeInmuebleArrendatario;
    private String emeNovedades;
    private Integer emeComandante;
    private Integer emeEstado;
    private Integer emeTipoe;
    //Constructor
    public EmergenciaAuxiliar(Integer id, String fecha, String hora, Integer informante, String informacion_recibida, Integer medio_informacion, String otro_medio_informacion, String persona_confirmacion, Integer medio_confirmacion, String descripcion_otro_medio, String direccion, Integer inmueble_clase, String inmueble_propietario, String inmueble_administrador, String inmueble_arrendatario, String novedades, Integer comandante, Integer estado, Integer tipoe) {
        this.emeId = id;
        this.emeFecha = fecha;
        this.emeHora = hora;
        this.emeInformante = informante;
        this.emeInformacionRecibida = informacion_recibida;
        this.emeMedioInformacion = medio_informacion;
        this.emeDescripcionOtroMedio = otro_medio_informacion;
        this.emePersonaConfirmacion = persona_confirmacion;
        this.emeMedioConfirmacion = medio_confirmacion;
        this.emeDescripcionOtroMedioC = descripcion_otro_medio;
        this.emeDireccion = direccion;
        this.emeInmuebleClase = inmueble_clase;
        this.emeInmueblePropietario = inmueble_propietario;
        this.emeInmuebleAdministrador = inmueble_administrador;
        this.emeInmuebleArrendatario = inmueble_arrendatario;
        this.emeNovedades = novedades;
        this.emeComandante = comandante;
        this.emeEstado = estado;
        this.emeTipoe = tipoe;
    }
    //Implementacion Getters and Setters

    public Integer getEmeId() {
        return emeId;
    }

    public void setEmeId(Integer emeId) {
        this.emeId = emeId;
    }

    public String getEmeFecha() {
        return emeFecha;
    }

    public void setEmeFecha(String emeFecha) {
        this.emeFecha = emeFecha;
    }

    public String getEmeHora() {
        return emeHora;
    }

    public void setEmeHora(String emeHora) {
        this.emeHora = emeHora;
    }

    public Integer getEmeInformante() {
        return emeInformante;
    }

    public void setEmeInformante(Integer emeInformante) {
        this.emeInformante = emeInformante;
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

    public Integer getEmeInmuebleClase() {
        return emeInmuebleClase;
    }

    public void setEmeInnmuebleClase(Integer emeInmuebleClase) {
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

    public Integer getEmeComandante() {
        return emeComandante;
    }

    public void setEmeComandante(Integer emeComandante) {
        this.emeComandante = emeComandante;
    }

    public Integer getEmeEstado() {
        return emeEstado;
    }

    public void setEmeEstado(Integer emeEstado) {
        this.emeEstado = emeEstado;
    }

    public Integer getEmeTipoe() {
        return emeTipoe;
    }

    public void setEmeTipoe(Integer emeTipoe) {
        this.emeTipoe = emeTipoe;
    }

    //Finalizacion de los Getters and Setters
    //Implementacion metodo ToString
    @Override
    public String toString() {
        return "Emergencia{" +
                "id='" + emeId + '\'' +
                ", fecha=" + emeFecha +
                ", hora='" + emeHora + '\'' +
                ", informante=" + emeInformante +
                ", informacion_recibida='" + emeInformacionRecibida + '\'' +
                ", medio_informacion=" + emeMedioInformacion +
                ", otro_medio_informacion='" + emeDescripcionOtroMedio + '\'' +
                ", persona_confirmacion='" + emePersonaConfirmacion + '\'' +
                ", medio_confirmacion=" + emeMedioConfirmacion +
                ", descripcion_otro_medio='" + emeDescripcionOtroMedioC + '\'' +
                ", direccion='" + emeDireccion + '\'' +
                ", inmueble_clase=" + emeInmuebleClase +
                ", inmueble_propietario='" + emeInmueblePropietario + '\'' +
                ", inmueble_administrador='" + emeInmuebleAdministrador + '\'' +
                ", inmueble_arrendatario='" + emeInmuebleArrendatario + '\'' +
                ", novedades='" + emeNovedades + '\'' +
                ", comandante=" + emeComandante +
                ", estado=" + emeEstado +
                ", tipoe=" + emeTipoe +
                '}';
    }
}