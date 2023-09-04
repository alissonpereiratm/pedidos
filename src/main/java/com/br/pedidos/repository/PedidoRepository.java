package com.br.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pedidos.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido , Integer>{
    
}
