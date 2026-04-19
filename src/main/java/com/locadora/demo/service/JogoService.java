package com.locadora.demo.service;

import com.locadora.demo.model.Jogo;
import com.locadora.demo.repository.JogoRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class JogoService {

    private final JogoRepository repository;

    public JogoService(JogoRepository repository) {
        this.repository = repository;
    }

    public List<Jogo> listar() {
        return repository.findAll();
    }

    public Jogo salvar(Jogo jogo) {
        return repository.save(jogo);
    }

    public Jogo atualizar(Long id, Jogo jogoAtualizado) {
        Jogo jogo = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não localizado"));
        jogo.setNome(jogoAtualizado.getNome());
        jogo.setPlataforma(jogoAtualizado.getPlataforma());
        return repository.save(jogo);
    }
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado");
        }
        repository.deleteById(id);
    }
}