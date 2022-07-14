
package com.user.negocios;

import com.user.datos.*;
import com.user.domain.*;
import com.user.exceptions.AccesoDatosEx;
import com.user.negocios.*;


public class AccionesComercialesImpl implements IAccionesComerciales {
    
    IAccesoDatos datos;
    AccesoDatosMarcaImpl datosMarca;
    AccesoDatosModeloImpl datosModelo;
    AccesoDatosCaracteristicasTecImpl datosTecnicos;
    AccesoDatosDistribuidorImpl datosDistribuidor;
    AccesoDatosAgenciaImpl datosAgencia;
    
    public AccionesComercialesImpl() {
        this.datos = new AccesoDatosMarcaImpl();
        this.datosMarca = new AccesoDatosMarcaImpl();
        this.datosModelo = new AccesoDatosModeloImpl();
        this.datosTecnicos = new AccesoDatosCaracteristicasTecImpl();
        this.datosDistribuidor = new AccesoDatosDistribuidorImpl();
        this.datosAgencia = new AccesoDatosAgenciaImpl();
    }
    
    @Override
    public void iniciarArchivo() {
        try {
            if(this.datos.existe(ARCHIVO_MARCAS)){
                System.out.println("El archivo Marcas ya existe!");

            } else {
                this.datos.crear(ARCHIVO_MARCAS);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar archivo Marcas!");
            ex.printStackTrace(System.out);
        }
        try {
            if (this.datos.existe(ARCHIVO_MODELOS)) {
                 System.out.println("El archivo Modelos ya existe!");

            } else {
                this.datos.crear(ARCHIVO_MODELOS);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar archivo Modelos!");
            ex.printStackTrace(System.out);
        }
        try {
            if (this.datos.existe(ARCHIVO_CARACTERISTICAS_TEC)) {
                System.out.println("El archivo Caracteristicas Tecnicas ya existe!");

            } else {
                this.datos.crear(ARCHIVO_CARACTERISTICAS_TEC);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar archivo Caracteristicas Tecnicas!");
            ex.printStackTrace(System.out);
        }
        try {
            if (this.datos.existe(ARCHIVO_DISTRIBUIDORES)) {
                System.out.println("El archivo Distribuidores ya existe!");

            } else {
                this.datos.crear(ARCHIVO_DISTRIBUIDORES);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar archivo Distribuidores!");
            ex.printStackTrace(System.out);
        }
        try {
            if (this.datos.existe(ARCHIVO_AGENCIAS)) {
                System.out.println("El archivo Agencias ya existe!");

            } else {
                this.datos.crear(ARCHIVO_AGENCIAS);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar archivo Agencias!");
            ex.printStackTrace(System.out);
        }
    }

     @Override
    public void agregarMarca(String nombreArchivo, String nombre, String origen, String logo) {
        Marca marca = new Marca(nombre, origen, logo);
        boolean anexar = false;
        try {
            if(anexar = datosMarca.existe(ARCHIVO_MARCAS)){
                this.datosMarca.escribir(marca, nombreArchivo);
            } else {
                System.out.println("El archivo Marcas no exixte!");
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al agregar marca!");
            ex.printStackTrace(System.out);
        }
    }
    
    @Override
    public void agregarModelos(String nombreArchivo, String tipoVehiculo, String denominacion, int cantidad) {
        Modelo modelo = new Modelo(tipoVehiculo, denominacion, cantidad);
        boolean anexar = false;
        try {
            if(anexar = this.datosModelo.existe(ARCHIVO_MODELOS)){
                this.datosModelo.escribir(modelo, nombreArchivo);
            } else {
                System.out.println("El archivo Modelos no existe!");                       
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al agregar marca!");
            ex.printStackTrace(System.out);
        }
                
    }

    @Override
    public void agregarCaracteristicasTecnicas(String nombreArchivo, String denominacion, String tipoMotor, String cilindros, int cilindrada, int HP, String caja, String equipamiento, String carroceria, String id) {
        CaracteristicasTec caracteristica = new CaracteristicasTec(denominacion, tipoMotor, cilindros, cilindrada, HP, caja, equipamiento, carroceria, id);
        try {
            if (this.datosTecnicos.existe(ARCHIVO_CARACTERISTICAS_TEC)) {
                this.datosTecnicos.escribir(caracteristica, nombreArchivo);
            } else {
                System.out.println("El archivo caracteristicas tecnicas no existe!");
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al agregar caracteristicas tecnicas!");
            ex.printStackTrace(System.out);
        }
    }
    
     @Override
    public void agregarDistribuidor(String nombreArchivo, String nombreDistribuidor, String pais) {
        Distribuidor distribuidor = new Distribuidor(nombreDistribuidor, pais);        
        try {
            if (this.datosDistribuidor.existe(ARCHIVO_DISTRIBUIDORES)) {
                this.datosDistribuidor.escribir(distribuidor, nombreArchivo);
            } else {
                System.out.println("El archivo distribuidores no existe!");
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al agregar distribuidor!");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void agregarAgencia(String nombreArchivo, String nombreAgencia, String ciudad, String marcaComercializada) {
        Agencia agencia = new Agencia(nombreAgencia, ciudad, marcaComercializada);
        try {
            if (this.datosAgencia.existe(ARCHIVO_AGENCIAS)) {
                this.datosAgencia.escribir(agencia, nombreArchivo);
            } else {
                System.out.println("El archivo agencias no existe!");
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al agregar agencia!");
            ex.printStackTrace(System.out);
        }
    }
    
    @Override
    public void enviarPedidoAFabricante(Marca marca, int unidades) {
        
    }

    @Override
    public void venderVehiculo(Marca marca, Modelo modelo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ingresarAlService(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void enviarUnidadesAAgencia(Marca marca, Modelo modelo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarArchivo(String nombreArchivo) {
        try {
            if (this.datos.existe(nombreArchivo)) {
                this.datos.borrar(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al borrar el archivo");
            ex.printStackTrace(System.out);
        }
    }
}
