package com.br.pedidos.dto;

import com.br.pedidos.entities.Usuario;

public class UsuarioDto {

    private int id;
    private String nome;
    private String usuarioNome;
    private String email;
    private String cpf;

    
    public UsuarioDto(int id, String nome, String usuarioNome, String email,String cpf) {
        this.id = id;
        this.nome = nome;
        this.usuarioNome = usuarioNome;
        this.email = email;
        this.cpf= cpf;
      
    }
    
    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.usuarioNome = usuario.getUsuarioNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
    }
   

    public UsuarioDto() {
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getUsuarioNome() {
        return usuarioNome;
    }


    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    

    
}
