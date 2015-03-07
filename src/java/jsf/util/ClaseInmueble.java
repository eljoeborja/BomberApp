package jsf.util;

import java.util.HashMap;
import java.util.Map;

public enum ClaseInmueble {

    RESIDENCIAL(0, "Residencial"),
    COMERCIAL(1, "Comercial"),
    INDUSTRIAL(2, "Industrial");
    
    private int valor;
    private String detalle;

    private ClaseInmueble(int valor, String detalle) {
        this.valor = valor;
        this.detalle = detalle;
    }

    public static ClaseInmueble getFromValue(int value) {
        for (ClaseInmueble tipo : ClaseInmueble.values()) {
            if (tipo.getValor() == value) {
                return tipo;
            }
        }
        return null;
    }

    public static ClaseInmueble[] getFromValue(Integer[] arre) {
        ClaseInmueble[] estadoVisitasTMP = new ClaseInmueble[arre.length];
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
        for (ClaseInmueble estadoVisita : ClaseInmueble.values()) {
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