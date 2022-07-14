package com.user.datos;

import com.user.domain.Agencia;
import com.user.exceptions.AccesoDatosEx;
import java.io.*;
import java.util.*;


public class AccesoDatosAgenciaImpl implements IAccesoDatos<Agencia> {

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
            System.out.println("Se ha creado el archivo de Agencias!");
            createFile.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al escribir en el archivo!" + ex.getMessage());
        }
    }

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public void escribir(Agencia agencia, String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        PrintWriter write;
        try {
            write = new PrintWriter(new FileWriter(archivo, true));
            write.println(agencia.toString());
            write.close();
            System.out.println("Se agrego una agencia al archivo agencias!");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al escribir en el archivo de agencias!" + ex.getMessage());
        }
    }

    @Override
    public List listar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        List<Agencia> agencias = new ArrayList<>();
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            while(linea != null){
                Agencia agencia = new Agencia(linea);
                agencias.add(agencia);
                linea = leer.readLine();
            }
            leer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar las agencias!" + ex.getMessage());
        } catch (IOException ex) {
            
        }
        return agencias;
    }

    @Override
//    public Object buscar(String nombreArchivo, Object agencia) throws AccesoDatosEx {
    public Agencia buscar(String nombreArchivo, Agencia agencia) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        //String encontrado = null;
        agencia = null;
        try {
            BufferedReader search = new BufferedReader(new FileReader(archivo));
            String linea = search.readLine();
            int indice = 1;
            while(linea != null){
                if (agencia != null && agencia.equals(linea)) {
                    //encontrado = "Agencia " + linea + " localizada en el indice " + indice;
                    //agencia.toString();
                    System.out.println("Agencia " + agencia + " localizada en el indice " + indice);
                    break;
                }
                indice++;
                linea = search.readLine();
            }
            search.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo agencias!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo agencias!" + ex.getMessage());
        }
        return agencia;
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
