
package com.user.domain;



public class Distribuidor {
    
    private String nombreDistribuidor;
    private String pais;
//    private List<Agencia> agencias = new ArrayList<>(); 
//    private ArrayList<Marca> marcas = new ArrayList<>();
//    private ArrayList<Modelo> modelos = new ArrayList<>();
    
    public Distribuidor() {}

    public Distribuidor(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }

    public Distribuidor(String nombreDistribuidor, String pais) {
        this.nombreDistribuidor = nombreDistribuidor;
        this.pais = pais;
    }

    public String getNombreDistribuidor() {
        return nombreDistribuidor;
    }

    public void setNombreDistribuidor(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("Distribuidor: ");
        sb.append("Nombre: ").append(nombreDistribuidor);
        sb.append(" | Pais: ").append(pais);
        sb.append(" -");
        return sb.toString();
    }
}
