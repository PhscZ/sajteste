package com.example.demo.application.commands.handlers;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.application.commands.RegisterPessoaCommand;
import com.example.demo.application.dtos.PessoaDto;
import com.example.demo.domain.aggregates.Pessoa;
import com.example.demo.domain.repositories.PessoaRepository;

@Service
public class RegisterPessoaHandler {
    
    private final PessoaRepository pessoaRepository;

    public RegisterPessoaHandler(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public PessoaDto handle(RegisterPessoaCommand command) {
        Pessoa pessoa = new Pessoa(command.nome(), command.idade(), command.email());
        pessoaRepository.save(pessoa);
        return new PessoaDto(pessoa.getId(), pessoa.getNome(), pessoa.getIdade(), pessoa.getEmail());
    }
}
