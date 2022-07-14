
package com.user;

import com.user.domain.*;
import com.user.negocios.*;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_AGENCIAS;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_CARACTERISTICAS_TEC;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_DISTRIBUIDORES;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_MARCAS;
import static com.user.negocios.IAccionesComerciales.ARCHIVO_MODELOS;
import java.util.*;


public class Ejecutable {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        
//        Marca marca = new Marca();
//        Modelo modelo = new Modelo();
//        CaracteristicasTec caracteristicas = new CaracteristicasTec();
//        Distribuidor distribuidor = new Distribuidor();
//        Agencia agencia = new Agencia();
        
        
        
        IAccionesComerciales accion = new AccionesComercialesImpl();
        
        int opcion = -1;
        
        do {
            System.out.println("""
                               
                               Ingrese una opcion:
                               1  - Iniciar archivos (Marcas, Modelos, Caracteristicas Tecnicas, Distribuidores, Agencias).
                               2  - Agregar Marca
                               3  - Agregar Modelo
                               4  - Agregar Caracteristicas Tecnicas
                               5  - Agregar Distribuidor
                               6  - Agregar Agencia
                               7  - Vender Vehiculo
                               8  - Ingresar al service de garantia
                               9  - Servicio mecanico externo
                               10 - Listar Marcas
                               11 - Listar Modelos
                               12 - Listar Caracteristicas Tecnicas
                               13 - Listar Distribuidores
                               14 - Listar Agencias
                               15 - Buscar Modelo
                               16 - Buscar Distribuidor
                               17 - Buscar Agencia
                               18 - Borrar Archivo
                               19 - Test
                               0  - Salir
                               """);
            
            opcion = Integer.parseInt(input.nextLine());
            
            switch (opcion){  //Iniciar archivos (Marcas, Modelos, Caracteristicas Tecnicas, Distribuidores, Agencias).
                case 1 -> accion.iniciarArchivo();
                                
                case 2 ->{ //Agregar Marca
                    System.out.println("Ingrese el nombre de la Marca: ");
                    var nombre = inputString.nextLine();
                    System.out.println("Ingrese el origen de la Marca: ");
                    var origen = inputString.nextLine();
                    System.out.println("Ingrese el logo de la marca: ");
                    var logo = inputString.nextLine();
                    accion.agregarMarca(ARCHIVO_MARCAS, nombre, origen, logo);
                }
                
                case 3 ->{ //Agregar Modeo
                    System.out.println("Ingrese el tipo de vehiculo (auto, camionesta, moto, camion): ");
                    var tipoVehiculo = inputString.nextLine();
                    System.out.println("Ingrese la denominacion del modelo: ");
                    var denominacion = inputString.nextLine();
                    System.out.println("Ingrese la cantidad de unidades: ");
                    var cantidad = Integer.parseInt(input.nextLine());
                    accion.agregarModelos(ARCHIVO_MODELOS, tipoVehiculo, denominacion, cantidad);
                    
                }
                
                case 4 ->{ //Agregar Caracteristicas Tecnicas
                    System.out.println("Ingrese la denominacion del modelo: ");
                    var denominacion = inputString.nextLine();
                    System.out.println("Ingrese el tipo de motor (Nafta, gasoil): ");
                    var tipoMotor = inputString.nextLine();
                    System.out.println("Ingrese la cantidad de cilindros: ");
                    var cilindros = inputString.nextLine();
                    System.out.println("Ingrese la cilindrada: ");
                    var cilindrada = Integer.parseInt(input.nextLine());
                    System.out.println("Ingrese la potencia del motor en HP: ");
                    var HP = Integer.parseInt(input.nextLine());
                    System.out.println("Ingrese las caracteristicas de la caja (Manual o automatica y la cantidad de velocidades): ");
                    var caja = inputString.nextLine();
                    System.out.println("Ingrese el nivel de equipamiento (base o full): ");
                    var equipamiento = inputString.nextLine();
                    System.out.println("Ingrese el tipo de carroceria (auto, camioneta, SUV, cantidad de puertas, camion, moto)");
                    var carroceria = inputString.nextLine();
                    System.out.println("Ingrese el id del vehiculo: ");
                    var id = inputString.nextLine();
                    accion.agregarCaracteristicasTecnicas(ARCHIVO_CARACTERISTICAS_TEC, denominacion, tipoMotor, cilindros, cilindrada, HP, caja, equipamiento, carroceria, id);
                }
                
                case 5 ->{ //Agregar Distribuidor
                    System.out.println("Ingrese el nombre del distribuidor: ");
                    var nombreDistribuidor = inputString.nextLine();
                    System.out.println("Ingrese el pais donde se localiza la sede: ");
                    var pais = inputString.nextLine();
                    accion.agregarDistribuidor(ARCHIVO_DISTRIBUIDORES, nombreDistribuidor, pais);
                }
                
                case 6 ->{ //Agregar Agencia
                    System.out.println("Ingrese el nombre de la agencia: ");
                    var nombreAgencia = inputString.nextLine();
                    System.out.println("Ingrese la ciudad donde se ubica la agencia: ");
                    var ciudad = inputString.nextLine();
                    System.out.println("Ingrese el nombre de la marca que comercializa la agencia: ");
                    var marcaComercializada = inputString.nextLine();
                    accion.agregarAgencia(ARCHIVO_AGENCIAS, nombreAgencia, ciudad, marcaComercializada);
                }
                
                case 7 ->{ //Vender Vehiculo
                                    
                }
                
                case 8 ->{ //Ingresar al service de garantia
                    
                }
                
                case 9 ->{ //Servicio mecanico externo
                    
                }
                
                case 10 ->{ //Listar Marcas
                                    
                }
                
                case 11 ->{ //Listar Modelos
                
                }
                
                case 12 ->{ //Listar Caracteristicas Tecnicas
                
                }
                
                case 13 ->{ //Listar Distribuidores
                
                }
                
                case 14 ->{ //Listar Agencias
                
                }
                
                case 15 ->{ //Buscar Modelo
                
                }
                
                case 16 ->{ //Buscar Distribuidor
                 
                }
                
                case 17 ->{ //Buscar Agencia
                
                }
                
                case 18 ->{ //Borrar Archivo
                    System.out.println("Ingrese el nombre del archivo a eliminar: ");
                    var nombreArchivo = inputString.nextLine();
                    accion.borrarArchivo(nombreArchivo);
                    System.out.println("El archivo " + nombreArchivo + " ha sido borrado!");
                }
                
                case 19 -> { //Testeo
                    
                }
                
                case 0 ->{ //Salir
                    System.out.println("Hasta pronto!");
                    System.exit(0);
                }
                
                default -> System.out.println("La opcion ingresada no existe! , ingrese una opcion valida! ");
                
                     
                        
            }
                               
            
        } while (opcion != 0);
        
    }
    
}
