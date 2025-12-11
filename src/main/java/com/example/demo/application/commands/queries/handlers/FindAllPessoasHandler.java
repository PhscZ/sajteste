package com.example.demo.application.commands.queries.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.application.dtos.PessoaDto;
import com.example.demo.domain.repositories.PessoaRepository;

@Service
public class FindAllPessoasHandler {
    private final PessoaRepository pessoaRepository;

    public FindAllPessoasHandler(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public List<PessoaDto> handle(){
        return pessoaRepository.findAll().stream().map(
            pessoa -> new PessoaDto(pessoa.getId(), pessoa.getNome(), pessoa.getIdade(), pessoa.getEmail()))
            .collect(Collectors.toList());
    }
}
