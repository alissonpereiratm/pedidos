package com.br.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pedidos.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario , Integer>{
    
}
