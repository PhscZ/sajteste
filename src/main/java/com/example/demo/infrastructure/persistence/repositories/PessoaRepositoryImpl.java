package com.example.demo.infrastructure.persistence.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.aggregates.Pessoa;
import com.example.demo.domain.repositories.PessoaRepository;
import com.example.demo.infrastructure.persistence.entities.PessoaEntity;
import com.example.demo.infrastructure.persistence.mappers.PessoaMapper;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository{
    private final JpaPessoaRepository jpaRepository;
    private final PessoaMapper mapper;

    public PessoaRepositoryImpl(JpaPessoaRepository jpaRepository, PessoaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(Pessoa pessoa){
        if (pessoa == null) {
            throw new NullPointerException("pessoa is marked non-null but is null");
        }
        jpaRepository.save(mapper.toEntity(pessoa)); //garanta que não é null
    }

    @Override
    public Optional<Pessoa> findById(UUID id){
        if (id == null) throw new IllegalArgumentException("Pessoa ID cannot be null");
        Optional<PessoaEntity> entity = jpaRepository.findById(id);
        return entity.map(mapper::toDomain);
    }


    @Override
    public void deleteById(UUID id){
        if (id == null) throw new IllegalArgumentException("Pessoa ID cannot be null");
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Pessoa> findAll(){
        return jpaRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}
