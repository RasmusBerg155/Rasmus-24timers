package com.example.rasm63f424timers.model;



import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Kommune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String navn;

    @JsonBackReference
    @OneToMany(mappedBy = "kommune")
    private Set<Sogn> sogn;

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

    public Set<Sogn> getSogn() {
        return sogn;
    }

    public void setSogn(Set<Sogn> sogn) {
        this.sogn = sogn;
    }

}
