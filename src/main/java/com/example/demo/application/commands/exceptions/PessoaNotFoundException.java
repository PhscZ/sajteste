package com.example.demo.application.commands.exceptions;

import java.util.UUID;

public class PessoaNotFoundException extends RuntimeException {
    public PessoaNotFoundException(UUID id){
        super("Usuario não encontrado com o ID: " + id);
    }
}
