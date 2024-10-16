package catedra.proyecto_dwf.model;

import jakarta.persistence.*;
import catedra.proyecto_dwf.entities.ProductoEntity;
import catedra.proyecto_dwf.utils.JpaUtil;

import java.util.List;

import static catedra.proyecto_dwf.utils.JpaUtil.getEntityManager;

public class ProductoModel {
    public List<ProductoEntity> obtenerTodos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<ProductoEntity> query = em.createQuery("SELECT p FROM ProductoEntity p", ProductoEntity.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void guardar(ProductoEntity producto) {
        EntityManager em = getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            if (producto.getIdProducto() == null) {
                em.persist(producto);
            } else {
                em.merge(producto);
            }
            tran.commit();
        } catch (Exception e) {
            if (tran.isActive()) {
                tran.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }



    public void editar(ProductoEntity producto) {
        EntityManager em = getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin(); // Inicia la transacción
            em.merge(producto); // Actualiza el producto
            tran.commit(); // Confirma los cambios
        } catch (Exception e) {
            if (tran.isActive()) {
                tran.rollback();
            }
            throw e;
        } finally {
            em.close(); // Cierra el EntityManager
        }
    }


    public void eliminar(Integer idProducto) {
        EntityManager em = getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin(); // Iniciar transacción
            ProductoEntity producto = em.find(ProductoEntity.class, idProducto);
            if (producto != null) {
                em.remove(producto);
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

    public ProductoEntity obtenerPorId(Integer idProducto) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductoEntity.class, idProducto);
        } finally {
            em.close();
        }
    }
}
