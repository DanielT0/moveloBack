package com.movelo.moveloapp.gestores;

import com.movelo.moveloapp.models.MinAmbiente;

public class GestorComunicacion {
    private MinAmbiente minAmbiente = new MinAmbiente();

    public MinAmbiente getMinAmbiente() {
        return minAmbiente;
    }

    public void setMinAmbiente(MinAmbiente minAmbiente) {
        this.minAmbiente = minAmbiente;
    }

    public GestorComunicacion() {
    }

    public GestorComunicacion(MinAmbiente minAmbiente) {
        this.minAmbiente = minAmbiente;
    }

}
