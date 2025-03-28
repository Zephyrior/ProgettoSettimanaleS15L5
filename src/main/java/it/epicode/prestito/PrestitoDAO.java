package it.epicode.prestito;

import it.epicode.catalogo.Catalogo;
import it.epicode.rivista.Rivista;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public Prestito findByIsbn(Long isbn) {
        return em.find(Prestito.class, isbn);
    }

    public void insert(Prestito prestito) {
        em.persist(prestito);
    }

    public void update(Prestito prestito) {
        em.merge(prestito);
    }

    public void delete(Long isbn) {
        Prestito prestito = findByIsbn(isbn);
        em.remove(prestito);
    }

    public List<Catalogo> findBorrowedCatalogByUserId(Long userId) {
        return em.createQuery("SELECT p.catalogo From Prestito p WHERE p.utente.numeroDiTessera = :userId AND p.dataRestituzioneEffettiva IS NULL", Catalogo.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<Prestito> findOverdueCatalogs(){
        return em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.dataRestituzionePrevista < CURRENT_DATE", Prestito.class)
                .getResultList();
    }
}
