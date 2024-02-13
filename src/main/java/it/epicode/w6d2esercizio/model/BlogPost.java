package it.epicode.w6d2esercizio.model;

import lombok.Data;

@Data
public class BlogPost {
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

}
