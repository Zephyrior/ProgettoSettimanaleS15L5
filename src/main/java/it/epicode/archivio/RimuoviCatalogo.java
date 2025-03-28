package it.epicode.archivio;

import it.epicode.libro.LibroDAO;
import it.epicode.rivista.RivistaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RimuoviCatalogo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        RivistaDAO rivistaDAO = new RivistaDAO(em);
        LibroDAO libroDAO = new LibroDAO(em);

        em.getTransaction().begin();

        rivistaDAO.delete(4L);
        libroDAO.delete(1L);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
