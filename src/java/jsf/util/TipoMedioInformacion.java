package jsf.util;

import java.util.HashMap;
import java.util.Map;

public enum TipoMedioInformacion {

    PERSONALMENTE(0, "Personalmente"),
    TELEFONO(1, "Telefono"),
    OTROS(2, "Otro medio");
    
    private int valor;
    private String detalle;

    private TipoMedioInformacion(int valor, String detalle) {
        this.valor = valor;
        this.detalle = detalle;
    }

    public static TipoMedioInformacion getFromValue(int value) {
        for (TipoMedioInformacion tipo : TipoMedioInformacion.values()) {
            if (tipo.getValor() == value) {
                return tipo;
            }
        }
        return null;
    }

    public static TipoMedioInformacion[] getFromValue(Integer[] arre) {
        TipoMedioInformacion[] estadoVisitasTMP = new TipoMedioInformacion[arre.length];
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
        for (TipoMedioInformacion estadoVisita : TipoMedioInformacion.values()) {
            mapTMP.put(estadoVisita.getValor(), estadoVisita.getDetalle());

        }
        return mapTMP;
    }

    public int getValor() {
        System.out.println(valor);
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