package catedra.proyecto_dwf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_ventas", schema = "bd_ventas", catalog = "")
public class DetalleVentasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdDetalleVentas", nullable = false)
    private Integer idDetalleVentas;
    @Basic
    @Column(name = "IdVentas", nullable = true)
    private Integer idVentas;
    @Basic
    @Column(name = "IdProducto", nullable = true)
    private Integer idProducto;
    @Basic
    @Column(name = "Cantidad", nullable = true)
    private String cantidad;
    @Basic
    @Column(name = "PrecioVenta", nullable = true, precision = 0)
    private Double precioVenta;

    public Object getIdDetalleVentas() {
        return idDetalleVentas;
    }

    public void setIdDetalleVentas(Integer idDetalleVentas) {
        this.idDetalleVentas = idDetalleVentas;
    }

    public Object getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Object getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Object getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleVentasEntity that = (DetalleVentasEntity) o;

        if (idDetalleVentas != null ? !idDetalleVentas.equals(that.idDetalleVentas) : that.idDetalleVentas != null)
            return false;
        if (idVentas != null ? !idVentas.equals(that.idVentas) : that.idVentas != null) return false;
        if (idProducto != null ? !idProducto.equals(that.idProducto) : that.idProducto != null) return false;
        if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;
        if (precioVenta != null ? !precioVenta.equals(that.precioVenta) : that.precioVenta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDetalleVentas != null ? idDetalleVentas.hashCode() : 0;
        result = 31 * result + (idVentas != null ? idVentas.hashCode() : 0);
        result = 31 * result + (idProducto != null ? idProducto.hashCode() : 0);
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        result = 31 * result + (precioVenta != null ? precioVenta.hashCode() : 0);
        return result;
    }
}
