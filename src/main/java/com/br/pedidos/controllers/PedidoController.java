package com.br.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pedidos.entities.Pedido;
import com.br.pedidos.services.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {



    @Autowired
    PedidoService pedidoService;

    @PostMapping("/cadastro")
    public void cadastro(Pedido pedido) {
      pedidoService.cadastro(pedido);
      
    }

    @GetMapping("/lista")
    public List<Pedido> getObject() {
        return pedidoService.getObject() ;
    }

    @GetMapping("/buscaId/{id}")
    public Pedido getPedido(@PathVariable("id") int id) {
        return pedidoService.getPedido(id);
    }

    @DeleteMapping("/excluir/{id}")
    public void delPedido(@PathVariable("id") int id) {
       pedidoService.delPedido(id);;

    }
}
