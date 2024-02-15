package it.epicode.w6d2esercizio.model;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class BlogPostRequest {
    @NotNull(message = "contenuto obbligatorio")
    @NotEmpty(message = "contenuto non vuoto")
    private String contenuto;
    @NotNull(message = "titolo obbligatorio")
    @NotEmpty(message = "titolo non vuoto")
    private String titolo;
    @NotNull(message = "categoria obbligatoria")
    @NotEmpty(message = "categoria non vuota")
    private String categoria;
    @NotNull(message = "tempo lettura obbligatorio")
    private int tempoLettura;
    @NotNull(message = "idAutore obbligatorio")
    private int idAutore;
}