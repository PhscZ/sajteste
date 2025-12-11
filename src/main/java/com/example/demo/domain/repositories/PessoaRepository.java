package com.example.demo.domain.repositories;

import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.aggregates.Pessoa;

public interface PessoaRepository {
    Optional<Pessoa> findById(UUID id);
    void save(Pessoa pessoa);
    void deleteById(UUID id);
}
