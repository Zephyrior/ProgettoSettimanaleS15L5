package it.epicode.archivio;

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

public class CercaPrestitiScadutiNonRestituiti {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        PrestitoDAO prestitoDAO = new PrestitoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        LibroDAO libroDAO = new LibroDAO(em);
        RivistaDAO rivistaDAO = new RivistaDAO(em);

        Libro l = new Libro(null, "Il Signore degli Anelli", 1954, 123, null, "JRR Tolkien", "Fantasy");
        Libro l2 = new Libro(null, "Il Nome della Rosa", 1980, 123, null, "Umberto Eco", "Historical");
        Libro l3 = new Libro(null, "Il Barone Rampante", 1957, 123, null, "Italo Calvino", "Fiction");

        Rivista r = new Rivista(null, "Il Giornale", 2022, 123, null, Periodicita.SETTIMANALE);
        Rivista r2 = new Rivista(null, "La Repubblica", 2022, 123, null, Periodicita.MENSILE);

        Utente u = new Utente("Mario", "Rossi", LocalDate.of(2000, 1, 1), null, null);
        Utente u2 = new Utente("Giuseppe", "Verdi", LocalDate.of(2000, 1, 1), null, null);
        Utente u3 = new Utente("Francesco", "Bianchi", LocalDate.of(2000, 1, 1), null, null);

        Prestito p = new Prestito(null, u, l, LocalDate.now(), LocalDate.now().plusDays(30), null);
        Prestito p2 = new Prestito(null, u2, r, LocalDate.of(2025,2,20), LocalDate.of(2025,2,20).plusDays(30), null);
        Prestito p3 = new Prestito(null, u, l2, LocalDate.of(2025,1,20), LocalDate.of(2025,1,20).plusDays(30), LocalDate.of(2025,2,1));
        Prestito p4 = new Prestito(null, u3, l3, LocalDate.of(2025,2,20), LocalDate.of(2025,2,20).plusDays(30), null);
        Prestito p5 = new Prestito(null, u, r2, LocalDate.of(2025,3,20), LocalDate.of(2025,3,20).plusDays(30), LocalDate.of(2025,3,28));

        em.getTransaction().begin();

        libroDAO.insert(l);
        libroDAO.insert(l2);
        libroDAO.insert(l3);
        rivistaDAO.insert(r);
        rivistaDAO.insert(r2);
        utenteDAO.insert(u);
        utenteDAO.insert(u2);
        utenteDAO.insert(u3);
        prestitoDAO.insert(p);
        prestitoDAO.insert(p2);
        prestitoDAO.insert(p3);
        prestitoDAO.insert(p4);
        prestitoDAO.insert(p5);

        em.getTransaction().commit();

        List<Prestito> prestitiScaduti = prestitoDAO.findOverdueCatalogs();

        System.out.println("Il seguente catalogo è ancora da restituire:");
        System.out.println(prestitiScaduti);

        em.close();
        emf.close();
    }
}
