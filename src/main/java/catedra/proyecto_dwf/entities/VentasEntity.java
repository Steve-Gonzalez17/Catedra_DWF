package catedra.proyecto_dwf.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "ventas", schema = "bd_ventas", catalog = "")
public class VentasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdVentas", nullable = false)
    private Integer idVentas;
    @Basic
    @Column(name = "IdCliente", nullable = true)
    private Integer idCliente;
    @Basic
    @Column(name = "IdEmpleado", nullable = true)
    private Integer idEmpleado;
    @Basic
    @Column(name = "NumeroSerie", nullable = true, length = 244)
    private String numeroSerie;
    @Basic
    @Column(name = "FechaVentas", nullable = true)
    private Date fechaVentas;
    @Basic
    @Column(name = "Monto", nullable = true, precision = 0)
    private Double monto;
    @Basic
    @Column(name = "Estado", nullable = true, length = 1)
    private String estado;

    public Object getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Object getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Object getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
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

        VentasEntity that = (VentasEntity) o;

        if (idVentas != null ? !idVentas.equals(that.idVentas) : that.idVentas != null) return false;
        if (idCliente != null ? !idCliente.equals(that.idCliente) : that.idCliente != null) return false;
        if (idEmpleado != null ? !idEmpleado.equals(that.idEmpleado) : that.idEmpleado != null) return false;
        if (numeroSerie != null ? !numeroSerie.equals(that.numeroSerie) : that.numeroSerie != null) return false;
        if (fechaVentas != null ? !fechaVentas.equals(that.fechaVentas) : that.fechaVentas != null) return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVentas != null ? idVentas.hashCode() : 0;
        result = 31 * result + (idCliente != null ? idCliente.hashCode() : 0);
        result = 31 * result + (idEmpleado != null ? idEmpleado.hashCode() : 0);
        result = 31 * result + (numeroSerie != null ? numeroSerie.hashCode() : 0);
        result = 31 * result + (fechaVentas != null ? fechaVentas.hashCode() : 0);
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
