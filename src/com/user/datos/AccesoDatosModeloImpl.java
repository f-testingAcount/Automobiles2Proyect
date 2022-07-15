
package com.user.datos;

import com.user.domain.Modelo;
import com.user.exceptions.AccesoDatosEx;
import java.io.*;
import java.util.*;



public class AccesoDatosModeloImpl implements IAccesoDatos<Modelo> {

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
            System.out.println("Se ha creado el archivo de modelos!");
            createFile.close();
            System.out.println("Se agrego un modelo al archivo modelos!");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear el archivo de modelos!" + ex.getMessage());
        }
    }

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public void escribir(Modelo modelo, String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
            write.println(modelo.toString());
            write.close();
            System.out.println("Se agrego un modelo al archivo modelos!");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al escribir en el archivo modelos!" + ex.getMessage());
        }
    }
    
    @Override
    public void sobreEscribir(Modelo modelo, String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        int indice = buscarIndice(nombreArchivo, modelo);
        int posicion = 1;
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            while(linea != null){
                if (posicion < indice) {
                    posicion++;
                    linea = leer.readLine();
                } else {
                    break;
                }                
            }
            leer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al sobre escribir en el archivo modelos!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al sobre escribir en el archivo modelos!" + ex.getMessage());
        }        
        try {
            PrintWriter write = new PrintWriter(new FileWriter(archivo, false));
            write.println(modelo.toString());
            write.close();
            System.out.println("Se modificaron datos de un modelo en el archivo modelos!");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Se modificaron datos de un modelo en el archivo modelos!" + ex.getMessage());
        }
    }

    @Override
    public List listar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        List<Modelo> modelos = new ArrayList<>();
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            while(linea != null){
                Modelo modelo = new Modelo(linea);
                modelos.add(modelo);
                linea = leer.readLine();
            }
            leer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar el archivo modelos!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar el archivo modelos!" + ex.getMessage());
        }
        return modelos;
    }

    @Override
    public Modelo buscar(String nombreArchivo, String denominacion) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        //modelo = null;
        //denominacion = null;
        Modelo modelo = new Modelo();
        try {
            BufferedReader search = new BufferedReader(new FileReader(archivo));
            var indice = 1;
            String linea = search.readLine();
            while(linea != null){
                if (denominacion != null && denominacion.equals(linea)) {
                    modelo.getDenominacion();
                    break;
                }
                indice++;
                linea = search.readLine();
            }
            search.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo modelos!" + ex.getMessage());
        }
        return modelo;
    }
    
    @Override
    public int buscarIndice(String nombreArchivo, Modelo modelo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        var indice = 1;
        try {
            BufferedReader search = new BufferedReader(new FileReader(archivo));
            String linea = search.readLine();
            while(linea != null){
                if (modelo != null && modelo.equals(linea)) {
                    modelo.toString();
                    break;
                } else {
                indice++;
                }
                linea = search.readLine();
            }
            search.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar indice en el archivo modelos!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar indice en el archivo modelos!" + ex.getMessage());
        }
        return indice;
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
