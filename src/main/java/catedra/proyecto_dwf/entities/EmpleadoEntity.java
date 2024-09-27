package catedra.proyecto_dwf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado", schema = "bd_ventas", catalog = "")
public class EmpleadoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdEmpleado", nullable = false)
    private Object idEmpleado;
    @Basic
    @Column(name = "Dni", nullable = true, length = 8)
    private String dni;
    @Basic
    @Column(name = "Nombres", nullable = true, length = 255)
    private String nombres;
    @Basic
    @Column(name = "Telefono", nullable = true, length = 9)
    private String telefono;
    @Basic
    @Column(name = "Estado", nullable = true, length = 1)
    private String estado;
    @Basic
    @Column(name = "User", nullable = true, length = 8)
    private String user;

    public Object getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Object idEmpleado) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadoEntity that = (EmpleadoEntity) o;

        if (idEmpleado != null ? !idEmpleado.equals(that.idEmpleado) : that.idEmpleado != null) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpleado != null ? idEmpleado.hashCode() : 0;
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
