package it.epicode.prestito;

import jakarta.persistence.EntityManager;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }
}
