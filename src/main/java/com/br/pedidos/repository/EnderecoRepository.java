package com.br.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pedidos.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {
    
}
