package it.epicode.w6d2esercizio.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreRequest {
    @NotNull(message = "Nome obbligatorio")
    @NotEmpty(message = "Nome non vuoto")
    private String nome;
    @NotNull(message = "cognome obbligatorio")
    @NotEmpty(message = "cognome non vuoto")
    private String cognome;
    @NotNull(message = "email obbligatorio")
    @NotEmpty(message = "email non vuoto")
    private String email;
    @NotNull(message = "data di nascita obbligatoria")
    private LocalDate dataNascita;
}
