package ec.edu.ups.bussines;

import java.util.List;

import ec.edu.ups.models.*;
import ec.edu.ups.dao.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
@Stateless
public class GestionCategoria {

    @Inject
    private CategoriaDAO daoCategoria;

     public List<CategoriaModel> getCategoria() {
        return daoCategoria.getAll();
    }

     public CategoriaModel getCategoria(String id) throws Exception {
        if (id == null || id.isEmpty())
            throw new Exception("ID inválido");

        return daoCategoria.read(id);
    }

     public void crearCategoria(CategoriaModel categoria) throws Exception {
        if (categoria.getId() <= 0)
            throw new Exception("ID incorrecto");

        daoCategoria.insert(categoria);
    }
}



