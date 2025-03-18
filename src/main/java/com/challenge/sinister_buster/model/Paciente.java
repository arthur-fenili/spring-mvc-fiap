package com.challenge.sinister_buster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CH_PACIENTES")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PACIENTE", nullable = false)
    private Long id;

    @Column(name = "NOME", length = 255)
    private String nome;

    @Column(name = "CPF", length = 255, unique = true)
    private String cpf;

    @Column(name = "DATA_NASCIMENTO", length = 255)
    private String dataNascimento;

    @Column(name = "PLANO_SAUDE", length = 255)
    private String planoSaude;

    @Column(name = "TELEFONE", length = 255)
    private String telefone;

    @Column(name = "EMAIL", length = 255, unique = true)
    private String email;

}
