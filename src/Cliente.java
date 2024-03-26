public class Cliente {
  private String nombre;
  private String cedula;
  private Double ahorro;
  private String nivelingresos;
  private String fechacreacion; 

public Cliente(String nombre,String cedula,Double ahorro, String nivelingresos,String fechacreacion){
       this.nombre = nombre;
       this.cedula = cedula; 
       this.ahorro = ahorro;
       this.nivelingresos = nivelingresos;
       this.fechacreacion = fechacreacion;}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getCedula() {
    return cedula;
}

public void setCedula(String cedula) {
    this.cedula = cedula;
}

public Double getAhorro() {
    return ahorro;
}

public void setAhorro(Double ahorro) {
    this.ahorro = ahorro;
}

public String getNivelingresos() {
    return nivelingresos;
}

public void setNivelingresos(String nivelingresos) {
    this.nivelingresos = nivelingresos;
}

public String getFechacreacion() {
    return fechacreacion;
}

public void setFechacreacion(String fechacreacion) {
    this.fechacreacion = fechacreacion;
}}





