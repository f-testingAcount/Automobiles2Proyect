package com.user.datos;

import com.user.exceptions.AccesoDatosEx;
import java.util.List;

public interface IAccesoDatos <T> {
    
    void crear(String nombreArchivo) throws AccesoDatosEx;
    
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    
    void escribir(T variable, String nombreArchivo) throws AccesoDatosEx;
    
    List<T> listar(String nombreArchivo) throws AccesoDatosEx;
    
    T buscar(String nombreArchivo, T object) throws AccesoDatosEx;
    
    void borrar(String nombreArchivo) throws AccesoDatosEx;
    
    
}
