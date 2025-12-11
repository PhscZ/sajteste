package com.example.demo.application.commands;

public record UpdatePessoaCommand(
    String nome,
    Integer idade,
    String email) {}
