package com.example.examen_ejercicio2.models;

public class Ciudad {
    private String nombre;
    private String url;
    private double tarifa;

    public Ciudad(String nombre, String url, double tarifa){
        this.nombre = nombre;
        this.url = url;
        this.tarifa = tarifa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
