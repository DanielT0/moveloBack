package com.movelo.moveloapp.models;

public class MinAmbiente {
    private String direccion;
    private String telefono;
    private String correo;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public MinAmbiente() {
    }

    public MinAmbiente(String direccion, String telefono, String correo) {
        this.direccion = "direccion";
        this.telefono = "telefono";
        this.correo = "correo";
    }

}
