package com.br.pedidos.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pedidos.entities.Pedido;
import com.br.pedidos.entities.Usuario;
import com.br.pedidos.repository.PedidoRepository;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
       @Autowired
   PedidoRepository pedidoRepository;

    @PostMapping("/cadastro")
    public void cadastro(Pedido pedido) {
        pedido.setData(LocalDate.now());
        pedidoRepository.save(pedido);

    }

    @GetMapping("/lista")
    public List<Pedido> getObject() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/buscaId/{id}")
    public Pedido getPedido(@PathVariable("id") int id) {
        return pedidoRepository.findById(id).get();
    }

     @GetMapping("/excluir/{id}")
    public void delPedido(@PathVariable("id") int id) {
        pedidoRepository.deleteById(id);

    }
}
