package catedra.proyecto_dwf.beans;

import catedra.proyecto_dwf.entities.ProductoEntity;
import catedra.proyecto_dwf.model.ProductoModel;
import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;
import org.primefaces.model.file.UploadedFile;

import java.io.IOException;
import java.util.List;
import java.util.Base64;

@ManagedBean
@ViewScoped
public class Producto {
    private List<ProductoEntity> productos;
    private ProductoEntity nuevoProducto;
    private ProductoModel productoModel;
    private UploadedFile imagenFile;

    private ProductoEntity productoEditado;

    @PostConstruct
    public void init() {
        productoModel = new ProductoModel();
        cargarProductos();
        nuevoProducto = new ProductoEntity();
        productoEditado = new ProductoEntity();

        String idProductoParam = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("idProducto");

        if (idProductoParam != null) {
            try {
                Integer idProducto = Integer.parseInt(idProductoParam);
                productoEditado = productoModel.obtenerPorId(idProducto);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void cargarProductos() {
        productos = productoModel.obtenerTodos();
    }

    public void redirigirEditar(Integer idProducto) {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("editarProducto.xhtml?idProducto=" + idProducto + "&faces-redirect=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarProducto() {
        try {
            if (imagenFile != null) {
                // Convertir el archivo subido a un byte[]
                byte[] bytes = imagenFile.getContent();
                nuevoProducto.setImagenUrl(bytes);
            }

            productoModel.guardar(nuevoProducto);
            cargarProductos();
            nuevoProducto = new ProductoEntity();

            FacesContext.getCurrentInstance().getExternalContext().redirect("admin_index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editarProducto() {
        try {
            if (productoEditado != null && productoEditado.getIdProducto() != null) {
                productoModel.editar(productoEditado);
                cargarProductos();
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("admin_index.xhtml?faces-redirect=true");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(Integer idProducto) {
        productoModel.eliminar(idProducto);
        cargarProductos(); // Recargar la lista de productos
    }

    public ProductoEntity getProductoEditado() {
        return productoEditado;
    }

    public void setProductoEditado(ProductoEntity productoEditado) {
        this.productoEditado = productoEditado;
    }

    public void handleFileUpload(org.primefaces.event.FileUploadEvent event) {
        this.imagenFile = event.getFile();
    }

    public List<ProductoEntity> getProductos() {
        return productos;
    }

    public ProductoEntity getNuevoProducto() {
        return nuevoProducto;
    }

    public void setNuevoProducto(ProductoEntity nuevoProducto) {
        this.nuevoProducto = nuevoProducto;
    }

    public UploadedFile getImagenFile() {
        return imagenFile;
    }

    public void setImagenFile(UploadedFile imagenFile) {
        this.imagenFile = imagenFile; // Aquí está el método setter
    }

    public String convertirImagen(byte[] imagenUrl) {
        if (imagenUrl != null) {
            return Base64.getEncoder().encodeToString(imagenUrl);
        }
        return "";
    }
}
