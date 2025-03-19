package com.challenge.sinister_buster.dto;

import com.challenge.sinister_buster.model.Especialidade;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DentistaRequest {
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CRO é obrigatório")
    private String cro;

    @NotBlank(message = "Especialidade é obrigatória")
    private Especialidade especialidade;

    @NotBlank(message = "Email é obrigatório")
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

}
