package catedra.proyecto_dwf.entities;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "producto", schema = "bd_ventas", catalog = "")
public class ProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdProducto", nullable = false)
    private Integer idProducto;
    @Basic
    @Column(name = "Nombres", nullable = true, length = 244)
    private String nombres;
    @Basic
    @Column(name = "Precio", nullable = true, precision = 0)
    private Double precio;
    @Basic
    @Column(name = "Stock", nullable = true)
    private String stock;
    @Basic
    @Column(name = "Estado", nullable = true, length = 1)
    private boolean  estado;
    @Basic
    @Column(name = "ImagenUrl", nullable = true)
    private byte[] imagenUrl;

    public Object getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
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

    public void setStock(String stock) {
        this.stock = stock;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public byte[] getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(byte[] imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductoEntity that = (ProductoEntity) o;

        if (estado != that.estado) return false;
        if (idProducto != null ? !idProducto.equals(that.idProducto) : that.idProducto != null) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (precio != null ? !precio.equals(that.precio) : that.precio != null) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        return Arrays.equals(imagenUrl, that.imagenUrl);
    }

    @Override
    public int hashCode() {
        int result = idProducto != null ? idProducto.hashCode() : 0;
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (estado ? 1 : 0);
        result = 31 * result + Arrays.hashCode(imagenUrl);
        return result;
    }
}
