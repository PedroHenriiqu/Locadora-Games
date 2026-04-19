package com.locadora.demo.controller;

import com.locadora.demo.model.Jogo;
import com.locadora.demo.service.JogoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoService service;

    public JogoController(JogoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Jogo> listar() {
        return service.listar();
    }

    @PostMapping
    public Jogo criar(@RequestBody Jogo jogo) {
        return service.salvar(jogo);
    }

    @PutMapping("/{id}")
    public Jogo atualizar(@PathVariable Long id, @RequestBody Jogo jogo) {
        return service.atualizar(id, jogo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok("Jogo deletado com sucesso");
    }
}