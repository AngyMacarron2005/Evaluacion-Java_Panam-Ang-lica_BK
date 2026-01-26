package ec.edu.ups.bussines;

import java.util.List;

import ec.edu.ups.models.*;
import ec.edu.ups.dao.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionProductos {

    @Inject
    private ProductoDAO daoProductos;

     public List<ProductoModel> getProductos() {
        return daoProductos.getAll();
    }

     public ProductoModel getProducto(int id) throws Exception {
    	    if (id <= 0)
    	        throw new Exception("ID inválido");

    	    return daoProductos.read(id);
    	}


     public void crearProducto(ProductoModel producto) throws Exception {
        if (producto.getId() <= 0)
            throw new Exception("ID incorrecto");

        daoProductos.insert(producto);
    }
}

