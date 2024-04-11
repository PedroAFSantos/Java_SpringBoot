package br.com.book.entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "livro")
@Entity
public class Entidade { // Criação da Entidade(Tabela Livro )

    @Id // Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo; // Renomeado para "titulo" para corresponder ao campo na tabela MySQL

    @Column(name = "autor_principal", nullable = false, length = 150)
    private String autorPrincipal; // Renomeado para "autor_principal" para corresponder ao campo na tabela MySQL

    @Column(name = "ano_publicacao", nullable = false)
    private int anoPublicacao; // Mantido como está

    @Column(name = "edicao", nullable = false)
    private int edicao; // Mantido como está

    @Column(name = "data_criacao", nullable = false)
    private LocalDate dataCriacao; // Mantido como está

    @Column(name = "data_alteracao", nullable = true) // Ajustado para permitir NULL, já que a tabela MySQL permite NULL
    private LocalDate dataAlteracao;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutorPrincipal() {
        return autorPrincipal;
    }

    public void setAutorPrincipal(String autorPrincipal) {
        this.autorPrincipal = autorPrincipal;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

}
