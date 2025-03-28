package it.epicode.utente;

import it.epicode.prestito.Prestito;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "utenti")
public class Utente {

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String cognome;

    private LocalDate dataDiNascita;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long numeroDiTessera;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;


    public Utente(String nome, String cognome, LocalDate dataDiNascita, Long numeroDiTessera, List<Prestito> prestiti) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTessera = numeroDiTessera;
        this.prestiti = prestiti;
    }

    public Utente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Long getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public void setNumeroDiTessera(Long numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestito(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }
}
