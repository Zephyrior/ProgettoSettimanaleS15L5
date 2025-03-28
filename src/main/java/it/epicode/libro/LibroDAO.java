package it.epicode.libro;

import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

public class LibroDAO {
    private EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    public Libro findByIsbn(Long isbn) {
        return em.find(Libro.class, isbn);
    }

    public List<Libro> findByPubblicationYear(int annoPubblicazione) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.annoPubblicazione = :annoPubblicazione", Libro.class)
                .setParameter("annoPubblicazione", annoPubblicazione)
                .getResultList();
    }

    public List<Libro> findByAuthor(String autore) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class)
                .setParameter("autore", autore)
                .getResultList();
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
