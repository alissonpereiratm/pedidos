package com.br.pedidos.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pedidos.entities.Pedido;
import com.br.pedidos.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;
     @Autowired
    EmailService emailService;

      public void cadastro(Pedido pedido) {
        pedido.setData(LocalDate.now());
        pedidoRepository.save(pedido);
        emailService.sendEmail(pedido);

    }

  public List<Pedido> getObject() {
        return pedidoRepository.findAll();
    }

      public Pedido getPedido( int id) {
        return pedidoRepository.findById(id).get();
    }

    public void delPedido( int id) {
        pedidoRepository.deleteById(id);

    }
    
}
