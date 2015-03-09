package jsf.util;

import java.util.HashMap;
import java.util.Map;

public enum EstadoSync {

    NO(0, "No Sincronizado"),
    SI(1, "Sincronizado");    
    
    private int valor;
    private String detalle;

    private EstadoSync(int valor, String detalle) {
        this.valor = valor;
        this.detalle = detalle;
    }

    public static EstadoSync getFromValue(int value) {
        for (EstadoSync tipo : EstadoSync.values()) {
            if (tipo.getValor() == value) {
                return tipo;
            }
        }
        return null;
    }

    public static EstadoSync[] getFromValue(Integer[] arre) {
        EstadoSync[] estadoVisitasTMP = new EstadoSync[arre.length];
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
        for (EstadoSync estadoVisita : EstadoSync.values()) {
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