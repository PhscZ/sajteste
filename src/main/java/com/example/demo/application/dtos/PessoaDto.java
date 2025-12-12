package com.example.demo.application.dtos;

import java.util.UUID;

public record PessoaDto(UUID id, String nome, Integer idade, String email) {
    
}
