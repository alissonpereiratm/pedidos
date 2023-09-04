package com.br.pedidos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pedidos.entities.Usuario;
import com.br.pedidos.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/cadastro")
    public void cadastro(Usuario usuario) {
        usuarioRepository.save(usuario);

    }

    @GetMapping("/lista")
    public List<Usuario> getObject() {
        return usuarioRepository.findAll();

    }
    @GetMapping("/buscaId/{id}")
    public Usuario getUsuario(@PathVariable("id") int id) {
        return usuarioRepository.findById(id).get();

    }

     @GetMapping("/excluir/{id}")
    public void delUsuario(@PathVariable("id") int id) {
        usuarioRepository.deleteById(id);

    }

}
