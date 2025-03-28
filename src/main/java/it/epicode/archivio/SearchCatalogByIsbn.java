package it.epicode.archivio;

import it.epicode.libro.Libro;
import it.epicode.libro.LibroDAO;
import it.epicode.rivista.Rivista;
import it.epicode.rivista.RivistaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SearchCatalogByIsbn {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDAO = new LibroDAO(em);
        RivistaDAO rivistaDAO = new RivistaDAO(em);

        Libro l = libroDAO.findByIsbn(2L);
        Rivista r = rivistaDAO.findByIsbn(5L);

        System.out.println(l);
        System.out.println(r);

        em.close();
        emf.close();
    }
}
