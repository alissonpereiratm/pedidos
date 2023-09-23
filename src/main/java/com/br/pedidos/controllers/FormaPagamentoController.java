package com.br.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pedidos.entities.FormaPagamento;
import com.br.pedidos.services.FormaPagamentoService;


@RestController
@RequestMapping(value = "/formaPagamento")
public class FormaPagamentoController {

@Autowired
FormaPagamentoService formaPagamentoService;

     @PostMapping("/cadastro")
   public void cadastro(FormaPagamento formaPagamento) {
    formaPagamentoService.cadastro(formaPagamento);
    }

     @GetMapping("/lista")
    public List<FormaPagamento> getObject() {
        return formaPagamentoService.getObject();
    }

    @GetMapping("/buscaId/{id}")
      public FormaPagamento getEndereco( int id) {
        return formaPagamentoService.getFormaPagamento(id);
    }

    @DeleteMapping("/excluir/{id}")
    public void delFormaPagamento( int id) {
       formaPagamentoService.delFormaPagamento(id);

    }
    
}
