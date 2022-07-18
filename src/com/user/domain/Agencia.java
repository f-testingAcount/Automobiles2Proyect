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
    
    public int totalStock(){
        int stock = 0;
        for (int i = 0; i < modelos.size(); i++) {
            //Solucionado //La existencia de stock de una determinada marca la podria controlar con invocando un metodo definido en la clase Marca 
            stock = stock + modelos.get(i).getCantidad(); //Como sumo las cantidades que me devuelve de cada posicion? para saber cuantos modelos hay de cada tipo
        }
        return stock;
    }
    
    public void venderVehiculo(Marca marca, Modelo modelo, CaracteristicasTec caracteristica){
        //Controlar el stock de marca, modelo y caracteristicas tecnicas invocando metodos predefinidos.
        //Efectuar la venta descontando el modelo del stock.
        //Ademas en funcion al diseño del programa donde conviene ubicar el metodo venderVehiculo? En la clase agencia que es la que por logica ejecuta
        //la accion o en la clase acciones comerciales donde implemento los varios de los metodos de interaccion con el cliente?
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("Agencia: ");
        sb.append("Nombre: ").append(nombreAgencia);
        sb.append(" | Ciudad: ").append(ciudad);
        sb.append(" | Marca: ").append(marcaComercializada);
        sb.append(" -");
        return sb.toString();
    }
}
