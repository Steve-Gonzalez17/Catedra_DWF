package catedra.proyecto_dwf.beans;

import catedra.proyecto_dwf.entities.EmpleadoEntity;
import catedra.proyecto_dwf.entities.ProductoEntity;
import catedra.proyecto_dwf.model.EmpleadoModel;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;

import java.io.IOException;
import java.util.List;

@ManagedBean
@ViewScoped
public class Empleado {
    private List<EmpleadoEntity> empleados;
    private EmpleadoEntity nuevoEmpleado;
    private EmpleadoModel empleadoModel;
    private EmpleadoEntity empleadoEditado;

    @PostConstruct
    public void init() {
        empleadoModel = new EmpleadoModel();
        cargarEmpleados();
        nuevoEmpleado = new EmpleadoEntity();
        empleadoEditado = new EmpleadoEntity(); // Inicializar el objeto para edición

        String idEmpleadoParam = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("idEmpleado");

        if (idEmpleadoParam != null) {
            try {
                Integer idEmpleado = Integer.parseInt(idEmpleadoParam);
                empleadoEditado = empleadoModel.obtenerPorId(idEmpleado);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }



    public void cargarEmpleados() {
        empleados = empleadoModel.obtenerTodos();
    }

    public void guardarEmpleado() {
        try {

            empleadoModel.guardar(nuevoEmpleado);
            cargarEmpleados();
            nuevoEmpleado = new EmpleadoEntity();
            FacesContext.getCurrentInstance().getExternalContext().redirect("empleados.xhtml");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void redirigirEditar(Integer idEmpleado) {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("editarEmpleado.xhtml?idEmpleado=" + idEmpleado + "&faces-redirect=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editarEmpleado() {
        try {
            if (empleadoEditado != null && empleadoEditado.getIdEmpleado() != null) {
                empleadoModel.editar(empleadoEditado); // Llama al modelo para actualizar el empleado
                cargarEmpleados(); // Recargar la lista de empleados
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("empleado.xhtml?faces-redirect=true"); // Redirigir correctamente
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEmpleado(Integer idEmpleado) {
        empleadoModel.eliminar(idEmpleado);
        cargarEmpleados(); // Recargar la lista de empleados
    }

    public EmpleadoEntity getempleadoEditado() {
        return empleadoEditado;
    }

    // Getters y Setters
    public List<EmpleadoEntity> getEmpleados() {
        return empleados;
    }

    public EmpleadoEntity getNuevoEmpleado() {
        return nuevoEmpleado;
    }

    public void setNuevoEmpleado(EmpleadoEntity nuevoEmpleado) {
        this.nuevoEmpleado = nuevoEmpleado;
    }

    public EmpleadoEntity getEmpleadoEditado() {
        return empleadoEditado;
    }

    public void setEmpleadoEditado(EmpleadoEntity empleadoEditado) {
        this.empleadoEditado = empleadoEditado;
    }
}
