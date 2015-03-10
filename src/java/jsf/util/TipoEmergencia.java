package jsf.util;

import java.util.HashMap;
import java.util.Map;

public enum TipoEmergencia {

    INCENDIOFORESTAL(0, "Incendio Forestal"),
    INCENDIOESTRUCTURAL(1, "Incendio Estructural"),
    INUNDACION(2, "Inundacion"),
    ACCIDENTETRANSITO(3, "Accidente de Transito"),
    OTROSINCIDENTES(4, "Otros incidentes");

    private int valor;
    private String detalle;

    private TipoEmergencia(int valor, String detalle) {
        this.valor = valor;
        this.detalle = detalle;
    }

    public static TipoEmergencia getFromValue(int value) {
        for (TipoEmergencia tipo : TipoEmergencia.values()) {
            if (tipo.getValor() == value) {
                return tipo;
            }
        }
        return null;
    }

    public static TipoEmergencia[] getFromValue(Integer[] arre) {
        TipoEmergencia[] estadoVisitasTMP = new TipoEmergencia[arre.length];
        int count = 0;
        for (int b : arre) {
            estadoVisitasTMP[count] = getFromValue(b);
            count++;
        }
        System.out.println("Size-> "+estadoVisitasTMP.length);
        return estadoVisitasTMP;
    }

    public static Map<Integer, String> getMapaTiposEmergencia() {
        Map<Integer, String> mapTMP = new HashMap<>();
        for (TipoEmergencia estadoVisita : TipoEmergencia.values()) {
            mapTMP.put(estadoVisita.getValor(), estadoVisita.getDetalle());

        }
        return mapTMP;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return detalle;
    }

}