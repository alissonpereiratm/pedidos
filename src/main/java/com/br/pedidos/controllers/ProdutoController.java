package com.br.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pedidos.entities.Produto;
import com.br.pedidos.services.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
     @Autowired
    ProdutoService produtoService;

    @PostMapping("/cadastro")
    public void cadastro(@RequestBody Produto produto) {
      produtoService.cadastro(produto);
    }

    @GetMapping("/lista")
    public List<Produto> getObject() {
        return produtoService.getObject() ;
    }

    @GetMapping("/buscaId/{id}")
    public Produto getProduto(@PathVariable("id") int id) {
        return produtoService.getProduto(id);
    }

    @DeleteMapping("/excluir/{id}")
    public void delProduto(@PathVariable("id") int id) {
       produtoService.delProduto(id);

    }
}
