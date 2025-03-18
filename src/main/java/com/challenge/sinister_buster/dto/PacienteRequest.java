package com.challenge.sinister_buster.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PacienteRequest {
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Data de nascimento é obrigatória")
    private String dataNascimento;

    @NotBlank(message = "Plano de saúde é obrigatório")
    private String planoSaude;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "Email é obrigatório")
    private String email;
}
