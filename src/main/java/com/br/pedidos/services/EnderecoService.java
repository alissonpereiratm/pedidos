package com.br.pedidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pedidos.entities.Endereco;
import com.br.pedidos.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;


       public void cadastro(Endereco endereco) {
      enderecoRepository.save(endereco);
    }
    

      public List<Endereco> getObject() {
        return enderecoRepository.findAll();
    }

      public Endereco getEndereco( int id) {
        return enderecoRepository.findById(id).get();
    }

    public void delEndereco( int id) {
        enderecoRepository.deleteById(id);

    }
}
