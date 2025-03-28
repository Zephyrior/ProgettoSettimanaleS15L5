package it.epicode.utente;

import it.epicode.prestito.Prestito;
import jakarta.persistence.EntityManager;

public class UtenteDAO {
    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public Utente findByIsbn(Long isbn) {
        return em.find(Utente.class, isbn);
    }

    public void insert(Utente utente) {
        em.persist(utente);
    }

    public void update(Utente utente) {
        em.merge(utente);
    }

    public void delete(Long isbn) {
        Utente utente = findByIsbn(isbn);
        em.remove(utente);
    }
}
