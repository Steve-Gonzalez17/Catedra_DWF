package catedra.proyecto_dwf.model;

import catedra.proyecto_dwf.entities.EmpleadoEntity;
import catedra.proyecto_dwf.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

import static catedra.proyecto_dwf.utils.JpaUtil.getEntityManager;

public class EmpleadoModel {

    public List<EmpleadoEntity> obtenerTodos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<EmpleadoEntity> query = em.createQuery("SELECT e FROM EmpleadoEntity e", EmpleadoEntity.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public EmpleadoEntity obtenerPorId(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmpleadoEntity.class, id);
        } finally {
            em.close();
        }
    }

    public void guardar(EmpleadoEntity empleado) {
        EntityManager em = getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            if (empleado.getIdEmpleado() == null) {
                em.persist(empleado); // Guardar nuevo empleado
            } else {
                em.merge(empleado); // Actualizar empleado existente
            }
            tran.commit();
        } catch (Exception e) {
            if (tran.isActive()) {
                tran.rollback();
            }
            throw e; // Manejar la excepción según sea necesario
        } finally {
            em.close();
        }
    }

    public void editar(EmpleadoEntity empleado) {
        EntityManager em = getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.merge(empleado); // Actualiza el empleado
            tran.commit(); // Confirma los cambios
        } catch (Exception e) {
            if (tran.isActive()) {
                tran.rollback();
            }
            throw e; // Manejar la excepción según sea necesario
        } finally {
            em.close(); // Cierra el EntityManager
        }
    }

    public void eliminar(int id) {
        EntityManager em = getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin(); // Iniciar transacción
            EmpleadoEntity empleado = em.find(EmpleadoEntity.class, id);
            if (empleado != null) {
                em.remove(empleado); // Eliminar empleado
            }
            tran.commit(); // Confirmar transacción
        } catch (Exception e) {
            if (tran.isActive()) {
                tran.rollback(); // Deshacer cambios en caso de error
            }
            throw e; // Manejar la excepción según sea necesario
        } finally {
            em.close(); // Cerrar el EntityManager
        }
    }
}
