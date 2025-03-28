package it.epicode.rivista;

import it.epicode.catalogo.Catalogo;
import it.epicode.prestito.Prestito;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "riviste")
public class Rivista extends Catalogo {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;


    public Rivista(Long codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine, List<Prestito> prestito, Periodicita periodicita) {
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine, prestito);
        this.periodicita = periodicita;
    }

    public Rivista() {
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
