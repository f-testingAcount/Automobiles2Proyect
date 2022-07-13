package com.user.datos;

import com.user.domain.Marca;
import com.user.exceptions.AccesoDatosEx;
import java.io.*;
import java.util.*;

public class AccesoDatosMarcaImpl implements IAccesoDatos<Marca> {

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter createFile = new PrintWriter(new FileWriter(archivo));
            System.out.println("Se ha creado el archivo  " + nombreArchivo + "!");
            createFile.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear el archivo!" + ex.getMessage());
        }
    }

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
//    void escribir(T variable, String nombreArchivo, boolean anexar) throws AccesoDatosEx;
    public void escribir(Marca marca, String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
            write.println(marca.toString());
            write.close();
            System.out.println("Se agrego una marca al archivo marcas!");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al escribir en el archivo de marcas!" + ex.getMessage());
        }        
    }

    @Override
    public List listar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        List<Marca> marcas = new ArrayList<>();
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            while(linea != null){
                Marca marca = new Marca(linea);
                marcas.add(marca);
                linea = leer.readLine();
            }
            leer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar el archivo!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar el archivo!" + ex.getMessage());
        }
        return marcas;
    }

    @Override
    public Marca buscar(String nombreArchivo, Marca marca) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        //String encontrado = null;
        //marca = null;
        try {
            BufferedReader search = new BufferedReader(new FileReader(archivo));
            String linea = search.readLine();
            int indice = 1;
            while(linea != null){
                if (marca != null && marca.equals(linea)) {
                    //encontrado = "Marca: " + linea + " localizada en el indice " + indice;
                    //System.out.println("Marca: " + linea + " localizada en el indice " + indice);
                    marca.toString();
                    break;
                }
                indice++;
                linea = search.readLine();
            }
            search.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al buscar en el archivo!" + ex.getMessage());
        }
        return marca;
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
