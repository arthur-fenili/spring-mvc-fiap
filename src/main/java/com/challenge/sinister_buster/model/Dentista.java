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
@Table(name = "CH_DENTISTAS")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DENTISTA", nullable = false)
    private Long id;

    @Column(name = "NOME_DENTISTA", length = 255)
    private String nome;

    @Column(name = "CRO", length = 255)
    private String cro;

    @Column(name = "ESPECIALIDADE", length = 255)
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Column(name = "EMAIL", length = 255)
    private String email;

    @Column(name = "TELEFONE", length = 255)
    private String telefone;
}
