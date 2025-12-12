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
    private String email;

    public Pessoa(String nome, Integer idade, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }
    
    public Pessoa(UUID id, String nome, Integer idade, String email){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public void changeNome(String nome){
        this.nome = nome;
    }

    public void changeIdade(int idade){
        this.idade = idade;
    }

    public void changeEmail(String email){
        this.email = email;
    }

    public void updateFullProfile(String nome, Integer idade, String email){
        changeNome(nome);
        changeIdade(idade);
        changeEmail(email);
    }
}
