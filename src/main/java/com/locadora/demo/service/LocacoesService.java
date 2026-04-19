package com.locadora.demo.service;

import com.locadora.demo.model.Locacoes;
import com.locadora.demo.repository.LocacoesRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LocacoesService {
    
    private final LocacoesRepository repository;

    public LocacoesService(LocacoesRepository repository) {
        this.repository = repository;
    }

    public List<Locacoes> listar() {
        return repository.findAll();
    }

    public Locacoes salvar(Locacoes locacao) {
        return repository.save(locacao);
    }

    public Locacoes atualizar(Long id, Locacoes locacaoAtualizada) {
        Locacoes locacao = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Locação não localizada"));
        // Atualize os campos necessários aqui
        return repository.save(locacao);
    }
    
}