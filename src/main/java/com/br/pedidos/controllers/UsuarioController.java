package com.br.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pedidos.dto.UsuarioDto;
import com.br.pedidos.dto.UsuarioDtoLogin;
import com.br.pedidos.entities.Usuario;
import com.br.pedidos.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(Usuario usuario) {
        usuarioService.cadastro(usuario);
        return ResponseEntity.ok("Usuario salvo com sucesso.");
    }

    @PutMapping("/updateByName/{nome}")
    public ResponseEntity<String> updateUsuarioByName(@PathVariable String nome, @RequestBody Usuario updateUsuario) {
        if (usuarioService.updateUsuarioByName(nome, updateUsuario)) {
            return ResponseEntity.ok("Usuario updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public List<UsuarioDto> getObject() {
        return usuarioService.listaUsuario();
    }

    @GetMapping("/buscaId/{id}")
    public UsuarioDto getUsuario(@PathVariable("id") int id) {
        return usuarioService.getUsuario(id);
    }

    @DeleteMapping("/excluir/{id}")
    public void delUsuario(@PathVariable("id") int id) {
        usuarioService.delUsuario(id);
        ;

    }

    // @PostMapping("/login")
    // public ResponseEntity<String> login(UsuarioDtoLogin usuario) {
    //     // return usuarioService.login(usuario);
    // }

}
