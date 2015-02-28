package jsf.util;

import java.util.HashMap;
import java.util.Map;

public enum TipoPersona {

    INFORMANTE(0, "Informante"),
    TESTIGO(1, "Testigo"),
    UNIDAD(2, "Unidad"),
    VICTIMA_LESIONADO(3, "Victima Lesionado"),
    VICTIMA_FALLECIDO(4, "Victima Fallecido");

    private int valor;
    private String detalle;

    private TipoPersona(int valor, String detalle) {
        this.valor = valor;
        this.detalle = detalle;
    }

    public static TipoPersona getFromValue(int value) {
        for (TipoPersona tipo : TipoPersona.values()) {
            if (tipo.getValor() == value) {
                return tipo;
            }
        }
        return null;
    }

    public static TipoPersona[] getFromValue(Integer[] arre) {
        TipoPersona[] estadoVisitasTMP = new TipoPersona[arre.length];
        int count = 0;
        for (int b : arre) {
            estadoVisitasTMP[count] = getFromValue(b);
            count++;
        }
        System.out.println("Size-> "+estadoVisitasTMP.length);
        return estadoVisitasTMP;
    }

    public static Map<Integer, String> getMapaEstados() {
        Map<Integer, String> mapTMP = new HashMap<>();
        for (TipoPersona estadoVisita : TipoPersona.values()) {
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