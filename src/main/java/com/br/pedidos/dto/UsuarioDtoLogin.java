package com.br.pedidos.dto;

import com.br.pedidos.entities.Usuario;

public class UsuarioDtoLogin {
    private String senha;
    private String cpf;

    
    public UsuarioDtoLogin(String cpf, String senha) {
      
        this.cpf= cpf;
        this.senha=senha;
    }

     public UsuarioDtoLogin(Usuario usuario) {
        this.cpf = usuario.getCpf();
        this.senha=usuario.getSenha();
    }

    public  UsuarioDtoLogin() {
    }

  
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    
}
