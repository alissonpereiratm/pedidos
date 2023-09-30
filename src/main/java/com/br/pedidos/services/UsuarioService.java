package com.br.pedidos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pedidos.dto.UsuarioDto;
import com.br.pedidos.dto.UsuarioDtoLogin;
import com.br.pedidos.entities.Usuario;
import com.br.pedidos.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioDto> listaUsuario() {
        return usuarioRepository.findAll().stream().map(x -> new UsuarioDto(x)).collect(Collectors.toList());
    }

    public void cadastro(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public boolean updateUsuarioByName(String nome, Usuario updateUsuario) {
        Optional<Usuario> existingUsuarioOptional = usuarioRepository.findByNome(nome);
        if (existingUsuarioOptional.isPresent()) {
            Usuario existingUsuario = existingUsuarioOptional.get();
            existingUsuario.setNome(updateUsuario.getNome());
            existingUsuario.setUsuarioNome(updateUsuario.getUsuarioNome());
            existingUsuario.setCpf(updateUsuario.getCpf());
            existingUsuario.setEmail(updateUsuario.getEmail());
            usuarioRepository.save(existingUsuario);
            return true;
        } else {
            return false;
        }
    }

    public UsuarioDto getUsuario(int id) {
        return usuarioRepository.findById(id).map(x -> new UsuarioDto(x)).get();
    }

    public void delUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    public boolean login(Usuario usuario) {
        return usuarioRepository.findAll().stream()
            .anyMatch(usuarioDtoLogin -> usuarioDtoLogin.getCpf().equals(usuario.getCpf())
                    && usuarioDtoLogin.getSenha().equals(usuario.getSenha()));
    }

}
