package catedra.proyecto_dwf.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    private int idCliente;
    private String dni;
    private String nombres;
    private String direccion;
    private String estado;

    // Constructor por defecto
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(int idCliente, String dni, String nombres, String direccion, String estado) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombres = nombres;
        this.direccion = direccion;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}