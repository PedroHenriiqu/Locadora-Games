package com.locadora.demo.repository;

import com.locadora.demo.model.Locacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacoesRepository extends JpaRepository<Locacoes, Long> {
}