
package com.user.negocios;

import com.user.domain.Marca;
import com.user.domain.Modelo;


public interface IAccionesComerciales {
    
    String ARCHIVO_MARCAS = "Fabricantes.txt";
    String ARCHIVO_MODELOS = "Modelos.txt";
    String ARCHIVO_CARACTERISTICAS_TEC = "Caracteristicas Tecnicas.txt";
    String ARCHIVO_DISTRIBUIDORES = "Distribuidores.txt";
    String ARCHIVO_AGENCIAS = "Agencias.txt";
    
    
    void iniciarArchivo();
    
    void agregarMarca(String nombreArchivo, String nombre, String origen, String logo);
    
    void agregarModelos(String nombreArchivo, String tipoVehiculo, String denominacion, int cantidad); 
    
    void agregarCaracteristicasTecnicas(String nombreArchivo, String denominacion, String tipoMotor, String cilindros, int cilindrada, int HP, String caja, String equipamiento, String carroceria, String id);
    
    void agregarDistribuidor(String nombreArchivo, String nombreDistribuidor, String pais);
    
    void agregarAgencia(String nombreArchivo, String nombreAgencia, String ciudad, String marcaComercializada);
    
    void enviarPedidoAFabricante(Marca marca, int unidades);
    
    void venderVehiculo(Marca marca, Modelo modelo); 
    
    void ingresarAlService(String ID);
    
    void enviarUnidadesAAgencia(Marca marca, Modelo modelo);
    
    void borrarArchivo(String nombreArchivo);
            
}
