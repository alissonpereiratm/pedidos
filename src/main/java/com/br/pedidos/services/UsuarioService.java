package com.br.pedidos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.pedidos.dto.UsuarioDto;
import com.br.pedidos.dto.UsuarioDtoLogin;
import com.br.pedidos.entities.Usuario;
import com.br.pedidos.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // private PasswordEncoder passwordEncoder;

    

    // public UsuarioService(UsuarioRepository usuarioRepository) {
    //     this.usuarioRepository = usuarioRepository;
    //     this.passwordEncoder=new BCryptPasswordEncoder();
    // }

    public List<UsuarioDto> listaUsuario() {
        return usuarioRepository.findAll().stream().map(UsuarioDto::new).collect(Collectors.toList());
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

    // public ResponseEntity<String> login(UsuarioDtoLogin usuario) {
    //     if (usuarioRepository.findAll().stream()
    //             .anyMatch(usuarioDtoLogin -> usuarioDtoLogin.getCpf().equals(usuario.getCpf())
    //                     && passwordEncoder.matches(usuario.getSenha(), usuarioDtoLogin.getSenha()))) {
    //         return ResponseEntity.ok("Login Sucess");
    //     } else {
    //         return ResponseEntity.badRequest().body("Login failed");
    //     }
    // }

}
