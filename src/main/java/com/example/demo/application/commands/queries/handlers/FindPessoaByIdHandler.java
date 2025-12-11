package com.example.demo.application.commands.queries.handlers;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.application.commands.exceptions.PessoaNotFoundException;
import com.example.demo.application.dtos.PessoaDto;
import com.example.demo.domain.aggregates.Pessoa;
import com.example.demo.domain.repositories.PessoaRepository;

@Service
public class FindPessoaByIdHandler {
    private final PessoaRepository pessoaRepository;

    public FindPessoaByIdHandler(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional(readOnly = true)
    public PessoaDto handle(UUID id){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));

        return new PessoaDto(pessoa.getId(), pessoa.getNome(), pessoa.getIdade(), pessoa.getEmail());
    }
}
