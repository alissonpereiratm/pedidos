package com.br.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pedidos.entities.Endereco;
import com.br.pedidos.services.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;
    
    @PostMapping("/cadastro")
   public void cadastro(Endereco endereco) {
    enderecoService.cadastro(endereco);
    }

     @GetMapping("/lista")
    public List<Endereco> getObject() {
        return enderecoService.getObject();
    }

    @GetMapping("/buscaId/{id}")
      public Endereco getEndereco( int id) {
        return enderecoService.getEndereco(id);
    }

    @DeleteMapping("/excluir/{id}")
    public void delEndereco( int id) {
       enderecoService.delEndereco(id);

    }

}
