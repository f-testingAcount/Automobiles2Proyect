package com.user.negocios;

import com.user.datos.*;
import com.user.domain.*;
import com.user.exceptions.AccesoDatosEx;
import com.user.negocios.*;
import java.util.List;


public class AccionesComercialesImpl implements IAccionesComerciales {

    IAccesoDatos datos;
    AccesoDatosMarcaImpl datosMarca;
    AccesoDatosModeloImpl datosModelo;
    AccesoDatosCaracteristicasTecImpl datosTecnicos;
    AccesoDatosDistribuidorImpl datosDistribuidor;
    AccesoDatosAgenciaImpl datosAgencia;

    public AccionesComercialesImpl() {
        //this.datos = new AccesoDatosMarcaImpl();
        this.datosMarca = new AccesoDatosMarcaImpl();
        this.datosModelo = new AccesoDatosModeloImpl();
        this.datosTecnicos = new AccesoDatosCaracteristicasTecImpl();
        this.datosDistribuidor = new AccesoDatosDistribuidorImpl();
        this.datosAgencia = new AccesoDatosAgenciaImpl();
    }

    @Override
    public void iniciarArchivo() {
        try {
            if (this.datos.existe(ARCHIVO_MARCAS)) {
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
            if (anexar = datosMarca.existe(ARCHIVO_MARCAS)) {
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
            if (anexar = this.datosModelo.existe(ARCHIVO_MODELOS)) {
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

//    @Override
//    public void listarArchivo() {
//        try {
//            List<T> object = this.datos.listar(nombreArchivo);
//            System.out.println("marcas = " + marcas);
//        } catch (AccesoDatosEx ex) 
//            System.out.println("Error al listar marcas!");
//            ex.printStackTrace(System.out);
//        }
//    }
    @Override
    public void listarArchivo(String nombreArchivo) {
        if (nombreArchivo == ARCHIVO_MARCAS) {
            try {
                List<Marca> marca = this.datosMarca.listar(ARCHIVO_MARCAS);
                System.out.println("marca = " + marca);
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al listar marcas!");
                ex.printStackTrace(System.out);
            }
        } else if (nombreArchivo == ARCHIVO_MODELOS) {
            try {
                List<Modelo> modelo = this.datosModelo.listar(ARCHIVO_MODELOS);
                System.out.println("modelo = " + modelo);
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al listar modelos!");
                ex.printStackTrace(System.out);
            }
        } else if (nombreArchivo == ARCHIVO_CARACTERISTICAS_TEC) {
            try {
                List<CaracteristicasTec> caracteristica = this.datosTecnicos.listar(ARCHIVO_CARACTERISTICAS_TEC);
                System.out.println("caracteristica = " + caracteristica);
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al listar caracteristicas tecnicas!");
                ex.printStackTrace(System.out);
            }
        } else if (nombreArchivo == ARCHIVO_DISTRIBUIDORES) {
            try {
                List<Distribuidor> distribuidor = this.datosDistribuidor.listar(ARCHIVO_DISTRIBUIDORES);
                System.out.println("distribuidor = " + distribuidor);
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al listar distribuidores!");
                ex.printStackTrace(System.out);
            }
        } else if (nombreArchivo == ARCHIVO_AGENCIAS) {
            try {
                List<Agencia> agencias = this.datosAgencia.listar(ARCHIVO_AGENCIAS);
                System.out.println("agencias = " + agencias);
            } catch (AccesoDatosEx ex) {
                System.out.println("Error al listar agencias!");
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void enviarPedidoAFabricante(Marca marca, int unidades) {
        //En vase al stock con que cuenta el distribuidor solicitar mas unidades.
    }

    @Override
    public void venderVehiculo(Modelo modelo) {
        try {
            Modelo modeloEncontrado = datosModelo.buscar(ARCHIVO_MODELOS, modelo.getDenominacion());
            if (modeloEncontrado != null) {
                modeloEncontrado.setCantidad(modeloEncontrado.getCantidad() - 1);
                System.out.println("Se ha vendido un vehiculo!");
                System.out.println("Quedan en stock del modelo " + modelo + " " + modelo.getCantidad());
            } else {
                //Pedir stock al fabricante
                System.out.println("No hay stock del modelo solicitado! Enviar pedido a distribuidor!");
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al vender vehiculo!");
            ex.printStackTrace(System.out);
        }
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
