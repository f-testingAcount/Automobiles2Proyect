
package com.user.datos;

import com.user.domain.Distribuidor;
import com.user.exceptions.AccesoDatosEx;
import java.io.*;
import java.util.*;



public class AccesoDatosDistribuidorImpl implements IAccesoDatos<Distribuidor> {

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
            System.out.println("Se ha creado el archivo Distribuidores!");
            createFile.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear al archivo Distribuidores!" + ex.getMessage());
        }
    }

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public void escribir(Distribuidor distribuidor, String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
            write.println(distribuidor.toString());
            write.close();
            System.out.println("Se ha agregado un distribuidor al archivo distribuidores");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al escribir en el archivo Distribuidores!" + ex.getMessage());
        }
    }

    @Override
    public List listar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        List<Distribuidor> distribuidores = new ArrayList<>();
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            while(linea != null){
                Distribuidor distribuidor = new Distribuidor();
                distribuidores.add(distribuidor);
                linea = leer.readLine();
            }
            leer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar el archivo distribuidores!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar el archivo distribuidores!" + ex.getMessage());
        }
        return distribuidores;
    }

    @Override
    public Distribuidor buscar(String nombreArchivo, Distribuidor distribuidor) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);        
        try {
            BufferedReader search = new BufferedReader(new FileReader(archivo));
            String linea = search.readLine();
            var indice = 1;
            while(linea != null){
                if (distribuidor != null && distribuidor.equals(linea)) {
                    distribuidor.toString();
                    break;
                }
                indice++;
                linea = search.readLine();
            }
            search.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo distribuidores!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar el archivo distribuidores!" + ex.getMessage());
        }
        return distribuidor;
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
