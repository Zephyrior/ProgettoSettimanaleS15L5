package it.epicode.libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainLibro {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDAO = new LibroDAO(em);

        Libro l = libroDAO.findByIsbn(1L);

        System.out.println(l);

        em.close();
        emf.close();
    }
}
