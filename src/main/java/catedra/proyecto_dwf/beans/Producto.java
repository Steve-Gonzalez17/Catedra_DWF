package catedra.proyecto_dwf.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    private int idProducto;
    private String nombres;
    private double precio;
    private int stock;
    private String estado;

    // Constructor por defecto
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(int idProducto, String nombres, double precio, int stock, String estado) {
        this.idProducto = idProducto;
        this.nombres = nombres;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}