package com.br.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pedidos.entities.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository <FormaPagamento,Integer>{
    
}
