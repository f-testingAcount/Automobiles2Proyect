package com.user.domain;

import java.util.*;


public class Modelo {
    
    private String tipoVehiculo; //Auto, camioneta, Moto, camion
    String denominacion;
    private int cantidad;
    private ArrayList<CaracteristicasTec> caracteristicas = new ArrayList<>();

    public Modelo() {}

    public Modelo(String denominacion) {
        this.denominacion = denominacion;
    }
    
    public Modelo(String tipoVehiculo, String denominacion){
        this.tipoVehiculo = tipoVehiculo;
        this.denominacion = denominacion;
    }

    public Modelo(String tipoVehiculo, String denominacion, int cantidad) {
        this.tipoVehiculo = tipoVehiculo;
        this.denominacion = denominacion;
        this.cantidad = cantidad;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<CaracteristicasTec> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(ArrayList<CaracteristicasTec> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    
    public void agregarCaracteristicaAModelo(CaracteristicasTec caracteristica){
        caracteristicas.add(caracteristica);
    }
    
    public void mostrarCaracteristicas(){
        for (int i = 0; i < caracteristicas.size(); i++) {
            System.out.println(caracteristicas.get(i));
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("Modelo ");
        sb.append("Tipo de Vehiculo: ").append(tipoVehiculo);
        sb.append(" | Denominacion: ").append(denominacion);
        sb.append(" | Cantidad: ").append(cantidad);
        //sb.append(" | Caracteristicas: ").append(caracteristicas);
        sb.append(" -");
        return sb.toString();
    }
           
}
