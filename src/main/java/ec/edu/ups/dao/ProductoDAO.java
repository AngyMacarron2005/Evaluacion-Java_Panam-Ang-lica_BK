package ec.edu.ups.dao;

import java.util.List;
import java.util.UUID;

import ec.edu.ups.models.CategoriaModel;
import ec.edu.ups.models.ProductoModel;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ProductoDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(ProductoModel p) {
        em.persist(p);
    }

    public ProductoModel read(int id) {
        return em.find(ProductoModel.class, id);
    }

    public List<ProductoModel> getAll() {
        return em.createQuery(
            "SELECT p FROM ProductoModel p",
            ProductoModel.class
        ).getResultList();
    }

    public List<ProductoModel> getByCategoria(int catId) {
        return em.createQuery(
            "SELECT p FROM ProductoModel p WHERE p.categoria.id = :id",
            ProductoModel.class
        ).setParameter("id", catId)
         .getResultList();
    }
}
