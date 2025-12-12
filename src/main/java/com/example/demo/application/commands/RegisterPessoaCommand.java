package com.example.demo.application.commands;

public record RegisterPessoaCommand(
    String nome,
    Integer idade,
    String email) {
}
