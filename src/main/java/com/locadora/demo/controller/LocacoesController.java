package com.locadora.demo.controller;

import com.locadora.demo.model.Locacoes;
import com.locadora.demo.service.LocacoesService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacoesController {
    
    private final LocacoesService service;

    public LocacoesController(LocacoesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Locacoes> listar() {
        return service.listar();
    }

    @PostMapping
    public Locacoes criar(@RequestBody Locacoes locacao) {
        return service.salvar(locacao);
    }

    @PutMapping("/{id}/devolucao")
    public Locacoes atualizar(@PathVariable Long id, @RequestBody Locacoes locacao) {
        return service.atualizar(id, locacao);
    }
    
}