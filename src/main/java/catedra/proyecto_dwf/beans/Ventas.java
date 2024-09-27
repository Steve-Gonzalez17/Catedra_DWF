package catedra.proyecto_dwf.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "ventas")
public class Ventas {

    @Id
    private int idVentas;
    private int idCliente;
    private int idEmpleado;
    private String numeroSerie;
    private Date fechaVentas;
    private double monto;
    private String estado;

    // Constructor por defecto
    public Ventas() {
    }

    // Constructor con parámetros
    public Ventas(int idVentas, int idCliente, int idEmpleado, String numeroSerie, Date fechaVentas, double monto, String estado) {
        this.idVentas = idVentas;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.numeroSerie = numeroSerie;
        this.fechaVentas = fechaVentas;
        this.monto = monto;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Date getFechaVentas() {
        return fechaVentas;
    }

    public void setFechaVentas(Date fechaVentas) {
        this.fechaVentas = fechaVentas;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}