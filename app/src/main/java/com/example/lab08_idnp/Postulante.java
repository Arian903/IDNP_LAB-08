package com.example.lab08_idnp;

import java.io.Serializable;

public class Postulante implements Serializable {
    private String dni;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNac;
    private String colegio;
    private String carrera;

    public String getDni(){
        return  dni;
    }

    public  void setDni(String dni){
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String toString(){
        return "Postulante:"+
                "DNI: " + dni + '\n' +
                "Nombre: " + nombre + '\n' +
                "Apellido Paterno: " + apellidoPaterno + '\n' +
                "Apellido Materno: " + apellidoMaterno + '\n' +
                "Fecha de Nac: " + fechaNac + '\n' +
                "Colegio: " + colegio + '\n' +
                "Carrera: " + carrera + '\n';
    }
}
