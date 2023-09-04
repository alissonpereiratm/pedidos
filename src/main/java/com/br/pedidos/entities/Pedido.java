package com.br.pedidos.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate data;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Usuario usuario;

 

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", data=" + data + ", usuario=" + usuario + "]";
    }

    public Pedido(int id, LocalDate data, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
