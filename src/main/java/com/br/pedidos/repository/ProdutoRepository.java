package com.br.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pedidos.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto , Integer>{
    
}
