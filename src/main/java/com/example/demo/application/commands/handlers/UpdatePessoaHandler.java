package com.example.demo.application.commands.handlers;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.application.commands.UpdatePessoaCommand;
import com.example.demo.application.commands.exceptions.PessoaNotFoundException;
import com.example.demo.application.commands.queries.handlers.FindPessoaByIdHandler;
import com.example.demo.application.dtos.PessoaDto;
import com.example.demo.domain.aggregates.Pessoa;
import com.example.demo.domain.repositories.PessoaRepository;

@Service
public class UpdatePessoaHandler {

    private final FindPessoaByIdHandler findPessoaByIdHandler;
    private final PessoaRepository pessoaRepository;

    public UpdatePessoaHandler(PessoaRepository pessoaRepository, FindPessoaByIdHandler findPessoaByIdHandler) {
        this.pessoaRepository = pessoaRepository;
        this.findPessoaByIdHandler = findPessoaByIdHandler;
    }

    @Transactional
    public PessoaDto handle(UUID id, UpdatePessoaCommand command){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));
        pessoa.updateFullProfile(command.nome(), command.idade(), command.email());
        pessoaRepository.save(pessoa);
        return new PessoaDto(pessoa.getId(), pessoa.getNome(), pessoa.getIdade(), pessoa.getEmail());
    }
}
