package it.epicode.archivio;

import it.epicode.libro.Libro;
import it.epicode.libro.LibroDAO;
import it.epicode.rivista.Periodicita;
import it.epicode.rivista.Rivista;
import it.epicode.rivista.RivistaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AggiungiCatalogo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();


        RivistaDAO rivistaDAO = new RivistaDAO(em);
        LibroDAO libroDAO = new LibroDAO(em);

        em.getTransaction().begin();

        Libro l1 = new Libro(null, "Il Signore degli Anelli", 1954, 123, null, "JRR Tolkien", "Fantasy");
        Libro l2 = new Libro(null, "Il Nome della Rosa", 1980, 123, null, "Umberto Eco", "Historical");
        Libro l3 = new Libro(null, "Il Barone Rampante", 1957, 123, null, "Italo Calvino", "Fiction");

        libroDAO.insert(l1);
        libroDAO.insert(l2);
        libroDAO.insert(l3);

        Rivista r1 = new Rivista(null, "Il Giornale", 2022, 123, null, Periodicita.SETTIMANALE);
        Rivista r2 = new Rivista(null, "La Repubblica", 2022, 123, null, Periodicita.MENSILE);
        Rivista r3 = new Rivista(null, "Il Corriere", 2022, 123, null, Periodicita.SEMESTRALE);

        rivistaDAO.insert(r1);
        rivistaDAO.insert(r2);
        rivistaDAO.insert(r3);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
