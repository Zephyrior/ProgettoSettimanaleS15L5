package it.epicode.libro;

import jakarta.persistence.EntityManager;

public class LibroDAO {
    private EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    public Libro findByIsbn(Long isbn) {
        return em.find(Libro.class, isbn);
    }

    public void insert(Libro libro) {
        em.persist(libro);
    }

    public void update(Libro libro) {
        em.merge(libro);
    }

    public void delete(Long isbn) {
        Libro libro = findByIsbn(isbn);
        em.remove(libro);
    }

}
