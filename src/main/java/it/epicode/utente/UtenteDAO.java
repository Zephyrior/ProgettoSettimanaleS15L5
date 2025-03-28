package it.epicode.utente;

import jakarta.persistence.EntityManager;

public class UtenteDAO {
    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }
}
