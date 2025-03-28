package it.epicode.libro;

import it.epicode.catalogo.Catalogo;
import it.epicode.prestito.Prestito;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name = "libri")
public class Libro extends Catalogo {
    private String autore;
    private String genere;


    public Libro(Long codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine, List<Prestito> prestiti, String autore, String genere) {
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine, prestiti);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro() {
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" + "Il titolo del libro è: " + super.getTitolo() +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
