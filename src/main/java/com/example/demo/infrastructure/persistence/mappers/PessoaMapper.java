package com.example.demo.infrastructure.persistence.mappers;

import org.springframework.stereotype.Component;

import com.example.demo.domain.aggregates.Pessoa;
import com.example.demo.infrastructure.persistence.entities.PessoaEntity;

@Component
public class PessoaMapper {
    public PessoaEntity toEntity(Pessoa pessoa){
        PessoaEntity entity = new PessoaEntity(pessoa.getId(), pessoa.getNome(), pessoa.getIdade());
        return entity;
    }

    public Pessoa toDomain(PessoaEntity entity){
        Pessoa pessoa = new Pessoa(entity.getId(), entity.getNome(), entity.getIdade());
        return pessoa;
    }
}
