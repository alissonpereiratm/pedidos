package com.br.pedidos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pedidos.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario , Integer>{

    Optional<Usuario> findByNome(String nome);
   
}
