
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
    public Modelo buscar(String nombreArchivo, Modelo modelo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        //modelo = null;
        try {
            BufferedReader search = new BufferedReader(new FileReader(archivo));
            var indice = 1;
            String linea = search.readLine();
            while(linea != null){
                if (modelo != null && modelo.equals(linea)) {
                    //encontrado = "Modelo " + linea + " encontrado en el indice " + indice;
                    modelo.toString();
                    //System.out.println("Modelo " + linea + " encontrado en el indice " + indice);
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
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
