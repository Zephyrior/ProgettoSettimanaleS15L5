package it.epicode.archivio;

import it.epicode.catalogo.Catalogo;
import it.epicode.libro.Libro;
import it.epicode.libro.LibroDAO;
import it.epicode.prestito.Prestito;
import it.epicode.prestito.PrestitoDAO;
import it.epicode.rivista.Periodicita;
import it.epicode.rivista.Rivista;
import it.epicode.rivista.RivistaDAO;
import it.epicode.utente.Utente;
import it.epicode.utente.UtenteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class CercaCatalogoPrestato {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDAO = new LibroDAO(em);
        RivistaDAO rivistaDAO = new RivistaDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        Libro l = new Libro(null, "Il Signore degli Anelli", 1954, 123, null, "JRR Tolkien", "Fantasy");
        Rivista r = new Rivista(null, "Il Giornale", 2022, 123, null, Periodicita.SETTIMANALE);
        Utente u = new Utente("Mario", "Rossi", LocalDate.of(2000, 1, 1), null, null);
        Prestito p = new Prestito(null, u, l, LocalDate.now(), LocalDate.now().plusDays(30), null);
        Prestito p2 = new Prestito(null, u, r, LocalDate.now(), LocalDate.now().plusDays(30), null);

        em.getTransaction().begin();

        libroDAO.insert(l);
        rivistaDAO.insert(r);
        utenteDAO.insert(u);
        prestitoDAO.insert(p);
        prestitoDAO.insert(p2);

        em.getTransaction().commit();

        List<Catalogo> c = prestitoDAO.findBorrowedCatalogByUserId(1L);

        System.out.println(c);

        em.close();
        emf.close();
    }
}
