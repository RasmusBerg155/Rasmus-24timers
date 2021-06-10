package com.example.rasm63f424timers.model;


import javax.persistence.*;

@Entity
public class Kommune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String navn;

    public Kommune() {
    }

    public Kommune(Long id, String navn) {
        this.id = id;
        this.navn = navn;
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

    @Override
    public String toString() {
        return "Kommune{" +
                "id=" + id +
                ", navn='" + navn + '\'' +
                '}';
    }
}
