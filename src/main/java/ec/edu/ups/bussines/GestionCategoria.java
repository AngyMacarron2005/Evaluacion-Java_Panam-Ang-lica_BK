package ec.edu.ups.bussines;

import java.util.List;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.models.CategoriaModel;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCategoria {

    @Inject
    private CategoriaDAO daoCategoria;

    public List<CategoriaModel> getCategoria() {
        return daoCategoria.getAll();
    }

    public CategoriaModel getCategoria(int id) throws Exception {
        if (id <= 0)
            throw new Exception("ID inválido");

        return daoCategoria.read(id);
    }

    public void crearCategoria(CategoriaModel categoria) throws Exception {

        if (categoria.getId() != null) {
            throw new Exception("ID incorrecto");
        }

        if (categoria.getNombre() == null || categoria.getNombre().isEmpty()) {
            throw new Exception("Nombre obligatorio");
        }

        daoCategoria.insert(categoria);
    }
}
