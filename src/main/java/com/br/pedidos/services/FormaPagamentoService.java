package com.br.pedidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pedidos.entities.FormaPagamento;
import com.br.pedidos.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {

    @Autowired
    FormaPagamentoRepository formaPagamentoRepository;


       public void cadastro(FormaPagamento formaPagamento) {
      formaPagamentoRepository.save(formaPagamento);
    }
    

      public List<FormaPagamento> getObject() {
        return formaPagamentoRepository.findAll();
    }

      public FormaPagamento getFormaPagamento( int id) {
        return formaPagamentoRepository.findById(id).get();
    }

    public void delFormaPagamento( int id) {
        formaPagamentoRepository.deleteById(id);

    }
    
}
