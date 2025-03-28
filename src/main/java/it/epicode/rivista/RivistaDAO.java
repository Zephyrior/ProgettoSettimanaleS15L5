package it.epicode.rivista;

import it.epicode.libro.Libro;
import jakarta.persistence.EntityManager;

public class RivistaDAO {
    private EntityManager em;

    public RivistaDAO(EntityManager em) {
        this.em = em;
    }

    public Rivista findByIsbn(Long isbn) {
        return em.find(Rivista.class, isbn);
    }

    public void insert(Rivista rivista) {
        em.persist(rivista);
    }

    public void update(Rivista rivista) {
        em.merge(rivista);
    }

    public void delete(Long isbn) {
        Rivista rivista = findByIsbn(isbn);
        em.remove(rivista);
    }
}
