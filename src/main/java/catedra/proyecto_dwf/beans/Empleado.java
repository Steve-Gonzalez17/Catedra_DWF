package catedra.proyecto_dwf.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    private int idEmpleado;
    private String dni;
    private String nombres;
    private String telefono;
    private String estado;
    private String user;

    // Constructor por defecto
    public Empleado() {
    }

    // Constructor con parámetros
    public Empleado(int idEmpleado, String dni, String nombres, String telefono, String estado, String user) {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
        this.nombres = nombres;
        this.telefono = telefono;
        this.estado = estado;
        this.user = user;
    }

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}