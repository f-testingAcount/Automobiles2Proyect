package com.user.domain;


public class CaracteristicasTec {
    
    private String tipoMotor; //Nafta, gasoil
    private String cilindros;
    private int cilindrada;
    private int HP;
    private String caja; //Manual o automatica y cantidad de velocidades
    private String equipamiento; //Base o full
    private String carroceria; //Auto, camioneta, SUV, cntidad de puertas
    private String id; //Codigo unico de identificacion

    public CaracteristicasTec() {super();}

    public CaracteristicasTec(String id) {
        this.id = id;
    }

    public CaracteristicasTec(String tipoMotor, String cilindros, int cilindrada, int HP, String caja, String equipamiento, String carroceria, String id) {
        this.tipoMotor = tipoMotor;
        this.cilindros = cilindros;
        this.cilindrada = cilindrada;
        this.HP = HP;
        this.caja = caja;
        this.equipamiento = equipamiento;
        this.carroceria = carroceria;
        this.id = id;
    }

    public CaracteristicasTec(String denominacion, String tipoMotor, String cilindros, int cilindrada, int HP, String caja, String equipamiento, String carroceria, String id) {
        this.tipoMotor = tipoMotor;
        this.cilindros = cilindros;
        this.cilindrada = cilindrada;
        this.HP = HP;
        this.caja = caja;
        this.equipamiento = equipamiento;
        this.carroceria = carroceria;
        this.id = id;
        
    }
    
    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getCilindros() {
        return cilindros;
    }

    public void setCilindros(String cilindros) {
        this.cilindros = cilindros;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        sb.append("Modelo: ").append(denominacion);
        sb.append(" | Caracteristicas Tecnicas: ");
        sb.append(" | TipoMotor: ").append(tipoMotor);
        sb.append(" | Cilindros: ").append(cilindros);
        sb.append(" | Cilindrada: ").append(cilindrada);
        sb.append(" | HP: ").append(HP);
        sb.append(" | Caja: ").append(caja);
        sb.append(" | Equipamiento: ").append(equipamiento);
        sb.append(" | Carroceria: ").append(carroceria);
        sb.append(" | id: ").append(id);
        sb.append(" -");
        return sb.toString();
    }

}
