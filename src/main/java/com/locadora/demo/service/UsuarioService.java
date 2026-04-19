package com.locadora.demo.service;

import com.locadora.demo.model.Usuario;
import com.locadora.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario cadastrar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario login(String email, String senha) {
        String sql = "SELECT * FROM usuario WHERE email = '" + email + "' AND senha = '" + senha + "'";
        List<Usuario> usuarios = entityManager
                .createNativeQuery(sql, Usuario.class)
                .getResultList();

        if (!usuarios.isEmpty()) {
            return usuarios.get(0);
        }

        throw new RuntimeException("Credenciais inválidas");
    }
}