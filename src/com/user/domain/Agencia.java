package com.user.domain;

import java.util.*;


public class Agencia {
    private String nombreAgencia;
    private String ciudad;
    private String marcaComercializada;
    private List<Modelo> modelos = new ArrayList<>();

    public Agencia() {}

    public Agencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public Agencia(String nombreAgencia, String ciudad, String marcaComercializada) {
        this.nombreAgencia = nombreAgencia;
        this.ciudad = ciudad;
        this.marcaComercializada = marcaComercializada;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }


    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public String getMarcaComercializada() {
        return marcaComercializada;
    }

    public void setMarcaComercializada(String marcaComercializada) {
        this.marcaComercializada = marcaComercializada;
    }
    
    
    public int controlarStock(){
        int stock = 0;
        
        return stock;
    }
    
    public void venderVehiculo(Marca marca, Modelo modelo, CaracteristicasTec caracteristica){
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agencia: ");
        sb.append("Nombre: ").append(nombreAgencia);
        sb.append(" | Ciudad: ").append(ciudad);
        sb.append(" | Marca: ").append(marcaComercializada);
        sb.append(" -");
        return sb.toString();
    }

    
    
    
    
    
    
    
    
    
}
