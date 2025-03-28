package it.epicode.catalogo;


import it.epicode.prestito.Prestito;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codiceIsbn;

    @Column(length = 100, nullable = false)
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    @OneToMany(mappedBy = "catalogo")
    private List<Prestito> prestiti;


    public Catalogo(Long codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine, List<Prestito> prestiti) {
        this.codiceIsbn = codiceIsbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.prestiti = prestiti;
    }

    public Catalogo() {
    }

    public Long getCodiceIsbn() {
        return codiceIsbn;
    }

    public void setCodiceIsbn(Long codiceIsbn) {
        this.codiceIsbn = codiceIsbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestito(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }
}
