package com.example.demo.infrastructure.web;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.application.commands.RegisterPessoaCommand;
import com.example.demo.application.commands.handlers.RegisterPessoaHandler;
import com.example.demo.application.commands.queries.handlers.FindAllPessoasHandler;
import com.example.demo.application.commands.queries.handlers.FindPessoaByIdHandler;
import com.example.demo.application.dtos.PessoaDto;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final RegisterPessoaHandler registerPessoaHandler;
    private final FindPessoaByIdHandler findPessoaByIdHandler;
    private final FindAllPessoasHandler findAllPessoasHandler;

    @PostMapping
    public ResponseEntity<PessoaDto> register(@RequestBody RegisterPessoaCommand command, UriComponentsBuilder uriBuilder){
        PessoaDto createdPessoa = registerPessoaHandler.handle(command);
        URI uri = uriBuilder.path("pessoas/").buildAndExpand(createdPessoa.id()).toUri();
        return ResponseEntity.created(uri).body(createdPessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> findById(@PathVariable UUID id) {
        PessoaDto pessoa = findPessoaByIdHandler.handle(id);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDto>> findAll() {
        return ResponseEntity.ok(findAllPessoasHandler.handle());
    }
    
}
