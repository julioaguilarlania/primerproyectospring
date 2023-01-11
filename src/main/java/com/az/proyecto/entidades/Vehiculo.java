package com.az.proyecto.entidades;

import java.time.LocalDateTime;

public class Vehiculo {

    public Vehiculo(String placas, String color, String marca, String modelo, Double kilometraje, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        this.placas = placas;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    private String placas;
    private String color;
    private String marca;
    private String modelo;
    private Double kilometraje;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
