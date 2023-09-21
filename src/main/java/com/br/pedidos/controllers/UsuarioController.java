package com.br.pedidos.controllers;

import java.util.List;
import java.util.Optional;

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

import com.br.pedidos.entities.Usuario;
import com.br.pedidos.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario salvo com sucesso.");

    }


    @PutMapping("/updateByName/{nome}")
    public ResponseEntity<String> updateUsuarioByName(@PathVariable String nome, @RequestBody Usuario updateUsuario) {
        Optional<Usuario> existingUsuarioOptional = usuarioRepository.findByNome(nome);

        if (existingUsuarioOptional.isPresent()) {
            Usuario existingUsuario = existingUsuarioOptional.get();
            existingUsuario.setNome(updateUsuario.getNome());
            existingUsuario.setUsuarioNome(updateUsuario.getUsuarioNome());
            existingUsuario.setCpf(updateUsuario.getCpf());
            existingUsuario.setEmail(updateUsuario.getEmail());
            usuarioRepository.save(existingUsuario);
            return ResponseEntity.ok("Usuario updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/lista")
    public List<Usuario> getObject() {
        return usuarioRepository.findAll();

    }

    @GetMapping("/buscaId/{id}")
    public Usuario getUsuario(@PathVariable("id") int id) {
        return usuarioRepository.findById(id).get();

    }

    @DeleteMapping("/excluir/{id}")
    public void delUsuario(@PathVariable("id") int id) {
        usuarioRepository.deleteById(id);

    }

}
