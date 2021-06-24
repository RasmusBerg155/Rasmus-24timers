package com.example.rasm63f424timers.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Sogn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String navn;
    private double smitteniveau;
    private String nedlukningStart;

    @ManyToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "kommune_id")
    private Kommune kommune;

    public Sogn(){
    }

    public Sogn(String navn, double smitteniveau, String nedlukningStart, Kommune kommune) {
        this.navn = navn;
        this.smitteniveau = smitteniveau;
        this.nedlukningStart = nedlukningStart;
        this.kommune = kommune;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getSmitteniveau() {
        return smitteniveau;
    }

    public void setSmitteniveau(double smitteniveau) {
        this.smitteniveau = smitteniveau;
    }

    public String getNedlukningStart() {
        return nedlukningStart;
    }

    public void setNedlukningStart(String nedlukningStart) {
        this.nedlukningStart = nedlukningStart;
    }

    public Kommune getKommune() {
        return kommune;
    }

    public void setKommune(Kommune kommune) {
        this.kommune = kommune;
    }
}
