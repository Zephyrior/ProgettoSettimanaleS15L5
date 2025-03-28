package it.epicode.archivio;

import it.epicode.libro.Libro;
import it.epicode.libro.LibroDAO;
import it.epicode.rivista.Rivista;
import it.epicode.rivista.RivistaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CercaCatalogoPerAnnoPubblicazione {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDAO = new LibroDAO(em);
        RivistaDAO rivistaDAO = new RivistaDAO(em);

        List<Libro> l = libroDAO.findByPubblicationYear(1980);
        List<Rivista> r = rivistaDAO.findByPubblicationYear(2022);

        System.out.println(l);
        System.out.println(r);

        em.close();
        emf.close();

    }
}
