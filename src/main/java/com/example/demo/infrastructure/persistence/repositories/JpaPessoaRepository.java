package com.example.demo.infrastructure.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infrastructure.persistence.entities.PessoaEntity;

public interface JpaPessoaRepository extends JpaRepository<PessoaEntity, UUID> {
    
}
