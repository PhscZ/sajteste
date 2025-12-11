package com.example.demo.domain.aggregates;

import java.util.UUID;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Pessoa {
    private final UUID id;
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.idade = idade;
    }
    
    public Pessoa(UUID id, String nome, int idade){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public void changeNome(String nome){
        this.nome = nome;
    }

    public void changeIdade(int idade){
        this.idade = idade;
    }
}
