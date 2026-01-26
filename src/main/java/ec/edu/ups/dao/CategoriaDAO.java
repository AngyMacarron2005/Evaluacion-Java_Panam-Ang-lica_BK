package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.models.CategoriaModel;
import ec.edu.ups.models.ProductoModel;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CategoriaDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(CategoriaModel c) {
        em.persist(c);
    }

    public CategoriaModel read(int id) {
        return em.find(CategoriaModel.class, id);
    }

    public List<CategoriaModel> getAll() {
        return em.createQuery(
            "SELECT c FROM CategoriaModel c WHERE c.deleted = false",
            CategoriaModel.class
        ).getResultList();
    }

    public void update(CategoriaModel c) {
        em.merge(c);
    }

    public void delete(int id) {
        CategoriaModel c = read(id);
        if (c != null) {
            c.setDeleted(true);
            em.merge(c);
        }
    }
}

