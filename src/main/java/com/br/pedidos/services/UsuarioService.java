package com.br.pedidos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.br.pedidos.entities.Usuario;
import com.br.pedidos.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listaUsuario() {
        return usuarioRepository.findAll();
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

    public Usuario getUsuario(int id) {
        return usuarioRepository.findById(id).get();
    }

    public void delUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

}
