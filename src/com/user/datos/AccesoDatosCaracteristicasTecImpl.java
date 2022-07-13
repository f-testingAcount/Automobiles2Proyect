
package com.user.datos;

import com.user.domain.CaracteristicasTec;
import com.user.exceptions.AccesoDatosEx;
import java.io.*;
import java.util.*;



public class AccesoDatosCaracteristicasTecImpl implements IAccesoDatos<CaracteristicasTec> {

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter createFile = new PrintWriter(new FileWriter(archivo, true));
            System.out.println("Se ha creado el archivo de caracteristicas tecnicas!");
            createFile.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear archivo de caracteristicas tecnicas!" + ex.getMessage());
        }
    }

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public void escribir(CaracteristicasTec caracteristicas, String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter write = new PrintWriter(new FileWriter(archivo, true));
            write.println(caracteristicas.toString());
            write.close();
            System.out.println("Se agrego una caracteristica al archivo caracteristicas!");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al escribir en archivo de caracteristicas tecnicas!" + ex.getMessage());
        }
    }

    @Override
    public List listar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        List<CaracteristicasTec> caracteristicas = new ArrayList<>();
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            while(linea != null){
                CaracteristicasTec caracteristica = new CaracteristicasTec(linea);
                caracteristicas.add(caracteristica);
                linea = leer.readLine();
            }
            leer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar caracteristicas tecnicas!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear archivo de caracteristicas tecnicas!" + ex.getMessage());
        }
        return caracteristicas;
    }

    @Override
    //public Object buscar(String nombreArchivo, Object caracteristica) throws AccesoDatosEx {
    public CaracteristicasTec buscar(String nombreArchivo, CaracteristicasTec caracteristica) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        //String encontrado = null;
        try {
            BufferedReader search = new BufferedReader(new FileReader(archivo));
            String linea = search.readLine();
            var indice = 1;
            while(linea != null){
                if(caracteristica != null && caracteristica.equals(linea)){
                    //encontrado = "Caractristica " + linea + " encontrada en el indice " + indice;
                    caracteristica.toString();
                    break;
                }
                indice++;
                linea = search.readLine();
            }
            search.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar archivo de caracteristicas tecnicas!" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al listar archivo de caracteristicas tecnicas!" + ex.getMessage());
        }
        return caracteristica;
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
