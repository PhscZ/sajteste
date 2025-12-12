package com.example.demo.infrastructure.persistence.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "pessoas")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PessoaEntity {
    
    @Id @Column private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    @Column(name = "email", nullable = false)
    private String email;

    public PessoaEntity(UUID id, String nome, Integer idade, String email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }
}
