package com.br.pedidos.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.br.pedidos.dto.ProdutoDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate data;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Usuario usuario;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Endereco endereco;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private FormaPagamento formaPagamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<Produto> produtos;

    public Pedido(int id, LocalDate data, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
    }

    public Pedido() {
    }

     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Querido ").append(usuario.getNome()).append("\n Detalhamento do Pedido:\n");
        
        if (endereco != null) {
            sb.append("Endereço = ").append(endereco.getCidade()).append(",").append(endereco.getBairro())
                .append(",").append(endereco.getRua()).append(",").append(endereco.getNumero()).append("\n");
        } else {
            sb.append("Endereço = N/A\n");
        }
    
        if (formaPagamento != null) {
            sb.append("Forma de Pagamento = ").append(formaPagamento.getTipo()).append("\n");
        } else {
            sb.append("Forma de Pagamento = N/A\n");
        }
    
        sb.append("Lanche = ");
        if (produtosDto(produtos) != null && !produtosDto(produtos).isEmpty()) {
            for (ProdutoDto produto : produtosDto(produtos)) {
                sb.append("").append(produto.getNome()); // Supondo que Produto tenha um bom método toString()
            }
        } else {
            sb.append("Nenhum produto listado\n");
        }
    
        sb.append("\nData = ").append(data);
        return sb.toString();
    }

   public List<ProdutoDto> produtosDto(List<Produto> produtos) {
    List<ProdutoDto> listaProdutoDto = new ArrayList<>();

    for (Produto produto : produtos) {
        ProdutoDto produtoDto = new ProdutoDto(produto);
        listaProdutoDto.add(produtoDto);
    }

    return listaProdutoDto;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public LocalDate getData() {
        return data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
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
