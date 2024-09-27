package catedra.proyecto_dwf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "producto", schema = "bd_ventas", catalog = "")
public class ProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdProducto", nullable = false)
    private Object idProducto;
    @Basic
    @Column(name = "Nombres", nullable = true, length = 244)
    private String nombres;
    @Basic
    @Column(name = "Precio", nullable = true, precision = 0)
    private Double precio;
    @Basic
    @Column(name = "Stock", nullable = true)
    private Object stock;
    @Basic
    @Column(name = "Estado", nullable = true, length = 1)
    private String estado;

    public Object getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Object idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Object getStock() {
        return stock;
    }

    public void setStock(Object stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductoEntity that = (ProductoEntity) o;

        if (idProducto != null ? !idProducto.equals(that.idProducto) : that.idProducto != null) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (precio != null ? !precio.equals(that.precio) : that.precio != null) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProducto != null ? idProducto.hashCode() : 0;
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
