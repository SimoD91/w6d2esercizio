package it.epicode.w6d2esercizio.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String categoria;
    private String titolo;
    private String cover = "https://picsum.photos/200/300";
    private String contenuto;
    private int tempoDiLettura;
    @ManyToOne
    @JoinColumn(name = "autore_fk")
    private Autore autore;
}
